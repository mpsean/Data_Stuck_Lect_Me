

public interface DeQ extends MyQueue {
	// Remove the last data (return its value too).
	// Throw Exception if the queue is empty.
	public Object removeLast() throws Exception;

	// Insert new data as the first data.
	// Throw Exception if the insert is not successful
	// for some unknown reason.
	public void insertFirst(Object data) throws Exception;
}
