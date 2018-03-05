package com.serena.ownerproject.model.bean;

import java.io.Serializable;

public class OwnerBean implements Serializable {

    private long owner_id;
    private String owner_name;
    private String owner_surname;
    private int owner_age;
    private String owner_sex;
    private int owner_number_phone;

    public ownerBean() {

    }

    /**
     * @return the owner_id
     */
    public long getOwner_id() {
        return owner_id;
    }

    /**
     * @param owner_id the owner_id to set
     */
    public void setOwner_id(long owner_id) {
        this.owner_id = owner_id;
    }

    /**
     * @return the owner_name
     */
    public String getOwner_name() {
        return owner_name;
    }

    /**
     * @param owner_name the owner_name to set
     */
    public void setOwnner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    /**
     * @return the owner_surname
     */
    public String getOwner_surname() {
        return owner_surname;
    }

    /**
     * @param owner_surname the owner_surname to set
     */
    public void setOwner_surname(int owner_surname) {
        this.owner_surname = owner_surname;
    }

    /**
     * @return the owner_age
     */
    public int getowner_age() {
        return owner_age;
    }

    /**
     * @param owner_age the owner_age to set
     */
    public void setOwner_age(int owner_age) {
        this.owner_age = owner_age;
    }

    /**
     * @return the owner_sex
     */
    public String getOwner_sex() {
        return owner_sex;
    }

    /**
     * @param owner_sex the owner_sex to set
     */
    public void setOwner_sex(String owner_sex) {
        this.owner_sex = owner_sex;
    }

    /**
     * @return the owner_number_phone
     */
    public int getOwner_number_phone() {
        return owner_number_phone;
    }

    /**
     * @param owner_number_phone the owner_number_phone to set
     */
    public void setOwner_number_phone(int owner_number_phone) {
        this.owner_number_phone = owener_number_phone;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName())
                .append(" [owner_id=").append(owner_id)
                .append(", owner_name=").append(owner_name)
                .append(", owner_surname=").append(owner_surname)
                .append(", owner_age=").append(owner_age)
                .append(", owner_sex=").append(owner_sex)
                .append(", owner_number_phone=").append(owner_number_phone)
                .append("]");
        return builder.toString();
    }
}
