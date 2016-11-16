package microtwo;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value="/api/micro_two")
public class MicroServiceTwoController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    DatedGreeting index() {

        String today = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        return new DatedGreeting("Hello world from MicroService Two!", today);
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
