package com.Efi.beachmanager.dao.customer;

/**
 * Created by Nova Stefano on 25/12/2017.
 */
public class CustomerDaoImpl implements CustomerDao {
    public List<Customer> getAllCustomer() {
        EntityManager manager = connection();

        Query query = manager.createQuery("select allCustomer from Customer customer");
        List<Customer> customerList = query.getResultList();

        return customerList;
    }

    //public void insertCategory(String category) {
        //EntityManager manager = connessione();

        //Category wordObj = new Category();
        //wordObj.setCategory(category);

        //manager.getTransaction().begin();
        //manager.persist(wordObj);
        //manager.getTransaction().commit();
    //}

    private EntityManager connection() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("connection");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
}
