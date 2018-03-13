package com.serena.animalproject.model;

import javax.persistence.*;

@Entity
@Table(name = "TBL_ANIMAL")
@NamedQueries({
	    @NamedQuery(name = "getAnimals", query = "" +
		        "SELECT a " +
		        "FROM Animal a " +
		        "ORDER BY a.animalName"
	    ),
        @NamedQuery(name = "getAnimal", query = "" +
                "SELECT a " +
                "FROM Animal a " +
                "WHERE a.animalId = :animalId"
        ),
})
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ANIMAL_ID", nullable = false, updatable = false)
    private long animalId;

    @Basic(optional = false)
    @Column(name = "TE_NAME")
    private String animalName;

    @Basic
    @Column(name = "TE_FAMILY")
    private String animalFamily;

    @Basic
    @Column(name = "TE_RACE")
    private String animalRace;

    @Basic
    @Column(name = "TE_DESCENT")
    private String animalDescent;

    @Basic
    @Column(name = "NU_LEGS")
    private int animalLegs;

    /**
     * @return the animalId
     */
    public long getAnimalId() {
        return animalId;
    }

    /**
     * @param animalId the animalId to set
     */
    public void setAnimalId(long animalId) {
        this.animalId = animalId;
    }

    /**
     * @return the animalName
     */
    public String getAnimalName() {
        return animalName;
    }

    /**
     * @param animalName the animalName to set
     */
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    /**
     * @return the animalFamily
     */
    public String getAnimalFamily() {
        return animalFamily;
    }

    /**
     * @param animalFamily the animalFamily to set
     */
    public void setAnimalFamily(String animalFamily) {
        this.animalFamily = animalFamily;
    }

    /**
     * @return the animalRace
     */
    public String getAnimalRace() {
        return animalRace;
    }

    /**
     * @param animalRace the animalRace to set
     */
    public void setAnimalRace(String animalRace) {
        this.animalRace = animalRace;
    }

    /**
     * @return the animalDescent
     */
    public String getAnimalDescent() {
        return animalDescent;
    }

    /**
     * @param animalDescent the animalDescent to set
     */
    public void setAnimalDescent(String animalDescent) {
        this.animalDescent = animalDescent;
    }

    /**
     * @return the animalLegs
     */
    public int getAnimalLegs() {
        return animalLegs;
    }

    /**
     * @param animalLegs the animalLegs to set
     */
    public void setAnimalLegs(int animalLegs) {
        this.animalLegs = animalLegs;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", animalName='" + animalName + '\'' +
                ", animalFamily='" + animalFamily + '\'' +
                ", animalRace='" + animalRace + '\'' +
                ", animalDescent='" + animalDescent + '\'' +
                ", animalLegs=" + animalLegs +
                '}';
    }
}