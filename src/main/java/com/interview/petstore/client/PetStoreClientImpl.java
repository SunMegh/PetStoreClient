package com.interview.petstore.client;

import com.interview.petstore.service.PetStoreOrchestrationService;
import com.interview.petstore.service.PetStoreOrchestrationServiceImpl;
import com.interview.petstore.swagger.model.Pet;
import com.interview.petstore.swagger.model.Pet.*;

import java.util.ArrayList;
import java.util.List;

public class PetStoreClientImpl implements PetStoreClient {

    PetStoreOrchestrationService orchestrationService;

    public PetStoreClientImpl(){
        orchestrationService = new PetStoreOrchestrationServiceImpl();
    }

    public PetStoreClientImpl(PetStoreOrchestrationService orchestrationService){
        this.orchestrationService = orchestrationService;
    }

    @Override
    public List<Pet> getPetsByStatus(StatusEnum givenStatus) {
        return orchestrationService.invokeFindByStatus(givenStatus);
    }




}
