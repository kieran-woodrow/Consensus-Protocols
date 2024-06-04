import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class MemorySwapConsensus<T> extends ConsensusProtocol<T>
{
    private static final Logger LOGGER = Logger.getLogger("global");
    private volatile int array[];
    private int number=-1;
    private AtomicInteger register = new AtomicInteger(number);
    private int x;
    private Integer winner;
    // MemorySwapConsensus object;
    
    public MemorySwapConsensus(int threadCount)
    {
      super(threadCount);
      x = threadCount;
      array = new int [threadCount];

      for(int k = 0; k < threadCount; k++)
      {
        array[k] = 0;
      }

    }
    
    public void propose(Integer value)
    {
		  propose(value);
    }
    
    public void decide()
    {
      int currentThread = ThreadID.get() % x;

      if( register.compareAndSet(-1, currentThread) )
      {
        array[currentThread] = 1;
      }

        winner = (Integer) proposedArray[currentThread % x];

        LOGGER.info("Participant " + ThreadID.get() + " sees the winning raffle number is " + winner);

      printRegisterContents();
      // String arrayString = print();
      // LOGGER.fine("Registers @  Participant "+ThreadID.get()+": ["+arrayString+"]");
    } 
  
  public void printRegisterContents()
  {
    String arrayString = print();
    LOGGER.fine("Registers @  Participant "+ThreadID.get()+": ["+arrayString+"]");
  }

  public String print()
  {
    String empty = " ";
    String all="hello";

    for(int c = 0; c < array.length; c++)
    {
      all = array[c] + empty;
    }

    all.substring(0, all.length()-1);

    return all;
  }

  // public void swapFunction(int a)
  // {
  //      int temp;
  //      temp=array[a];
  //      array[ThreadID.get()] = 1;
  //      r = temp;
  // }

}
