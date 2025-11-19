package service;

import java.util.List;
import java.util.Optional;

public interface BaseService<ID,T> {
    void add(T entity);
    Optional<T> find(ID id);
    Optional<List<T>> findAll();
    void update(T t);
    void delete(ID id);
}
