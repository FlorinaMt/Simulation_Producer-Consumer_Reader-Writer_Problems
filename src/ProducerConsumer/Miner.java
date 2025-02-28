package ProducerConsumer;

public class Miner implements Runnable
{
  private final Deposit deposit;
  public Miner(Deposit deposit)
  {
    this.deposit=deposit;
  }
  @Override public void run()
  {
    while(true)
    {
      Logger.getInstance().addLog(Thread.currentThread().getName() + " is digging.");
      Valuable valuable=dig();
      Logger.getInstance().addLog(Thread.currentThread().getName() + " found a valuable: "+ valuable);
      deposit.depositValuable(valuable);
      try
      {
        Thread.sleep(5000);
      }
      catch(InterruptedException e)
      {
        //
      }
    }
  }
  private Valuable dig()
  {
    try
    {
      Thread.sleep(3000);
    }
    catch(InterruptedException e)
    { }
    double random=Math.random();
    if(random<0.2)
      return Valuable.getInstance("diamond");
    else if(random<0.4)
      return Valuable.getInstance("golden nugget");
    else if(random<0.6)
      return Valuable.getInstance("jewel");
    else if(random<0.8)
      return Valuable.getInstance("ruby");
    return Valuable.getInstance("wooden coin");
  }
}
