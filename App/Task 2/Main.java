import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.io.FileInputStream;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        final Logger LOGGER = Logger.getLogger("global");
		
		configureLogger();
        LOGGER.setLevel(Level.FINE);

        StackConsensus <Integer> Thestack;
        ConsensusThread [] n=null;


        Thestack=new StackConsensus(ConsensusOptions.threads);
          

       
        for(int i=0;i<ConsensusOptions.runs;i++)
        {
        	Thestack=new StackConsensus(ConsensusOptions.threads);
        	
        	
        	n=new ConsensusThread[ConsensusOptions.threads];
        	
        	for(int j=0;j<ConsensusOptions.threads;j++)
        	{
        		n[j]=new ConsensusThread(Thestack);
        	}
        	
        	
        	for(int j=0;j<ConsensusOptions.threads;j++)
        	{
        		n[j].start();
        	}
        	
        	for(int j=0;j<ConsensusOptions.threads;j++)
        	{
        		try
        		{
        			n[j].join();
        		}
        		
        		catch (InterruptedException e)
      			{
        			e.printStackTrace();
        		}
        	}
       
            ThreadID.reset();
            Thestack.displayStackContents();   
        }
        
        // The scenario will need to run for the amount of runs
        // specified in the ConsensusOptions.java file. You can overwrite
        // the default ConsensusOptions values in this main method as follows:

            //ConsensusOptions.delay = 50;

        // This value will then reflect in all classes that access ConsensusOptions.delay.


        // HINT - Make sure the thread IDs are 0 and 1 in each run.
        // Take a look at the functions offered in ThreadID.java that you
        // could use to enforce this.
        // */
        
    }

    private static void configureLogger() {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
