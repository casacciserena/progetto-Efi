package com.serena.animalproject.utility;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public abstract class JPAAbstractService<T> {

    protected final Class<T> typeParameterClass;

    @PersistenceContext(unitName = "MainPersistenceService", type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;

    /**
     *
     * @param typeParameterClass
     */
    public JPAAbstractService(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean existEntity(long id) {
        boolean exist = true;
        try {
            T entity = (T) entityManager.find(typeParameterClass, id);
            System.out.println("Found entity: " + entity);
            if (entity == null) {
                exist = false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            exist = false;
        } catch (Exception e) {
            System.out.println(e);
            exist = false;
        }
        System.out.println("[existEntity] exist: " + exist);
        return exist;
    }

    /**
     *
     * @param entityClass
     * @param id
     * @return
     */
    public <T> boolean existEntity(Class<T> entityClass, long id) {
        boolean exist = true;
        try {
            T entity = (T) entityManager.find(entityClass, id);
            System.out.println("Found entity: " + entity);
            if (entity == null) {
                exist = false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            exist = false;
        } catch (Exception e) {
            System.out.println(e);
            exist = false;
        }
        System.out.println("[existEntity] exist: " + exist);
        return exist;
    }

    /**
     *
     * @param entityClass
     * @param id
     * @return
     */
    public <T> T findEntity(Class<T> entityClass, long id){
        T entity = null;
        try {
            entity = (T) entityManager.find(entityClass, id);
            System.out.println("Found entity: " + entity);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        return entity;
    }
}