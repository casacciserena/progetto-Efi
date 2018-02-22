package com.serena.animalproject.model;

//import java.util.List;
//
//import javax.persistence.Basic;
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
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ANIMAL")
@NamedQueries({
//	@NamedQuery(name = "getDisplayByBranchId", query = "" +
//		"SELECT d " +
//		"FROM Display d, Asset a " +
//		"WHERE d.assetId = a.assetId " +
//		"AND a.branch.branchId = :branchId " +
//		"ORDER BY d.displayName"
//	),
//	@NamedQuery(name = "getDisplayByBranchCode", query = "" +
//			"SELECT d " +
//			"FROM Display d, Asset a " +
//			"WHERE d.assetId = a.assetId " +
//			"AND a.branch.branchCode = :branchCode " +
//			"ORDER BY d.displayName"
//	),
//	@NamedQuery(name = "getDisplayByAreaCode", query = "" +
//			"SELECT d " +
//			"FROM Display d, Asset a " +
//			"WHERE d.assetId = a.assetId " +
//			"AND a.branch.area.areaCode = :areaCode " +
//			"ORDER BY d.displayName"
//	),
//	@NamedQuery(name = "getDisplayByBankCode", query = "" +
//			"SELECT d " +
//			"FROM Display d, Asset a " +
//			"WHERE d.assetId = a.assetId " +
//			"AND a.branch.area.bank.bankCode = :bankCode " +
//			"ORDER BY d.displayName"
//	),
//        @NamedQuery(name = "deleteDisplayById", query = "" +
//                "DELETE FROM Display d WHERE d.displayId = :displayId"
//        )
})
public class Animal {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="animalSeq")
    @SequenceGenerator(
            name="animalSeq",
            sequenceName="SQ_ANIMAL_01",
            allocationSize=1
    )
    @Column(name = "ANIMAL_ID", nullable=false, updatable=false)
    private long animalId;

//    @Basic
//    @Column(name = "TE_NAME", length = 100)
//    private String displayName;
//
//    @Basic(optional = false)
//    @Column(name = "CO_TYPE", length = 100)
//    private String displayCode;

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
}