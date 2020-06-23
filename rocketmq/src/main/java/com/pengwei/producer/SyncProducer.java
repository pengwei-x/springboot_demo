package com.pengwei.producer;


import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 同步消息
 *
 * @author pengwei
 * @date 2020/6/23
 */
public class SyncProducer {
    private static final Logger logger = LoggerFactory.getLogger(SyncProducer.class);
    private static final int MAX = 1;

    public static void main(String[] args) {
        /**
         * 实例化消息生产者Producer
         *  设置NameServer的地址
         *  启动Producer实例
         */
        DefaultMQProducer mqProducer = new DefaultMQProducer("producer_group");
        mqProducer.setNamesrvAddr("localhost:9876");
        try {
            mqProducer.start();

            for (int i = 0; i < MAX; i++) {
                //创建消息，指定topic，tag和消息体
                String body = "消息体，RocketMQ:" + i;
                Message message = new Message("TopicTest", "TagA", body.getBytes("UTF-8"));
                //发送消息到Broker
                SendResult result = mqProducer.send(message);
                logger.info("生产者返回结果，result{}", result);
            }
            mqProducer.shutdown();
        } catch (Exception e) {

            logger.error("生产者发送消息失败", e);
            e.printStackTrace();
        }
    }
}
