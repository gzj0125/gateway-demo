/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.gaozhijun.gateway.filter.global;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

/**
 * TODO: 全局过滤器
 *
 * @author gaozh
 * @date 2018/8/5
 * @since 1.0.0
 */
@Slf4j
//@Configuration
public class GlobalFilters {

    @Bean
    @Order(-1)
    public GlobalFilter a() {

        ServerWebExchange ax;

        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest().mutate()
                    .header("gaozhijun", "kljljljlj")
                    .build();

            return chain.filter(exchange.mutate().request(request).build());
        };
    }
}
