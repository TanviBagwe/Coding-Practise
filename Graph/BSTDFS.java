package com.tanvi.practise.Graph;

import java.util.Stack;

public class BSTDFS {

	public void DFS(Node root){
		Stack<Node> s = new Stack<Node>();
		s.add(root);
		while(s.isEmpty() == false){
			Node data = s.pop();
			if(null != data.right){
				s.add(data.right);
			}
			if(null !=data.left){
				s.add(data.left);
			}
			System.out.println("Node "+data.data);
		}
	}
	public static void main(String args[]){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		BSTDFS test = new BSTDFS();
		test.DFS(root);
	}
}


class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}