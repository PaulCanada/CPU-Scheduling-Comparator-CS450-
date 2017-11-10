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
public class ProcessQueue
{

    // Main constructor
    public ProcessQueue(int numberOfProcesses, String type)
    {
        random = new Random();
        initialList = new ArrayList<>();
        readyQueue = new ArrayList<>();

        setupInitialList(numberOfProcesses, type);
    }

    public void setupInitialList(int numberOfProcesses, String type)
    {
        this.type = type;
        this.numberOfProcesses = numberOfProcesses;

        for (int i = 0; i < this.numberOfProcesses; i++)
        {
            initialList.add(new Process("P" + i, random.nextInt(5) + 3, random.nextInt(numberOfProcesses / 2), random.nextInt(30)));
        }

        Collections.sort(initialList);
    }

    // Testing constructor
    public ProcessQueue()
    {
        type = "FCFS";
        random = new Random();
        numberOfProcesses = 4;
        initialList = new ArrayList<>();
        readyQueue = new ArrayList<>();

        initialList.add(new Process("P0", 6, 1, 0));
        initialList.add(new Process("P1", 4, 0, 5));
        initialList.add(new Process("P2", 3, 0, 7));
        initialList.add(new Process("P3", 4, 1, 13));
        /*
        initialList.add(new Process("P0", 4, 1, 0));
        initialList.add(new Process("P1", 3, 0, 5));
        initialList.add(new Process("P2", 3, 0, 10));
        initialList.add(new Process("P3", 7, 1, 11));
         */
    }

    public void setupRoundRobinQueue(int quantum)
    {
        // Clear the ready queue to start fresh.
        readyQueue.clear();
        int serviceTime = 0;
        int waitTime = 0;
        int completionTime = 0;
        int turnAroundTime = 0;
        int startTime = 0;
        int currentTime = 0;

        readyQueue = new ArrayList<>(initialList);

        // Set time remaining for all processes to their burst time
        for (Process process : readyQueue)
        {
            process.setRemainingTime(process.getBurstTime());
        }

        // Loop through until process is finished
        while (true)
        {
            boolean done = true;

            for (int i = 0; i < numberOfProcesses; i++)
            {
                Process currentProcess;
                currentProcess = readyQueue.get(i);

                // Process is not yet complete
                if (currentProcess.getRemainingTime() > 0)
                {
                    done = false;

                    if (currentProcess.getRemainingTime() > quantum)
                    {
                        // Increment current time by quantum
                        currentTime += quantum;
                        
                        // Decrement process's remaining time by quantum
                        currentProcess.setRemainingTime(currentProcess.getRemainingTime() - quantum);
                        
                    } else
                    {

                    }

                }
            }

        }

    }

    public void setupFCFSQueue()
    {
        // Clear the ready queue to start fresh.
        readyQueue.clear();

        // Starting value for the service time.
        int serviceTime = 0;

        int waitTime = 0;

        int completionTime = 0;

        int turnAroundTime = 0;

        int startTime = 0;

        for (int i = 0; i < numberOfProcesses; i++)
        {
            Process currentProcess;
            currentProcess = new Process(initialList.get(i));

            if (i == 0)
            {
                startTime = currentProcess.getArrivalTime();
                currentProcess.setStartTime(startTime);
                currentProcess.setWaitTime(waitTime);
                completionTime = currentProcess.getBurstTime() + currentProcess.getStartTime();
                turnAroundTime = currentProcess.getBurstTime();

            } else
            {
                if (readyQueue.get(i - 1).getBurstTime() + readyQueue.get(i - 1).getArrivalTime() < currentProcess.getArrivalTime())
                {
                    waitTime = 0;
                    startTime = currentProcess.getArrivalTime();
                    currentProcess.setWaitTime(waitTime);

                } else
                {
                    serviceTime = readyQueue.get(i - 1).getArrivalTime() + readyQueue.get(i - 1).getBurstTime() + readyQueue.get(i - 1).getWaitTime();
                    waitTime = serviceTime - currentProcess.getArrivalTime();
                    startTime = waitTime + currentProcess.getArrivalTime();
                    currentProcess.setWaitTime(waitTime);

                }

                completionTime = startTime + currentProcess.getBurstTime();
                turnAroundTime = waitTime + currentProcess.getBurstTime();

            }

            currentProcess.setCompletionTime(completionTime);
            currentProcess.setTurnAroundTime(turnAroundTime);
            currentProcess.setStartTime(startTime);

            readyQueue.add(currentProcess);
        }
    }

    public int calculateTotalFCFSWaitTime()
    {
        int total = 0;
        for (Iterator<Process> it = readyQueue.iterator(); it.hasNext();)
        {
            Process process = it.next();
            total += process.getWaitTime();
        }

        return total;
    }

    public int calculateAverageFCFSWaitTime()
    {
        int average = 0;

        for (Iterator<Process> it = readyQueue.iterator(); it.hasNext();)
        {
            Process process = it.next();
            average += process.getWaitTime();
        }

        return average / numberOfProcesses;
    }

    public void printInitialProcessInformation()
    {
        System.out.println("Initial process information:");
        for (Iterator<Process> it = initialList.iterator(); it.hasNext();)
        {
            Process process = it.next();
            System.out.println("Process name: " + process.getProcessName() + ", Burst time: " + process.getBurstTime() + ", Priority: " + process.getPriority()
                    + ", Arrival time: " + process.getArrivalTime());
        }
    }

    public void printReadyProcessInformation()
    {
        System.out.println("Ready process information:");
        for (Iterator<Process> it = readyQueue.iterator(); it.hasNext();)
        {
            Process process = it.next();
            System.out.println("Process name: " + process.getProcessName() + ", Burst time: " + process.getBurstTime() + ", Priority: " + process.getPriority()
                    + ", Arrival time: " + process.getArrivalTime() + ", Wait time: " + process.getWaitTime() + ", Start time: " + process.getStartTime()
                    + ", Completion time: " + process.getCompletionTime() + ", Turn around time: " + process.getTurnAroundTime());
        }
    }

    private String type;
    private ArrayList<Process> initialList;
    private ArrayList<Process> readyQueue;
    private int numberOfProcesses;
    private final Random random;

}
