package Practise.BT;

import java.util.LinkedList;
import java.util.Queue;
/**
function to give binary tree left view */
public class BinarySTreeLeftView <T extends Comparable<T>>{

	private Node root;
	
	private class Node{
		T val;
		Node left,right;
		
		public Node(T val){
			this.val = val;
		}
	}
	
	private Node doInsert(T data, Node node){
		if(null == node){
			return new Node(data);
		}
		
		int result = data.compareTo(node.val);
		if(result< 0){
			node.left = doInsert(data,node.left);
		}else if(result > 0){
			node.right = doInsert(data,node.right);
		}
		
		return node;
	}
	
	private void insert(T data){
		root = doInsert(data, root);
	}
	
	
	private void printDataLeftView(Node root){
		Queue<Node> q = new LinkedList<>();
		
		q.add(root);
		while(!q.isEmpty()){
			int noOfElementInLine = q.size();
			
			for(int i = 0;i<noOfElementInLine;i++){
				Node tmp = q.poll();
				
				if(i == 0){
					System.out.println(" co ordinates "+ tmp.val);
				}
				
				if(tmp.left !=  null){
					q.add(tmp.left);
				}
				
				if(tmp.right !=  null){
					q.add(tmp.right);
				}
				System.out.println();
			}
		}
		}
	
	public void print(){
		printDataLeftView(root);
	}
	public static void main(String[] args) {
		final BinarySTreeLeftView<Integer> binaryTree = new BinarySTreeLeftView<>();
		binaryTree.insert(50);
		binaryTree.insert(30);
		binaryTree.insert(10);
		binaryTree.insert(20);
		binaryTree.insert(40);
		binaryTree.insert(70);
		binaryTree.insert(60);
		binaryTree.insert(80);
		binaryTree.insert(90);

		binaryTree.print();
	}

}
