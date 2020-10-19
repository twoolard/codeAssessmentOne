package com.interview.coding.challenge.pages.todo;

import com.interview.coding.challenge.pages.BasePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageUtil;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "input.new-todo")
    private WebElement toDoInput;

    @FindBy(css = "ul.todo-list")
    private WebElement toDoList;

    @FindBy(css = "button.clear-completed")
    private WebElement clearCompletedBtn;

    private static final String PAGE_NAME = "ToDo App Home Page";

    public HomePage(WebDriver driver, String url) throws Exception {
        super(driver);

        if (StringUtils.isEmpty(url)) {
            throw new Exception("No URL was provided for " + PAGE_NAME);
        }

        driver.navigate().to(url);
        PageFactory.initElements(driver, this);
    }

    public void addToDo(String toDo) {
        if (isPageLoaded()) {
            PageUtil.clearInputAndSendKeys(toDoInput, toDo);
            toDoInput.sendKeys(Keys.ENTER);
        }
    }

    public boolean isToDoAdded(String toDo) {
        boolean toAdded = false;
        if (isElementDisplayed(toDoList, 15)) {
            List<WebElement> tasks = toDoList.findElements(By.tagName("li"));
            for (WebElement task : tasks) {
                if (task.getText().equals(toDo)) {
                    toAdded = true;
                    break;
                }
            }
        }

        return toAdded;
    }

    public void completeToDo(String toDo) {
        List<WebElement> tasks = toDoList.findElements(By.tagName("li"));
        for (WebElement task : tasks) {
            if (task.getText().equals(toDo)) {
                task.findElement(By.cssSelector("div > input.toggle")).click();
                break;
            }
        }
    }

    public void deleteToDo(String toDo)  {
        List<WebElement> tasks = toDoList.findElements(By.tagName("li"));
        for (WebElement task : tasks) {
            if (task.getText().equals(toDo)) {
                task.click();
                task.findElement(By.cssSelector("div > button.destroy")).click();
                break;
            }
        }
    }

    public boolean isTaskCompleted(String toDo){
        boolean taskCompleted = false;
        if (isClearCompletedVisible()){
            List<WebElement> completedTasks = toDoList.findElements(By.cssSelector("li.completed"));
            for (WebElement task : completedTasks) {
                if (task.getText().equals(toDo)) {
                    taskCompleted = true;
                    break;
                }
            }
        }

        return taskCompleted;
    }

    public boolean oneTaskInList() {
        boolean oneTask = false;
        if (isToDoListVisible()) {
            List<WebElement> tasks = toDoList.findElements(By.tagName("li"));
            if (tasks.size() == 1) {
                oneTask = true;
            }
        }
        return oneTask;
    }

    public boolean isToDoListVisible() {
        return isElementDisplayed(toDoList, 3);
    }

    public boolean isClearCompletedVisible() {
        return isElementDisplayed(clearCompletedBtn, 15);
    }

    public boolean isPageLoaded() {
        return isElementDisplayed(toDoInput, 15);
    }

}
