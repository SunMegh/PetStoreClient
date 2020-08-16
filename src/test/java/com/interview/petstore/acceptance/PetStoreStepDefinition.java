package com.interview.petstore.acceptance;

import com.interview.petstore.client.PetStoreClient;
import com.interview.petstore.client.PetStoreClientImpl;
import com.interview.petstore.swagger.model.Pet;
import com.interview.petstore.swagger.model.Pet.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PetStoreStepDefinition {

    private List<Pet> petList;
    @Given("^I have the status as (.*) for the Pets list$")
    public void i_have_the_status_as_available_for_the_pets_list(String status) {
        assertTrue(!Objects.isNull(status));
    }


      @When("I request the list of Pets with the status (.*)$")
    public void i_request_the_list_of_pets_with_the_status_available(String status) {
          PetStoreClient petStoreClient = new PetStoreClientImpl();
          StatusEnum givenStatus = StatusEnum.fromValue(status.toLowerCase());
          petList = petStoreClient.getPetsByStatus(givenStatus);

    }
    @Then("I should have list of all the Pets based on the status available")
    public void i_should_have_list_of_all_the_pets_based_on_the_status_available() {
        assertNotNull(petList);
        List<Pet> doggieList = null;
        for(Pet pet: petList){
            if(pet.getName() != null && pet.getName().equals("doggie")){
                if(doggieList == null)
                    doggieList = new ArrayList<>();
                doggieList.add(pet);
            }
        }
        assertNotNull(doggieList);

    }
}
