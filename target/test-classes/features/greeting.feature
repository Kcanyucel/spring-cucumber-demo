Feature: Greeting Service
    Scenario: Retrieve greeting message
        Given a greeting repository
        When I retrieve the greeting message
        Then the greeting message should be "Hello, World!"
