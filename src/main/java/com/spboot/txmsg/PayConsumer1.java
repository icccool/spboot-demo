package com.spboot.txmsg;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author WANG JI BO
 * @Date 2020/4/8 3:00 下午
 * @Description
 **/
@Component
public class PayConsumer1 {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    private DefaultMQPushConsumer consumer;

    private String consumerGroup = "transac_consumer_group";

    public PayConsumer1() throws MQClientException {

        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(TxConfig.NAME_SERVER);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 默认是集群方式，可以更改为广播，但是广播方式不支持重试
        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.subscribe(TxConfig.TOPIC_NAME, "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                MessageExt msg = msgs.get(0);
                String key = msg.getKeys();
                try {
                    logger.info("[消费者接收]{} msg: {} ", Thread.currentThread().getName(),new String(msgs.get(0).getBody()));
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                } catch (Exception e) {
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
            }
        });

        consumer.start();
        System.out.println("consumer start ...");
    }

}

