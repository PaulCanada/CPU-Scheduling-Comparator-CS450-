/**
 * This class serves as a container for data pertaining to a process
 * used for the CPU scheduler.
 *
 */
package cs450assignment1;

/**
 * @author Paul Canada (https://github.com/PaulCanada)
 */
public class Process implements Comparable
{

    /**
     * Constructor for Process object given input values.
     *
     * @param name Name of the process.
     * @param burstTime Burst time of the process.
     * @param priority Priority of the process.
     * @param arrivalTime Arrival time of the process.
     */
    public Process(String name, int burstTime, int priority, int arrivalTime)
    {
        this.processName = name;
        this.burstTime = burstTime;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    /**
     * Constructor for Process object that will copy data from a secondary
     * Process object.
     *
     * @param toCopy    The Process object to copy data from.
     */
    public Process(Process toCopy)
    {
        processName = toCopy.processName;
        burstTime = toCopy.burstTime;
        priority = toCopy.priority;
        arrivalTime = toCopy.arrivalTime;
    }

    /**
     * Overridable compareTo for comparing two Process objects based on their
     * arrival time.
     *
     * @param other Process object to compare against.
     * @return Whether this object has a smaller arrival time than other.
     */
    @Override
    public int compareTo(Object other)
    {
        int compareArrivalTime = ((Process) other).getArrivalTime();

        return this.arrivalTime - compareArrivalTime;
    }

    /**
     * This method will return the name of the current Process.
     *
     * @return The name of the Process object.
     */
    public String getProcessName()
    {
        return processName;
    }

    /**
     * This method will return the burst time of the current Process.
     *
     * @return The burst time of the Process object.
     */
    public int getBurstTime()
    {
        return burstTime;
    }

    /**
     * This method will return the priority value of the current Process.
     *
     * @return The priority value of the Process object.
     */
    public int getPriority()
    {
        return priority;
    }

    /**
     * This method will return the time that the current Process arrived at.
     *
     * @return The arrival time of the Process object.
     */
    public int getArrivalTime()
    {
        return arrivalTime;
    }

    /**
     * This method will set the arrival time of this Process to the input.
     *
     * @param arrivalTime The time at which the process arrived.
     */
    public void setArrivalTime(int arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    /**
     * This method will return the total time this Process has waited until it
     * has completed.
     *
     * @return The time the Process has waited until its completion.
     */
    public int getWaitTime()
    {
        return waitTime;
    }

    /**
     * This method will set the time the Process has waited to the input.
     *
     * @param waitTime The total time the Process has waited.
     */
    public void setWaitTime(int waitTime)
    {
        this.waitTime = waitTime;
    }

    /**
     * This method will return the total time the Process took to complete.
     *
     * @return The total time the Process took to complete.
     */
    public int getTurnAroundTime()
    {
        return turnAroundTime;
    }

    /**
     * This method will set the turn around time for the Process to the input.
     *
     * @param turnAroundTime The total time the process took to complete.
     */
    public void setTurnAroundTime(int turnAroundTime)
    {
        this.turnAroundTime = turnAroundTime;
    }

    /**
     * This method will return the time at which the Process has completed.
     *
     * @return The time the Process completed.
     */
    public int getCompletionTime()
    {
        return completionTime;
    }

    /**
     * This method will set the time the Process completed to the input.
     *
     * @param completionTime The time the Process completed.
     */
    public void setCompletionTime(int completionTime)
    {
        this.completionTime = completionTime;
    }

    /**
     * This method will return the time at which the Process started.
     *
     * @return The time the Process started.
     */
    public int getStartTime()
    {
        return startTime;
    }

    /**
     * This method will set the time that the Process started to the input.
     *
     * @param startTime The time the Process started.
     */
    public void setStartTime(int startTime)
    {
        this.startTime = startTime;
    }

    // Class attributes.
    private final String processName;
    private final int burstTime;
    private final int priority;
    private int arrivalTime;
    private int waitTime = 0;
    private int turnAroundTime = 0;
    private int completionTime = 0;
    private int startTime = -1;

}
