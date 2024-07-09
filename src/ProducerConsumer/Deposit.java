package ProducerConsumer;

import java.util.ArrayDeque;
import java.util.Queue;

public class Deposit
{
  //private ListADT<Valuable> list;
  private final Queue<Valuable> queue;
  private final int capacity;

  public Deposit(int capacity)
  {
    queue = new ArrayDeque<>();
    this.capacity = capacity;
  }

  public synchronized void depositValuable(Valuable valuable)
  {
    while (queue.size() >= capacity)
    {
      try
      {
        Logger.getInstance().addLog(
            Thread.currentThread().getName() + " is waiting to deposit a "
                + valuable + "; The deposit contains " + queue.size()
                + " valuables: " + queue.toString());
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    queue.add(valuable);
    Logger.getInstance().addLog(
        Thread.currentThread().getName() + " deposited a " + valuable
            + "; The deposit contains " + queue.size() + " valuables: "
            + queue.toString());
    notifyAll();
  }

  public synchronized Valuable extractValuable()
  {
    while (queue.isEmpty())
    {
      try
      {
        Logger.getInstance().addLog(Thread.currentThread().getName()
            + " is waiting to extract a valuable; The deposit contains "
            + queue.size() + " valuables: " + queue.toString());
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    Valuable valuable = queue.peek();
    notifyAll();
    Logger.getInstance().addLog(
        Thread.currentThread().getName() + " extracted a " + valuable
            + "; The deposit contains " + queue.size() + " valuables: "
            + queue.toString());
    return valuable;
  }
}
