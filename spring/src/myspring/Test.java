package myspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(produces = "application/json")
public class Test {

    @RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Map> getTest(@PathVariable String name) {

        List<Map> ret = new ArrayList<>();
        HashMap map = new HashMap();
        map.put(name, name);
        ret.add(map);

        return ret;

    }

    @RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getRestaurant(@PathVariable String id) {

        return id;

    }

}
