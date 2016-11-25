package jungkosta.commons.util;

import javax.inject.Inject;

public class AvlTree {
	
	public static final int SUCCESS=1;
	public static final int FAIL=0;
	public int count = 0;
	
	private Node root;
	
	public AvlTree(){
		root=null;
	}
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public int insertNode(Node pNew){
		
		Node pCur = null;
		Node pPre = null;
		
		if(root == null){
			
			root = pNew;
			
			return SUCCESS;
		}
		else{
			
			pCur = root;
			
			while(pCur != null){
				
				pPre = pCur;
				
				if(pCur.getEmail().equals(pNew.getEmail())){
					return FAIL;
				}else if(pCur.getEmail().compareTo(pNew.getEmail()) > 0){
					pCur = pCur.getAvlLeft();
				}else{
					pCur = pCur.getAvlRight();
				}
				
			}
		}
		
		if(pPre.getEmail().compareTo(pNew.getEmail()) > 0){
			pPre.setAvlLeft(pNew);
		}else{
			pPre.setAvlRight(pNew);
		}
		
		rebalanceTree(root, null);
		
		return SUCCESS;
	}
	
	public void inorderTraveersal(){
		
		count = 0;
		
		if(root == null)
			return ;
		
		Stack stack = DataStructure.getStack();
		
		stack.push(root);
		
		Node pWalker = root.getAvlLeft();
		
		while(true){
			while(pWalker != null){
				stack.push(pWalker);
				pWalker = pWalker.getAvlLeft();
			}
			
			pWalker = stack.pop();
			
			if(pWalker == null)
				break;
			
			count++;
			
			pWalker = pWalker.getAvlRight();
		}
		
	}

	public int deleteNode(String email){
		
		if(root == null)
			return FAIL;

		Node pDel = root;
		Node pPreDel = null;
		
		int result = 0;
		boolean flag = false;
		
		while(pDel != null){
			result = pDel.getEmail().compareTo(email);
			
			if(result == 0){
				if(pDel == root){
					flag = true;
				}
				
				break;
			}else if(result < 0){
				
				pPreDel = pDel;
				pDel = pDel.getAvlRight();
				
			}else{
				
				pPreDel = pDel;
				pDel = pDel.getAvlLeft();
				
			}
		}
		
		if(pDel == null)
			return FAIL;
		
		
		if(pDel.getAvlLeft() == null && pDel.getAvlRight() == null){
			
			if(pDel == root){
				
				pDel.getSession().removeAttribute("email");
				pDel.getSession().removeAttribute("password");
				pDel.getSession().removeAttribute("name");
				
				root = null;
				
				return SUCCESS;
			}
			
			if(pDel.getEmail().compareTo(pPreDel.getEmail()) > 0){
				pPreDel.setAvlRight(null);
			}else
				pPreDel.setAvlLeft(null);
			
			pDel.getSession().removeAttribute("email");
			pDel.getSession().removeAttribute("password");
			pDel.getSession().removeAttribute("name");
			
			pDel = null;
			
			rebalanceTree(root, null);
			
			return SUCCESS;
			
		}
		
		Node pCur = pDel;
		Node pPre = pCur;
		
		if(pDel.getAvlLeft() != null){
			
			pCur = pCur.getAvlLeft();
			
			while(pCur.getAvlRight() != null){
				pPre = pCur;
				pCur = pCur.getAvlRight();
			}
			
			if(pCur.getAvlLeft() != null){
				pPre.setAvlLeft(pCur.getAvlLeft());
			}
			
			pPre.setAvlRight(null);
			
		}else if(pDel.getAvlLeft() == null){
			pCur = pCur.getAvlRight();
			
			while(pCur.getAvlLeft() != null){
				pPre = pCur;
				pCur = pCur.getAvlLeft();
			}
			
			if(pCur.getAvlRight() != null){
				pPre.setAvlRight(pCur.getAvlRight());
			}
			
			pPre.setAvlLeft(null);
		}
		
		if(pDel == pPre){
			pDel.setAvlLeft(null);
			pDel.setAvlRight(null);
		}
		
		changeNode(pDel, pCur);
		
		if(flag == true)
			root = pCur;
		else
			connectNode(pCur, pPreDel);
		
		pDel.getSession().removeAttribute("email");
		pDel.getSession().removeAttribute("password");
		pDel.getSession().removeAttribute("name");
		
		pDel = null;
		
		rebalanceTree(root, null);
		
		return SUCCESS;
	}
	
	void rebalanceTree(Node pCur, Node parentNode){
		
		Node right = pCur.getAvlRight();
		Node left = pCur.getAvlLeft();
		
		if(pCur.getAvlRight() == null && pCur.getAvlLeft() == null){
			return ;
		}else if(pCur.getAvlRight() == null){
			
			rebalanceTree(left, pCur);
			
		}else if(pCur.getAvlLeft() == null){
			
			rebalanceTree(right, pCur);
			
		}else{
			
			rebalanceTree(right, pCur);
			rebalanceTree(left, pCur);
		}
		
		pCur = rebalance(pCur, parentNode);
		
	}
	
	public Node rebalance(Node pCur, Node parentNode){
		
		int hDiff = getHeightDiff(pCur);
		
		if(hDiff > 1){
			
			if(getHeightDiff(pCur.getAvlLeft()) > 0){
				pCur = rotateLL(pCur);
			}else{
				pCur = rotateLR(pCur);
			}
			
		}
		
		if(hDiff < -1){
			
			if(getHeightDiff(pCur.getAvlRight()) < 0){
				pCur = rotateRR(pCur);
			}else{
				pCur = rotateRL(pCur);
			}
			
		}
		
		if(parentNode != null){
			
			if(parentNode.getEmail().compareTo(pCur.getEmail()) > 0){
				parentNode.setAvlLeft(pCur);
			}else{
				parentNode.setAvlRight(pCur);
			}
			
		}
		
		
		return pCur;
	}
	
	public int getHeight(Node tree){
		int leftH = 0;
		int rightH = 0;
		
		if(tree == null)
			return 0;
		
		leftH = getHeight(tree.getAvlLeft());
		rightH = getHeight(tree.getAvlRight());
		
		return (leftH > rightH) ? leftH+1 : rightH+1;
	}
	
	public int getHeightDiff(Node tree){
		
		int lsh = 0;
		int rsh = 0;
		
		if(tree == null){
			return 0;
		}
		
		
		lsh = getHeight(tree.getAvlLeft());
		rsh = getHeight(tree.getAvlRight());
		
		return lsh-rsh;
	}
	
	public Node rotateLL(Node pCur) {
		Node pNode = null;
		Node cNode = null;
		
		pNode = pCur;
		cNode = pNode.getAvlLeft();
		
		pNode.setAvlLeft(cNode.getAvlRight());
		cNode.setAvlRight(pNode);
		
		return cNode;
	}

	public Node rotateLR(Node pCur) {
		
		Node pNode = null;
		Node cNode = null;
		
		pNode = pCur;
		cNode = pNode.getAvlLeft();
		
		pNode.setAvlLeft(rotateRR(cNode));
		
		return rotateLL(pNode);
	}

	public Node rotateRR(Node pCur) {
		
		Node pNode = null;
		Node cNode = null;
		
		pNode = pCur;
		cNode = pNode.getAvlRight();
		
		pNode.setAvlRight(cNode.getAvlLeft());
		cNode.setAvlLeft(pNode);
		
		return cNode;
	}

	public Node rotateRL(Node pCur) {
		
		Node pNode = null;
		Node cNode = null;
		
		pNode = pCur;
		cNode = pNode.getAvlRight();
		
		pNode.setAvlRight(rotateLL(cNode));
		
		return rotateRR(pNode);
	}
	
	public void connectNode(Node pConnect, Node Connect){
		
		if(Connect.getEmail().compareTo(pConnect.getEmail()) > 0){
			Connect.setAvlLeft(pConnect);
		}else{
			Connect.setAvlRight(pConnect);
		}
	}
	
	public void changeNode(Node pDel, Node pCur){
		pCur.setAvlLeft(pDel.getAvlLeft());
		pCur.setAvlRight(pDel.getAvlRight());
	}
	
	
}
