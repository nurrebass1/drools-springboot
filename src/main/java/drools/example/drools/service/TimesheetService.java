package drools.example.drools.service;

import drools.example.drools.entity.Employee;
import drools.example.drools.entity.ProductOwner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimesheetService {

    @Autowired
    KieContainer kieContainer;

    public String getWorkingHours(Employee employee, ProductOwner product) {
        KieSession kieSession = this.kieContainer.newKieSession();
        employee.setDayOffWork(false);
        kieSession.insert(product);
        kieSession.insert(employee);
        kieSession.fireAllRules();
        kieSession.dispose();

        return employee.getStatus();
    }
}
