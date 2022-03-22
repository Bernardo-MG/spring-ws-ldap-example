
package com.bernardomg.example.ws.security.basic.response.controller;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.bernardomg.example.ws.security.basic.response.model.DefaultResponse;
import com.bernardomg.example.ws.security.basic.response.model.Response;

@ControllerAdvice("com.bernardomg.example.ws")
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    public ResponseAdvice() {
        super();
    }

    @Override
    public boolean supports(MethodParameter returnType,
            Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
            MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request, ServerHttpResponse response) {
        final Object result;

        if (body instanceof Response) {
            result = body;
        } else {
            result = new DefaultResponse<>(body);
        }

        return result;
    }

}
