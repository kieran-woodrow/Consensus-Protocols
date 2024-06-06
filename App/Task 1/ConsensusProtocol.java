import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.io.FileInputStream;

public abstract class ConsensusProtocol<T> implements Consensus<T>
{
	private static final Logger LOGGER = Logger.getLogger("global"); //logger object used to display messages
	protected volatile T[] proposedArray; //create array

	
	public ConsensusProtocol(int threadCount)
	{
		proposedArray = (T[]) new Object[threadCount]; //have to cast it
	}

	public void propose(T value)
	{
		int currentThread = ThreadID.get() % 2;

			if (currentThread == 0)
				LOGGER.info("Alice wants to watch the program for "+value+" minutes");

			else
				LOGGER.info("Bob wants to watch the program for "+value+" minutes");

		proposedArray[currentThread] = value; 
	}

	abstract public void decide(); //abstract/virtual function. Implemented in other class
}
