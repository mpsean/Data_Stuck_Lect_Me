
public class App {
	public static void main(String[] args) throws Exception {
		//Printing example. 
		//You can print how the tree looks to help with debugging.
		
		BSTNode r = new BSTNode(25);
		BST t = new BST(r, 1);
		t.insert(15);
		t.insert(50);
		t.insert(10);
		t.insert(22);
		t.insert(4);
		t.insert(12);
		t.insert(18);
		t.insert(24);
		t.insert(35);
		t.insert(31);
		t.insert(44);
		t.insert(70);
		t.insert(66);
		t.insert(90);

		BTreePrinter.printNode(t.root);
		t.inOrderTraversal(r);
		System.out.println(" ");
		t.preOrderTraversal(r);
		System.out.println(" ");
		t.postOrderTraversalIterative(r);
		System.out.println(" ");
		;
	}


}
