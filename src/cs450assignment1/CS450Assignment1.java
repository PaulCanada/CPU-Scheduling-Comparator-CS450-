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
        // TODO code application logic here
        /*
        ProcessQueue q = new ProcessQueue(5, "Round Robin");
        //q.setupFCFSQueue();
        q.setupRoundRobinQueue(4);
        
        q.printInitialProcessInformation();
        q.printReadyProcessInformation();
        
        System.out.println("Total wait time for " + q.getType() + ": " + q.calculateTotalWaitTime());
        System.out.println("Average wait time for " + q.getType() + ": " + q.calculateAverageWaitTime());
         */
        
        FCFSQueue fcfs = new FCFSQueue();
        RRQueue rr = new RRQueue(4, "RR");
        fcfs.setupAlgorithm();
        //rr.setupAlgorithm();
        
        System.out.println("First come first serve algorithm:");
        fcfs.printInitialProcessInformation();
        fcfs.printReadyProcessInformation();
        
        System.out.println("Round Robin algorithm:");
        //rr.printInitialProcessInformation();
        //rr.printReadyProcessInformation();
    }

}
