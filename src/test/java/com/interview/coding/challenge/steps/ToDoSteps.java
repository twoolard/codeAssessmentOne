package com.interview.coding.challenge.steps;

import com.interview.coding.challenge.pages.todo.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseUtil;
import utils.properties.TestConstant;
import utils.properties.TestProperties;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ToDoSteps extends BaseUtil {

    private BaseUtil base;
    private HomePage page;
    private String task;

    public ToDoSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() throws Exception {
        page = new HomePage(base.driver, TestProperties.getProperty(TestConstant.EX_URL));
        assertTrue(page.isPageLoaded());
    }

    @Given("I have a to-do in my list")
    public void iHaveAToDoInMyList() {
        assertTrue(page.isToDoListVisible());
    }

    @When("I complete that to-do")
    public void iCompleteThatToDo() {
        page.completeToDo(task);
    }

    @Then("I should see that to-do was completed")
    public void iShouldSeeThatToDoWasCompleted() {
        assertTrue(page.isTaskCompleted(task));
    }

    @When("I delete that to-do")
    public void iDeleteThatToDo() {
        page.deleteToDo(task);
    }

    @Then("I should see that the to-do was deleted")
    public void iShouldSeeThatTheToDoWasDeleted() {
        assertFalse(page.isToDoListVisible());
    }

    @When("I add the to-do {string}")
    public void iAddTheToDo(String toDo)  {
        task = toDo;
        page.addToDo(toDo);
    }

    @Then("I should see that {string} was added to my list")
    public void iShouldSeeThatWasAddedToMyList(String toDo) {
        assertTrue(page.isToDoAdded(toDo));
    }

    @Given("I have one to-do in my list")
    public void iHaveOneToDoInMyList() {
        assertTrue(page.oneTaskInList());
    }
}
