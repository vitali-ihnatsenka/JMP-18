package by.epam.jmp18.service;

import by.epam.jmp18.dao.EmployeeDao;
import by.epam.jmp18.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vitali on 12.11.2016.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public Employee find(long id) {
        return employeeDao.find(id);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(long id) {
        employeeDao.delete(id);
    }
}
