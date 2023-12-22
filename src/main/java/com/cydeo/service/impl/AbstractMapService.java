package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService <ID,T> {

    protected Map<ID,T> map=new HashMap<>();

    T save(ID id, T object){
        map.put(id, object);

        return object;
    }

    List<T> findAll(){

        return new ArrayList<>(map.values()); // since im returning list I create a new list and return values stored in my created hashMap
    }


    T findById(ID id){

        return  map.get(id);
    }

    void deleteById(ID id){
        map.remove(id);
    }


    void update (ID id,T object){



        map.put(id,object);
    }


}

