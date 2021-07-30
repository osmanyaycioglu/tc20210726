package com.java.ee.training.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@JMSDestinationDefinitions({
                             @JMSDestinationDefinition(destinationName = "MyJMSQueue",
                                                       name = "java:/jms/MyJMSQueue",
                                                       interfaceName = "javax.jms.Queue"),
                             @JMSDestinationDefinition(destinationName = "MyJMSTopic",
                                                       name = "java:/jms/MyJMSTopic",
                                                       interfaceName = "javax.jms.Topic")
})
@MessageDriven(activationConfig = {
                                    @ActivationConfigProperty(propertyName = "destination",
                                                              propertyValue = "MyJMSQueue"),
                                    @ActivationConfigProperty(propertyName = "destinationType",
                                                              propertyValue = "javax.jms.Queue")

})
public class MyQueueListener1 implements MessageListener {

    public MyQueueListener1() {
    }

    @Override
    public void onMessage(final Message message) {
        if (message instanceof TextMessage) {
            TextMessage messageLoc = (TextMessage) message;
            try {
                String textLoc = messageLoc.getText();
                System.out.println("Listener 1 : " + textLoc);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
