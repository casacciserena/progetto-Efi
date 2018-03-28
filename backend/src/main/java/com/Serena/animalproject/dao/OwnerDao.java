package com.serena.animalproject.dao;

import com.serena.animalproject.model.Owner;

import java.util.Collection;

public interface OwnerDao {
    // Giro getOwners
    Collection<Owner> getOwners();

    // Giro getOwner
    Owner getOwner (long ownerId);

    // Giro createOwner
    //Owner createOwner (Owner owner);

    // Giro updateOwner
    String updateOwner(Owner ownerFromDB);

    // Giro deleteOwner
    //String deleteOwner(long ownerId);
}
