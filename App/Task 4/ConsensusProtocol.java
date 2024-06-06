import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.io.FileInputStream;
import java.util.*;

public abstract class ConsensusProtocol<T> implements Consensus<T>
{
	private static final Logger LOGGER = Logger.getLogger("global"); //logger object used to display messages
	protected volatile T[] proposedArray; //create array
	private int x;
	protected Stack Thestack;

	
	public ConsensusProtocol(int threadCount)
	{
		proposedArray = (T[]) new Object[threadCount]; //have to cast it
		x=threadCount;
		Thestack = new Stack();
	}

	public void propose(T value)
	{
		int currentThread = ThreadID.get();
		
		LOGGER.info("Participant "+ThreadID.get()+" buys a raffle ticket with random number "+value);
		Thestack.push(currentThread);

		proposedArray[ThreadID.get()%x]= value;
	}

	abstract public void decide(); //abstract/virtual function. Implemented in other class
}
