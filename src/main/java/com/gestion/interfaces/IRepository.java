package com.gestion.interfaces;

public interface IRepository<T> {
    void add(T obj);
    T search(String data);
    void update(T objeto, T actualizado);
    void remove(T obj);
}
