Feature: Updating ToDO App Feature
  This feature deals with adding, completing, and deleting items on your ToDo List

  Background: Add a task to your to-do list and confirm it was added
    Given I am on the home page
    When I add the to-do "Laundry"
    Then I should see that "Laundry" was added to my list

  Scenario: Check off an item on your to-do list and confirm it was completed
    Given I have one to-do in my list
    When I complete that to-do
    Then I should see that to-do was completed


  Scenario: Delete an item on your to-do list and confirm it was deleted
    Given I have one to-do in my list
    When I delete that to-do
    Then I should see that the to-do was deleted