package com.cydeo.service;

import java.util.List;

public interface CrudService <T,ID> {
    //my generics for the delete, updates, find for objects that might require those functionalities and prevent

    T save(T obj);

    List<T> findAll();

    T findById (ID id);

  //  void delete(T object);

    void deleteById(ID id);
}
