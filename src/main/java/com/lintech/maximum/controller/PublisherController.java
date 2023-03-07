package com.lintech.maximum.controller;

import com.lintech.maximum.model.Publisher;
import com.lintech.maximum.service.inter.PublihserInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublihserInter publihserInter;

    @PostMapping("")
    public ResponseEntity<Map> save(@RequestBody Publisher publisher){
            return new ResponseEntity<Map>(publihserInter.save(publisher), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<Map> findAll(){
        return new ResponseEntity<Map>(publihserInter.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map> getById(@PathVariable("id") Long id ){
        return new ResponseEntity<Map>(publihserInter.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map> deleteById(@PathVariable("id") Long id ){
        return new ResponseEntity<Map>(publihserInter.deleteById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map> deleteById(@PathVariable("id") Long id ,@RequestBody Publisher publisher){
        System.out.println(publisher);
        return new ResponseEntity<Map>(publihserInter.updateById(id,publisher), HttpStatus.OK);
    }

    @GetMapping("/buku/{id}")
    public ResponseEntity<Map> findBookWithIdAuthor(@PathVariable("id") Long id){
        return new ResponseEntity<Map>(publihserInter.findBookWithIdAuthor(id),HttpStatus.OK);
    }
}
