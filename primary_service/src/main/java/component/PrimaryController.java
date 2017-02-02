package component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value="/api/primary")
public class PrimaryController {

    private static final Logger LOG = LoggerFactory.getLogger(PrimaryController.class);

    @Value("${micro.svc.one.uri}")
    private String microServiceOneBaseUri;

    @Value("${micro.svc.two.uri}")
    private String microServiceTwoBaseUri;

    @Autowired
    private PrimaryResourceRepository primaryResourceRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        LOG.info("Request received!");
        return "Hello world from Primary Service!";
    }

    @RequestMapping(value = "/resource/{id}", method = RequestMethod.GET)
    public PrimaryResource getPrimaryResource(@PathVariable("id") int id) {
        LOG.info("Request received - resource id : [{}]", id);
        PrimaryResource primaryResource = primaryResourceRepository.findOne(id);
        return primaryResource;
    }

    @RequestMapping(value = "/micro_one", method = RequestMethod.GET)
    public String microOne() throws IOException {
        return invokeMicroService(microServiceOneBaseUri);
    }

    @RequestMapping(value = "/micro_one/resource/{id}", method = RequestMethod.GET)
    public String microOneResource(@PathVariable("id") int id) throws IOException {
        return invokeMicroService(microServiceOneBaseUri + "/resource/" + id);
    }

    @RequestMapping(value = "/micro_two", method = RequestMethod.GET)
    public String microTwo() throws IOException {
        return invokeMicroService(microServiceTwoBaseUri);
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