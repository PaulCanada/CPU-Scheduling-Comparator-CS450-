# CPU Scheduling Comparator

This repository contains source code for assignment 1 of WCSU's CS450 class (Operating Systems).

The purpose of this program is to "simulate" the First Come First Serve (FCFS) and Round Robin (RR) CPU scheduling algorithms.
This is achieved by creating processes with data such as:
  - Process name
  - Burst time 
  - Arrival time
  - Priority
  
With this data and a list of processes, we can compute the time that each process must wait using both algorithms. Upon calculating the wait time, we can also compute:
  - Start time ; The time at which the process starts "executing" (Arrival time - Wait time)
  - Completion ; The time at which the process has finished "executing" (Start time + Burst time)
  - Turn around time ; The time between when the process arrived and when the process finishes "executing" (Completion time - Arrival time)
  
  
If time permits, I will try to accomplish other CPU scheduling algorithms into this program.
