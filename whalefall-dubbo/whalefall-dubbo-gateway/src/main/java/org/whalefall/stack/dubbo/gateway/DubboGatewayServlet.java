package org.whalefall.stack.dubbo.gateway;

import com.alibaba.cloud.dubbo.http.MutableHttpServerRequest;
import com.alibaba.cloud.dubbo.metadata.DubboRestServiceMetadata;
import com.alibaba.cloud.dubbo.metadata.RequestMetadata;
import com.alibaba.cloud.dubbo.metadata.RestMethodMetadata;
import com.alibaba.cloud.dubbo.metadata.repository.DubboServiceMetadataRepository;
import com.alibaba.cloud.dubbo.service.DubboGenericServiceExecutionContext;
import com.alibaba.cloud.dubbo.service.DubboGenericServiceExecutionContextFactory;
import com.alibaba.cloud.dubbo.service.DubboGenericServiceFactory;
import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBetween;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 网关Servlet
 * @create 2020/7/6 11:29 上午
 */
@WebServlet("/wfd/*")
public class DubboGatewayServlet extends HttpServletBean {
    private final DubboServiceMetadataRepository dubboServiceMetadataRepository;
    private final DubboGenericServiceFactory dubboGenericServiceFactory;
    private final DubboGenericServiceExecutionContextFactory dubboGenericServiceExecutionContextFactory;
    private final PathMatcher pathMatcher = new AntPathMatcher();
    private final Map<String, Object> dubboTranslatedAttributes = new HashMap<>();

    public DubboGatewayServlet(DubboServiceMetadataRepository dubboServiceMetadataRepository, DubboGenericServiceFactory dubboGenericServiceFactory, DubboGenericServiceExecutionContextFactory dubboGenericServiceExecutionContextFactory) {
        this.dubboServiceMetadataRepository = dubboServiceMetadataRepository;
        this.dubboGenericServiceFactory = dubboGenericServiceFactory;
        this.dubboGenericServiceExecutionContextFactory = dubboGenericServiceExecutionContextFactory;
        dubboTranslatedAttributes.put("protocol", "dubbo");
        dubboTranslatedAttributes.put("cluster", "failover");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String serviceName = resolveServiceName((HttpServletRequest) req);
        //String restPath = substringAfter(((HttpServletRequest) req).getRequestURI(), serviceName);
        String restPath = resolveRestPath((HttpServletRequest) req);

        // 初始化 serviceName 的 REST 请求元数据
        dubboServiceMetadataRepository.initializeMetadata(serviceName);
        // 将 HttpServletRequest 转化为 RequestMetadata
        RequestMetadata requestMetadata = buildRequestMetadata((HttpServletRequest) req, restPath);

        DubboRestServiceMetadata dubboRestServiceMetadata = dubboServiceMetadataRepository.get(serviceName,
                requestMetadata);

        if (dubboRestServiceMetadata == null) {
            // if DubboServiceMetadata is not found, executes next
            throw new ServletException("DubboServiceMetadata can't be found!");
            //TODO:这里返回封装的JSON
        }

        RestMethodMetadata restMethodMetadata = dubboRestServiceMetadata
                .getRestMethodMetadata();

        GenericService genericService = dubboGenericServiceFactory.create(dubboRestServiceMetadata,
                dubboTranslatedAttributes);

        // TODO: Get the Request Body from HttpServletRequest
        byte[] body = getRequestBody((HttpServletRequest) req);

        MutableHttpServerRequest httpServerRequest = new MutableHttpServerRequest(
                new HttpRequestAdapter(req), body);

        DubboGenericServiceExecutionContext context = dubboGenericServiceExecutionContextFactory
                .create(restMethodMetadata, httpServerRequest);

        Object result = null;
        GenericException exception = null;

        try {
            result = genericService.$invoke(context.getMethodName(),
                    context.getParameterTypes(), context.getParameters());
        } catch (GenericException e) {
            exception = e;
        }
        res.getWriter().println("++++++网关获得返回数据++++++"+result);
    }

    private String resolveServiceName(HttpServletRequest httpServletRequest) {
        // /g/{app-name}/{rest-path}
        String requestURI = httpServletRequest.getRequestURI();
        // /g/
        String servletPath = httpServletRequest.getServletPath();

        String part = substringAfter(requestURI, servletPath);

        String serviceName = substringBetween(part, "/", "/");

        return serviceName;
    }

    private String resolveRestPath(HttpServletRequest httpServletRequest) {
        String requestURI = httpServletRequest.getRequestURI();
        String servletPath = httpServletRequest.getServletPath();
        String part = substringAfter(requestURI, servletPath);
        String serviceName = substringBetween(part, "/", "/");
        String restPath = substringAfter(requestURI, serviceName);
        return restPath;
    }

    private RequestMetadata buildRequestMetadata(HttpServletRequest httpServletRequest, String restPath) {

    }

    private byte[] getRequestBody(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        return StreamUtils.copyToByteArray(inputStream);
    }
}
