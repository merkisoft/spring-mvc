package model;

import java.math.BigDecimal;
import java.nio.charset.UnmappableCharacterException;
import java.util.*;

import com.clusterpoint.api.CPSConnection;
import com.clusterpoint.api.request.CPSSearchRequest;
import com.clusterpoint.api.response.CPSSearchResponse;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * Created by yirk on 10.07.15.
 */
public class Products {
    private static Map< String, Product> products = new HashMap<>();

    static {
        products.put("Thon", new Product(1, "Thon", new BigDecimal(35)));
        products.put("Koriander", new Product(2, "Koriander", new BigDecimal(4)));
        products.put("Mascarpone", new Product(2, "Mascarpone", new BigDecimal(3.5)));
    }

    private static Products instance = null;

    public static Products getInstance() {
        if (instance == null) {
            instance = new Products();
        }

        return instance;
    }

    private CPSConnection cpsConnection;

    public Products() {
        try {
            cpsConnection = new CPSConnection("tcps://cloud-eu-0.clusterpoint.com:9008", "Products",
                    System.getProperty( "DB_USER"), System.getProperty( "DB_PASSWORD"),
                    System.getProperty( "DB_ACCOUNT"), "document", "//document/id");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Collection< Product> getProducts() {
        List< Product> productList = new ArrayList<>();

        try {
            Map<String, String> list = new HashMap<String, String>();
            list.put("id", "yes");
            list.put("name", "yes");
            list.put("price", "yes");

            CPSSearchRequest searchRequest = new CPSSearchRequest( "*", 0, 200, list);
            CPSSearchResponse searchResponse = (CPSSearchResponse) cpsConnection.sendRequest(searchRequest);

            if (searchResponse.getHits() > 0) {
                System.out.println("Found:" + searchResponse.getHits());

                List<Element> results = searchResponse.getDocuments();
                Iterator<Element> it = results.iterator();

                JAXBContext context = JAXBContext.newInstance(Product.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();

                while (it.hasNext()) {
                    Product product = (Product) unmarshaller.unmarshal(it.next());
                    productList.add( product);
                }
            }

            } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return productList;
    }

    public Product getProduct(String name) {
        return products.get(name);
    }
}
