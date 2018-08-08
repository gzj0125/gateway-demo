/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.gaozhijun.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * @author gaozhijun
 * @date 2018/8/3 04:26
 **/
public class AddHeaderGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {


    @Override
    public GatewayFilter apply(NameValueConfig config) {

        GatewayFilter gatewayFilter = (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest().mutate()
                    .header(config.getName(), config.getValue())
                    .build();

            return chain.filter(exchange.mutate().request(request).build());

        };
        return gatewayFilter;
    }
}
