package com.pengwei.producer;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 单向发送消息,主要用在不特别关心发送结果的场景，例如日志发送。
 *
 * @author pengwei
 * @date 2020/6/23
 */
public class OneWayProducer {
    private static final Logger logger = LoggerFactory.getLogger(OneWayProducer.class);


    public static void main(String[] args) {

        DefaultMQProducer producer = new DefaultMQProducer("test_group");
        // 设置NameServer的地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动Producer实例
        try {
            // 启动Producer实例
            producer.start();

            for (int i = 0; i < 100; i++) {
                String body = "消息体，RocketMQ:" + i;
                Message message = new Message("TopicTest", "testTag", body.getBytes("UTF-8"));
                // 发送单向消息，没有任何返回结果
                producer.sendOneway(message);
            }
            // 如果不再发送消息，关闭Producer实例。
            producer.shutdown();

        } catch (Exception e) {
            logger.error("生产者发送消息失败！", e);
        }


    }

}


