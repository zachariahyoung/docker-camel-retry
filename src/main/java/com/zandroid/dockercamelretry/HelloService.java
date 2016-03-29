package com.zandroid.dockercamelretry;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Handler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService {


    @Handler
    public void save(String body) throws InterruptedException {

        //Thread.sleep(30000);

        if (body.equals("zzz")) {
            log.warn("exception: UpperCaseException");
            throw new UpperCaseException();
        } else if (body.equals("yyy")) {
            log.warn("exception: LowerCaseException");
            throw new LowerCaseException();

        }


    }
}