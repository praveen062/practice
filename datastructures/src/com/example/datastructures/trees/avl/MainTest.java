package com.example.datastructures.trees.avl;

public class MainTest {
	/* Class node is defined as :
    class Node 
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/
	
	public static void main(String[] args) {
		int i,j =-1;
		System.out.println();
		Node root = null;
		root = insert(root,3);
		root = insert(root,2);
		root = insert(root,4);
		root = insert(root,5);
		root = insert(root,6);
		print(root);
	}
	
	static void print(Node root) {
		if(root == null) {
			return ;
		}
		System.out.print(root.val);
		System.out.print(" left " );
		print(root.left);
		System.out.print(" right " );
		print(root.right);
		System.out.println();
	}

	static Node insert(Node root,int val)
    {
        Node n = new Node();
        n.val = val;
        if(root == null){
            n.ht = height(n);
            return n;
        }else {
            if(val < root.val){
                root.left = insert(root.left,val);
            }else{
                root.right = insert(root.right,val);
            }
            
            int balance = balance(root);
            if(balance > 1){
                if(balance(root.left) >= 0) {
                    root = rightRotate(root);
                }else {
                    root.left = leftRotate(root.left);
                    root = rightRotate(root);
                }
            }else if (balance < -1){
                if(balance(root.right) <=0) {
                    root = leftRotate(root);
                }else {
                    root.right = rightRotate(root.right);
                    root = leftRotate(root);
                }
            }else {
            	root.ht = height(root);
            }
            return root;
        }
        
    	
    }


    static int height(Node root)
    {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(height(root.left),height(root.left));
    }

    static int balance(Node root) {
    	int left = -1;
		int right = -1;
		if(root.left != null)
			left = root.left.ht;
		if(root.right != null)
			right = root.right.ht;
		return (left - right);
    }

    static Node rightRotate(Node root){
        Node newNode = root.left;
        root.left = root.left.right;
        newNode.right = root;
        newNode.ht = height(newNode);
        return newNode;
    }

static Node leftRotate(Node root){
        Node newNode = root.right;
        root.right = root.right.left;
        newNode.left = root;
        newNode.ht = height(newNode);
        return newNode;
    }



}
