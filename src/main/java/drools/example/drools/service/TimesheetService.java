package drools.example.drools.service;

import drools.example.drools.entity.Employee;
import drools.example.drools.entity.TimeSheet;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimesheetService {

    @Autowired
    KieContainer kieContainer;

    public String getWokringHours(Employee employee, TimeSheet timeSheet) {
        KieSession kieSession = this.kieContainer.newKieSession();
        kieSession.setGlobal("employee", employee);
        kieSession.insert(timeSheet);
        kieSession.fireAllRules();
        kieSession.dispose();

        return employee.getName();
    }
}
