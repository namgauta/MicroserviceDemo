package com.practice;

class Node{
	int value;
	Node right,left;
	Node(int v){
		this.value=v;
		this.right=null;
		this.left=null;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
}
public class BT {

	private Node root;
	public int minTurns(Node n,int l,int r,int v) {
		if(n.value==v) {
			return 0;
		}
		if(v>n.value) {
			if(l==1) {
				return 1+minTurns(n.right, 0, 1, v);
			}
		}else if(v<n.value) {
			if(r==1)
				return 1+minTurns(n.left, 1, 0, v);
		}
		if(v>n.value)
			return minTurns(n.right, 0, 1, v);
		return minTurns(n.left, 1, 0, v);
	}
	public Node lca(Node r,int a,int b) {
		if(r==null) {
			return null;
		}
		
		if(a<r.value && b<r.value)
		    return lca(r.left,a,b);
		
		if(a>r.value && b>r.value)
			 return lca(r.right,a,b);
		 
			return r;
		
	}
	public static void main(String[] args) {
		BT bt=new BT();
		int a=10;
		int b=27;
		bt.root=new Node(20);
		bt.root.right=new Node(30);
		bt.root.right.right=new Node(35);
		bt.root.right.right.right=new Node(40);
		bt.root.right.right.left=new Node(32);
		bt.root.right.left=new Node(28);
		bt.root.right.left.left=new Node(27);
		bt.root.right.left.right=new Node(29);
		bt.root.left=new Node(10);
		bt.root.left.left=new Node(8);
		bt.root.left.left.left=new Node(7);
		bt.root.left.left.right=new Node(9);
		bt.root.left.right=new Node(13);
		bt.root.left.right.left=new Node(12);
		bt.root.left.right.right=new Node(14);
		Node n=(bt.lca(bt.root, a, b)); 
		if(n.value==a || n.value==b) {
			System.out.println(bt.minTurns(n, 0, 0,  a)+bt.minTurns(n, 0, 0, b));
		}
		else {
			System.out.println(bt.minTurns(n, 0, 0,  a)+bt.minTurns(n, 0, 0,b)+1);
		}
		
	}
}
