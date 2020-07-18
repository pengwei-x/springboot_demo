package com.pengwei;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author pengwei
 * @date 2020/6/23
 */
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
    public static void main(String[] args) {
        //实例化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_group");
        consumer.setNamesrvAddr("localhost:9876");

        try {
            //订阅一个或多个Topic,以及Tag来过滤需要消费的消息
            consumer.subscribe("TopicTest","*");
            // 注册回调实现类来处理从broker拉取回来的消息
            consumer.registerMessageListener(new MessageListenerConcurrently() {


                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), list);
                    System.out.println("=================:"+consumeConcurrentlyContext.getMessageQueue());
                    // 标记该消息已经被成功消费

                    for (MessageExt messageExt:list) {

                        System.out.println(new String(messageExt.getBody()));

                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            // 启动消费者实例
            consumer.start();
        } catch (Exception e) {
           logger.error("消费者消费消息失败！",e);
        }
    }
}
