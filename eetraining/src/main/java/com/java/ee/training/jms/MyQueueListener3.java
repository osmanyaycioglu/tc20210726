package com.java.ee.training.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
                                    @ActivationConfigProperty(propertyName = "destination",
                                                              propertyValue = "MyJMSQueue"),
                                    @ActivationConfigProperty(propertyName = "destinationType",
                                                              propertyValue = "javax.jms.Queue")

})
public class MyQueueListener3 implements MessageListener {

    public MyQueueListener3() {
    }

    @Override
    public void onMessage(final Message message) {
        if (message instanceof TextMessage) {
            TextMessage messageLoc = (TextMessage) message;
            try {
                String textLoc = messageLoc.getText();
                System.out.println("Listener 3 : " + textLoc);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
