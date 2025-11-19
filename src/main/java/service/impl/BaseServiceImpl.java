package service.impl;

import model.BaseModel;
import repository.BaseRepository;
import service.BaseService;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<ID,T extends BaseModel> implements BaseService<ID,T> {
    protected BaseRepository repository;

    public BaseServiceImpl(BaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(T entity) {
        repository.add(entity);
    }

    @Override
    public Optional<T> find(ID id) {
        return repository.find(id);
    }

    @Override
    public Optional<List<T>> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(T t) {
        repository.update(t);
    }

    @Override
    public void delete(ID id) {
        repository.delete(id);
    }
}
