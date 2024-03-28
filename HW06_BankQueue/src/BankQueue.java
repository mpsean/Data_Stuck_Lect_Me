
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		double numberPeople = special.size();
		double numberQueue = 1;//special queue = 1
		for(DeQ c : counters) {
			numberPeople += c.size();
			numberQueue += 1;
		}
		double neededQueueLength = Math.round(numberPeople/numberQueue);
		
		System.out.print(neededQueueLength+"d");//debug
		
		for(DeQ c : counters) {
			if(c.size()==neededQueueLength) {
				break;
			}else {
				for(int n=0; n<neededQueueLength ;n++ ) //re-struct queue until needed queue length
				{
					c.insertLast(c.removeFirst());
				}
				//add to special
				//when special is not full && counter got more element that neededQueueLength
				while(special.size() < neededQueueLength && c.size() > neededQueueLength) {
					special.insertLast(c.removeFirst());
				}
				//re-struct leftovers
				if(c.size()>neededQueueLength) {
					for(int n=0; n<c.size()-neededQueueLength; n++) {
						c.insertLast(c.removeFirst());
					}
				}
			}
				
			}
		//if special is null, get the last data of last counter to it 
		if (special.size() == 0) {
			special.insertLast((counters[counters.length-1].removeLast()));
		}
		return;
		}
	}

