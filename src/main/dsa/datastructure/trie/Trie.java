package src.main.dsa.datastructure.trie;

public class Trie {
    
    TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    private static class TrieNode {
        
        TrieNode[] children;
        boolean isEndOfWord;
        
        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    
    public void insert(String word) {
        TrieNode curr = root;

        for(char letter : word.toLowerCase().toCharArray()) {
            int c = letter - 'a';
            if(curr.children[c] == null) {
                curr.children[c] = new TrieNode();
            }
            
            curr = curr.children[c];
        }
        
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        
        for(char letter : word.toLowerCase().toCharArray()) {
            int c = letter - 'a';
            
            if(curr.children[c] == null) {
                return false;
            }
            
            curr = curr.children[c];
        }
        
        return curr.isEndOfWord;
    }
    
    public boolean startsWith(String word) {
        TrieNode curr = root;
        
        for(char letter : word.toLowerCase().toCharArray()) {
            int c = letter - 'a';
            
            if(curr.children[c] == null) return false;
            
            curr = curr.children[c];
        }
        
        return true;
    }
}
