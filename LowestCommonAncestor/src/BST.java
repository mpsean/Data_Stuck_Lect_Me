import java.util.ArrayList;

public class BST {
	BSTNode root;
	int size;

	public BST() {
		root = null;
		size = 0;
	}

	public BST(BSTNode root, int size) {
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

	public Iterator find(int v) {
		BSTNode temp = root;

		while (temp != null && temp.data != v) {
			if (v < temp.data) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		if (temp == null) // not found
			return null;
		return new TreeIterator(temp);
	}

	public Iterator insert(int v) {
		BSTNode parent = null;
		BSTNode temp = root;

		// This first part is almost the same as find,
		// but it has an extra pointer called parent.
		while (temp != null && temp.data != v) {
			if (v < temp.data) {
				parent = temp;
				temp = temp.left;

			} else {
				parent = temp;
				temp = temp.right;

			}
		}

		if (temp == null) {
			BSTNode n = new BSTNode(v, null, null, parent);
			if (parent == null) {
				root = n;
			} else if (v < parent.data) {
				parent.left = n;
			} else {
				parent.right = n;
			}
			size++;
			return new TreeIterator(n);
		} else {
			// we do nothing since
			// we don't want to add duplicated data.
			return null;
		}

	}

	public void remove(int v) {
		BSTNode parent = null;
		BSTNode temp = root;

		TreeIterator i = (TreeIterator) find(v);
		if (i == null) { // not found, we can not remove it
			return;
		}

		temp = i.currentNode;
		parent = temp.parent;

		// otherwise, we remove the value.
		size--;
		if (temp.left == null && temp.right == null) {// both subtrees are empty
			if (parent == null) {
				root = null;
			} else if (parent.left == temp) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (temp.left == null && temp.right != null) {// only right child
			if (parent == null) {
				root = temp.right;
				root.parent = null;
			} else if (parent.right == temp) {
				BSTNode n = temp.right;
				n.parent = parent;
				parent.right = n;
				// temp.right = null;
				// temp.parent = null;
			} else {// parent.left == temp
				BSTNode n = temp.right;
				n.parent = parent;
				parent.left = n;
			}
		} else if (temp.right == null && temp.left != null) {
			if (parent == null) {
				root = temp.left;
				root.parent = null;
			} else if (parent.right == temp) {
				BSTNode n = temp.left;
				n.parent = parent;
				parent.right = n;
			} else {
				BSTNode n = temp.left;
				n.parent = parent;
				parent.left = n;

			}

		} else {// temp has two subtrees
			BSTNode n = temp.right;
			TreeIterator itr = (TreeIterator)(findMin(n));
			BSTNode minInSubtree = itr.currentNode;

			temp.data = minInSubtree.data;

			BSTNode parentOfMin = minInSubtree.parent;
			if (parentOfMin.left == minInSubtree) {
				parentOfMin.left = minInSubtree.right;

			} else { // parentOfMin.right == minInSubtree
				parentOfMin.right = minInSubtree.right;

			}

			if (minInSubtree.right != null) {
				minInSubtree.right.parent = parentOfMin;
			}

		}
	}

	public Iterator findMin() {
		BSTNode temp = root;
		if(temp == null)
			return null;
		while (temp.left != null) {
			temp = temp.left;
		}
		Iterator itr = new TreeIterator(temp);
		return itr;
	}
	
	public Iterator findMin(BSTNode n) {
		BSTNode temp = n;
		if(temp == null)
			return null;
		while (temp.left != null) {
			temp = temp.left;
		}
		Iterator itr = new TreeIterator(temp);
		return itr;
	}
	
	public Iterator findMax() {
		BSTNode temp = root;
		if(temp == null)
			return null;
		while (temp.right != null) {
			temp = temp.right;
		}
		Iterator itr = new TreeIterator(temp);
		return itr;
	}
	
	public Iterator findMax(BSTNode n) {
		BSTNode temp = n;
		if(temp == null)
			return null;
		while (temp.right != null) {
			temp = temp.right;
		}
		Iterator itr = new TreeIterator(temp);
		return itr;
	}
	
	public int getSumPreOrderTraversal(BSTNode node) {
		int sum = 0;
		if(node == null) {
			return 0;
		}
		sum += node.data;
		int left = getSumPreOrderTraversal(node.left);
		int right = getSumPreOrderTraversal(node.right);
		return sum+left+right;
	}
	public int count(BSTNode node) {
		int count = 0;
		if(node == null) {
			return 0;
		}		
		count += 1;
		int left = count(node.left);
		int right = count(node.right);
		return count+left+right;
	}
	
	
	public int average(BST t) {
		int sum = getSumPreOrderTraversal(t.root);
		int length = count(t.root);
		return sum/length; 
	}
	
	public void addLeftSubTreeToMin(BST subtree) {
		//TODO
		//FILL CODE
		if(subtree.isEmpty()) { //if subtree is empty do nothing
			return;
		}
		if(this.root == null) { //if thistree is empty, subtree become thistree
			this.root = subtree.root;
			this.size = subtree.size;
			return;
		}else {
		TreeIterator itr1 = (TreeIterator) this.findMin();
		TreeIterator itr2 = (TreeIterator) subtree.findMax();
		if(itr2.currentNode.data>itr1.currentNode.data) {
			return;
		}
		itr1.currentNode.left = subtree.root;
		subtree.root.parent = itr1.currentNode;
		this.size += subtree.size;
		
		
		BTreePrinter.printNode(this.root);//test
		
	}	
}
	
	public int LCA(int low, int high) {
		BSTNode current = root;
		while(current!=null) {
		//go left
			if(current.data>low && current.data>high) {
				current = current.left;
			}
			if(current.data<low && current.data<high) {
				current = current.right;
			}
			if(current.data>low && current.data<high) {
				break;
			}
		
		}
		return current.data;
	}


	public static void main(String[] args) throws Exception {
		//Printing example. 
		//You can print how the tree looks to help with debugging.
		
		BSTNode r = new BSTNode(7);
		BST t = new BST(r, 1);
		t.insert(3);
		t.insert(11);
		t.insert(2);
		t.insert(5);
		t.insert(8);

		BTreePrinter.printNode(t.root);
		System.out.println(t.getSumPreOrderTraversal(t.root));
		System.out.println(t.count(t.root));
		System.out.println(t.average(t));
		
		BST t0 = new BST();
		BST t1 = new BST();

		t0.insert(9);
		t0.insert(7);
		t0.insert(11);
		t0.insert(8);
		t0.insert(10);
		t0.insert(12);

		t1.insert(6);
		t1.insert(1);
		t1.insert(9);
		BTreePrinter.printNode(t0.root);
		System.out.println(t0.getSumPreOrderTraversal(t0.root));
		System.out.println(t0.count(t0.root));
		System.out.println(t0.average(t0));

	}

}
