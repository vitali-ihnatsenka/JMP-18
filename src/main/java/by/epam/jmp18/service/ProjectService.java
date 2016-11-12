package by.epam.jmp18.service;

import by.epam.jmp18.domain.Project;

/**
 * Created by Vitali on 12.11.2016.
 */
public interface ProjectService {
    void save(Project project);
    Project find(long id);
    void update(Project project);
    void delete(long id);
}
