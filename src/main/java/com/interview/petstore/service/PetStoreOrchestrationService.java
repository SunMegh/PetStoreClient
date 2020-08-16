package com.interview.petstore.service;



import com.interview.petstore.swagger.model.Pet;
import com.interview.petstore.swagger.model.Pet.*;

import java.util.List;

public interface PetStoreOrchestrationService {
    List<Pet> invokeFindByStatus(StatusEnum capture);
}
