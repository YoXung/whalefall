package org.whalefall.stack.framework.exception.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 国际化消息映射
 * @create 2020/5/27 8:51 上午
 */
@Component
public class GlobalMessageSource {
    @Resource
    private MessageSource messageSource;

    /**
     * 获取国际化消息
     * @param code 消息code
     * @return 消息
     */
    public String getMessage(String code) {
        return getMessage(code, null);
    }

    /**
     * 获取国际化消息
     * @param code 消息code
     * @param args 参数
     * @return 消息
     */
    public String getMessage(String code, Object[] args) {
        return getMessage(code, args, "");
    }

    /**
     * 获取国际化消息
     * @param code 消息code
     * @param args 参数
     * @param defaultMessage 默认消息
     * @return 消息
     */
    public String getMessage(String code, Object[] args, String defaultMessage) {
        Locale locale = LocaleContextHolder.getLocale();

        return messageSource.getMessage(code, args, defaultMessage, locale);
    }
}
