/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs450assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Paul Canada (https://github.com/PaulCanada)
 */
public class FCFSQueue extends ProcessQueue {

    public FCFSQueue(ArrayList<Process> processList) {
        initialList = new ArrayList<>();
        readyQueue = new ArrayList<>();
        for (int i = 0; i < processList.size(); i++) {
            initialList.add(new Process(processList.get(i)));
        }
        numberOfProcesses = initialList.size();
    }


    /**
     * 
     */
    @Override
    public void setupAlgorithm() {
        // Clear the ready queue to start fresh.
        readyQueue.clear();

        // Starting value for the service time.
        int serviceTime = 0;

        Process currentProcess;

        // Loop through every process in the initial list
        for (int i = 0; i < initialList.size(); i++) {
            // Add a copy of the process at initialList[i] to readyQueue
            readyQueue.add(new Process(initialList.get(i)));
            currentProcess = readyQueue.get(i);

            // If first process in queue or if the process arrived after the prior process has already completed, set defaults
            if (i == 0 || (readyQueue.get(i - 1).getBurstTime() + readyQueue.get(i - 1).getArrivalTime() < currentProcess.getArrivalTime())) {
                currentProcess.setStartTime(currentProcess.getArrivalTime());
                currentProcess.setWaitTime(0);
                currentProcess.setTurnAroundTime(currentProcess.getBurstTime());

            } else {
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
    public int calculateTotalWaitTime() {
        int total = 0;
        for (Iterator<Process> it = readyQueue.iterator(); it.hasNext();) {
            Process process = it.next();
            total += process.getWaitTime();
        }

        return total;
    }

    @Override
    public float calculateAverageWaitTime() {
        return (float) calculateTotalWaitTime() / numberOfProcesses;
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

    //private String type;
    private ArrayList<Process> initialList;
    private ArrayList<Process> readyQueue;

}
