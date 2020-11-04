import javax.annotation.Resource;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.jms.*;

/**
 * Created by nikita on 23.10.2020.
 */
@Stateful
public class Sender {
    @Resource(mappedName = "java:/jms/queue/test")
    private Queue queue;

    @Inject
    private JMSContext context;

    public void sendMessage(String txt) {
        context.createProducer().send(queue, txt);
    }
}