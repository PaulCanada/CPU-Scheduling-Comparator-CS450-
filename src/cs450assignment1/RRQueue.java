/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs450assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Paul Canada (https://github.com/PaulCanada)
 */
public class RRQueue extends ProcessQueue
{

    public RRQueue(int numberOfProcesses, String type)
    {
        System.out.println("Start.");
        random = new Random();
        System.out.println("Random created.");
        initialList = new ArrayList<>();
        System.out.println("Initial list initialized.");
        readyQueue = new ArrayList<>();
        System.out.println("readyQueue initialized");
        this.type = type;

        System.out.println("Initial list setup start");
        setupInitialList(numberOfProcesses, type);
        System.out.println("Initial list setup completed.");
    }

    // Testing constructor
    /**
     *
     */
    public RRQueue()
    {
        type = "RR";
        random = new Random();

        initialList = new ArrayList<>();
        readyQueue = new ArrayList<>();

        // Round Robin
        initialList.add(new ExtendedProcess("P1", 5, 1, 5));
        initialList.add(new ExtendedProcess("P2", 6, 2, 14));
        initialList.add(new ExtendedProcess("P3", 5, 3, 17));
        initialList.add(new ExtendedProcess("P4", 3, 3, 20));
        initialList.add(new ExtendedProcess("P5", 6, 1, 23));

        /*
        initialList.add(new Process("P1", 1, 1, 15));
        initialList.add(new Process("P2", 14, 2, 18));
        initialList.add(new Process("P3", 1, 3, 23));
        initialList.add(new Process("P4", 14, 3, 39));
        initialList.add(new Process("P5", 16, 13, 42));
         */
        numberOfProcesses = initialList.size();

    }

    /**
     *
     * @param numberOfProcesses
     * @param type
     */
    public void setupInitialList(int numberOfProcesses, String type)
    {
        this.numberOfProcesses = numberOfProcesses;

        for (int i = 0; i < this.numberOfProcesses; i++)
        {
            initialList.add(new ExtendedProcess("P" + i, random.nextInt(5) + 3, random.nextInt(numberOfProcesses / 2), random.nextInt(30)));
        }

        Collections.sort(initialList);
    }

    /**
     *
     * @param quantum
     */
    public void setupAlgorithm()
    {
        System.out.println("setupAlgorithm started");
        // Clear the ready queue to start fresh.
        readyQueue.clear();

        int currentTime = 0;

        // Make a shallow copy of initialList and put it in readyQueue.
        readyQueue = new ArrayList<>(initialList);
        System.out.println("Ready queue copied.");

        ExtendedProcess currentProcess;

        // Loop through until all processes are finished.
        while (hasUnfinishedProcess(readyQueue))
        {
            // Loop through all processes in readyQueue.
            for (int i = 0; i < readyQueue.size(); i++)
            {
                currentProcess = readyQueue.get(i);

                // If the process is already done, skip it.
                if (!currentProcess.getCompletionStatus())
                {
                    // If the current time is less than the arrival time of the process, increment the current time and skip the whole process.
                    if (currentTime < currentProcess.getArrivalTime())
                    {
                        System.out.println("Current time: " + currentTime + " < process arrival time: " + currentProcess.getArrivalTime() );
                        /**
                         * TODO: Determine if the CPU will advance a whole
                         * quantum, or just increment by 1. This affects start
                         * and completion time of the process.
                         */
                        //currentTime += quantum; // Advance by whole quantum
                        currentTime++; // Advance by 1
                        break;
                    }

                    // If the startTime of the process is -1, this is the first time seeing 
                    // the process. Set values.
                    if (currentProcess.getStartTime() == -1)
                    {
                        currentProcess.setStartTime(currentTime);
                        currentProcess.setRemainingTime(currentProcess.getBurstTime());
                    }

                    // If the remaining time is greater than 0, then the process is not yet complete.
                    if (currentProcess.getRemainingTime() > 0)
                    {

                        // If the remaining time is greater than the quantum, increase current
                        // time by quantum and reduce remaining time by quantum.
                        if (currentProcess.getRemainingTime() > quantum)
                        {
                            // Increment current time by quantum
                            currentTime += quantum;

                            // Decrement process's remaining time by quantum
                            currentProcess.setRemainingTime(currentProcess.getRemainingTime() - quantum);

                        } else
                        // Otherwise, the remaining time is less than the quantum and we need to set
                        // ending values.
                        {
                            System.out.println("sdfgd");
                            currentTime += currentProcess.getRemainingTime();
                            currentProcess.setCompletionTime(currentTime);

                            currentProcess.setWaitTime(currentProcess.getCompletionTime() - currentProcess.getStartTime() - currentProcess.getBurstTime());

                            currentProcess.setRemainingTime(0);
                            currentProcess.setTurnAroundTime(currentProcess.getWaitTime() + currentProcess.getBurstTime());

                        }

                    }

                   // System.out.println("current process remaining time: " + currentProcess.getRemainingTime());
                    // If the remaining time of the process is 0, then the process
                    // is complete.
                    if (currentProcess.getRemainingTime() == 0)
                    {
                        currentProcess.setCompletionStatus(true);
                        System.out.println("Set process completion to true.");
                    }

                    try
                    {
                        if (currentTime < readyQueue.get(i + 1).getArrivalTime())
                        {
                            break;
                        }
                    } catch (IndexOutOfBoundsException e)
                    {
                        System.out.println("Index out of bounds. Caught.");
                        break;
                    }
                }
            }

        }

    }

    /**
     *
     * @return
     */
    public int calculateTotalWaitTime()
    {
        int total = 0;
        for (Iterator<ExtendedProcess> it = readyQueue.iterator(); it.hasNext();)
        {
            ExtendedProcess process = it.next();
            total += process.getWaitTime();
        }

        return total;
    }

    public float calculateAverageWaitTime()
    {
        float average = 0;

        for (Iterator<ExtendedProcess> it = readyQueue.iterator(); it.hasNext();)
        {
            ExtendedProcess process = it.next();
            average += process.getWaitTime();
        }

        return average / numberOfProcesses;
    }

    /**
     *
     * @param list
     * @return
     */
    public boolean hasUnfinishedProcess(ArrayList<ExtendedProcess> list)
    {
        for (ExtendedProcess process : list)
        {
            if (!process.getCompletionStatus())
            {
                return true;
            }
        }

        return false;
    }

    public void printInitialProcessInformation()
    {
        System.out.println("Initial process information:");
        for (Iterator<ExtendedProcess> it = initialList.iterator(); it.hasNext();)
        {
            ExtendedProcess process = it.next();
            System.out.println("Process name: " + process.getProcessName() + ", Burst time: " + process.getBurstTime() + ", Priority: " + process.getPriority()
                    + ", Arrival time: " + process.getArrivalTime());
        }
    }

    public void printReadyProcessInformation()
    {
        System.out.println("Ready process information:");
        for (Iterator<ExtendedProcess> it = readyQueue.iterator(); it.hasNext();)
        {
            ExtendedProcess process = it.next();
            System.out.println("Process name: " + process.getProcessName() + ", Burst time: " + process.getBurstTime() + ", Priority: " + process.getPriority()
                    + ", Arrival time: " + process.getArrivalTime() + ", Wait time: " + process.getWaitTime() + ", Start time: " + process.getStartTime()
                    + ", Completion time: " + process.getCompletionTime() + ", Turn around time: " + process.getTurnAroundTime());
        }
    }

    private int quantum = 0;
    private ArrayList<ExtendedProcess> initialList;
    private ArrayList<ExtendedProcess> readyQueue;

}
