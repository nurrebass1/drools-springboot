package drools.example.drools.entity;

import lombok.Data;

@Data
public class Employee {

    private String name;
    private String status;
    private TimeSheet hours;
}
