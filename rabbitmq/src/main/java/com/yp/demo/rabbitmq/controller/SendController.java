
package com.yp.demo.rabbitmq.controller;

import com.yp.demo.rabbitmq.producer.DirectProducer;
import com.yp.demo.rabbitmq.producer.FanoutProducer;
import com.yp.demo.rabbitmq.producer.TopicProducer;
import com.yp.demo.rabbitmq.vo.MsgVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendController {

    private final DirectProducer directProducer;

    private final FanoutProducer fanoutProducer;

    private final TopicProducer topicProducer;


    public SendController(DirectProducer directProducer, FanoutProducer fanoutProducer, TopicProducer topicProducer) {
        this.directProducer = directProducer;
        this.fanoutProducer = fanoutProducer;
        this.topicProducer = topicProducer;
    }

    /**
     * the consumer will receive 2 msg
     * @param msg
     * @return
     */
    @RequestMapping("direct/fanout")
    public String directTestFanout(String msg){
      return directProducer.testASender(msg);
    }

    /**
     * the consumer will receive 1 msg
     * @param msg
     * @return
     */
    @RequestMapping("direct/p2p")
    public String directTestP2PS(String msg){
      return directProducer.testBSender(msg);
    }


    /**
     * the consumer will receive 2 msg
     * @param msg
     * @return
     */
    @RequestMapping("fanout")
    public String fanoutTest(String msg){
        return fanoutProducer.fanoutSender( MsgVO.builder()
                .acctId(1111111111L)
                .customerName(msg).build());
    }

    /**
     * the consumer will receive 2 msg
     * @param msg
     * @return
     */
    @RequestMapping("topic/A")
    public String topicTestA(String msg){
        return topicProducer.topicSendA( MsgVO.builder()
                .acctId(1111111111L)
                .customerName(msg).build());
    }

    /**
     * the consumer will receive 1 msg
     * @param msg
     * @return
     */
    @RequestMapping("topic/B")
    public String topicTestB(String msg){
        return topicProducer.topicSendB( MsgVO.builder()
                .acctId(1111111111L)
                .customerName(msg).build());
    }

    /**
     * the consumer will receive 1 msg
     * @param msg
     * @return
     */
    @RequestMapping("topic/N")
    public String topicTestN(String msg){
        return topicProducer.topicSendN( MsgVO.builder()
                .acctId(1111111111L)
                .customerName(msg).build());
    }

}

