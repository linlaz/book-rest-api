package com.lintech.maximum.service.inter;

import java.util.Map;

public interface CrudGlobal<T> {
    public Map findAll();
    public Map save(T obj);
    public Map findById(Long id);
    public Map deleteById(Long id);
    public Map updateById(Long id, T obj);
}
