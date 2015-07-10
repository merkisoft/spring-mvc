package myspring;

import model.Products;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/product/id/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    model.Product getProduct(@PathVariable Integer id) {
        return null;
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    public
    @ResponseBody
    Boolean updateProduct(@RequestBody model.Product product) {
        Products.getInstance().updateProduct(product);

        return true;
    }


}
