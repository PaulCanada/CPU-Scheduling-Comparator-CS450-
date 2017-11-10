/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs450assignment1;

/**
 *
 * @author Paul Canada (https://github.com/PaulCanada)
 */
public class Process implements Comparable
{

    public Process(String name, int burstTime, int priority, int arrivalTime)
    {
        this.processName = name;
        this.burstTime = burstTime;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    public Process(String name, int burst, int arrival)
    {
        this.processName = name;
        burstTime = burst;
        arrivalTime = arrival;
        waitTime = 0;
        priority = 0;
    }

    public Process()
    {
        processName = "";
        burstTime = 0;
        priority = 0;
        arrivalTime = 0;
    }

    public Process(Process toCopy)
    {
        processName = toCopy.processName;
        burstTime = toCopy.burstTime;
        priority = toCopy.priority;
        arrivalTime = toCopy.arrivalTime;
    }

    @Override
    public int compareTo(Object other)
    {
        int compareArrivalTime = ((Process) other).getArrivalTime();

        return this.arrivalTime - compareArrivalTime;
    }

    public String getProcessName()
    {
        return processName;
    }

    public int getBurstTime()
    {
        return burstTime;
    }

    public int getPriority()
    {
        return priority;
    }

    public int getArrivalTime()
    {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public int getWaitTime()
    {
        return waitTime;
    }

    public void setWaitTime(int waitTime)
    {
        this.waitTime = waitTime;
    }

    public int getTurnAroundTime()
    {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime)
    {
        this.turnAroundTime = turnAroundTime;
    }

    public int getCompletionTime()
    {
        return completionTime;
    }

    public void setCompletionTime(int completionTime)
    {
        this.completionTime = completionTime;
    }

    public int getStartTime()
    {
        return startTime;
    }

    public void setStartTime(int startTime)
    {
        this.startTime = startTime;
    }

    public int getRemainingTime()
    {
        return remainingTime;
    }

    public void setRemainingTime(int amount)
    {
        remainingTime = amount;
    }
    
    public boolean getCompletionStatus()
    {
        return completionStatus;
    }
    
    public void setCompletionStatus(boolean status)
    {
        completionStatus = status;
    }

    private final String processName;
    private final int burstTime;
    private final int priority;
    private int arrivalTime;
    private int waitTime = 0;
    private int turnAroundTime = 0;
    private int completionTime = 0;
    private int startTime = 0;
    private int remainingTime = 0;
    private boolean completionStatus = false;
}
