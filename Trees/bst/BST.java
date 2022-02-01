package bst;

import java.util.LinkedList;

public class BST {
	private Node root;
	
	public BST(int val) {
		root=new Node(val);
	
	}
	public int height() {
		return root.height;
	}
	private int getHeight(Node n) {
		return n==null?-1:n.height;
	}
	public void insert(int val) {
		root=insert(val,root);
	}
	public boolean find(int val) {
		return find(val,root);
	}
	private boolean find(int val,Node n) {
		if (n==null)return false;
		if(val==n.val)return true;
		if(val>n.val)return find(val,n.right);
		return find(val,n.left);
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
		int hleft=getHeight(n.left);
		int hright=getHeight(n.right);
		if(hleft-hright>1) {
			//System.out.println("Left imbalance at node"+n.val);
			
		}
		if(hright-hleft>1) {
			//System.out.println("Right imbalance at node"+n.val);
			n=leftRotation(n);
		}
		hleft=getHeight(n.left);
		hright=getHeight(n.right);
		n.height=(hleft>hright?hleft:hright)+1;
		
		
	return n;	
	}
	
	private Node leftRotation(Node n) {
		Node tmp=n.right;
		n.right=tmp.left;
		tmp.left=n;
		//update the heights;
		int nleftheight=n.left==null?-1:n.left.height;
		int nrightheight=n.right==null?-1:n.right.height;
		n.height=(nleftheight>nrightheight?nleftheight:nrightheight)+1;
		int tmpleftheight=tmp.left==null?-1:tmp.left.height;
		int tmprightheight=tmp.right==null?-1:tmp.right.height;
		tmp.height=(tmpleftheight>tmprightheight?tmpleftheight:tmprightheight)+1;
		
		return tmp;
	}
	public void postorder() {
		postorder(root);
	}
	public void inorder() {
		inorder(root);
	}
	private void postorder(Node n) {
		if(n==null)return;
		postorder(n.left);
		postorder(n.right);
		System.out.println(n.val);
	}
	private void inorder(Node n) {
		if(n==null)return;
		inorder(n.left);
		System.out.print(n.val+",");
		inorder(n.right);
	}
	public void bfs() {
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node t=queue.removeFirst();
			if(t.left!=null)queue.add(t.left);
			if(t.right!=null)queue.add(t.right);
			System.out.print(t.val+"("+(t.height)+")"+",");
		}
		System.out.println("");
	}
	public int max() {
		return max(root);
	}
	private int max(Node n) {
		if(n==null)return -1;
		Node max=n;
		while(max.right!=null) {
			max=max.right;
		}
		return max.val;
	}
	public void delete(int val) {
		delete(val,root);
	}
	private Node delete(int val,Node n) {
		if(n==null)return null;
		if(val>n.val) {
			n.right=delete(val,n.right);
		}
		else if(val<n.val) {
			n.left=delete(val,n.left);
		}
		else if(n.left!=null && n.right!=null) {
			n.val=max(n.left);
			n.left=delete(n.val,n.left);
		}
		else {
			n=n.left==null?n.right:n.left;
		}
		return n;
	}
	public static void main(String[] args) {
	
		BST tree=new BST(20);
	
		tree.insert(10);
		tree.insert(30);
		tree.insert(25);
		tree.insert(40);
		tree.insert(50);
		//tree.inorder();
	//System.out.println("The height of the tree is "+tree.height());	
	tree.bfs();
	
		tree.delete(30);
		tree.bfs();


	//System.out.println("found "+25+" "+tree.find(25));
	//System.out.println("max="+tree.max());
	}

}

class Node {
	public Node (int val) {
		this.val=val;
		height=0;
	}
	int val;
	Node left;
	Node right;
	int height;
}
