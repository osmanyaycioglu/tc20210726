package com.java.ee.training.jms;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/jms")
@ApplicationScoped
public class JmsRest implements Serializable {

    @Inject
    private JMSContext        jmsContext;

    @Resource(lookup = "java:/jms/MyJMSQueue")
    private Queue             queue;

    @Resource(lookup = "java:/jms/MyJMSTopic")
    private Topic             topic;

    private static final long serialVersionUID = 1;

    @Path("/queue")
    @GET
    public String call(@QueryParam("text") final String text) {
        this.jmsContext.createProducer()
                       .send(this.queue,
                             text);
        return "SUCCESS";
    }

    @Path("/topic")
    @GET
    public String topic(@QueryParam("text") final String text) {
        this.jmsContext.createProducer()
                       .send(this.topic,
                             text);
        return "SUCCESS";
    }

}
