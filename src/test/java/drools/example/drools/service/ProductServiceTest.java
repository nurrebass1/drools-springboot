package drools.example.drools.service;

import drools.example.drools.config.DroolsConfig;
import drools.example.drools.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DroolsConfig.class)
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void getProductDiscount_should_return_15() {
        Product product = new Product();
        product.setType("Diamond");
        int disount = this.productService.getProductDiscount(product);

        assertThat(disount, is(15));
    }
}