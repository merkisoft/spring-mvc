package myspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Order getUserId(@PathVariable String id) {

        Order order = new Order();
        order.setId(id);
        Item item = new Item();
        item.setId("123");
        item.setName("Computer");
        order.setItems(Arrays.asList(item));
        return order;

    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public
    @ResponseBody
    Order postOrder(@RequestBody Order order) {
        order.setId("bla");
        return order;
    }

}
