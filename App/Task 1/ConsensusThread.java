import java.util.Random; 

public class ConsensusThread<T> extends Thread{
   
Consensus<Integer> object;

int s = ConsensusOptions.delay;
int r = ConsensusOptions.runs;
int t = ConsensusOptions.threads;

 ConsensusThread(Consensus<Integer> consensusObject)
 {
   object = consensusObject;
 }

 public void run()
 {
  int startTime = 0; 
  int endTime = 49; 
  int range = endTime - startTime + 1; 
  int randomTime = (int) ((Math.random() * range) + startTime); 

   try
   {
      object.propose(randomTime);
      sleep(s);
   }

   catch (InterruptedException e) // have to have catch for sleep function
   {
      e.printStackTrace();
   }

   object.decide();
   
 }

}
