package drools.example.drools.entity;

import lombok.Data;

import java.util.List;

@Data
public class Employee {

    private String name;
    private String status;
    private TimeSheet hours;
    private List<ProductOwner> productOwners;
    private Boolean dayOffWork;
    
}
