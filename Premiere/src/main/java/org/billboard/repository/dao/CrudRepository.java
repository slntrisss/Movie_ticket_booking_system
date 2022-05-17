package org.billboard.repository.dao;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository <T extends Serializable>{
    List<T> getAll();
    T findOneById(int id);
    void save(T entity);
    void delete(int id);
    void update(T entity);
}
