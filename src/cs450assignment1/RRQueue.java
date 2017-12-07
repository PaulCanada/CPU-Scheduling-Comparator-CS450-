/**
 * This class contains information and methods that will perform the Round Robin
 * algorithm for a set of ExtendedProcess objects.
 *
 * @see cs450Assignment1.ExtendedProcess
 */
package cs450assignment1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Paul Canada (https://github.com/PaulCanada)
 */
public class RRQueue extends ProcessQueue
{

    /**
     * Constructor for RRQueue object. Takes in a list of ExtendedProcesses and
     * a quantum to use as a time slice.
     *
     * @param processList The list of ExtendedProcesses to use.
     * @param quantum The time slice value to use.
     */
    public RRQueue(ArrayList<Process> processList, int quantum)
    {
        initialList = new ArrayList<>();
        readyQueue = new ArrayList<>();
        this.quantum = quantum;

        for (int i = 0; i < processList.size(); i++)
        {
            initialList.add(new ExtendedProcess(processList.get(i)));
        }
        numberOfProcesses = initialList.size();
    }

    /**
     * This method overrides the abstract method from ProcessQueue. This method
     * will handle the algorithm setup and completion for Round Robin.
     *
     * @see cs450Assignment1.ProcessQueue
     */
    @Override
    public void setupAlgorithm()
    {
        // Clear the ready queue to start fresh.
        readyQueue.clear();

        int currentTime = 0;

        // Make a shallow copy of initialList and put it in readyQueue.
        readyQueue = new ArrayList<>(initialList);

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

                        } else // Otherwise, the remaining time is less than the quantum and we need to set
                        // ending values.
                        {
                            currentTime += currentProcess.getRemainingTime();
                            currentProcess.setCompletionTime(currentTime);
                            currentProcess.setTurnAroundTime(currentProcess.getCompletionTime() - currentProcess.getArrivalTime());
                            currentProcess.setWaitTime(currentProcess.getTurnAroundTime() - currentProcess.getBurstTime());
                            currentProcess.setRemainingTime(0);
                            currentProcess.setCompletionStatus(true);

                        }

                    }

                    try
                    {
                        if (currentTime < readyQueue.get(i + 1).getArrivalTime())
                        {
                            break;
                        }
                    } catch (IndexOutOfBoundsException e)
                    {
                        //System.out.println("Index out of bounds in RR queue. Caught.");
                        break;
                    }
                }
            }

        }
    }

    /**
     * This method will calculate and return the total wait time for all
     * Processes in the list.
     *
     * @return The total wait time for all ExtendedProcess objects.
     */
    @Override
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

    /**
     * This method will calculate and return the average wait time for all
     * Processes in the list.
     *
     * @return The average wait time for all ExtendedProcess objects.
     */
    @Override
    public float calculateAverageWaitTime()
    {
        float average = 0;

        for (ExtendedProcess process : readyQueue)
        {
            average += process.getWaitTime();
        }

        return average / numberOfProcesses;
    }

    /**
     * This method will handle checking if there are any ExtendedProcesses in
     * the list that have yet to be completed.
     *
     * @param list The list of ExtendedProcess objects to check.
     * @return True if there is an unfinished process, false if all
     * ExtendedProcesses have been completed.
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

    /**
     * This method will handle setting the quantum value (read: time slice) for
     * use with Round Robin.
     *
     * @param quantum The time slice value to use.
     */
    public void setQuantum(int quantum)
    {
        this.quantum = quantum;
    }

    // Class variables.
    private int quantum = 0;
    private ArrayList<ExtendedProcess> initialList;
    private ArrayList<ExtendedProcess> readyQueue;

}
