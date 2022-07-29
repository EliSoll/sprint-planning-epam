package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {
    private final int id;
    private final int estimate;
    private String name;
    private final UserStory[] dependsOnCopy;
    UserStory[] defensiveCopy;
    private boolean isCompleted = false;



    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.dependsOnCopy = Arrays.copyOf(dependsOn, dependsOn.length);

    }


    @Override
    public void complete() {
        int temp = 0;
        for (UserStory story:dependsOnCopy) {
            if(!story.isCompleted()) {
               temp++;
            }
        }
        if (temp == 0) {
           super.complete();
        }
    }



    public UserStory[] getDependencies() {

        defensiveCopy = dependsOnCopy.clone();
        return defensiveCopy;
    }



    @Override
    public String toString() {
        return "[US "+ id + "] " + name;
    }

}
