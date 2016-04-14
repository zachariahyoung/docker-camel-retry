package com.zandroid.dockercamelretry;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MessageRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        getContext().setTracing(true);

//        errorHandler(deadLetterChannel("activemq:LowerCaseException")
//                .useOriginalMessage()
//                .maximumRedeliveries(2)
//                );

        onException(UpperCaseException.class)
                .handled(true)
                .useOriginalMessage()
                .maximumRedeliveries(2)
                .to("activemq:UpperCaseException");


        from("activemqtx:SERVER.Q.SUBDOMAIN.OBJECTNAME")
                .routeId(MessageRoute.class.getSimpleName())
                .bean("helloService")
                .bean("byeService")
//                .to("log:myLog?level=INFO&showAll=true&multiline=true")
                .to("activemq:error1");

        from("activemqtx:SERVER.Q.SUBDOMAIN.OBJECTNAME.TEST")
                .routeId("test")
                .bean("helloService")
                .bean("byeService")
//                .to("log:myLog?level=INFO&showAll=true&multiline=true")
                .to("activemq:error2");
    }



    @Bean
    public String myBean() {
        return "I'm Spring bean!";
    }

}
