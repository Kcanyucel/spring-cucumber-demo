package com.example.stepdefinitions;

import com.example.controller.GreetingController;
import com.example.repository.GreetingRepository;
import com.example.service.GreetingService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingStepDefinitions {
    private String greetingMessage;

    @Autowired
    private GreetingRepository greetingRepository;

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private GreetingController greetingController;

    public GreetingStepDefinitions(GreetingRepository greetingRepository, GreetingService greetingService, GreetingController greetingController) {
        this.greetingRepository = greetingRepository;
        this.greetingService = greetingService;
        this.greetingController = greetingController;
    }

    @Given("a greeting repository")
    public void givenGreetingRepository() {
        greetingRepository.getGreeting();
        greetingController.getGreetingDefault();
    }

    @When("I retrieve the greeting message")
    public void whenRetrieveGreetingMessage() {
        final String greet = greetingService.greet("World");

        greetingMessage = greet;
    }

    @Then("the greeting message should be {string}")
    public void thenGreetingMessageShouldBe(String expectedMessage) {
        Assert.assertEquals(expectedMessage, greetingMessage);
    }
}
