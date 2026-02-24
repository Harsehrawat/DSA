package AdvanceOperations;

// apple, apple, app,

class Trie{
    // what does it know/ contains..
    private TrieBlock root;

    public class TrieBlock { // private non-static inner class for Trie
        // what does it know/ contains..
        private TrieBlock[] arr;
        private int endWord;
        private int countPrefix;

        // constructor..
        public TrieBlock(){
            arr = new TrieBlock[ 26];
            endWord = 0;
            countPrefix = 0;
        }
        
    }

    // constructor..
    public Trie(){
        root = new TrieBlock();
    }

    // operations.. insert, countWordsEqualTo(), countWordsStartingWith()

    public void insert( String word){
        // traverse char by char over word..
        TrieBlock current = root;
        for( char ch: word.toCharArray()){
            // create if null
            if( current.arr[ ch - 'a'] == null){
                current.arr[ ch - 'a'] = new TrieBlock(); // this will set for arr[ ch] & with endWord = 0, cP = 0
            }
            current = current.arr[ ch - 'a'];
            current.countPrefix ++; // increment cP by 1 for this node
        }
        // for end- char..increment eW by 1
        current.endWord ++;
    }

    public int countWordsEqualTo( String word){
        // return the endWord value if word traverses an entire Trie
        // return 0 if Trie[ ch] doens't exist for word while traversal
        
        TrieBlock current = root;
        for( char ch: word.toCharArray()){
            if( current.arr[ ch - 'a'] == null) return 0;
            current = current.arr[ ch - 'a'];
        }
        return current.endWord;
    }

    public int countWordsStartingWith( String word){
        // while traversing arr[ char].. if it's null: return 0
        // at end.. return countPrefix

        TrieBlock current = root;
        for( char ch: word.toCharArray()){
            if( current.arr[ ch - 'a'] == null) return 0;
            current = current.arr[ ch - 'a'];
        }
        return current.countPrefix;
    }

}