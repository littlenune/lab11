package tasktimer;
/**
 *  The stop watch class will start the time , stop the time and get the elapsed of the time.
 * @author Tunya Wittayasiripaiboon 5810546676
 */
public class StopWatch {
	private long startTime;
	private long stopTime;
	private boolean running ;
	/**
	 * If the running is false then it will start counting the time.
	 */
	public void start(){
		if ( !running){
			startTime = System.nanoTime();
			running = true;
		}

	}
	/**
	 * If the running is true then it will stop counting the time.
	 */
	public void stop(){
		if ( running ){
			stopTime = System.nanoTime();
			running =  false;

		}
	}
	/**
	 * Get an elapsed of time.
	 * @return elapse time.
	 */
	public double geteElapsed(){
		return (stopTime - startTime)*1.0E-9 ;

	}
}
