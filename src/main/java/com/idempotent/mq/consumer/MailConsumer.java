package com.idempotent.mq.consumer;

import com.idempotent.exception.ServiceException;
import com.idempotent.mq.BaseConsumer;
import com.idempotent.mq.MessageHelper;
import com.idempotent.pojo.Mail;
import com.idempotent.util.MailUtil;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailConsumer implements BaseConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MailConsumer.class);

    @Autowired
    private MailUtil mailUtil;

    @Override
    public void consume(Message message, Channel channel) {
        Mail mail = MessageHelper.msgToObj(message, Mail.class);
        logger.info("收到消息: {}", mail.toString());

        boolean success = mailUtil.send(mail);
        if (!success) {
            throw new ServiceException("send mail error");
        }
    }

}
