package component;

import component.domain.PrimaryResource;
import component.repository.PrimaryResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
public class PrimaryController {

    @Value("${micro.svc.one.uri}")
    private String microServiceOneUri;

    @Value("${micro.svc.two.uri}")
    private String microServiceTwoUri;

    @Autowired
    private PrimaryResourceRepository primaryResourceRepository;

    @RequestMapping("/primary")
    public String endPoint() {
        return "You have hit the Primary Service!!!";
    }

    @RequestMapping(value = "/primary/resource/{id}", method = RequestMethod.GET)
    public PrimaryResource getPrimaryResource(@PathVariable("id") int id) {
        PrimaryResource primaryResource = primaryResourceRepository.findOne(id);
        return primaryResource;
    }

    @RequestMapping("/primary/env")
    public String env() throws IOException {
        return microServiceOneUri;
    }

    @RequestMapping("/primary/micro_one")
    public String microOne() throws IOException {
        return invokeMicroService(microServiceOneUri + "/micro_one");
    }

    @RequestMapping("/primary/micro_two")
    public String microTwo() throws IOException {
        return invokeMicroService(microServiceTwoUri + "/micro_two");
    }

    private String invokeMicroService(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}