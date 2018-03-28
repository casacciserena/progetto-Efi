package com.serena.animalproject.model;

import javax.persistence.*;

@Entity
@Table(name = "TBL_OWNER")
@NamedQueries({
        // Giro getOwners
        @NamedQuery(name = "getOwners", query = "" +
                "SELECT o " +
                "FROM Owner o " +
                "ORDER BY o.ownerName"
        ),
        // Giro getOwner
        @NamedQuery(name = "getOwner", query = "" +
                "SELECT o " +
                "FROM Owner o " +
                "WHERE o.ownerId = :ownerId"
        ),
        // Giro deleteOwner
        @NamedQuery(name = "deleteOwner", query = "" +
                "DELETE FROM Owner o WHERE o.ownerId = :ownerId"
        ),
})
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OWNER_ID", nullable = false, updatable = false)
    private long ownerId;

    @Basic(optional = false)
    @Column(name = "TE_NAME")
    private String ownerName;

    @Basic
    @Column(name = "TE_SURNAME")
    private String ownerSurname;

    @Basic
    @Column(name = "NU_AGE")
    private int ownerAge;

    @Basic
    @Column(name = "TE_SEX")
    private String ownerSex;

    @Basic
    @Column(name = "TE_MOBILE_PHONE")
    private String ownerMobilePhone;

    /**
     * @return the ownerId
     */
    public long getOwnerId() {
        return ownerId;
    }

    /**
     * @param ownerId the ownerId to set
     */
    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * @return the ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * @param ownerName the ownerName to set
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * @return the ownerSurname
     */
    public String getOwnerSurname() {
        return ownerSurname;
    }

    /**
     * @param ownerSurname the ownerSurname to set
     */
    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    /**
     * @return the ownerAge
     */
    public int getOwnerAge() {
        return ownerAge;
    }

    /**
     * @param ownerAge the ownerAge to set
     */
    public void setOwnerAge(int ownerAge) {
        this.ownerAge = ownerAge;
    }

    /**
     * @return the ownerSex
     */
    public String getOwnerSex() {
        return ownerSex;
    }

    /**
     * @param ownerSex the ownerSex to set
     */
    public void setOwnerSex(String ownerSex) {
        this.ownerSex = ownerSex;
    }

    /**
     * @return the ownerMobilePhone
     */
    public String getOwnerMobilePhone() {
        return ownerMobilePhone;
    }

    /**
     * @param ownerMobilePhone the ownerMobilePhone to set
     */
    public void setOwnerMobilePhone(String ownerMobilePhone) {
        this.ownerMobilePhone = ownerMobilePhone;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", ownerName='" + ownerName + '\'' +
                ", ownerSurname='" + ownerSurname + '\'' +
                ", ownerAge=" + ownerAge +
                ", ownerSex='" + ownerSex + '\'' +
                ", ownerMobilePhone='" + ownerMobilePhone + '\'' +
                '}';
    }
}
