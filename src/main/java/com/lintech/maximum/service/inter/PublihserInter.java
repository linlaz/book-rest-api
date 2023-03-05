package com.lintech.maximum.service.inter;

import com.lintech.maximum.model.Publisher;

import java.util.ArrayList;
import java.util.Map;

public interface PublihserInter extends CrudGlobal<Publisher> {

    public Map findBookWithIdAuthor(Long id);

}
