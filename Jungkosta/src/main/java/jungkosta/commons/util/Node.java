package jungkosta.commons.util;

import javax.servlet.http.HttpSession;

public class Node {
	
	private Node avlLeft;
	private Node avlRight;
	private Node stackNext;
	private Node stackPrev;
	
	private HttpSession session;
	private String email;
	
	public Node getAvlLeft() {
		return avlLeft;
	}
	public void setAvlLeft(Node avlLeft) {
		this.avlLeft = avlLeft;
	}
	public Node getAvlRight() {
		return avlRight;
	}
	public void setAvlRight(Node avlRight) {
		this.avlRight = avlRight;
	}
	public Node getStackNext() {
		return stackNext;
	}
	public void setStackNext(Node stackNext) {
		this.stackNext = stackNext;
	}
	public Node getStackPrev() {
		return stackPrev;
	}
	public void setStackPrev(Node stackPrev) {
		this.stackPrev = stackPrev;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
