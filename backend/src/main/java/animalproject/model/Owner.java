package com.serena.animalproject.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_OWNER")
@NamedQueries({
	@NamedQuery(name = "getOwners", query = "" +
		"SELECT o " +
		"FROM Owner o " +
		"ORDER BY o.ownerName"
	),
})
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OWENERS_ID", nullable = false, updatable = false)
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
    @Column(name = "NU_MOBILE_PHONE")
    private int ownerMobilePhone;

    /**
     * @return the owenerId
     */
    public long getOwnerId() {
        return ownerId;
    }

    /**
     * @param owenerId the ownerId to set
     */
    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * @return the ownerName
     */
    public String getownerName() {
        return ownerName;
    }

    /**
     * @param ownerName the ownerName to set
     */
    public void setOwnerName(String animalName) {
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
    public void setOwnerSurnaame(String animalFamily) {
        this.ownerSurname = ownerSurname;
    }

    /**
     * @return the ownerAge
     */
    public String getOwnerAge() {
        return ownerAge;
    }

    /**
     * @param ownerAge the ownerAge to set
     */
    public void setOwnerAge(String ownerAge) {
        this.ownerAge = ownerAge;
    }

    /**
     * @return the ownerSex
     */
    public String getOwnerSex() {
        return ownerSex;
    }

    /**
     * @param animalDescent the ownerSex to set
     */
    public void setAnimalDescent(String ownerSex) {
        this.animalDescent = ownerSex;
    }

    /**
     * @return the ownerMobilePhone
     */
    public int getOwnerMobilePhone() {
        return ownerMobilePhone;
    }

    /**
     * @param ownerMobilePhone the ownerMobilePhone to set
     */
    public void setOwnerMobilePhone(int ownerMobilePhone) {
        this.ownerMobilePhone = ownerMobilePhone;
    }
}
