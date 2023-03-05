package com.lintech.maximum.service.impl;

import com.lintech.maximum.model.Author;
import com.lintech.maximum.model.Publisher;
import com.lintech.maximum.repository.AuthorRepository;
import com.lintech.maximum.service.inter.AuthorInter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AuthorService implements AuthorInter {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Map findAll() {
        Map<String,Object> map = new HashMap();
        List list = authorRepository.findAll();

        try {
            map.put("data",list);
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
    public Map save(Author obj) {
        Map<String,Object> map = new HashMap();
        try{
            Author authorObj = authorRepository.save(obj);
            map.put("data",authorObj);
            map.put("code", HttpStatus.CREATED);
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
            map.put("data", authorRepository.findById(id));
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
            authorRepository.deleteById(id);
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
    public Map updateById(Long id, Author obj) {
        Map<String,Object> map = new HashMap();
        try{
            Integer boo = authorRepository.updateAllEntityByIdAndParameter(id,obj.getName(),obj.getDesc());
            if(boo != 0){
                map.put("data",boo);
                map.put("code", HttpStatus.OK);
                map.put("message","success");
                return map;
            }else {
                throw new Exception("Perubahasan gagal");
            }

        }catch (Exception e){
            map.put("code",HttpStatus.BAD_REQUEST);
            map.put("message",e.getMessage());
            return map;
        }
    }
}
