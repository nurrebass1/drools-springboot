package drools.example.drools.service;

import drools.example.drools.config.DroolsConfig;
import drools.example.drools.entity.Employee;
import drools.example.drools.entity.TimeSheet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DroolsConfig.class)
public class TimesheetServiceTest {

    @Autowired
    TimesheetService timesheetService;

    @Test
    public void getWokringHours_should_return_fired() {
        Employee employee = new Employee();
        TimeSheet timeSheet = new TimeSheet();
        timeSheet.setHours(28);
        String status = this.timesheetService.getWorkingHours(employee, timeSheet);

        assertThat(status, is("Fired"));
    }
}