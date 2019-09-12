package com.idempotent.mq.consumer;

import com.idempotent.mq.BaseConsumer;
import com.idempotent.mq.MessageHelper;
import com.idempotent.pojo.LoginLog;
import com.idempotent.service.LoginLogService;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginLogConsumer implements BaseConsumer {

    private static final Logger logger = LoggerFactory.getLogger(LoginLogConsumer.class);

    @Autowired
    private LoginLogService loginLogService;

    @Override
    public void consume(Message message, Channel channel) {
        logger.info("收到消息: {}", message.toString());
        LoginLog loginLog = MessageHelper.msgToObj(message, LoginLog.class);
        loginLogService.insert(loginLog);
    }
}
