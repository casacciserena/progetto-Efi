package com.serena.animalproject.dao.impl;

import com.serena.animalproject.dao.AnimalDao;
import com.serena.animalproject.model.Animal;
import com.serena.animalproject.utility.JPAUtility;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Collection;

@Repository("animalDao")
public class AnimalDaoImpl implements AnimalDao {

    protected EntityManager entityManager = JPAUtility.getEntityManager();

//    @Autowired
//    private SessionFactory sessionFactory;
//
//    protected Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }

    @Transactional
    public Collection<Animal> getAnimals() {
        return (Collection<Animal>) entityManager.createNamedQuery("getAnimals", Animal.class)
                .getResultList();
    }

    @Transactional
    public Animal getAnimal(long animalId) {
        return (Animal) entityManager.createNamedQuery("getAnimal", Animal.class)
                .setParameter("animalId", animalId)
                .getSingleResult();
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
}
