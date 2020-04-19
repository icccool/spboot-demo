package com.spboot.txmsg;

import com.spboot.interceptor.SqlInterceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;


@Component
public class TransactionProducer {

    private static final Logger logger = LoggerFactory.getLogger(TransactionProducer.class);

    private TransactionListener transactionListener = new TransactionListenerImpl();

    private TransactionMQProducer producer = null;

    // 一般自定义线程池的时候，需要给线程加个名称
    private ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("msg-check-thread");
            return thread;
        }
    });

    public TransactionProducer() {
        producer = new TransactionMQProducer(TxConfig.PRODUCER_GROUP);
        producer.setNamesrvAddr(TxConfig.NAME_SERVER);
        producer.setTransactionListener(transactionListener);
        producer.setExecutorService(executorService);
        start();
    }

    public TransactionMQProducer getProducer() {
        return this.producer;
    }

    /**
     * 对象在使用之前必须要调用一次，只能初始化一次
     */
    public void start() {
        try {
            this.producer.start();
        } catch (MQClientException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 一般在应用上下文，使用上下文监听器，进行关闭
     */
    public void shutdown() {
        this.producer.shutdown();
    }

}

/**
 * 实际处理业务的类，可能是本地带事务性的方法中处理
 */
class TransactionListenerImpl implements TransactionListener {

    private static final Logger logger = LoggerFactory.getLogger(TransactionProducer.class);

    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        System.out.println("executeLocalTransaction start");
        String body = new String(msg.getBody());
        String key = msg.getKeys();
        String transactionId = msg.getTransactionId();
        int status = 0;
        // 执行本地事务begin TODO
        status = doLocalTransaction();
        if (body.equals("retry")) {
            status = 3;
        }
        // 执行本地事务end TODO

        //二次确认消息，然后消费者可以消费
        logger.info("executeLocalTransaction end, status = " + status);
        if (status == 1) {
            return LocalTransactionState.COMMIT_MESSAGE;
        }

        //回滚消息，broker端会删除半消息
        if (status == 2) {
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }

        //broker端会进行回查消息，再或者什么都不响应
        if (status == 3) {
            return LocalTransactionState.UNKNOW;
        }
        return null;
    }

    /***
     * 执行本地事务
     * @return
     */
    private int doLocalTransaction() {
        return 1;
    }

    /***
     * 检查本地事务状态
     *
     * @param msg
     * @return
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        logger.info("checkLocalTransaction start");
        String body = new String(msg.getBody());
        String key = msg.getKeys();
        String transactionId = msg.getTransactionId();
        logger.info("retry===========================" + body);
        //要么commit 要么rollback
        //可以根据key去检查本地事务消息是否完成
        logger.info("checkLocalTransaction end");
        return LocalTransactionState.COMMIT_MESSAGE;
    }

}

