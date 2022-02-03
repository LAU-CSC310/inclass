package bst2;

import java.util.LinkedList;


public class BST2 {
private Node root;
	public static void main(String[] args) {
		BST2 tree=new BST2(20);
		
		tree.insert(10);
		tree.insert(30);
		tree.insert(40);
		tree.insert(50);
		tree.insert(60);
		
		//tree.delete(30);
	tree.bfs();

	}
	public BST2(int val) {
		root=new Node(val,null);
	}

	public void insert(int val ) {
		Node tmp=root,p=root;
		
		while(tmp!=null) {
			p=tmp;
			if(val>tmp.val) 
				tmp=tmp.right;
			
			else if (val<tmp.val) 
				tmp=tmp.left;
			
			else return;
		}
		tmp=new Node(val,p);
		if(val>p.val)p.right=tmp;
		else p.left=tmp;
		updateHeight(p);
		
	}
	private void leftRotation(Node n) {
		 if(n==root){
		        root=n.right;
		    }
		   
		  else{
		        if(n.val<n.parent.val)
		            n.parent.left=n.right;
		        else n.parent.right=n.right;
		        
		    }
		    
		    n.right.parent=n.parent;
		    Node tmp=n.right.left;//x
		    n.right.left=n;
		    n.parent=n.right;
		    n.right=tmp;
		    int lh=n.left==null?-1:n.left.height;
		    int rh=n.right==null?-1:n.right.height;
		    n.height=lh>rh?1+lh:1+rh;
		    if(tmp!=null) tmp.parent=n;
		   
	}
	private void updateHeight(Node t) {
		if(t==null)return;
		int lh,rh;
		lh=t.left==null?-1:t.left.height;
		rh=t.right==null?-1:t.right.height;
		if(rh-lh>1){//deals with right-right imbalance ONLY
			leftRotation(t);
		}
		else {
		t.height=lh>rh?lh+1:rh+1;
		}
		updateHeight(t.parent);
	}
	public void delete(int val) {
		delete(val,root);
	}
	private void delete(int val,Node n) {
		if(n==null)return ;
		Node p=n,tmp=n;
		while(tmp!=null &&tmp.val!=val) {
			p=tmp;
			if(val>tmp.val)
				tmp=tmp.right;
			else 
				tmp=tmp.left;
		}
		if (tmp==null)return;
		if(tmp.left!=null && tmp.right!=null) {
			tmp.val=max(tmp.left);
			delete(tmp.val,tmp.left);
		}
		else {
			tmp=n.left==null?n.right:n.left;
			if(n.val>n.parent.val)//right child
			   n.parent.right=tmp;
			else n.parent.left=tmp;
		}
		
	}

	private int max(Node n) {
		if(n==null)return -1;
		Node max=n;
		while(max.right!=null) {
			max=max.right;
		}
		return max.val;
	}
	
	private void balance(Node n) {
		//deals with right-right imbalance ONLY
		int lh=n.left==null?-1:n.left.height;
		int rh=n.right==null?-1:n.right.height;
		if (rh-lh>1) // assume it is a right-right imbalance
			leftRotation(n);
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

}

class Node {
	public Node (int val,Node p) {
		this.val=val;
		parent=p;
		height=0;
	}
	
	int val;
	Node left;
	Node right;
	Node parent;
	int height;
}