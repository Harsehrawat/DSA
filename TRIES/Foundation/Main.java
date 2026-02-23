package Foundation;

public class Main{

    public void printSearchResult( boolean res, String word){
        System.out.println(" Trie search returned "+ res+ " for word: "+ word);
    }

    public void printStartsWithResult( boolean res, String word){
        System.out.println(" Trie startsWith returned "+ res+ " for word: "+ word);
    }

    // constructor..
    public static void main( String[] args){
        Main m = new Main();
        Trie trie = new Trie();

        trie.insert("harsh");
        trie.insert("sumit");
        trie.insert("ravi");

        m.printSearchResult( trie.search("harsh"), "harsh");
        m.printSearchResult( trie.search("akash"), "akash");

        m.printStartsWithResult( trie.startsWith("ra"), "ra");
    }
}