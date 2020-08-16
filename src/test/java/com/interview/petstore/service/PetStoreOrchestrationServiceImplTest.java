package com.interview.petstore.service;

import com.interview.petstore.swagger.model.Pet;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class PetStoreOrchestrationServiceImplTest {

    PetStoreOrchestrationService petStoreOrchestrationService = new PetStoreOrchestrationServiceImpl();

    @Test
    public void shouldGetResponse(){
        List<Pet> petList = petStoreOrchestrationService.invokeFindByStatus(Pet.StatusEnum.AVAILABLE);
        assertNotNull(petList);
    }

}