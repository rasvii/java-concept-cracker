package src.main.dsa.datastructure.trie;

public class TrieMain {
    public static void main(String[] args) {
        
        boolean search = false;
        Trie trie = new Trie();
        trie.insert("rasvi");
        trie.insert("paul");
        search = trie.search("abc");
        System.out.println(search);
        search = trie.startsWith("ras");
        System.out.println(search);
        search = trie.search("ras");
        System.out.println(search);
        search = trie.search("paul");
        System.out.println(search);
    }
}
