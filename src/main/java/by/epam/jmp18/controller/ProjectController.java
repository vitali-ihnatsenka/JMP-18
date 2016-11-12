package by.epam.jmp18.controller;

import by.epam.jmp18.domain.Project;
import by.epam.jmp18.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Vitali on 12.11.2016.
 */
@RestController
@RequestMapping(value = "/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createProject(@RequestBody Project project){
        projectService.save(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> getProject(@PathVariable("id") long id ) {
        Project project =projectService.find(id);
        if(project == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Project> updateProject(@PathVariable("id") long id, @RequestBody Project project) {
        Project currentProject = projectService.find(id);
        if (currentProject==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentProject.setName(project.getName());
        projectService.update(currentProject);
        return new ResponseEntity<>(currentProject, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Project> deleteProject(@PathVariable("id") long id) {
        Project project = projectService.find(id);
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        projectService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
