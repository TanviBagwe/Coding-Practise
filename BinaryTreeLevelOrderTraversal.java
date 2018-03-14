package LinkedIn;

import java.util.ArrayList;

/**
 * 
 * @author tbagwe
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 *
 */
public class BinaryTreeLevelOrderTraversal {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class TreeNode {
	    int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        List<Integer> numberList = new ArrayList<Integer>();
	        
	        if(null == root){
	            return result;
	        }
	        LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
	        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
	        curr.offer(root);
	        while(!curr.isEmpty()){
	            TreeNode head = curr.pop();
	            if(null != head.left){
	                next.add(head.left);
	            }
	            if(null != head.right){
	                next.add(head.right);
	            }
	            
	            numberList.add(head.val);
	            
	            if(curr.isEmpty()){
	                curr = next;
	                next = new LinkedList<TreeNode>();
	                result.add(numberList);
	                numberList = new ArrayList<Integer>();
	            }
	            
	        }
			return result;
	    }
	}
}


