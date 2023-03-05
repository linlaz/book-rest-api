package com.lintech.maximum.service.impl;

import com.lintech.maximum.model.Publisher;
import com.lintech.maximum.repository.BookRepository;
import com.lintech.maximum.repository.PublisherRepository;
import com.lintech.maximum.service.inter.PublihserInter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PublisherService implements PublihserInter {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Map findAll() {
         Map<String,Object> map = new HashMap();
        List list = publisherRepository.findAll();
        map.put("data",list);
        map.put("code", HttpStatus.OK);
        map.put("message","success");
        return map;
    }

    @Override
    public Map save(Publisher obj) {
         Map<String,Object> map = new HashMap();

        try{
            Publisher publisherObj = publisherRepository.save(obj);
            map.put("data",publisherObj);
            map.put("code", HttpStatus.OK);
            map.put("message","success");
            return map;
        }catch (Exception e){
            map.put("code",HttpStatus.BAD_REQUEST);
            map.put("message",e.getMessage());
            return map;
        }
    }
    @Override
    public Map findById(Long id) {
         Map<String,Object> map = new HashMap();
        try{
            map.put("data", publisherRepository.findById(id));
            map.put("code", HttpStatus.OK);
            map.put("message","success");
            return map;
        }catch (Exception e){
            map.put("code",HttpStatus.BAD_REQUEST);
            map.put("message",e.getMessage());
            return map;
        }

    }
    @Override
    public Map deleteById(Long id) {
         Map<String,Object> map = new HashMap();

        try{
            publisherRepository.deleteById(id);
            map.put("code", HttpStatus.OK);
            map.put("message","success");
            return map;
        }catch (Exception e){
            map.put("code",HttpStatus.BAD_REQUEST);
            map.put("message",e.getMessage());
            return map;
        }

    }

    @Override
    public Map updateById(Long id,  Publisher publisher) {
         Map<String,Object> map = new HashMap();
        try {
            map.put("data", publisherRepository.updateAll(publisher.getName(), publisher.getAddress(), publisher.getDesc(), id));
            map.put("code", HttpStatus.OK);
            map.put("message", "success");
        } catch (Exception e) {
            map.put("code", HttpStatus.BAD_REQUEST);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @Override
    public Map findBookWithIdAuthor(Long id) {
         Map<String,Object> map = new HashMap();
        try{
            map.put("data",bookRepository.findBookByPublisherId(id));
            map.put("code", HttpStatus.OK);
            map.put("message","success");
            return map;
        }catch (Exception e){
            map.put("code",HttpStatus.BAD_REQUEST);
            map.put("message",e.getMessage());
            return map;
        }
    }

}
