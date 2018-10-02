package drools.example.drools.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("drools.example.drools")
public class DroolsConfig {

    private static final String RULES_PATH = "rules/";

    KieServices kieServices = KieServices.Factory.get();

    public KieFileSystem getKieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = this.kieServices.newKieFileSystem();
        List<String> rules = Arrays.asList("product.drl", "taxi.drl", "timesheet.drl");

        rules.forEach(rule -> {
            kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_PATH + rule));
        });

        return kieFileSystem;
    }

    @Bean
    public KieContainer kieContainer() throws IOException {

        KieBuilder kieBuilder = this.kieServices.newKieBuilder(getKieFileSystem());
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();

        return this.kieServices.newKieContainer(kieModule.getReleaseId());
    }
}
