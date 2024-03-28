import java.util.ArrayList;
import java.util.Collection;

public class BSTList {
	BSTNodeList root;
	int size;
	
	public BSTList() {
		root = null;
		size = 0;
	}
	
	public BSTList(BSTNodeList root, int size) {
		this.root = root;
		this.size = size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		root = null;
		size = 0;
	}
	
	public BSTNodeList find(Comparable v) { 
		BSTNodeList temp = this.root;

		//loop to traverse tree
		while (temp != null && temp.dataList.get(0).first != ((Pairdata) v).first) {
			int index = 0;
			if (v.compareTo(temp.dataList.get(index)) < 0) {
				temp = temp.left;
				index += 1;
			} else {
				temp = temp.right;
				index += 1;
			}
		}
		//if found node is null
		if (temp == null) {
			return null;
		//if found node isnt null but doesnt have v
		}else if(!temp.dataList.contains(v)) {
			return null;
		}
		return temp;
	}
	
	public BSTNodeList insert(Comparable v) {
		BSTNodeList parent = null;
		BSTNodeList temp = this.root;
		
		//loop to traverse tree
		while (temp != null && temp.dataList.get(0).first != ((Pairdata) v).first) {
			int index = 0;
			if (v.compareTo(temp.dataList.get(index)) < 0) {
				parent = temp;
				temp = temp.left;
				index += 1;
			} else {
				parent = temp;
				temp = temp.right;
				index += 1;
			}
		}		
		//if node doesnt exist, create new node
		if (temp == null) {
			ArrayList<Pairdata> Temp2 = new ArrayList<Pairdata>();
			Temp2.add((Pairdata) v);
			BSTNodeList n = new BSTNodeList(Temp2, null, null, parent);
			if (parent == null) {
				root = n;
			} else if (((Pairdata)v).first - (parent.dataList.get(0).first) < 0) {
				parent.left = n;
			} else {
				parent.right = n;
			}
			size++;
			return n;
		} else {
			if (!temp.dataList.contains(v)) {
				temp.dataList.add((Pairdata) v);
				size++;
			}
			//if node exist
			return temp;
		}

	}


	
	public BSTNodeList findMin(BSTNodeList n) {
		BSTNodeList temp = n;
		if (temp == null)
			return null;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

	

	
}
