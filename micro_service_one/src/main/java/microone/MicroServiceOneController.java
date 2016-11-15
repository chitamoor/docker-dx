package microone;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MicroServiceOneController {
    
    @RequestMapping("/micro_one")
    public @ResponseBody
    ServiceGreeting index() {
        return new ServiceGreeting("You have hit MicroService One!");
    }

}

class ServiceGreeting {

    private final String content;

    public ServiceGreeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
