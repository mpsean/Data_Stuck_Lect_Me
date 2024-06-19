
public class SimulateQueue {

	CustomerInfo[][] allEvents; //events in each and every queue
 
	MyQueue[] allQueues; // queues of people, corresponding to the events

	public SimulateQueue(CustomerInfo[][] allEvents, MyQueue[] allQueues) {
		super();
		this.allEvents = allEvents;
		this.allQueues = allQueues;
	}

	public void stateBeforeTimeT(int t) throws Exception {
		//TODO: implement this method.
		int allEventSize = allEvents.length;
		for(int i = 0; i<allEventSize;i++) {
			//MyQueue targetQueue = allQueues[i];
			CustomerInfo[] targetEvent = allEvents[i];
			int tEventSize = targetEvent.length;
			for(int j = 0 ; j<tEventSize;j++) {
				if(targetEvent[j].getTime()<t) {
					if(targetEvent[j].getEvent()==1) {
						allQueues[i].insertLast(targetEvent[j].getTime());
					}else { //customer done ; getEvent()=-1, remove customer from q
						allQueues[i].removeFirst();
					}
				}else {
					break;
				}
			}
		}



	}

}
