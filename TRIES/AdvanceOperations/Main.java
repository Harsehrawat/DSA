package AdvanceOperations;


public class Main{

    public void printcountWordsEqualTo( int val, String word){
        System.out.println(" Trie countWordsEqualTo() returned: "+ val+ " for word: "+ word);
    }

    public void printWordsStartingWith( int val, String word){
        System.out.println(" Trie countWordsStartingWith() returned: "+ val+ " for word: "+ word);
    }

    // constructor..
    public static void main( String[] args){
        Main m = new Main();
        Trie trie = new Trie();

        trie.insert("harsh");
        trie.insert("sumit");
        trie.insert("ravi");

        m.printcountWordsEqualTo( trie.countWordsEqualTo("harsh"), "harsh");
        m.printWordsStartingWith( trie.countWordsStartingWith("akash"), "akash");

        m.printWordsStartingWith( trie.countWordsStartingWith("ra"), "ra");
    }
}
