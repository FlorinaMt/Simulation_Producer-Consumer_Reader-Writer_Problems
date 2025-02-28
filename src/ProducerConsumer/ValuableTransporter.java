package ProducerConsumer;

import ReadersWritersProxy.TreasureRoom;
import ReadersWritersProxy.TreasureRoomDoor;
import ReadersWritersProxy.WriteTreasureRoom;

public class ValuableTransporter implements Runnable
{
  private final Deposit deposit;
  private final ArrayList<Valuable> valuables;
  private final TreasureRoomDoor treasureRoomDoor;
  public ValuableTransporter(Deposit deposit, TreasureRoomDoor treasureRoomDoor)
  {
    this.deposit=deposit;
    this.treasureRoomDoor=treasureRoomDoor;
    valuables=new ArrayList<>();
  }
  @Override public void run()
  {
    while (true)
    {
      int random = (int) Math.floor(Math.random() * (200 - 50 + 1) + 50);
      Logger.getInstance().addLog(Thread.currentThread().getName() + " must transport valuables worth at least: " + random);
      while (getTotalValue() < random)
      {
        valuables.add(deposit.extractValuable());
        Logger.getInstance().addLog(
            Thread.currentThread().getName() + " extracted valuables worth: " + getTotalValue() + "; Goal: " + random);
      }

      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        //
      }
      WriteTreasureRoom room=treasureRoomDoor.acquireWrite();
      int total=valuables.size();
      int value=0;
    for (int i = 0; i < total; i++)
    {
      room.add(valuables.get(0));
      value+=valuables.get(0).getValue();
      valuables.remove(0);
    }
    Logger.getInstance().addLog(Thread.currentThread().getName() + " added all the valuables to the treasure room; total value: " + value );
    treasureRoomDoor.releaseWrite(room);

    }
  }
  private int getTotalValue()
  {
    int total=0;
    for(int i=0; i<valuables.size(); i++)
      total=total+valuables.get(i).getValue();
    return total;
  }
}
