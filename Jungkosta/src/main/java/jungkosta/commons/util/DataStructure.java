package jungkosta.commons.util;

import javax.inject.Inject;

public class DataStructure {
	
	private static Stack stack = new Stack();
	
	private static AvlTree tree = new AvlTree();
	
	public static Stack getStack() {
		return stack;
	}

	public static void setStack(Stack stack) {
		DataStructure.stack = stack;
	}

	public static AvlTree getTree() {
		return tree;
	}

	public static void setTree(AvlTree tree) {
		DataStructure.tree = tree;
	}
	
	
}
