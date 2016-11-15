package microtwo;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MicroServiceTwoController {

    @RequestMapping("/micro_two")
    public @ResponseBody
    DatedGreeting index() {
        return new DatedGreeting("You have hit MicroService Two!", "12/12/2004");
    }

}

class DatedGreeting {

    private final String date;
    private final String content;

    public DatedGreeting(String content, String date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

}
