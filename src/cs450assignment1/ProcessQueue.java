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
public class ProcessQueue
{

    // Main constructor
    public ProcessQueue(int numberOfProcesses, String type)
    {
        random = new Random();
        this.type = type;
        this.numberOfProcesses = numberOfProcesses;
        initialList = new ArrayList<>();
        readyQueue = new ArrayList<>();

        int arrivalTime = 0;

        for (int i = 0; i < this.numberOfProcesses; i++)
        {
            arrivalTime = random.nextInt(30);
            initialList.add(new Process("P" + i, random.nextInt(5) + 3, random.nextInt(numberOfProcesses / 2), arrivalTime));
        }
    }

    // Testing constructor
    public ProcessQueue()
    {
        type = "FCFS";
        random = new Random();
        numberOfProcesses = 4;
        initialList = new ArrayList<>();
        readyQueue = new ArrayList<>();

        initialList.add(new Process("P0", 6, 1, 0));
        initialList.add(new Process("P1", 4, 0, 5));
        initialList.add(new Process("P2", 3, 0, 7));
        initialList.add(new Process("P3", 4, 1, 13));
        /*
        initialList.add(new Process("P0", 4, 1, 0));
        initialList.add(new Process("P1", 3, 0, 5));
        initialList.add(new Process("P2", 3, 0, 10));
        initialList.add(new Process("P3", 7, 1, 11));
         */
    }

    private final String type;
    private ArrayList<Process> initialList;
    private ArrayList<Process> readyQueue;
    private int numberOfProcesses;
    private final Random random;

}
