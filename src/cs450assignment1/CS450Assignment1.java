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
    public static void main(String[] args) {
        // TODO code application logic here
        
        ProcessQueue q = new ProcessQueue();
        q.setupFCFSQueue();
        
        q.printInitialProcessInformation();
        q.printReadyProcessInformation();
        
        System.out.println("Total wait time for FCFS: " + q.calculateTotalFCFSWaitTime());
        System.out.println("Average wait time for FCFS: " + q.calculateAverageFCFSWaitTime());
    }

}
