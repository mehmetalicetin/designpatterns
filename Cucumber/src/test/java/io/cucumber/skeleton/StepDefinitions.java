package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class StepDefinitions {
	Belly belly = new Belly();

	@Given("I have {int} cukes in my belly")
	public void I_have_cukes_in_my_belly(int cukes) {
		belly.eat(cukes);
	}

	@When("I wait {int} hour")
	public void i_wait_hour(int hours) {
		belly.sleep(hours);

	}
	@Then("my belly should growl")
	public void my_belly_should_growl() {
		Assertions.assertTrue(belly.isFull, "my belly should not growl");
	}

	@Then("my belly should not growl")
	public void my_belly_should_not_growl() {
		Assertions.assertFalse(belly.isFull, "my belly should growl");
	}
}
