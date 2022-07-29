package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {
    final int id;
    final String name;
    final int estimate;
    private boolean isCompleted;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
       this.name = name;
       this.estimate = estimate;
       isCompleted = false;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        if (isCompleted) {
            return true;
        }
        return false;
    }

    public void complete() {
        isCompleted = true;
    }

    public int getEstimate() {
        return estimate;
    }
}
