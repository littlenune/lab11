package tasktimer;

import static java.lang.System.out;

import java.io.InputStream;
import java.util.Scanner;

/**
 * 
 * Calculate the time of read words using Scanner and a while loop.
 * @author Tunya Wittayasiripaiboon 5810546676
 *
 */
public class Task1 implements Runnable {
	
	@Override
	/**
	 * Read words using Scanner and a while loops 
	 */
	public void run() {
		
		InputStream instream = Dictionary.getWordsAsStream();
		Scanner in = new Scanner(instream);
		int count = 0;
		long totalsize = 0;
		while(in.hasNext()) {
			String word = in.next();
			totalsize += word.length();
			count++;
		}
		double averageLength = ((double)totalsize)/(count>0 ? count : 1);
		out.printf("Average length of %,d words is %.2f\n", count, averageLength);
		in.close();
		
	}
	/**
	 * Return string of task usage.
	 * @return string of task usage.
	 */
	public String toString(){
		
		return "Starting task: read words using Scanner and a while loop";
	
	}
}
