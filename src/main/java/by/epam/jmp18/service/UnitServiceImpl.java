package by.epam.jmp18.service;

import by.epam.jmp18.dao.UnitDao;
import by.epam.jmp18.domain.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vitali on 12.11.2016.
 */
@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitDao unitDao;

    @Override
    public void save(Unit unit) {
        unitDao.save(unit);
    }

    @Override
    public Unit find(long id) {
        return unitDao.find(id);
    }

    @Override
    public void update(Unit unit) {
        unitDao.update(unit);
    }

    @Override
    public void delete(long id) {
        unitDao.delete(id);
    }
}
