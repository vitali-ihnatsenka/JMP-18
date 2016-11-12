package by.epam.jmp18.service;

import by.epam.jmp18.dao.ProjectDao;
import by.epam.jmp18.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vitali on 12.11.2016.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public void save(Project project) {
        projectDao.save(project);
    }

    @Override
    public Project find(long id) {
        return projectDao.find(id);
    }

    @Override
    public void update(Project project) {
        projectDao.update(project);
    }

    @Override
    public void delete(long id) {
        projectDao.delete(id);
    }
}
