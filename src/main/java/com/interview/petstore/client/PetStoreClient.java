package com.interview.petstore.client;

import com.interview.petstore.swagger.model.Pet;
import com.interview.petstore.swagger.model.Pet.*;

import java.util.List;

public interface PetStoreClient {
    List<Pet> getPetsByStatus(StatusEnum givenStatus);
}
