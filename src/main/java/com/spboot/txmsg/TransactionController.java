package com.spboot.txmsg;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.LocalDate;


/**
 * @Author WANG JI BO
 * @Date 2020/4/8 2:44 下午
 * @Description http:/localhost:8082/api/v1/sendTransactionMsg?tag=apk&otherParam=1
 **/
@RestController
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);


    @Autowired
    private TransactionProducer transactionProducer;

    /**
     * 发送事务性消息
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/api/v1/sendTransactionMsg")
    public Object sendTransactionMsg(@RequestBody TxMsg txMsg) throws Exception {
        String tag = txMsg.getTag();
        Object args = txMsg.getArgs();//其他参数,可以带到executeLocalTransactionBranch执行自己业务需要
        String msg = txMsg.getMsg();//msg
        Message message = new Message(TxConfig.TOPIC_NAME, tag, tag + "_key", msg.getBytes());
        TransactionSendResult sendResult = transactionProducer.getProducer().sendMessageInTransaction(message, args);
        logger.info("[生产者发送] sendStatus={}, localTransactionState = {},sendResult={}", sendResult.getSendStatus(), sendResult.getLocalTransactionState(), sendResult.toString());
        return String.format("[%s]sendResult=%s", LocalDate.now(Clock.systemDefaultZone()),JSON.toJSON(sendResult));
    }

}
