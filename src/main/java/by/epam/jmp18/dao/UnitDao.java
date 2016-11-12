package by.epam.jmp18.dao;

import by.epam.jmp18.domain.Unit;

/**
 * Created by Vitali on 12.11.2016.
 */
public interface UnitDao {
    void save(Unit unit);
    Unit find(long id);
    void update(Unit unit);
    void delete(long id);
}
