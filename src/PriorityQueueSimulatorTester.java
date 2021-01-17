import java.io.*;
import java.util.Random;

public class PriorityQueueSimulatorTester {
	//generate an array of jobs
	public static Job[] jobsInputArry(int num, Job[] arr) {
		for(int i = 0; i < num; i++) {
			String jobName = "JOB_"+(i+1);
			Random random = new Random();
			int randomLength = random.nextInt(70)+1;
			int jobLength = randomLength;
			int currentJobLength = randomLength;
			Random random2 = new Random();
			int randomPriority = random2.nextInt(40)+1;
			int jobPriority = randomPriority;
			int finalPriority = randomPriority;
			long entryTime = 0;
			long waitTime = 0;
			long endTime = 0;
			Job job = new Job(jobName, jobLength, currentJobLength, jobPriority, finalPriority, entryTime, waitTime, endTime);
			arr[i] = job;
		}
		return arr;
	}
	//Calculate the average wait time
	public static long CalculateAverage(long[] waitTime) {
		long AverageWaitingTime = 0;
		for (int i = 0; i < waitTime.length;i++) {
			AverageWaitingTime += (long)waitTime[i];
		}
		AverageWaitingTime = AverageWaitingTime/(long)(waitTime.length);
		return AverageWaitingTime;
	}
	//simulate CPU running method
	public static void runCPU(PQ_SortedList list, int count2, int count, int size, PrintWriter pw) {
		long[] waitArr = new long[size];
		int positionWaitArr = 0;
		int numOfPriorityChanges = 0;
		long startTime = System.currentTimeMillis();
		long endTime = 0;
		while(!list.isEmpty()){
			int processes = 0;
			while(processes != 30) {
				count++;
				Entry<Job, Integer, Integer> e = (Entry<Job, Integer, Integer>) list.removeMin();
				System.out.println("Now executing " + e.value.jobName + ". Job length: " + e.value.jobLength +
						" cycles; Current remaing length: " + e.value.currentJobLength + " cycles; Initial priority: " + 
						e.value.jobPriority + ";" + " Current priority: " + e.value.finalPriority);
				e.value.currentJobLength = e.value.currentJobLength - 1;
				if(e.value.currentJobLength == 0) {
					processes++;
					Long waitTime = count - e.value.entryTime - e.value.jobLength;
					waitArr[positionWaitArr]= waitTime;
					positionWaitArr++;
					if(list.isEmpty()) {
						break;
					}
				}
				else {
					processes++;
					count2++;
					e.finalKey = count2;
					list.insert(e.value, e.firstKey, e.finalKey);
					count++;
				}
			}
			if(!list.isEmpty()){
				numOfPriorityChanges += starvedMethod(list, numOfPriorityChanges);
				count++;
			}
			endTime = System.currentTimeMillis();
		}
		long AverageWaitingTime = CalculateAverage(waitArr);
		pw.println("Sorted-List PQ:");
		pw.println("Current system time (cycles): " + count);
		pw.println("Total number of jobs executed: " + size);
		pw.println("Average process waiting time: "+ AverageWaitingTime);
		pw.println("Total number of priority changes: "+ numOfPriorityChanges);
		pw.println("Actual system time needed to execute all jobs: " + (endTime-startTime) + "ms.");	
		pw.println();
	}
	//method for starved
	public static int starvedMethod(PQ_SortedList list, int numOfPriorityChanges){
		Entry poorJob = new Entry<Job, Integer, Integer>();	
		poorJob = (Entry) list.removeMax();
		if(poorJob != null) {
			((Job) poorJob.value).finalPriority = 1;
			poorJob.firstKey = 1;
			numOfPriorityChanges = numOfPriorityChanges + 1;
			list.insert(poorJob.value, ((Job) poorJob.value).finalPriority, poorJob.finalKey);
			System.out.println("changed!");
		}
		return 1;
	}
	
	
	
	
	
	/*
	 * the following methods are for the priority queue which implement by heap
	 */
	public static void runCPU2(Heap list, int count2, int count, int size, PrintWriter pw) {
		long[] waitArr = new long[size];
		int positionWaitArr = 0;
		int numOfPriorityChanges = 0;
		long startTime = System.currentTimeMillis();
		long endTime = 0;
		while(!list.isEmpty()){
			int processes = 0;
			while(processes != 30) {
				count++;
				Entry<Job, Integer, Integer> e = (Entry<Job, Integer, Integer>) list.removeMin();
				System.out.println("Now executing " + e.value.jobName + ". Job length: " + e.value.jobLength +
						" cycles; Current remaing length: " + e.value.currentJobLength + " cycles; Initial priority: " + 
						e.value.jobPriority + ";" + " Current priority: " + e.value.finalPriority);
				e.value.currentJobLength = e.value.currentJobLength - 1;
				if(e.value.currentJobLength == 0) {
					processes++;
					Long waitTime = count - e.value.entryTime - e.value.jobLength;
					waitArr[positionWaitArr]= waitTime;
					positionWaitArr++;
					if(list.isEmpty()) {
						break;
					}
				}
				else {
					processes++;
					count2++;
					e.finalKey = count2;
					list.insert(e.value, e.firstKey, e.finalKey);
					count++;
				}
			}
			if(!list.isEmpty()){
				numOfPriorityChanges += starvedMethod2(list, numOfPriorityChanges);
				count++;
			}
			endTime = System.currentTimeMillis();
		}
		long AverageWaitingTime = CalculateAverage(waitArr);
		pw.println("Array-List-based Heap PQ:");
		pw.println("Current system time (cycles): " + count);
		pw.println("Total number of jobs executed: " + size);
		pw.println("Average process waiting time: "+ AverageWaitingTime);
		pw.println("Total number of priority changes: "+ numOfPriorityChanges);
		pw.println("Actual system time needed to execute all jobs: " + (endTime-startTime) + "ms.");	
		pw.println();
	}
	//method for starved
		public static int starvedMethod2(Heap list, int numOfPriorityChanges){
			Entry poorJob = new Entry<Job, Integer, Integer>();	
			poorJob = (Entry) list.removeMax();
			if(poorJob != null) {
				((Job) poorJob.value).finalPriority = 1;
				poorJob.firstKey = 1;
				numOfPriorityChanges = numOfPriorityChanges + 1;
				list.insert(poorJob.value, ((Job) poorJob.value).finalPriority, poorJob.finalKey);
				System.out.println("changed!");
			}
			return 1;
		}
	
	
	
	
	
	/*
	 * main method
	 */
	public static void main(String[] args) {
		PrintWriter pw= null;
        try{
        pw = new PrintWriter(new FileOutputStream("SimulatorPerformanceResults.txt"));
        }
        catch (FileNotFoundException e){
        System.out.println(e.getStackTrace());
        } 
		
        //number of jobs need to execute
		int[] maxNumberOfJobs = {100, 1000, 10000, 100000, 1000000};
		//execute every elements from the above array
		for(int i = 0; i < 3; i++){
			int count = 0;//record the current system time
			int count1 = 0;//record the sequence of into the list
			Job[] jobsInputArray = new Job[maxNumberOfJobs[i]];
			jobsInputArray = jobsInputArry(maxNumberOfJobs[i],jobsInputArray);			
			PQ_SortedList list = new PQ_SortedList();
			for(int j = 0; j < jobsInputArray.length; j++){
				count1++;
				count++;
				Entry e = new Entry<Job, Integer, Integer>(jobsInputArray[j], jobsInputArray[j].jobPriority, count1);
				((Job) e.value).entryTime = count1;
				list.insert(e.value, e.firstKey, e.finalKey);
			}
			runCPU(list, count1, count, maxNumberOfJobs[i], pw);
			jobsInputArray = null;
		}
		
		System.out.println("\n==========================================================================\n");
		
		//execute in heap-pq
		for(int i = 0; i < 3; i++){
			int count = 0;//record the current system time
			int count1 = 0;//record the sequence of into the list
			Job[] jobsInputArray = new Job[maxNumberOfJobs[i]];
			jobsInputArray = jobsInputArry(maxNumberOfJobs[i],jobsInputArray);			
			Heap heap = new Heap();
			for(int j = 0; j < jobsInputArray.length; j++){
				count1++;
				count++;
				Entry e = new Entry<Job, Integer, Integer>(jobsInputArray[j], jobsInputArray[j].jobPriority, count1);
				((Job) e.value).entryTime = count1;
				heap.insert(e.value, e.firstKey, e.finalKey);
			}
			runCPU2(heap, count1, count, maxNumberOfJobs[i], pw);
			jobsInputArray = null;
		}
		pw.close();
	}

}
