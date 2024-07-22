package com.ust.Employee_jpastreamer.service;



import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.Employee_jpastreamer.model.Employee;
import com.ust.Employee_jpastreamer.repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private Employeerepo employeeRepository;

    private final JPAStreamer jpaStreamer;

    @Autowired
    public EmployeeService(final JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }


    public Map<String, List<Employee>> groupbyEmployeeByCity() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getCity));
    }

    public List<Employee> groupbyEmployeeByPaymentTier() {
        return employeeRepository.findAll() ;
    }

    public List<Employee> saveEmployee(List<Employee> employee) {
        return employeeRepository.saveAll(employee);
    }

    public List<Employee> groupbyEmployeeByAgeRange(Integer minAge, Integer maxAge) {
        return jpaStreamer.stream(Employee.class)
               .filter(e -> e.getAge() >= minAge && e.getAge() <= maxAge)
               .collect(Collectors.toList());


    }

    public long getCountByGender(String gender) {
        return jpaStreamer.stream(Employee.class)
                .filter(e -> e.getGender().equalsIgnoreCase(gender))
                .count();
    }

    public List<Employee> getEmployeesByJoiningYear(int joiningYear) {
        return jpaStreamer.stream(Employee.class)
                .filter(e -> e.getJoiningYear() == joiningYear)
                .collect(Collectors.toList());
    }
    public List<Employee> getEmployeesByGenderAndJoiningYear(String gender, int joiningYear) {
        return jpaStreamer.stream(Employee.class)
                .filter(e -> e.getGender().equalsIgnoreCase(gender) && e.getJoiningYear() == joiningYear)
                .collect(Collectors.toList());
    }

    public Map<String, List<Employee>> groupbyEmployeeByEducation() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getEducation));
    }
    public List<Employee> filterEmployees(int year, String gender, int experience, String education) {
        return jpaStreamer.stream(Employee.class)
                .filter(e -> e.getJoiningYear() == year)
                .filter(e -> e.getGender().equalsIgnoreCase(gender))
                .filter(e -> e.getExperienceInCurrentDomain() >= experience)
                .filter(e -> e.getEducation().equalsIgnoreCase(education))
                .collect(Collectors.toList());
    }
}
