package com.serena.animalproject.model.bean;

import java.io.Serializable;
//import java.util.List;
//import java.util.Set;

///**
// * {
// *   "consultant_id": 991982,
// *   "consultant_code": "C0201",
// *   "first_name": "Mario",
// *   "last_name": "Rossi",
// *   "sex": "MALE",
// *   "role_description": "Area crediti",
// *   "mail": "massimo@ferrara.it",
// *   "profile_description": "	",
// *   "mobile_phone": "3494939339",
// *   "image_resource_id": 737782,
// *   "workstation_asset_id": 192891,
// *   "callable": true,
// *   "remote": false,
// *   "currently_available": true,
// *   "help_priority": 0,
// *   "identification_code": "A122344",
// *   "notifications": {
// *     "mobile_phone": true,
// *     "universal_client": true
// *   },
// *   "services_id": [
// *   	9921,
//    	9922,
//    	9933,
//    	9292,
//    	9392
//	 ]
// * }
// */

public class AnimalBean implements Serializable {

    private long animal_id;
    private String animal_name;
    private String animal_family;
    private String animal_race;
    private String animal_descent;
//    private Set<AssetBean> asset_set_bean;
//    private List<DisplayCellBean> display_cell_list_bean;

    public AnimalBean() {

    }

    /**
     * @return the animal_id
     */
    public long getAnimal_id() {
        return animal_id;
    }

    /**
     * @param animal_id the animal_id to set
     */
    public void setAnimal_id(long animal_id) {
        this.animal_id = animal_id;
    }

    /**
     * @return the animal_name
     */
    public String getAnimal_name() {
        return animal_name;
    }

    /**
     * @param animal_name the animal_name to set
     */
    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    /**
     * @return the animal_family
     */
    public String getAnimal_family() {
        return animal_family;
    }

    /**
     * @param animal_family the animal_family to set
     */
    public void setAnimal_family(String animal_family) {
        this.animal_family = animal_family;
    }

    /**
     * @return the animal_race
     */
    public String getAnimal_race() {
        return animal_race;
    }

    /**
     * @param animal_race the animal_race to set
     */
    public void setAnimal_race(String animal_race) {
        this.animal_race = animal_race;
    }

    /**
     * @return the animal_descent
     */
    public String getAnimal_descent() {
        return animal_descent;
    }

    /**
     * @param animal_descent the animal_descent to set
     */
    public void setAnimal_descent(String animal_descent) {
        this.animal_descent = animal_descent;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName())
                .append(" [animal_id=").append(animal_id)
                .append(", animal_name=").append(animal_name)
                .append(", animal_family=").append(animal_family)
                .append(", animal_race=").append(animal_race)
                .append(", animal_descent=").append(animal_descent)
                .append("]");
        return builder.toString();
    }
}