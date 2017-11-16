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
public class FCFSQueue extends ProcessQueue
{

    public FCFSQueue(int numberOfProcesses, String type)
    {
        random = new Random();
        initialList = new ArrayList<>();
        readyQueue = new ArrayList<>();
        this.type = type;

        setupInitialList(numberOfProcesses, type);
    }

    // Testing constructor
    /**
     *
     */
    public FCFSQueue()
    {
        type = "FCFS";
        random = new Random();

        initialList = new ArrayList<>();
        readyQueue = new ArrayList<>();

        //FCFS
        
        initialList.add(new Process("P0", 6, 1, 0));
        initialList.add(new Process("P1", 4, 0, 5));
        initialList.add(new Process("P2", 3, 0, 7));
        initialList.add(new Process("P3", 4, 1, 13));
        
        //FCFS
        /*
        initialList.add(new Process("P0", 4, 1, 0));
        initialList.add(new Process("P1", 3, 0, 5));
        initialList.add(new Process("P2", 3, 0, 10));
        initialList.add(new Process("P3", 7, 1, 11));
         */

        numberOfProcesses = initialList.size();

    }

    /**
     *
     * @param numberOfProcesses
     * @param type
     */
    @Override
    public void setupInitialList(int numberOfProcesses, String type)
    {
        this.numberOfProcesses = numberOfProcesses;

        for (int i = 0; i < this.numberOfProcesses; i++)
        {
            initialList.add(new Process("P" + i, random.nextInt(5) + 3, random.nextInt(numberOfProcesses / 2), random.nextInt(30)));
        }

        Collections.sort(initialList);
    }

    /**
     *
     */
    @Override
    public void setupAlgorithm()
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

    /**
     *
     * @return
     */
    @Override
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

    @Override
    public float calculateAverageWaitTime()
    {
        float average = 0;

        for (Iterator<Process> it = readyQueue.iterator(); it.hasNext();)
        {
            Process process = it.next();
            average += process.getWaitTime();
        }

        return average / numberOfProcesses;
    }

    @Override
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

    @Override
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

    //private String type;
    private ArrayList<Process> initialList;
    private ArrayList<Process> readyQueue;


}
