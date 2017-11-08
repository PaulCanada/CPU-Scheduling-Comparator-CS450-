/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs450assignment1;

import java.util.Queue;

/**
 *
 * @author Paul Canada (https://github.com/PaulCanada)
 */
public class Process {

    public Process(String name, int burstTime, int priority, int arrivalTime) {
        this.name = name;
        this.burstTime = burstTime;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    public Process(String name, int burst, int arrival) {
        this.name = name;
        burstTime = burst;
        arrivalTime = arrival;
        waitTime = 0;
        priority = 0;
    }

    public Process() {
        name = "";
        burstTime = 0;
        priority = 0;
        arrivalTime = 0;
    }

    public Process(Process toCopy) {
        name = toCopy.name;
        burstTime = toCopy.burstTime;
        priority = toCopy.priority;
        arrivalTime = toCopy.arrivalTime;
        waitTime = toCopy.waitTime;
        turnAroundTime = toCopy.arrivalTime;
        completionTime = toCopy.completionTime;
        startTime = toCopy.startTime;
    }


    private final String name;
    private final int burstTime;
    private final int priority;
    private int arrivalTime;
    private int waitTime = 0;
    private int turnAroundTime = 0;
    private int completionTime = 0;
    private int startTime = 0;

}
