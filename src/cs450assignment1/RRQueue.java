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
public class RRQueue extends ProcessQueue {

    public RRQueue(ArrayList<Process> processList, int quantum) {
        initialList = new ArrayList<>();
        readyQueue = new ArrayList<>();
        this.quantum = quantum;
        System.out.println("Start");

        for (int i = 0; i < processList.size(); i++) {
            initialList.add(new ExtendedProcess(processList.get(i)));
        }
        numberOfProcesses = initialList.size();

        System.out.println("End");
    }

    /**
     *
     * @param quantum
     */
    @Override
    public void setupAlgorithm() {
        // Clear the ready queue to start fresh.
        readyQueue.clear();

        int currentTime = 0;

        // Make a shallow copy of initialList and put it in readyQueue.
        readyQueue = new ArrayList<>(initialList);

        ExtendedProcess currentProcess;

        // Loop through until all processes are finished.
        while (hasUnfinishedProcess(readyQueue)) {
            // Loop through all processes in readyQueue.
            for (int i = 0; i < readyQueue.size(); i++) {
                currentProcess = readyQueue.get(i);

                // If the process is already done, skip it.
                if (!currentProcess.getCompletionStatus()) {
                    // If the current time is less than the arrival time of the process, increment the current time and skip the whole process.
                    if (currentTime < currentProcess.getArrivalTime()) {
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
                    if (currentProcess.getStartTime() == -1) {
                        currentProcess.setStartTime(currentTime);
                        currentProcess.setRemainingTime(currentProcess.getBurstTime());
                    }

                    // If the remaining time is greater than 0, then the process is not yet complete.
                    if (currentProcess.getRemainingTime() > 0) {

                        // If the remaining time is greater than the quantum, increase current
                        // time by quantum and reduce remaining time by quantum.
                        if (currentProcess.getRemainingTime() > quantum) {
                            // Increment current time by quantum
                            currentTime += quantum;

                            // Decrement process's remaining time by quantum
                            currentProcess.setRemainingTime(currentProcess.getRemainingTime() - quantum);

                        } else // Otherwise, the remaining time is less than the quantum and we need to set
                        // ending values.
                        {
                            currentTime += currentProcess.getRemainingTime();
                            currentProcess.setCompletionTime(currentTime);

                            currentProcess.setWaitTime(currentProcess.getCompletionTime() - currentProcess.getStartTime() - currentProcess.getBurstTime());

                            currentProcess.setRemainingTime(0);
                            currentProcess.setTurnAroundTime(currentProcess.getWaitTime() + currentProcess.getBurstTime());
                            
                            currentProcess.setCompletionStatus(true);

                        }

                    }

                    try {
                        if (currentTime < readyQueue.get(i + 1).getArrivalTime()) {
                            break;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index out of bounds in RR queue. Caught.");
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
    @Override
    public int calculateTotalWaitTime() {
        int total = 0;
        for (Iterator<ExtendedProcess> it = readyQueue.iterator(); it.hasNext();) {
            ExtendedProcess process = it.next();
            total += process.getWaitTime();
        }

        return total;
    }

    @Override
    public float calculateAverageWaitTime() {
        float average = 0;

        for (Iterator<ExtendedProcess> it = readyQueue.iterator(); it.hasNext();) {
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
    public boolean hasUnfinishedProcess(ArrayList<ExtendedProcess> list) {
        for (ExtendedProcess process : list) {
            if (!process.getCompletionStatus()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getOutputText() {
        String output = "";

        for (Process process : readyQueue) {
            output += process.getProcessName()
                    + "\r\n---Arrival time:    " + process.getArrivalTime()
                    + "\r\n---Start time:      " + process.getStartTime()
                    + "\r\n---Completion time: " + process.getCompletionTime()
                    + "\r\n---Wait time:       " + process.getWaitTime() 
                    + "\r\n---Turnaround time: " + process.getTurnAroundTime() + "\r\n\r\n";

        }
        return output;
    }

    @Override
    public int getNumberOfProcesses() {
        return initialList.size();
    }
    
    public void setQuantum(int quantum)
    {
        this.quantum = quantum;
    }

    private int quantum = 0;
    private ArrayList<ExtendedProcess> initialList;
    private ArrayList<ExtendedProcess> readyQueue;

}
