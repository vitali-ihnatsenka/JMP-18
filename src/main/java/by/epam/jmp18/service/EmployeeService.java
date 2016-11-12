package by.epam.jmp18.service;

import by.epam.jmp18.domain.Employee;

/**
 * Created by Vitali on 12.11.2016.
 */
public interface EmployeeService {
    void save(Employee employee);
    Employee find(long id);
    void update(Employee employee);
    void delete(long id);
}
