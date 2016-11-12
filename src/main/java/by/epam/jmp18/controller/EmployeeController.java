package by.epam.jmp18.controller;

import by.epam.jmp18.domain.Employee;
import by.epam.jmp18.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Vitali on 12.11.2016.
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id ) {
        Employee employee = employeeService.find(id);
        if(employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        Employee currentEmployee = employeeService.find(id);
        if (currentEmployee==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentEmployee.setName(employee.getName());
        employeeService.update(currentEmployee);
        return new ResponseEntity<>(currentEmployee, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id) {
        Employee employee = employeeService.find(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
