package com.zandroid.dockercamelretry;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ByeService implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        log.info("Entering Bye Service");
        final Message inMessage = exchange.getIn();
        final String body = inMessage.getBody(String.class);

        if (body.equals("Hello Upper")) {
            log.warn("exception: UpperCaseException");
            throw new UpperCaseException(body);
        } else if (body.equals("Hello Lower")) {
            log.warn("exception: LowerCaseException");
            throw new LowerCaseException(body);
        }

    }
}