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
public class CS450Assignment1
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        FCFSQueue fcfs = new FCFSQueue();
        RRQueue rr = new RRQueue();
        fcfs.setupAlgorithm();
        rr.setupAlgorithm();

        System.out.println("First come first serve algorithm:");
        fcfs.printInitialProcessInformation();
        fcfs.printReadyProcessInformation();
        System.out.println("Total wait time for " + fcfs.getType() + ": " + fcfs.calculateTotalWaitTime());
        System.out.println("Average wait time for " + fcfs.getType() + ": " + fcfs.calculateAverageWaitTime());

        System.out.println("Round Robin algorithm:");
        rr.printInitialProcessInformation();
        rr.printReadyProcessInformation();
        System.out.println("Total wait time for " + rr.getType() + ": " + rr.calculateTotalWaitTime());
        System.out.println("Average wait time for " + rr.getType() + ": " + rr.calculateAverageWaitTime());
    }
}
