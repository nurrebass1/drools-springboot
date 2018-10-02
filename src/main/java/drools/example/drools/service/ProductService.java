package drools.example.drools.service;

import drools.example.drools.entity.Product;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    KieContainer kieContainer;

    public int getProductDiscount(Product product) {
        KieSession kieSession = this.kieContainer.newKieSession();
        kieSession.insert(product);
        kieSession.fireAllRules();
        kieSession.dispose();

        return product.getDiscount();
    }
}
