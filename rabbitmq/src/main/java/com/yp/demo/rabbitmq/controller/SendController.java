
package com.yp.demo.rabbitmq.controller;

import com.yp.demo.rabbitmq.producer.DirectProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendController {

    private final DirectProducer directProducer;


    public SendController(DirectProducer directProducer) {
        this.directProducer = directProducer;
    }

    @RequestMapping("direct/fanout")
    public String directTestFanout(String msg){
      return directProducer.testASender(msg);
    }

    @RequestMapping("direct/p2p")
    public String directTestP2PS(String msg){
      return directProducer.testBSender(msg);
    }
}

