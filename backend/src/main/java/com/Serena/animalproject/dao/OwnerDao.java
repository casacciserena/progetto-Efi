package com.serena.animalproject.dao;

import com.serena.animalproject.model.Owner;

import java.util.Collection;

public interface OwnerDao {
    Collection<Owner> getOwners();
    Owner getOwner (long ownerId);
    Owner createOwner (Owner owner);
    String updateOwner(Owner ownerFromDB);
    String deleteOwner(long ownerId);
}
