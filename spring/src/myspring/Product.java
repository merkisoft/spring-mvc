package myspring;

import model.Products;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by yirk on 10.07.15.
 */
@Controller
@RequestMapping(produces = "application/json")
public class Product {

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public
    @ResponseBody
    Collection<model.Product> getProducts() {
        return Products.getInstance().getProducts();
    }

    @RequestMapping(value = "/product/name/{name}", method = RequestMethod.GET)
    public
    @ResponseBody
    model.Product getProduct(@PathVariable String name) {

        model.Product product = Products.getInstance().getProduct(name);

        return product;
    }


}
