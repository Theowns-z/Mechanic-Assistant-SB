package com.Theowns.services.interfaces;

import com.Theowns.services.exceptions.ExceptionObjectNotFound;

import java.util.ArrayList;
import java.util.List;

public interface InterfaceService <T> {

    List<T> getAll();
    T getOne(Long id) throws ExceptionObjectNotFound;
    T save(T object);
    T update(Long id, T object) throws ExceptionObjectNotFound;
    String delete(Long id) throws ExceptionObjectNotFound;

}
