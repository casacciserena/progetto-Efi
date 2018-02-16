package com.Efi.beachmanager.dao.customer;

/**
 * Created by Nova Stefano on 25/12/2017.
 */
@Entity
@Table(name="tblcustomer")
public class Customer {
    @Id
    @SequenceGenerator(name="tblcustomer_id_customer_seq", sequenceName="tblcustomer_id_customer_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tblcustomer_id_customer_seq")
    @Column(name="id_customer", updatable=false)
    private long id_customer;
    private String first_name;

    public Customer(int id_customer, String first_name) {
        this.id_customer = id_customer;
        this.first_name = first_name;
    }

    public Customer() {

    }

    public long getId_customer() {
        return id_customer;
    }

    public void setId_customer(long id_customer) {
        this.id_customer = id_customer;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
