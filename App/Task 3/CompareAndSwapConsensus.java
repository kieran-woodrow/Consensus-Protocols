import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class CompareAndSwapConsensus<T> extends ConsensusProtocol<T>
{
    private static final Logger LOGGER = Logger.getLogger("global");
    private final int numberOne=-1;
    private AtomicInteger a = new AtomicInteger(numberOne);
    private int x;
    private Integer winner;
    
    public CompareAndSwapConsensus(int threadCount)
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
        int currentThread = (ThreadID.get()%x);
        int number =a.get();
        
        if(a.compareAndSet( numberOne, currentThread ))
        {
            winner = (Integer) proposedArray[currentThread % x];
            LOGGER.info("Participant " + ThreadID.get() + " sees the winning raffle number is " + winner);
        } 
        
        else 
        {
            LOGGER.info("Participant " + ThreadID.get() + " sees the winning raffle number is "+ proposedArray[a.get()]);
        }
        
		LOGGER.fine("Thread "+ThreadID.get()+" - register: "+number+" => "+a.get());
	} 
}
