package com.unilearntech.unilearntech.utils.activemq;


import com.google.gson.Gson;
import com.unilearntech.unilearntech.service.file.FileStoreService;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class VideoEncodingListener {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(VideoEncodingListener.class);
    @Autowired FileStoreService fileStoreService;


    @JmsListener(destination = "video-encode", concurrency = "${spring.activemq.craete-job.listener.concurrency:5}")
    public void videoEncoding(final Message message) throws JMSException {
        try {
            logger.info("Message Received:{}", message);
            boolean contextSuccess = setupContext(message);
            if (!contextSuccess) {
                logger.error("Invalid message context headers");
                return;
            }
            processVideoEncoding(message);
        } finally {

        }
    }

    private void processVideoEncoding(Message message) throws JMSException {
        if (!(message instanceof TextMessage)) {
            logger.error("Message Received is not text message:{}", message);
            return;
        }
        TextMessage textMessage = (TextMessage) message;
        String messageText = textMessage.getText();
        logger.info("Message Text Received:{}", messageText);
        try {
            logger.info("messageText : {}",messageText);
            VideoEncodingEvent videoEncodingEvent = new Gson().fromJson(messageText, VideoEncodingEvent.class);
            logger.info("Video path from jsm video event : {}",videoEncodingEvent.getVideoPath());
            fileStoreService.encode(videoEncodingEvent);
        } catch (Exception e) {
            logger.error("Exception while processing message", e);
        }
    }

    private boolean setupContext(Message message) throws JMSException {
        return true;

    }
}