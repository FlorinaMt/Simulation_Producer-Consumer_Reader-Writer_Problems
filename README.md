### The simulation

![image](https://github.com/FlorinaMt/Producer-Consumer_Reader-Writer_Problems/assets/151634373/42fb700f-d4e0-4734-a0be-6cc61caadffa)


&emsp;The King has a Treasure room (lower left corner) with the door guarded by a Guardsman. The valuables in the Treasure room come from a Mine (upper right corner) with Miners transporting their findings to a Deposit (lower right corner). Occasionally, Valuable Transporters are moving valuables from Deposit to the Treasure room and Accountants are counting all valuables in the Treasure room. When the King feels like partying, he takes valuables from the Treasure room if there are enough for a party.

#### Requirements

• Threads to simulate the actors: King, Accountant, ValuableTransporter and ValuablesMiner.

• Singleton to log any action, e.g. when an actor waits or performs a job.

• Multiton for different types of Valuables, e.g. Diamond, GoldNugget, Jewel, Ruby, WoodenCoin.

• Adapter for the ArrayList in the Deposit.

• Producer - Consumer for the Deposit with the Miners and Valuables Transporters being producers and consumers, respectively.

• Readers - Writers for the Treasure room and Guardsman.

• Proxy between the Treasure room and the Guardsman.

• There is quite a distance from the Deposit to the Treasure Room, so a Valuables Transporter does not want to transport only one valuable at a time. Therefore, the Valuables Transporter will generate a random number, e.g. between 50 and 200. He will then, a number of times, get the next valuable from the Deposit. This will continue, until he has a list of valuables with a total worth equal to or more than the original target number.

#### Class Diagram
![image](https://github.com/FlorinaMt/Producer-Consumer_Reader-Writer_Problems/assets/151634373/dac283ec-6e51-4fb9-a1c1-3cc0f74f434f)

