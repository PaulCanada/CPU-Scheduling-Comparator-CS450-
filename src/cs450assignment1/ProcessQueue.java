/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs450assignment1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Paul Canada (https://github.com/PaulCanada)
 */
public abstract class ProcessQueue
{

    /**
     *
     * @param numberOfProcesses
     * @param type
     */
    abstract void setupInitialList(int numberOfProcesses, String type);

    /**
     *
     */
    abstract void setupAlgorithm();

    /**
     *
     * @return
     */
    abstract int calculateTotalWaitTime();

    /**
     *
     * @return
     */
    abstract float calculateAverageWaitTime();

    /**
     *
     */
    abstract void printInitialProcessInformation();

    /**
     *
     */
    abstract void printReadyProcessInformation();

    /**
     *
     * @return
     */
    public String getType()
    {
        return type;
    }

    protected String type;
    protected int numberOfProcesses;
    protected Random random;

}
