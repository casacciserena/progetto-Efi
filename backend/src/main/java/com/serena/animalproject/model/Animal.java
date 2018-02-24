package com.serena.animalproject.model;

//import java.util.List;

import javax.persistence.Basic;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ANIMAL")
@NamedQueries({
	@NamedQuery(name = "getAnimals", query = "" +
		"SELECT a " +
		"FROM Animal a " +
		"ORDER BY a.animalName"
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

//    @ManyToMany
//    @JoinTable
//            (
//                    name="TBCM_DISPLAY_ASSET",
//                    joinColumns={ @JoinColumn(name="DISPLAY_ID", referencedColumnName="DISPLAY_ID") },
//                    inverseJoinColumns={ @JoinColumn(name="ASSET_ID", referencedColumnName="ASSET_ID") }
//            )
//    @OrderBy("displayId")
//    private List<Asset> assetList;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "DISPLAY_ID", referencedColumnName = "DISPLAY_ID")
//    @OrderBy("displayId")
//    private List<DisplayCell> displayCellList;

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
}