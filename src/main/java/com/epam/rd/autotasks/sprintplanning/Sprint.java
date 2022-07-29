package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;
import java.util.Objects;

public class Sprint {
    private final int capacity;

    private int capacityAlready = 0;
    private int capacityBug = 0;
    private final int ticketsLimit;
    private int ticketsAddSum = 0;
    private UserStory userStory;

    private final Ticket[] array;
    private Ticket[] newArray;


    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        array = new Ticket[ticketsLimit];

    }

   public boolean dependenciesAceptance(UserStory story) {
        int temp = 0;

        for (Ticket value : this.getTickets()) {
           for (Ticket ticket : userStory.getDependencies()) {
               if(value.getId() == ticket.getId())
                   temp++;
            }
        }
        if (temp == story.getDependencies().length) {
            return true;
        }
        return false;
    }

    public boolean addUserStory(UserStory userStory) {
        this.userStory = userStory;
        if (ticketsAddSum >= ticketsLimit)
        {
            return false;}
        int temp = 0;

        if ((userStory == null) || (userStory.isCompleted()) || userStory.getEstimate() > capacity || capacityAlready + userStory.getEstimate() > capacity) {
            temp++;
        }
        if (temp == 0 && ticketsAddSum < ticketsLimit && this.dependenciesAceptance(userStory)) {
            array[ticketsAddSum] = userStory;
            ticketsAddSum++;
            capacityAlready += userStory.getEstimate();
            return true;
        }
        return false;
    }

    public boolean addBug(Bug bugReport) {
        int temp = 0;
        if ((bugReport == null) || (bugReport.isCompleted())) {
        temp++;
    }
        if (temp == 0 && ticketsAddSum < ticketsLimit && capacityBug + bugReport.getEstimate() <= capacity ) {
        array[ticketsAddSum] = bugReport;
        ticketsAddSum++;
        capacityBug += bugReport.getEstimate();
        return true;
    }
        return false;
    }

    public Ticket[] getTickets() {
       int countLength = 0;
       for(Ticket value : array) {
           if(value != null) {
               countLength++;
           }
       }
      newArray = Arrays.copyOf(array, countLength);
       return newArray;
    }

    public int getTotalEstimate() {
        int sum = 0;
        for (Ticket value: newArray) {
            sum += value.getEstimate();
        }
        return sum;
    }
}
