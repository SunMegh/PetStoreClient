**Pet Store Client**
This project is developed using Test Driven Development(TDD).

Acceptance Criteria has been documented into the feature file named "PetStoreServiceClient.feature"

Integration tests is written within "PetStoreClientImpl.java". This will test the orchestration service to make sure it connecst to repmote server and gets the result. 
This Integration test can be improved by using wiremock service.

PetStore orchestration service is client service which fetches the response from the API client. 

**Running the Test**
To run the acceptance test execute the class "AcceptanceRunner" under the test package com.interview.petstore.acceptance

Acceptance Test can also be developed using Karate Framework. 


