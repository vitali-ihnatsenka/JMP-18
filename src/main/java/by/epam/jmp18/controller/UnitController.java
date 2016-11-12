package by.epam.jmp18.controller;

import by.epam.jmp18.domain.Unit;
import by.epam.jmp18.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Vitali on 12.11.2016.
 */
@RestController
@RequestMapping(value = "/unit")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createUnit(@RequestBody Unit unit){
        unitService.save(unit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Unit> getUnit(@PathVariable("id") long id ) {
        Unit unit = unitService.find(id);
        if(unit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(unit, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Unit> updateUnit(@PathVariable("id") long id, @RequestBody Unit unit) {
        Unit currentUnit = unitService.find(id);
        if (unit==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentUnit.setName(unit.getName());
        unitService.update(currentUnit);
        return new ResponseEntity<>(currentUnit, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Unit> deleteUnit(@PathVariable("id") long id) {
        Unit unit = unitService.find(id);
        if (unit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        unitService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
