/**
 * This class serves as a container for data pertaining to a process
 * used for the CPU scheduler. This class is derived from the parent
 * class Process.
 * Along with the data from Process(), this class contains the remaining
 * time of a process, as well as a boolean value for if the process is 
 * complete.
 *
 * @see cs450Assignment1.Process
 */
package cs450assignment1;

/**
 * @date 11/21/2017
 * @author Paul Canada (https://github.com/PaulCanada)
 */
public class ExtendedProcess extends Process {

    /**
     * Constructor for ExtendedProcess given input values.
     * Inherits from super class Process.
     * @see cs450Assignment1.Process
     * 
     * @param name          Name of the process.
     * @param burstTime     Burst time of the process.
     * @param priority      Priority of the process.
     * @param arrivalTime   Arrival time of the process.
     */
    public ExtendedProcess(String name, int burstTime, int priority, int arrivalTime) {
        super(name, burstTime, priority, arrivalTime);
    }

    /**
     * Constructor for ExtendedProcess to copy data from an input Process.
     * @see cs450Assignment1.Process
     * 
     * @param toCopy        The process to copy data from.
     */
    public ExtendedProcess(Process toCopy) {
        super(toCopy.getProcessName(), toCopy.getBurstTime(), toCopy.getPriority(), toCopy.getArrivalTime());

    }

    /**
     * This method will return the remaining time left for the 
     * ExtendedObject until it is finished. 
     * 
     * @return  The remaining time of the ExtendedProcess object.
     */
    public int getRemainingTime() {
        return remainingTime;
    }

    /**
     * This method will set the remaining time of the ExtendedProcess 
     * to the input amount.
     * 
     * @param amount The amount to set.
     */
    public void setRemainingTime(int amount) {
        remainingTime = amount;
    }

    /**
     * This method will return the completion of the ExtendedProcess.
     * True if complete, false if uncompleted.
     * 
     * @return  Whether the ExtendedProcess has completed or not.
     */
    public boolean getCompletionStatus() {
        return completionStatus;
    }

    /**
     * This method will set the ExtendedProcess's completionStatus
     * to the input boolean.
     * 
     * @param status Boolean value to set.
     */
    public void setCompletionStatus(boolean status) {
        completionStatus = status;
    }

    // Class attributes.
    private int remainingTime = 0;
    private boolean completionStatus = false;

}
