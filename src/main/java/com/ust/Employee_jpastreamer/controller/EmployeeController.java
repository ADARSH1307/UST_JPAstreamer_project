package com.ust.Employee_jpastreamer.controller;

import com.ust.Employee_jpastreamer.model.Employee;
import com.ust.Employee_jpastreamer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public List<Employee> saveEmployee(@RequestBody List<Employee> employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/groupByCity")
    public Map<String, List<Employee>> groupbyEmployeeByCity(){
        return employeeService.groupbyEmployeeByCity();
    }
    @GetMapping("/findall")
    public List<Employee> groupbyEmployeeByPaymentTier(){
        return employeeService.groupbyEmployeeByPaymentTier();
    }
    @GetMapping("/ageRange/{minAge}/{maxAge}")
    public List<Employee> groupbyEmployeeByAgeRange(@PathVariable int minAge, @PathVariable int maxAge){
        return employeeService.groupbyEmployeeByAgeRange(minAge, maxAge);
    }
    @GetMapping("/genderCount/{gender}")
    public long getCountByGender(@PathVariable String gender) {
        return employeeService.getCountByGender(gender);
    }
    @GetMapping("/employeesByJoiningYear/{joiningYear}")
    public List<Employee> getEmployeesByJoiningYear(@PathVariable int joiningYear) {
        return employeeService.getEmployeesByJoiningYear(joiningYear);
    }
    @GetMapping("/employeesByGenderAndJoiningYear/{gender}/{joiningYear}")
    public List<Employee> getEmployeesByGenderAndJoiningYear(@PathVariable String gender, @PathVariable int joiningYear) {
        return employeeService.getEmployeesByGenderAndJoiningYear(gender, joiningYear);
    }
    @GetMapping("/groupByEducation")
    public Map<String, List<Employee>> groupbyEmployeeByEducation(){
        return employeeService.groupbyEmployeeByEducation();
    }
    @GetMapping("/filterEmployees/{year}/{gender}/{experience}/{education}")
    public List<Employee> filterEmployees(
            @PathVariable int year,
            @PathVariable String gender,
            @PathVariable int experience,
            @PathVariable String education) {
        return employeeService.filterEmployees(year, gender, experience, education);
    }
}
