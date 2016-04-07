package com.zandroid.dockercamelretry;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MessageRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        errorHandler(deadLetterChannel("activemq:DEAD").useOriginalMessage());

        from("activemqtx:SERVER.Q.SUBDOMAIN.OBJECTNAME")
                .routeId("TriggerTX")
                    .onException(UpperCaseException.class)
                    .handled(true)
                    .to("activemq:DEAD?timeToLive=5000")
                    .end()
                .bean("helloService")
                .to("log:out");



    }

    @Bean
    public String myBean() {
        return "I'm Spring bean!";
    }

}
