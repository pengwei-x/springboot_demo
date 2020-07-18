package com.pengwei.producer;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendCallback;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 异步消息
 *
 * @author pengwei
 * @date 2020/6/23
 */
public class AsyncProducer {
    private static final Logger logger = LoggerFactory.getLogger(AsyncProducer.class);

    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("test_group");
        producer.setNamesrvAddr("localhost:9876");
        try {
            producer.start();
            //
            producer.setRetryTimesWhenSendFailed(0);

            int messageCount = 100;
            // 根据消息数量实例化倒计时计算器
            final CountDownLatch countDownLatch = new CountDownLatch(messageCount);
            for (int i = 0; i < messageCount; i++) {
                final int index = i;
                String body = "异步消息，RocketMQ";
                Message message = new Message("TopicTest", "testTag", "11234", body.getBytes("UTF-8"));

                //发送消息到Broker
                // SendCallback接收异步返回结果的回调
                producer.send(message, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        String msgId = sendResult.getMsgId();
                        System.out.printf("%-10d OK %s %n", index,
                                msgId);
                    }

                    @Override
                    public void onException(Throwable e) {
                        logger.error("异步发送消息失败,index:{}", index, e);
                    }
                });
            }
            // 等待5s
            countDownLatch.await(1000, TimeUnit.SECONDS);
            // 如果不再发送消息，关闭Producer实例。
            producer.shutdown();
        } catch (Exception e) {
            logger.error("AsyncProducer,消息发送失败!", e);
        }

    }
}
