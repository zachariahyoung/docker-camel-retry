package com.zandroid.dockercamelretry;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        log.info("Entering Hello Service");

        final Message inMessage = exchange.getIn();
        final String body = inMessage.getBody(String.class);

        inMessage.setHeader("WHO", body);
        inMessage.setBody("Hello " + body);
    }
}