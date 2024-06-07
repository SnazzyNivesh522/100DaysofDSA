public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Test insertion
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("banana");
        trie.insert("band");
        trie.insert("bandana");

        // Test search
        System.out.println("Search for 'apple': " + trie.search("apple")); // true
        System.out.println("Search for 'app': " + trie.search("app")); // true
        System.out.println("Search for 'appl': " + trie.search("appl")); // false
        System.out.println("Search for 'application': " + trie.search("application")); // true
        System.out.println("Search for 'banana': " + trie.search("banana")); // true
        System.out.println("Search for 'band': " + trie.search("band")); // true
        System.out.println("Search for 'bandana': " + trie.search("bandana")); // true
        System.out.println("Search for 'bandit': " + trie.search("bandit")); // false

        // Test startsWith
        System.out.println("Starts with 'app': " + trie.startsWith("app")); // true
        System.out.println("Starts with 'ban': " + trie.startsWith("ban")); // true
        System.out.println("Starts with 'bat': " + trie.startsWith("bat")); // false
        System.out.println("Starts with 'banda': " + trie.startsWith("banda")); // true
        System.out.println("Starts with 'bandit': " + trie.startsWith("bandit")); // false
    }
}
