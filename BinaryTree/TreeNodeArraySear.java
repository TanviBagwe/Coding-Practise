package Practise.BT;

/**
 * 
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example:
Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

public TreeNode sortedArrayToBST(int[] num) {
    if (num.length == 0) {
        return null;
    }
    TreeNode head = helper(num, 0, num.length - 1);
    return head;
}

public TreeNode helper(int[] num, int low, int high) {
    if (low > high) { // Done
        return null;
    }
    int mid = (low + high) / 2;
    TreeNode node = new TreeNode(num[mid]);
    node.left = helper(num, low, mid - 1);
    node.right = helper(num, mid + 1, high);
    return node;
}


 * @author tbagwe
 *
 */
public class TreeNodeArraySear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNodeArraySear s = new TreeNodeArraySear();
		int[] nums ={-5,-4,0,1,3,5,9};
		TreeNode head =s.sortedArrayToBST(nums);
		System.out.println("head :" +head.val);
	}

	public TreeNode sortedArrayToBST(int[] num) {
	    if (num.length == 0) {
	        return null;
	    }
	    TreeNode head = helper(num, 0, num.length - 1);
	    return head;
	}

	public TreeNode helper(int[] num, int low, int high) {
	    if (low > high) { // Done
	        return null;
	    }
	    int mid = (low + high) / 2;
	    TreeNode node = new TreeNode(num[mid]);
	    System.out.println("nums :"+num[mid]);
	    node.left = helper(num, low, mid - 1);
	    System.out.println("after left  :"+low);
	    node.right = helper(num, mid + 1, high);
	    System.out.println("after right  :"+low);
	    return node;
	}

	public class TreeNode{
		int val;
		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		TreeNode left,right;
		
		public TreeNode(int val){
			this.val = val;
		}
		
	}
}
