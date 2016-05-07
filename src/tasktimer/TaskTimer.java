package tasktimer;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.*;
import java.util.function.IntConsumer;
import java.util.function.Consumer;
import java.util.concurrent.atomic.*;  // hack, using AtomicInteger as accumulator

/**
 * Get the elapsed time of each tasks and run the program.
 * @author Tunya Wittayasiripaiboon 5810546676
 */
public class TaskTimer
{
	/**
	 * Run the tasks.
	 * @param args
	 */
	public static void main(String [] args) {
		execAndPrint(new Task1());
		execAndPrint(new Task2());
		execAndPrint(new Task3());
		execAndPrint(new Task4());
		execAndPrint(new Task5());
		execAndPrint(new Task6());
	}
	/**
	 * Print out task usage of interested task also start , stop and get elapsed of the time.
	 * @param task that wanted to test.
	 */
	public static void execAndPrint ( Runnable task ){
		StopWatch time = new StopWatch();
		System.out.println(task.toString());
		time.start();
		task.run();
		time.stop();
		out.printf("Elapsed time is %f sec\n",time.geteElapsed());
		
	}

}
