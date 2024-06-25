

public interface MyQueue {
	//Return the first data.
	//Throw Exception if the queue is empty.
	public Object front() throws Exception; 
	
	//Return the last data.
	//Throw Exception if the queue is empty.
	public Object back() throws Exception; 
	
	//Remove the first data (return its value too).
	//Throw Exception if the queue is empty.
	public Object removeFirst() throws Exception; 
	
	//Insert new data after the last data.
	//Throw exception if the insert fails for some reason.
	public void insertLast(Object data) throws Exception; 
	
	//Check if the queue is empty.
	public boolean isEmpty(); 
	
	//Check if the queue has no more space to store new data.
	public boolean isFull();
	
	//Return the number of data currently stored in the queue.
	public int size(); 	
	
}