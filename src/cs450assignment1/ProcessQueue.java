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
        numberOfProcesses = 3;
        initialList = new ArrayList<>();
        readyQueue = new ArrayList<>();

        //FCFS
        /*
        initialList.add(new Process("P0", 6, 1, 0));
        initialList.add(new Process("P1", 4, 0, 5));
        initialList.add(new Process("P2", 3, 0, 7));
        initialList.add(new Process("P3", 4, 1, 13));
         */
        //FCFS
        /*
        initialList.add(new Process("P0", 4, 1, 0));
        initialList.add(new Process("P1", 3, 0, 5));
        initialList.add(new Process("P2", 3, 0, 10));
        initialList.add(new Process("P3", 7, 1, 11));
         */
        //Round Robin
        initialList.add(new Process("P1", 3, 1, 7));
        initialList.add(new Process("P2", 4, 2, 8));
        initialList.add(new Process("P3", 3, 3, 8));

    }

    public void setupRoundRobinQueue(int quantum)
    {
        // Clear the ready queue to start fresh.
        readyQueue.clear();

        int currentTime = 0;
        int quantumPassedCounter = 0;

        readyQueue = new ArrayList<>(initialList);

        // Set time remaining for all processes to their burst time
        for (Process process : readyQueue)
        {
            process.setRemainingTime(process.getBurstTime());
        }

        Process currentProcess;

        // Loop through until all processes are finished
        while (hasUnfinishedProcess(readyQueue))
        {
 
            for (int i = 0; i < numberOfProcesses; i++)
            {
                currentProcess = readyQueue.get(i);

                if (currentTime < currentProcess.getArrivalTime())
                {
                    /**
                     * TODO:
                     * Determine if the CPU will advance a whole quantum, or just increment by 1.
                     * This affects start and completion time of the process
                     */
                    //currentTime += quantum; // Advance by whole quantum
                    currentTime++; // Advance by 1
                    break;
                }
                
                if (currentProcess.getStartTime() == -1)
                {
                    currentProcess.setStartTime(currentTime);
                }
                
                // Process is not yet complete
                if (currentProcess.getRemainingTime() > 0)
                {

                    if (currentProcess.getRemainingTime() > quantum)
                    {
                        // Increment current time by quantum
                        currentTime += quantum;
                        //quantumPassedCounter += quantum;

                        // Decrement process's remaining time by quantum
                        currentProcess.setRemainingTime(currentProcess.getRemainingTime() - quantum);

                    } else
                    {
                        //quantumPassedCounter += quantum;
                        currentTime = currentTime + currentProcess.getRemainingTime();
                        currentProcess.setCompletionTime(currentTime);

                        currentProcess.setWaitTime(currentTime - currentProcess.getStartTime());
                        //currentProcess.setWaitTime(quantumPassedCounter);

                        currentProcess.setRemainingTime(0);
                        currentProcess.setTurnAroundTime(currentProcess.getCompletionTime() - currentProcess.getStartTime());

                    }

                }

                if (currentProcess.getRemainingTime() == 0)
                {
                    currentProcess.setCompletionStatus(true);
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

        Process currentProcess;

        // Loop through every process in the initial list
        for (int i = 0; i < initialList.size(); i++)
        {
            // Add a copy of the process at initialList[i] to readyQueue
            readyQueue.add(new Process(initialList.get(i)));
            currentProcess = readyQueue.get(i);

            // If first process in queue or if the process arrived after the prior process has already completed, set defaults
            if (i == 0 || (readyQueue.get(i - 1).getBurstTime() + readyQueue.get(i - 1).getArrivalTime() < currentProcess.getArrivalTime()))
            {
                currentProcess.setStartTime(currentProcess.getArrivalTime());
                currentProcess.setWaitTime(0);
                currentProcess.setTurnAroundTime(currentProcess.getBurstTime());

            } else
            {
                serviceTime = readyQueue.get(i - 1).getArrivalTime() + readyQueue.get(i - 1).getBurstTime() + readyQueue.get(i - 1).getWaitTime();
                currentProcess.setWaitTime(serviceTime - currentProcess.getArrivalTime());
                currentProcess.setStartTime(currentProcess.getWaitTime() + currentProcess.getArrivalTime());
            }

            currentProcess.setTurnAroundTime(currentProcess.getWaitTime() + currentProcess.getBurstTime());
            currentProcess.setCompletionTime(currentProcess.getStartTime() + currentProcess.getBurstTime());
        }
    }

    public int calculateTotalWaitTime()
    {
        int total = 0;
        for (Iterator<Process> it = readyQueue.iterator(); it.hasNext();)
        {
            Process process = it.next();
            total += process.getWaitTime();
        }

        return total;
    }

    public int calculateAverageWaitTime()
    {
        int average = 0;

        for (Iterator<Process> it = readyQueue.iterator(); it.hasNext();)
        {
            Process process = it.next();
            average += process.getWaitTime();
        }

        return average / numberOfProcesses;
    }

    public boolean hasUnfinishedProcess(ArrayList<Process> list)
    {
        for (Process process : list)
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

    public String getType()
    {
        return type;
    }

    private String type;
    private ArrayList<Process> initialList;
    private ArrayList<Process> readyQueue;
    private int numberOfProcesses;
    private final Random random;

}
