package Controller;

import Model.Tariff;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


import javax.ejb.Singleton;
import java.util.List;

/**
 * Created by nikita on 21.10.2020.
 */
@Singleton
public class RestController {

    public List<Tariff> getTariffs() {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        WebResource webResource = client.resource("http://localhost:8082/tariffs");

        List<Tariff> tariffs = webResource.type("application/json").get(new GenericType<List<Tariff>>(){
        });

        return tariffs;

    }
}
