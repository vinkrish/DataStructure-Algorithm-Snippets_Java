package commontests;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BinaryDigitNumber {

	public static void main(String[] args) {
		int n = 3;
		System.out.println("Smallest multiple using only 0s and 1s as digits: " + multiple(n));
	}

	public static String multiple(int num) {
		if (num < 0) {
			throw new IllegalArgumentException("Invalid num");
		}

		String result = "0";

		if (num > 0) {
			// An array to mark all the visited nodes
			boolean[] isVisited = new boolean[num];
			Arrays.fill(isVisited, false);

			// The queue used by BFS
			Queue<Node> queue = new ArrayDeque<>();

			// Add the first number 1 and mark it visited
			queue.add(new Node(true, 1 % num, null));
			isVisited[1 % num] = true;

			// The final destination node which represents the answer
			Node destNode = null;

			while (!queue.isEmpty()) {
				// Get the next node from the queue
				Node currNode = queue.remove();

				if (currNode.val == 0) {
					// We have reached a valid multiple of num
					destNode = currNode;
					break;
				} else {
					// Visit the next 2 neighbors
					// Append 0 - (currNode.val * 10)
					// Append 1 - (currNode.val * 10) + 1

					// Append a '0'
					int val1 = (currNode.val * 10) % num;
					if (!isVisited[val1]) {
						queue.add(new Node(false, val1, currNode));
						isVisited[val1] = true;
					}

					// Append a '1'
					int val2 = (val1 + 1) % num;
					if (!isVisited[val2]) {
						queue.add(new Node(true, val2, currNode));
						isVisited[val2] = true;
					}
				}
			}

			// Trace the path from destination to source
			if (destNode == null) {
				throw new IllegalStateException("Result should not be null");
			} else {
				StringBuilder reverseResultBuilder = new StringBuilder();
				Node currNode = destNode;
				while (currNode != null) {
					reverseResultBuilder.append(currNode.isDigitOne ? '1' : '0');
					currNode = currNode.parent;
				}
				result = reverseResultBuilder.reverse().toString();
			}
		}

		return result;
	}

	// Node represents every digit being appended in the decision tree
	private static class Node {
		// True if '1', false otherwise (i.e. '0')
		public final boolean isDigitOne;
		// The number represented in the tree modulo the input number
		public final int val;
		// The parent node in the tree
		public final Node parent;

		public Node(boolean isDigitOne, int val, Node parent) {
			this.isDigitOne = isDigitOne;
			this.val = val;
			this.parent = parent;
		}
	}

}
