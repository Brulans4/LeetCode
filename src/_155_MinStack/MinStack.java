package _155_MinStack;

public class MinStack {

	int min;
	Node top;

	public MinStack() {
		min = Integer.MAX_VALUE;
		top = null;
	}

	public void push(int val) {
		Node newNode = new Node(val);

		if (top == null) {
			top = newNode;
		} else {
			Node prevNode = top;
			top = newNode;
			top.nextNode = prevNode;
		}

		if (val < min) {
			min = val;
		}
	}

	public void pop() {
		if (top != null) {
			Node oldNode = top;
			top = oldNode.nextNode;

			if (oldNode.value == min) {
				min = newMin(top);
			}
		}
	}

	private int newMin(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		return Math.min(node.value, newMin(node.nextNode));
	}

	public int top() {
		if (top == null) {
			throw new NullPointerException();
		}
		return top.value;
	}

	public int getMin() {
		return min;
	}

	private class Node {
		int value;
		Node nextNode;

		private Node(int val) {
			value = val;
			nextNode = null;
		}
	}
}
