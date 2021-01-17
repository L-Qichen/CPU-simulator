# cpu-simulator
In this programming question, you need to build a program that simulates CPU (Central Processing Unit) scheduling for executing processes/jobs (these names will be used interchangeably as they have the same meaning) on a computer system. You are going to use a priority queue to schedule the CPU jobs for the operating system. As a quick idea of what you need to do, the jobs, which are recorded in an initial array, are entered into a priority queue. The program will then keep looping, where each iteration will correspond to a time slice of the CPU where one of the jobs is partially executed, until the priority queue is empty (which indicates that all jobs have been completed).
ADT & Implementation:
1. The Job class. The attributes of this class correspond the above description.
2. two priority queues one linear and one non-linear: 1. Sorted List; 2. Array-List-based Heap.

Test Simulator:
Write a driver class called PriorityQueueSimulatorTester.  In that class, generate an array called jobsInputArray of size maxNumberOfJobs. Use your two priority queues implementation from part I to run your simulator with maxNumberOfJobs = {100, 1000, 10000, 100000, 1000000}.
The array jobsInputArray holds a set of jobs (each index has an entry of type Job). When you create your job
objects to fill the array, the following must be followed:
 The jobName is composed of the word "JOB_" and the jobNumber. which is the index of the array where this job
is inserted + 1. For instance, the entry inserted at index 0 will be set as Job_1, and the entry inserted at index 285 will be Job_286.
 The jobLength must be initialed at random integer value between 1 and 70 inclusive. The currentJobLength must then be initialed to this same value.
 The jobPriority must be initialed at random to an integer value between 1 (highest priority) and 40 (lowest priority), inclusive. The finalPriority must then be initialed to this same value.
 The enteryTime, waitTime, endTime must all be initialized to zero. However, these values are updated either when the entry is inserted in the queue (entryTime as described above), or when the process terminates (endTime, and waitTime).
 Record the performance report for each value of MaxNumberOfJobs and for all two types of your priority queues.
Finally, save the result of your program execution in a file called SimulatorPerformanceResults.txt.
