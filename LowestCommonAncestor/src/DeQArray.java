

public class DeQArray extends QueueArray implements DeQ{

	@Override
	public Object removeLast() throws Exception {
		Object data = back();
		size--;
		return data;
	}

	@Override
	public void insertFirst(Object data) throws Exception {
		if (isFull())
			doubleCapacity();
		front = front-1;
		if(front <0) front = theArray.length-1;
		theArray[front] = data;
		size++;
	}

}
