package com.yp.demo.rabbitmq.config;

public class MqConstants {

   private MqConstants(){}

   public static class Direct{

       private Direct(){}

       /**queue name***/

       public static final String DIRECT_QUEUE_NAME_A = "DIRECT_QUEUE_NAME_A";

       public static final String DIRECT_QUEUE_NAME_B = "DIRECT_QUEUE_NAME_B";


       /**exchange name***/

       public static final String DIRECT_EXCHANGE_NAME = "DIRECT_EXCHANGE_NAME";


       /**route key ***/

       public static final String DIRECT_ROUTE_KEY_A = "DIRECT_ROUTE_KEY_A";


       public static final String DIRECT_ROUTE_KEY_B = "DIRECT_ROUTE_KEY_B";


   }


    public static class Fanout{

        private Fanout(){}

        /**queue name***/

        public static final String FANOUT_QUEUE_NAME_A = "DIRECT_QUEUE_NAME_A";

        public static final String FANOUT_QUEUE_NAME_B = "DIRECT_QUEUE_NAME_B";


        /**exchange name***/

        public static final String FANOUT_EXCHANGE_NAME = "DIRECT_EXCHANGE_NAME";


    }


    public static class Topic{

        private Topic(){}

        /**queue name***/

        public static final String TOPIC_QUEUE_NAME_A = "TOPIC_QUEUE_NAME_A";

        public static final String TOPIC_QUEUE_NAME_B = "TOPIC_QUEUE_NAME_B";


        /**exchange name***/

        public static final String TOPIC_EXCHANGE_NAME = "TOPIC_EXCHANGE_NAME";


        /**route key***/

        public static final String TOPIC_ROUTE_KEY_A = "TOPIC_ROUTE_KEY_A";

        public static final String TOPIC_ROUTE_KEY_B = "TOPIC_ROUTE_KEY_A";

        public static final String TOPIC_ROUTE_KEY_N = "ROUTE_KEY_TOPIC";


        /**binding key***/

        public static final String TOPIC_BINDING_KEY_A = "*._BINDING_KEY_A";

        public static final String TOPIC_BINDING_KEY_A_PREFIX = "#._A";

        public static final String TOPIC_BINDING_KEY_ALL = "#.ROUTE_KEY.#";


    }




    public static String[] queueNames(){
        return new String[]{Direct.DIRECT_QUEUE_NAME_A,Direct.DIRECT_QUEUE_NAME_B,Fanout.FANOUT_QUEUE_NAME_A,Fanout.FANOUT_QUEUE_NAME_B};
    }





}
