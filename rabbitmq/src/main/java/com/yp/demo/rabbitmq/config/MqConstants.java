package com.yp.demo.rabbitmq.config;

public class MqConstants {

   private MqConstants(){}

   public static class Direct{

       private Direct(){}

       /**queue name***/

       public static final String DIRECT_QUEUE_NAME_A = "direct.queue.name.a";

       public static final String DIRECT_QUEUE_NAME_B = "direct.queue_name.b";


       /**exchange name***/

       public static final String DIRECT_EXCHANGE_NAME = "direct.exchange.name";


       /**route key ***/

       public static final String DIRECT_ROUTE_KEY_A = "direct.route.key.a";


       public static final String DIRECT_ROUTE_KEY_B = "direct.route.key.b";


   }


    public static class Fanout{

        private Fanout(){}

        /**queue name***/

        public static final String FANOUT_QUEUE_NAME_A = "fanout.queue.name.a";

        public static final String FANOUT_QUEUE_NAME_B = "fanout.queue.name.b";


        /**exchange name***/

        public static final String FANOUT_EXCHANGE_NAME = "fanout.exchange.name";


    }


    public static class Topic{

        private Topic(){}

        /**queue name***/

        public static final String TOPIC_QUEUE_NAME_A = "topic.queue.name.a";

        public static final String TOPIC_QUEUE_NAME_B = "topic.queue.name.b";


        /**exchange name***/

        public static final String TOPIC_EXCHANGE_NAME = "topic.exchange.name";


        /**route key***/

        public static final String TOPIC_ROUTE_KEY_A = "topic.route.key.a";

        public static final String TOPIC_ROUTE_KEY_B = "topic.route.key.b";

        public static final String TOPIC_ROUTE_KEY_N = "route.key.topic";


        /**binding key***/

        public static final String TOPIC_BINDING_KEY_A = "*.route.key.a";

        public static final String TOPIC_BINDING_KEY_A_PREFIX = "#.a";

        public static final String TOPIC_BINDING_KEY_ALL = "#.route.key.#";


    }


    public static String[] queueNames(){
        return new String[]{Direct.DIRECT_QUEUE_NAME_A,Direct.DIRECT_QUEUE_NAME_B,Fanout.FANOUT_QUEUE_NAME_A,Fanout.FANOUT_QUEUE_NAME_B};
    }





}
