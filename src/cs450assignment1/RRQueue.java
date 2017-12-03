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
     * @param numberOfProcesses
     * @param type
     */
    @Override
    public void setupInitialList(int numberOfProcesses, String type) {
        this.numberOfProcesses = numberOfProcesses;

        for (int i = 0; i < this.numberOfProcesses; i++) {
            initialList.add(new ExtendedProcess("P" + i, random.nextInt(5) + 3, random.nextInt(numberOfProcesses / 2), random.nextInt(30)));
        }

        Collections.sort(initialList);
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

                        }

                    }

                    // System.out.println("current process remaining time: " + currentProcess.getRemainingTime());
                    // If the remaining time of the process is 0, then the process
                    // is complete.
                    if (currentProcess.getRemainingTime() == 0) {
                        currentProcess.setCompletionStatus(true);
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
    public void printInitialProcessInformation() {
        System.out.println("Initial process information:");
        for (Iterator<ExtendedProcess> it = initialList.iterator(); it.hasNext();) {
            ExtendedProcess process = it.next();
            System.out.println("Process name: " + process.getProcessName() + ", Burst time: " + process.getBurstTime() + ", Priority: " + process.getPriority()
                    + ", Arrival time: " + process.getArrivalTime());
        }
    }

    @Override
    public void printReadyProcessInformation() {
        System.out.println("Ready process information:");
        for (Iterator<ExtendedProcess> it = readyQueue.iterator(); it.hasNext();) {
            ExtendedProcess process = it.next();
            System.out.println("Process name: " + process.getProcessName() + ", Burst time: " + process.getBurstTime() + ", Priority: " + process.getPriority()
                    + ", Arrival time: " + process.getArrivalTime() + ", Wait time: " + process.getWaitTime() + ", Start time: " + process.getStartTime()
                    + ", Completion time: " + process.getCompletionTime() + ", Turn around time: " + process.getTurnAroundTime());
        }
    }

    @Override
    public String getOutputText() {
        String output = "";

        for (ExtendedProcess process : readyQueue) {
            output += "Process name: " + process.getProcessName() + ", Burst time: " + process.getBurstTime() + ", Priority: " + process.getPriority()
                    + ", Arrival time: " + process.getArrivalTime() + ", Wait time: " + process.getWaitTime() + ", Start time: " + process.getStartTime()
                    + ", Completion time: " + process.getCompletionTime() + ", Turn around time: " + process.getTurnAroundTime() + ".\n";
        }

        output += "\nAverage wait time: " + calculateAverageWaitTime() + ".\n\n";

        return output;
    }

    @Override
    public int getNumberOfProcesses() {
        return initialList.size();
    }

    private int quantum = 0;
    private ArrayList<ExtendedProcess> initialList;
    private ArrayList<ExtendedProcess> readyQueue;

}
