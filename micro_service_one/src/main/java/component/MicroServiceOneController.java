package component;

import component.repository.SecondaryResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/micro_one")
public class MicroServiceOneController {

    @Autowired
    private SecondaryResourceRepository secondaryResourceRepository;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ServiceGreeting index() {
        return new ServiceGreeting("Hello world from MicroService One!");
    }

    @RequestMapping(value = "/resource/{id}", method = RequestMethod.GET)
    public component.domain.SecondaryResource getSecondaryResource(@PathVariable("id") int id) {
        component.domain.SecondaryResource secondaryResource = secondaryResourceRepository.findOne(id);
        return secondaryResource;
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
