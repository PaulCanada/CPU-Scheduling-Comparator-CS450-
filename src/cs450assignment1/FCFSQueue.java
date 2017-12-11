/**
 * This class contains information and methods that will perform the First Come
 * First Serve algorithm for a set of Processes.
 *
 * @see Process
 */
package cs450assignment1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Paul Canada (https://github.com/PaulCanada)
 */
public class FCFSQueue extends ProcessQueue
{

    /**
     * Constructor for an FCFS object. Takes in a list of Processes to use.
     *
     * @param processList The list of Processes to use.
     */
    public FCFSQueue(ArrayList<Process> processList)
    {
        initialList = new ArrayList<>();
        readyQueue = new ArrayList<>();
        for (int i = 0; i < processList.size(); i++)
        {
            initialList.add(new Process(processList.get(i)));
        }
        numberOfProcesses = initialList.size();
    }

    /**
     * This method overrides the abstract method from ProcessQueue. This method
     * will handle the algorithm setup and completion for FCFS.
     *
     * @see ProcessQueue
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
            if (i == 0 || (readyQueue.get(i - 1).getTurnAroundTime() + readyQueue.get(i - 1).getArrivalTime() < currentProcess.getArrivalTime()))
            {
                currentProcess.setStartTime(currentProcess.getArrivalTime());
                currentProcess.setWaitTime(0);
                currentProcess.setTurnAroundTime(currentProcess.getBurstTime());

            } // Otherwise, calculate service time based on prior Process's data.
            else
            {
                serviceTime = readyQueue.get(i - 1).getArrivalTime() + readyQueue.get(i - 1).getBurstTime() + readyQueue.get(i - 1).getWaitTime();
                currentProcess.setWaitTime(serviceTime - currentProcess.getArrivalTime());
                currentProcess.setStartTime(currentProcess.getWaitTime() + currentProcess.getArrivalTime());
            }

            // Set turn around time and completion time for this process.
            currentProcess.setTurnAroundTime(currentProcess.getWaitTime() + currentProcess.getBurstTime());
            currentProcess.setCompletionTime(currentProcess.getStartTime() + currentProcess.getBurstTime());
        }
    }

    /**
     * This method will calculate and return the total wait time for all
     * Processes in the list.
     *
     * @return The total wait time for all Process objects.
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

    /**
     * This method will calculate and return the average wait time for all
     * Processes in the list.
     *
     * @return The average wait time for all Process objects.
     */
    @Override
    public float calculateAverageWaitTime()
    {
        return (float) calculateTotalWaitTime() / numberOfProcesses;
    }

    /**
     * This method will handle sending output text from the completed algorithm
     * to the UI. This will allow the UI to update the TextAreaOuput with the
     * completed algorithm data.
     *
     * @return The text output from running the algorithm.
     */
    @Override
    public String getOutputText()
    {
        String output = "";

        for (Process process : readyQueue)
        {
            output += process.getProcessName()
                    + "\r\n---Arrival time:    " + process.getArrivalTime()
                    + "\r\n---Start time:      " + process.getStartTime()
                    + "\r\n---Completion time: " + process.getCompletionTime()
                    + "\r\n---Wait time:       " + process.getWaitTime()
                    + "\r\n---Turnaround time: " + process.getTurnAroundTime() + "\r\n\r\n";

        }
        return output;
    }

    /**
     * This method will return the total number of Processes in the list.
     *
     * @return The total number of Process objects in the list.
     */
    @Override
    public int getNumberOfProcesses()
    {
        return initialList.size();
    }

    //private String type;
    private ArrayList<Process> initialList;
    private ArrayList<Process> readyQueue;

}
