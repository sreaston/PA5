

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TestCorrectness {

	static final String DIRECTED_GRAPH1_PATH = "directed1.txt";
	static final String DIRECTED_GRAPH2_PATH = "directed2.txt";
	static final String UNDIRECTED_GRAPH1_PATH = "undirected1.txt";
	static final String UNDIRECTED_GRAPH2_PATH = "undirected2.txt";
	static final String TOPO1_PATH = "topo1.txt";
	static final String TOPO2_PATH = "topo2.txt";
	static final String TOPO3_PATH = "topo3.txt";

	public static void testSetAndMap() {
		System.out.println("*** Using Set & Map ***\n");
		char[] str = { 'a', 'b', 'r', 'a', 'c', 'a', 'd', 'a', 'b', 'r', 'a', '$' };
		System.out.print("Sorted order of " + Arrays.toString(str) + " is ");
		SetsAndMaps.bstSort(str, str.length);
		System.out.println(Arrays.toString(str));
		testIntersection(false);
	}

	private static BinaryTreeNode binaryTree() {
		BinaryTreeNode node_22 = new BinaryTreeNode(22);
		BinaryTreeNode node_8 = new BinaryTreeNode(8);
		BinaryTreeNode node_16 = new BinaryTreeNode(16);
		BinaryTreeNode node_14 = new BinaryTreeNode(14);
		BinaryTreeNode node_20 = new BinaryTreeNode(20);
		BinaryTreeNode node_24 = new BinaryTreeNode(24);
		BinaryTreeNode node_8_2 = new BinaryTreeNode(8);
		BinaryTreeNode node_0 = new BinaryTreeNode(0);
		BinaryTreeNode node_6 = new BinaryTreeNode(6);
		BinaryTreeNode node_11 = new BinaryTreeNode(11);
		BinaryTreeNode node_20_2 = new BinaryTreeNode(20);
		BinaryTreeNode node_5 = new BinaryTreeNode(5);
		BinaryTreeNode node_70 = new BinaryTreeNode(70);

		node_22.left = node_8;
		node_22.right = node_16;
		node_8.left = node_14;
		node_8.right = node_20;
		node_16.left = node_24;
		node_16.right = node_8_2;
		node_14.left = node_0;
		node_14.right = node_6;
		node_20.right = node_11;
		node_8_2.right = node_20_2;
		node_6.left = node_5;
		node_6.right = node_70;

		return node_22;
	}

	private static void testTreeTraversal() {
		System.out.println("*** Test Tree Traversals ***\n");
		System.out.print("Pre-order Traversal: ");
		TreeTraversals.preOrder(binaryTree());
		System.out.print("\nIn-order Traversal: ");
		TreeTraversals.inOrder(binaryTree());
		System.out.print("\nPost-order Traversal: ");
		TreeTraversals.postOrder(binaryTree());
		System.out.println();
	}

	private static void testBFS() throws Exception {
		String filePaths[] = {DIRECTED_GRAPH1_PATH, DIRECTED_GRAPH2_PATH, UNDIRECTED_GRAPH1_PATH, UNDIRECTED_GRAPH2_PATH};
		for (int i = 0; i < filePaths.length; i++) {
			if (i < 2)
				System.out.printf("*** Test BFS on Directed Graph %d ***\n\n", i + 1);
			else System.out.printf("*** Test BFS on Undirected Graph %d ***\n\n", i - 1);
			GraphAlgorithms bfs = new GraphAlgorithms(filePaths[i]);
			for (int j = 0; j < bfs.adjList.size(); j++) {
				ArrayList<Integer> level = bfs.bfs(j);
				System.out.println("Level array (from v" + j + "):   "
						+ level.toString().replaceAll("" + Integer.MAX_VALUE, "infty"));
			}
			System.out.println();
		}
	}

	private static void testTopologicalSorting() throws Exception {
		String filePaths[] = {TOPO1_PATH, TOPO2_PATH, TOPO3_PATH};
		for (int i = 0; i < filePaths.length; i++) {
			System.out.printf("*** Test Topo %d ***\n\n", i + 1);
			GraphAlgorithms mutant = new GraphAlgorithms(filePaths[i]);
			ArrayList<Integer> topoOrder = mutant.topoOrder();
			System.out.println("Topological order: " + topoOrder);
			System.out.println();
		}
	}

	private static void testTrie() {
		System.out.println("*** Test Trie (Spell Checker) ***\n");
		Trie trie = new Trie();
		String dictionary[] = { "abc$", "abcd$", "bce$", "abx$", "acfe$", "bfr$", "de$" };
		for (int i = 0; i < 7; i++)
			trie.insert(dictionary[i]);

		String document[] = { "abc", "def", "abcd", "bce", "abx", "acfe", "bfr", "xyz", "de", "tyu", "ab" };
		int numWordsInDoc = 11;
		boolean spellCheck[] = new boolean[numWordsInDoc];

		for (int i = 0; i < numWordsInDoc; i++) {
			spellCheck[i] = trie.search(document[i] + "$");
		}

		System.out.println("Dictionary: " + Arrays.toString(dictionary));
		System.out.println("Document:   " + Arrays.toString(document));
		System.out.print("\nIncorrect spellings: ");
		for (int i = 0; i < numWordsInDoc; i++) {
			if (!spellCheck[i])
				System.out.print(document[i] + " ");
		}
	}

	public static void testIntersection(boolean useTrie) {
		ArrayList<String> arg1 = new ArrayList<>();
		arg1.add("xyz");
		arg1.add("abc");
		arg1.add("def");
		arg1.add("efg");
		arg1.add("ghi");
		arg1.add("xyz");
		arg1.add("abc");
		arg1.add("abc");
		arg1.add("ghixx");

		ArrayList<String> arg2 = new ArrayList<>();
		arg2.add("ghi");
		arg2.add("abc");
		arg2.add("def");
		arg2.add("ghix");
		arg2.add("eff");
		arg2.add("xyz");
		arg2.add("xyw");
		arg2.add("abcxyz");

		System.out.println("\n* Set Intersection *");
		System.out.println("\nSet 1: " + arg1);
		System.out.println("Set 2: " + arg2);
		System.out.println("");

		if (useTrie) {
			TreeSet<String> answer = Trie.intersection(arg1, arg2);
			System.out.println("Intersection is: " + answer);
		}
		else {
			ArrayList<String> answer = SetsAndMaps.intersection(arg1, arg2);
			System.out.println("Intersection is: " + answer);
		}
	}

	public static void main(String[] args) throws Exception {
		testTreeTraversal();
		System.out.println();
		testSetAndMap();
		System.out.println();
		testTopologicalSorting();
		testBFS();
		testTrie();
		System.out.println();
		testIntersection(true);
	}
}
