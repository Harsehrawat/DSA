package Foundation;

class Trie{

    private class TrieBlock{
        // what it contains/know ..  TrieBlock arr[ 26], boolean flag
        private TrieBlock[] arr;  // This array does NOT store indexes.. It stores references to child nodes.
        private boolean flag;

        // constructor..
        public TrieBlock(){
            arr = new TrieBlock[ 26];
            flag = false;
        }
    }

    // what it contains/knows !?.. TrieBlocks
    TrieBlock root;
    
    // constructor..
    public Trie(){
        root = new TrieBlock();
    }
    
    public void insert( String word){ // method to insert
        // char by char
        TrieBlock current = root;
        for( char ch: word.toCharArray()){
            if( current.arr[ ch - 'a'] == null){ // if not already contained.. assign a new TrieBlock for it in memory
                current.arr[ ch - 'a'] = new TrieBlock();
            }
            current = current.arr[ ch - 'a'];
        }
        current.flag = true; // at end.. mark this last block's flag to be true

        System.out.println(" Inserted into Trie: "+ word);        
    }

    public boolean search( String word){ // method to verify word existance in current Trie
        // start from root..
        TrieBlock current = root;
        for( char ch: word.toCharArray()){
            if( current.arr[ ch - 'a'] == null) return false;
            current = current.arr[ ch - 'a'];
        }
        return ( current.flag)? true: false;
    }

    public boolean startsWith( String word){ // method to verify word existance as a prefix in current Trie
        TrieBlock current = root;
        for( char ch: word.toCharArray()){
            if( current.arr[ ch - 'a'] == null) return false;
            current = current.arr[ ch - 'a'];
        }
        return true;
    }
}