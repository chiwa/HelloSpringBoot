package com.zengcode.th;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class MyRouter extends RouteBuilder {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public void configure() throws Exception {
        onException(JMSException.class)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("================= Error =============");
                    }
                });



        from("timer://foo?fixedRate=true&period=5000").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                producerTemplate.sendBody("activemq:test.spring.boot", "Hello World !");
            }
        });

        from("activemq:test.spring.boot").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                System.out.println("Message from queue : " + exchange.getIn().getBody(String.class));
            }
        });
    }

}