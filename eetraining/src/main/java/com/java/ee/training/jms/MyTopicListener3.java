package com.java.ee.training.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
                                    @ActivationConfigProperty(propertyName = "destination",
                                                              propertyValue = "MyJMSTopic"),
                                    @ActivationConfigProperty(propertyName = "destinationType",
                                                              propertyValue = "javax.jms.Topic")

})
public class MyTopicListener3 implements MessageListener {

    public MyTopicListener3() {
    }

    @Override
    public void onMessage(final Message message) {
        if (message instanceof TextMessage) {
            TextMessage messageLoc = (TextMessage) message;
            try {
                String textLoc = messageLoc.getText();
                System.out.println("Topic Listener 3 : " + textLoc);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
