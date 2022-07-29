package com.epam.rd.autotasks.sprintplanning.tickets;

public class Bug extends Ticket {
    public UserStory userStory;

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (!userStory.isCompleted() || userStory == null) {
          return null;
      }
        return new Bug (id, name, estimate, userStory);
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }

    @Override
    public String toString() {
        return "[Bug " + this.getId() + "] " + userStory.getName() +": " + this.getName();
    }
}
