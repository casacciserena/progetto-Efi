package com.serena.animalproject.dao.impl;

import com.serena.animalproject.dao.AnimalDao;
import com.serena.animalproject.model.Animal;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository("animalDao")
public class AnimalDaoImpl implements AnimalDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public Collection<Animal> getAnimals() {
        Criteria criteria = getSession().createCriteria(Animal.class);
        //criteria.setFetchMode("collectionProgetto", FetchMode.JOIN);
        return (Collection<Animal>) criteria.list();
    }

//    @Transactional
//    public boolean newClienteName(Cliente c, String newName) {
//        boolean hasErrors = false;
//        try {
//            c.setNomeCliente(newName);
//        }
//        catch(Exception e) {
//
//            hasErrors = true;
//        }
//        return hasErrors;
//    }

//    @Transactional
//    public boolean insertCliente(Cliente cliente, String name){
//
//        boolean hasErrors = true;
//
//        Criteria criteria = getSession().createCriteria(Cliente.class);
//        criteria.add(Restrictions.eq("nomeCliente", name));
//        Cliente cliente1 = (Cliente)criteria.uniqueResult();
//
//        try {
//            if(cliente1 == null)
//                getSession().save(cliente);
//            else
//                hasErrors = false;
//        }
//        catch(Exception e) {
//            hasErrors = false;
//            e.printStackTrace();
//        }
//        return hasErrors;
//    }

//    @Transactional
//    public boolean deleteCliente(Integer id) {
//        Collection<Cliente> clienteCollection = findClienteById(id);
//        for(Cliente cliente : clienteCollection) {
//            if(cliente.getIdCliente() == id)
//                getSession().delete(cliente);
//        }
//        return true;
//    }

//    @Transactional
//    public Collection<Cliente> findClienteById(Integer id) {
//        Criteria criteria = getSession().createCriteria(Cliente.class);
//        criteria.add(Restrictions.eq("idCliente", id));
//        return (Collection<Cliente>) criteria.list();
//    }

//    @Transactional
//    public Collection<Cliente> findClienteByName(String name) {
//        Criteria criteria = getSession().createCriteria(Cliente.class);
//        criteria.add(Restrictions.eq("nomeCliente", name));
//        return (Collection<Cliente>) criteria.list();
//    }
}
