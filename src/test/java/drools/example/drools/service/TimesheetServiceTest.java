package drools.example.drools.service;

import drools.example.drools.config.DroolsConfig;
import drools.example.drools.entity.Employee;
import drools.example.drools.entity.ProductOwner;
import drools.example.drools.entity.TimeSheet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DroolsConfig.class)
public class TimesheetServiceTest {

    @Autowired
    TimesheetService timesheetService;

    @Test
    public void getWorkingHours_should_return_dayOffWork_true() {
        Employee employee = new Employee();
        TimeSheet timeSheet = new TimeSheet();
        timeSheet.setHours(28);
        ProductOwner product = new ProductOwner();
        product.setType("BOB");
        employee.setProductOwners(Collections.singletonList(product));
        this.timesheetService.getWorkingHours(employee, product);

        assertThat(employee.getDayOffWork(), is(true));
    }

    @Test
    public void getWorkingHours_should_return_dayOffWork_false() {
        Employee employee = new Employee();
        ProductOwner product = new ProductOwner();
        product.setType("NOT BOB");
        employee.setProductOwners(Collections.singletonList(product));
        this.timesheetService.getWorkingHours(employee, product);

        assertThat(employee.getDayOffWork(), is(false));
    }
}
