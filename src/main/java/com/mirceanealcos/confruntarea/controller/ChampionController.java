package com.mirceanealcos.confruntarea.controller;

import com.mirceanealcos.confruntarea.entity.Champion;
import com.mirceanealcos.confruntarea.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api/champions")
public class ChampionController {

    @Autowired
    ChampionService championService;

    @GetMapping
    public ResponseEntity<List<Champion>> getAllChampions() {
        try{
            List<Champion> champions = championService.getAllChampions();
            if(champions.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(champions, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Champion> getChampionById(@PathVariable("id") Long id) {
        Champion champ = championService.getChampionById(id);
        if(champ != null)
            return new ResponseEntity<>(champ,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @GetMapping(path="/name/{name}")
    public ResponseEntity<Champion> getChampionByName(@PathVariable("name") String name) {
        Champion champ = championService.getChampionByName(name);
        if(champ != null)
            return new ResponseEntity<>(champ,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @PostMapping(path="/add")
    public ResponseEntity<String> addNewChampion(@RequestBody Champion champ) {
        try {
            championService.addNewChampion(champ);
            return new ResponseEntity<>("Champion added successfully!",HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Error..", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<String> deleteChampionById(@PathVariable("id") Long id) {
        int num = championService.deleteChampionById(id);
        if(num != 0)
            return new ResponseEntity<>("Successfully deleted champion!", HttpStatus.OK);
        return new ResponseEntity<>("Champion does not exist!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(path="/delete/all")
    public ResponseEntity<String> deleteAllChampions() {
        int num = championService.deleteAllChampions();
        if(num != 0)
            return new ResponseEntity<>("Successfully deleted " + num + " champion(s)!",HttpStatus.OK);
        return new ResponseEntity<>("No champions in database to delete..", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(path="/update/{id}")
    public ResponseEntity<String> updateChampion(@PathVariable("id") Long id, @RequestBody Champion champ) {
        try {
            if(championService.updateChampion(id,champ))
                return new ResponseEntity<>("Champion updated successfully!",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Error..", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
