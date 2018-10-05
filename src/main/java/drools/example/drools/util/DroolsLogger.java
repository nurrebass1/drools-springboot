package drools.example.drools.util;

import org.drools.core.spi.KnowledgeHelper;

public class DroolsLogger {

    public static void helper(final KnowledgeHelper drools){
        System.out.println("\nrule triggered: " + drools.getRule().getName());
    }

}
