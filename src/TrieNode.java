

import java.util.HashMap;

public class TrieNode {

	public HashMap<Character, TrieNode> edges;
	public int depth;

	public TrieNode(int depth) {
		edges = new HashMap<>();
		this.depth = depth;
	}
}