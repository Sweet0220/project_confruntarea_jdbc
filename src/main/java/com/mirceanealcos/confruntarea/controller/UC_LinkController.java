package com.mirceanealcos.confruntarea.controller;

import com.mirceanealcos.confruntarea.entity.UC_Link;
import com.mirceanealcos.confruntarea.service.UC_LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/uc_links")
public class UC_LinkController {

    @Autowired
    UC_LinkService uc_linkService;

    @GetMapping
    public ResponseEntity<List<UC_Link>> getAllLinks() {
        try{
            List<UC_Link> links = uc_linkService.getAllLinks();
            return new ResponseEntity<>(links, HttpStatus.OK);
        }catch (IncorrectResultSizeDataAccessException e) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path="/user_id/{id}")
    public ResponseEntity<List<UC_Link>> getLinksByUserId(@PathVariable("id") Long user_id) {
        try{
            List<UC_Link> links = uc_linkService.getLinksByUserId(user_id);
            return new ResponseEntity<>(links, HttpStatus.OK);
        }catch (IncorrectResultSizeDataAccessException e) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path="/champion_id/{id}")
    public ResponseEntity<List<UC_Link>> getLinksByChampionId(@PathVariable("id") Long champion_id) {
        try{
            List<UC_Link> links = uc_linkService.getLinksByChampionId(champion_id);
            return new ResponseEntity<>(links, HttpStatus.OK);
        }catch (IncorrectResultSizeDataAccessException e) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(path="/add")
    public ResponseEntity<String> addLink(@RequestBody UC_Link link) {
        try{
            uc_linkService.addLink(link);
            return new ResponseEntity<>("Link added successfully!", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path="/update")
    public ResponseEntity<String> updateLink(@RequestBody List<UC_Link> links) {
        try{
            uc_linkService.updateLink(links.get(0), links.get(1));
            return new ResponseEntity<>("Link updated successfully!", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path="/delete/all")
    public ResponseEntity<String> deleteAllLinks() {
        int numRows = uc_linkService.deleteAllLinks();
        return new ResponseEntity<>("Deleted "+ numRows + " link(s)..", HttpStatus.OK);
    }

    @DeleteMapping(path="/delete/user_id/{id}")
    public ResponseEntity<String> deleteLinksByUserId(@PathVariable("id") Long user_id) {
        int numRows = uc_linkService.deleteLinkByUserId(user_id);
        return new ResponseEntity<>("Deleted " + numRows + " link(s) with user_id " + user_id + "..", HttpStatus.OK);
    }

    @DeleteMapping(path="/delete/champion_id/{id}")
    public ResponseEntity<String> deleteLinksByChampionId(@PathVariable("id") Long champion_id) {
        int numRows = uc_linkService.deleteLinkByChampionId(champion_id);
        return new ResponseEntity<>("Deleted " + numRows + " link(s) with champion_id " + champion_id + "..", HttpStatus.OK);
    }

}
