package by.epam.jmp18.dao;

import by.epam.jmp18.domain.Project;

/**
 * Created by Vitali on 12.11.2016.
 */
public interface ProjectDao {
    void save(Project project);
    Project find(long id);
    void update(Project project);
    void delete(long id);
}
