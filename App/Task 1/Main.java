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
        ConsensusThread <Integer> T1;
        ConsensusThread <Integer> T2;

        Thestack=new StackConsensus(ConsensusOptions.threads);
          

        for(int i=0; i<ConsensusOptions.runs; i++)
        {
           T1= new ConsensusThread(Thestack);
           T2= new ConsensusThread(Thestack);

           T1.start();
           T2.start();
          
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
