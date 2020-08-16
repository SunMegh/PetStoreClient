package com.interview.petstore.client;

import com.interview.petstore.service.PetStoreOrchestrationService;
import com.interview.petstore.swagger.model.Pet;
import com.interview.petstore.swagger.model.Pet.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("local")
public class PetStoreClientImplIT {

    @Mock
    PetStoreOrchestrationService petStoreOrchestrationService;

    @Captor
    ArgumentCaptor<Pet.StatusEnum> argumentCaptorForOrchestration;

    PetStoreClient petStoreClient;

    @Before
    public void setUp(){
        petStoreClient = new PetStoreClientImpl(petStoreOrchestrationService);
        MockitoAnnotations.openMocks(petStoreClient);
    }

    @Test
    public void shouldInvokeService(){
        petStoreClient.getPetsByStatus(StatusEnum.AVAILABLE);
        Mockito.verify(petStoreOrchestrationService, times(1)).invokeFindByStatus(argumentCaptorForOrchestration.capture());
        List<StatusEnum> status = argumentCaptorForOrchestration.getAllValues();
        assertEquals(status.get(0).name(), StatusEnum.AVAILABLE.toString().toUpperCase());
    }


}