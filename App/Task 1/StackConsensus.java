import java.io.FileInputStream;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.*;

public class StackConsensus<T> extends ConsensusProtocol<T> 
{
    private static final Logger LOGGER = Logger.getLogger("global");

    private Stack stackContainer;
    
    public StackConsensus(int threadCount)
    {
        super(threadCount);
        this.stackContainer =  new Stack(); //create the stack

        for(int i=0;i<ConsensusOptions.runs;i++)
        {
            this.stackContainer.push(0); //push 0 onto stack representing a lose
            this.stackContainer.push(1); //push 1 onto stack to represent a win
        }
    }

    public void propose(Integer value)
    {
       propose(value);
    }

    public void decide() {

        int x = (int) stackContainer.pop();
        int currentThread = ThreadID.get() % 2;

        if(currentThread == 0)
        {
            if(x==0)
        	{
        		LOGGER.fine("Alice drew a WIN from the stack");
        	}
        	
        	else
        	{
        		LOGGER.fine("Alice drew a LOSE from the stack");
        	}
        
        }
        
        else
        {
            if(x==0)
        	{
        		LOGGER.fine("Bob drew a WIN from the stack");
        	}
        	
        	else
        	{
        		LOGGER.fine("Bob drew a LOSE from the stack");
        	}
        }

        int amount=0;

        if(x==0)
        {
            amount = (int) proposedArray[currentThread];
        } 

        else 
        {
            amount = (int) proposedArray[1 - currentThread];
        }
        
        if(currentThread==0)
        {
        	LOGGER.info("Alice decided on "+amount+" minutes");
        }
        
        else
        {
        	LOGGER.info("Bob decided on "+amount+" minutes");
        }

    }
}
