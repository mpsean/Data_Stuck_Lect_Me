
public class StackNode implements MyStack {
	private Object[] theArray;
	private int currentSize;
	private static final int DEFAULT_SIZE = 10;
	
		public StackNode(){ // create an empty stack
			this(DEFAULT_SIZE);
		}
		
		public StackNode(int intendedCapacity){
			theArray = new Object[intendedCapacity];
			currentSize =0;
		}
		
		public StackNode(Object[] theArray, int currentSize) {
			super();
			this.theArray = theArray;
			this.currentSize = currentSize;
		}

		public Object[] getTheArray() {
			return theArray;
		}

		public void setTheArray(Object[] theArray) {
			this.theArray = theArray;
		}

		public int getCurrentSize() {
			return currentSize;
		}

		public void setCurrentSize(int currentSize) {
			this.currentSize = currentSize;
		}
		
		public boolean isEmpty(){
			return currentSize ==0;
		}
		
		public boolean isFull(){
			return currentSize == theArray.length;
		}
		
		public void makeEmpty(){
			theArray = new Object[DEFAULT_SIZE];
			currentSize =0;
		}
		
		@Overwrite
		public int top() throws MyStackException{
			return -1; //we dont use this 
		}
		
		public Object Top() throws MyStackException{
			if(isEmpty())
				throw new MyStackException();
			return theArray[currentSize-1];
		}
		
		public void pop() throws MyStackException{
			if(isEmpty())
				throw new MyStackException();
			currentSize--;
		}
		
		public void doubleCapacity(){ //resize array to twice the original size 
			Object[] temp = new Object[theArray.length*2];
			System.arraycopy(theArray, 0, temp, 0, theArray.length);
			theArray = temp;
		}
		
		public void push(int i) throws Exception {
			//do nothing
		}
		
		public void Push(Object obj) throws Exception {
			if(isFull())
				doubleCapacity();
			theArray[currentSize] = obj;
			currentSize++;
		}
		
		
		public int size() {
			return currentSize;
		}

}
