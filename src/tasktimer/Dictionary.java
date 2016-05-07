package tasktimer;

import java.io.InputStream;
/**
 * Dictionary class will return the words in a  file and will parse to input stream. 
 * @author Tunya Wittayasiripaiboon 5810546676
 */
public class Dictionary {
    private static String DICTIONARY = "wordlist.txt";
	public static InputStream getWordsAsStream(){
        InputStream instream = TaskTimer.class.getClassLoader().getResourceAsStream(DICTIONARY);
        return instream;
	}
}
