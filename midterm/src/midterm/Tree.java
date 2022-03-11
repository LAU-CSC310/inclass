package midterm;
/* for convenience we construct a binary search
 * tree but leaves and sumLeaves work
 * for any binary tree
 */


public class Tree {

private Node root;
	
	public Tree(int val) {
		root=new Node(val);
	
	}
	
	public void insert(int val) {
		root=insert(val,root);
	}
	
	private Node insert(int val,Node n) {
		if(n==null) 
			n=new Node(val);
		else if (val<n.val) {
			n.left=insert(val,n.left);
		}
		else if (val>n.val) {
			n.right=insert(val,n.right);
		}
		else ;// do nothing
			
		
		return n;	
	}
	public int leaves() {
		return leaves(root);
	}
	private int leaves(Node t) {
		if (t.left==null && t.right==null)
			return 1;

		int left=t.left==null?0:leaves(t.left);
		int right=t.right==null?0:leaves(t.right);
		return left+right;
	}
	public int sumLeaves() {
		return sumLeaves(root);
	}
	private int sumLeaves(Node t) {
		if (t.left==null && t.right==null)
			return t.val;

		int left=t.left==null?0:sumLeaves(t.left);
		int right=t.right==null?0:sumLeaves(t.right);
		return left+right;	
	}
	public void postOrder() {
		postOrder(root);
	}
	private void postOrder(Node t) {
		if(t==null)return;
		postOrder(t.left);
		postOrder(t.right);
		System.out.println(t.val);
	}
	
	public static void main(String[] args) {
	
		Tree tree=new Tree(20);
	
		tree.insert(10);
		tree.insert(5);
		tree.insert(30);
		tree.insert(25);
		tree.insert(40);
		tree.insert(50);
		tree.insert(12);
		System.out.println(tree.sumLeaves());
		//tree.postOrder();
	}

}

class Node {
	public Node (int val) {
		this.val=val;
	}
	int val;
	Node left;
	Node right;
}

