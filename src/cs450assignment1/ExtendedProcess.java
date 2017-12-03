/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs450assignment1;

/**
 *
 * @author Paul Canada (https://github.com/PaulCanada)
 */
public class ExtendedProcess extends Process
{

    public ExtendedProcess(String name, int burstTime, int priority, int arrivalTime)
    {
        super(name, burstTime, priority, arrivalTime);
        remainingTime = burstTime;
    }

    public int getRemainingTime()
    {
        return remainingTime;
    }

    public void setRemainingTime(int amount)
    {
        remainingTime = amount;
    }

    public boolean getCompletionStatus()
    {
        return completionStatus;
    }

    public void setCompletionStatus(boolean status)
    {
        completionStatus = status;
    }

    private int remainingTime = 0;
    private boolean completionStatus = false;

}
