package Bean;

import Controller.RestController;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by nikita on 21.10.2020.
 */
@MessageDriven(name = "Consumer", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/test"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class MessageDrivenBean implements MessageListener {


    @EJB
    private TariffBean tariffBean;

    public void onMessage(Message rcvMessage) {
        tariffBean.update();
        System.out.println("Message confirm");
    }
}
