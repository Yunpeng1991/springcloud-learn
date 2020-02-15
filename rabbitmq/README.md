# Getting Started

### ENV
+ JDK1.8
+ RabbitMq[RabbitMQ 3.7.24 release]

### DOC


### SHOULD KNOW
#### 模式
```text
简单模式：一个生产者，一个消费者

work模式：一个生产者，多个消费者，每个消费者获取到的消息唯一。

订阅模式：一个生产者发送的消息会被多个消费者获取。

路由模式：发送消息到交换机并且要指定路由key ，消费者将队列绑定到交换机时需要指定路由key

topic模式：将路由键和某模式进行匹配，此时队列需要绑定在一个模式上，“#”匹配一个词或多个词，“*”只匹配一个词

```

-BlockQueueConsumer.handle


### INSTALL MQ IN DOCKER

+ install docker
```text
 see link https://docs.docker.com/install/linux/docker-ce/centos/
```

+ install rabbitmq 
```text
1、docker pull rabbitmq:3.7.24-management
2、run rabbitmq
  方式一：默认guest 用户，密码也是 guest
  docker run -d --hostname my-rabbit --name rabbit -p 15672:15672 -p 5672:5672 rabbitmq:management
  
  方式二：设置用户名和密码
  docker run -d --hostname my-rabbit --name rabbit -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=password -p 15672:15672 -p 5672:5672 rabbitmq:management


```

+ CentOs7 firewall

```text
 1、check service status : systemctl status firewalld
 2、check firewall status : firewall-cmd --state
 3、start firewall command : service firewalld start / service firewalld restart / service firewalld stop
 4、lookup the firewall rules : firewall-cmd --list-all 
   

```

