import java.io.FileInputStream;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.*;

public class StackConsensus<T> extends ConsensusProtocol<T> 
{
    private static final Logger LOGGER = Logger.getLogger("global");

    private Stack stackContainer;
    private int x;
	private Integer winner;
    
    public StackConsensus(int threadCount)
    {
        super(threadCount);
        x = threadCount;
    }

    public void propose(Integer value)
    {
       propose(value);
    }

    public void decide() 
    {

        int winnerFromStack = (int)Thestack.peek();

		winner = (Integer) proposedArray[winnerFromStack % x];
		
		LOGGER.info("Participant "+ThreadID.get()+" sees the winning raffle number is "+winner);

    }

    public  void displayStackContents()
    {
        String emptyString="";

        if(!Thestack.isEmpty())
        {
            int[] tempArray = new int[x];
            
            for (int k =0;k<x ;k++)
            {
				tempArray[k] = (int)Thestack.peek();
				Thestack.pop();
			}
			
            for (int t = x-1; t >= 0; t--) //pop stack in reverse
            {
				emptyString = emptyString+tempArray[t]+" ";
            }	
            
            emptyString = emptyString.substring(0,emptyString.length());
            
			LOGGER.fine("Stack: "+emptyString);
	    }

    }
}
