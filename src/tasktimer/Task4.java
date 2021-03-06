package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * Calculate the time of read words using BufferedReader and Stream with Collector.
 * @author Tunya Wittayasiripaiboon 5810546676
 */
public class Task4 implements Runnable{
	
	/**
	 * Read words using BufferedReader and Stream with Collector.
	 */
	@Override
	public void run() {
		InputStream instream = Dictionary.getWordsAsStream();
		BufferedReader br = null;
		try {
			br = new BufferedReader( new InputStreamReader(instream) );
		} catch (Exception ex) {
			out.println("Could not open dictionary: "+ex.getMessage());
			return;
		}

		final AtomicLong total = new AtomicLong();
		final AtomicInteger counter = new AtomicInteger();

		Consumer<String> consumer = new Consumer<String>() {
			public void accept(String word) {
				total.getAndAdd( word.length() );
				counter.incrementAndGet();
			}
		};

		br.lines().forEach( consumer ); 

		try { br.close(); } catch(IOException ex) {  }

		int count = counter.intValue();
		double averageLength = (count > 0) ? total.doubleValue()/count : 0.0;
		out.printf("Average length of %,d words is %.2f\n", count, averageLength );
	}
	/**
	 * Return string of task usage.
	 * @return string of task usage.
	 */
	public String toString(){
		return "Starting task: read words using BufferedReader and Stream with Collector";

	}
}
