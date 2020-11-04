package Bean;

import Controller.RestController;
import Model.Tariff;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by nikita on 21.10.2020.
 */
@Named("tariffBean")
@Stateless
public class TariffBean implements Serializable {

    @EJB
    private RestController rest;

    @Inject
    @Push(channel = "push")
    PushContext pushContext;


    private List<Tariff> tariffs;

    public void setTariffs(List<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    public List<Tariff> getTariffs() {
        return rest.getTariffs();
    }

    public void update() {
        pushContext.send("updateTariffs");
    }
}
