package org.whalefall.stack.dubbo.gateway.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description rest路由
 * @create 2020/7/13 9:48 上午
 */
@WebServlet(urlPatterns = "/wfrest/*")
public class RestGatewayServlet extends HttpServletBean {
    @Value("${rest.server.ip}")
    private String serverIP;
    @Value("${rest.server.port}")
    private int port;
    /** uri规则需要根据项目情况定义 */
    private String uriRegex = "/wfrest";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] requestUris = req.getRequestURI().split(uriRegex);
        String requestUri = requestUris[1];
        try {
            // http://localhost:9097/
            URI uri = new URI("http", null, serverIP, port, null, null, null);
            // http://localhost:9097/xxxx/xxxx
            uri = UriComponentsBuilder.fromUri(uri)
                    .path(requestUri)
                    .query(req.getQueryString())
                    .build(true).toUri();
            HttpHeaders headers = new HttpHeaders();
            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                headers.set(headerName, req.getHeader(headerName));
            }

            HttpEntity<String> httpEntity = new HttpEntity<>(getRequestBody(req), headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.resolve(req.getMethod()), httpEntity, String.class);
            resp.getWriter().write(responseEntity.getBody());

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private String getRequestBody(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        try (ServletInputStream inputStream = request.getInputStream()) {
            //byte[] bytes = StreamUtils.copyToByteArray(inputStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line = "";
            if ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
            // TODO：异常封装返回
        }
        return sb.toString();
    }
}
