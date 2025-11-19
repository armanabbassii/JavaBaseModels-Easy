package repository.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.BaseModel;
import repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<ID,T extends BaseModel<ID>> implements BaseRepository<ID,T> {
    private final Class<T> classType ;
    protected EntityManagerFactory emf;

    public BaseRepositoryImpl(Class<T> classType, EntityManagerFactory emf) {
        this.classType = classType;
        this.emf = emf;
    }

    @Override
    public void add(T entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Optional<T> find(ID id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        T output =em.find(classType, id);
        em.getTransaction().commit();
        em.close();
        return Optional.ofNullable(output);
    }

    @Override
    public Optional<List<T>> findAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<T> output =em.createQuery("select a from " + classType.getSimpleName() + " a",classType).getResultList();
        em.getTransaction().commit();
        em.close();
        return Optional.ofNullable(output);
    }

    @Override
    public void update( T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();

    }



    @Override
    public void delete(ID id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(classType,id));
        em.getTransaction().commit();
        em.close();
    }
}
