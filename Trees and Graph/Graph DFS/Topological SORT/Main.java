class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        // [ a, b] : a-> b edge direction
        // first get the adjList
        List< List< Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i< V; i++){
            adjList.add( new ArrayList<>());
        }
        
        for(int[] i: edges){
            adjList.get( i[0]).add( i[1]);
        }
        
        // my adjList will look like:
        // 0 -> nullList, 
        // 1-> 0
        // 2-> 0
        //3-> 0
        
        int[] visited = new int[ V];
        Arrays.fill( visited, 0);
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< visited.length; i++){
            if( visited[ i] == 0){
                dfs( i, edges, visited, stack, adjList);
            }
        }
        
        ArrayList< Integer> res = new ArrayList<>();
        while( !stack.isEmpty()){
            res.add( stack.pop());
        }
        
        return res;
        
    }
    
    public void dfs(int node, int[][] edges, int[] visited, Stack< Integer> stack, List<List< Integer>> adjList){
        // mark current node visited
        visited[ node] = 1;
        
        // get it's adjList values
        List<Integer> connectedNodes = adjList.get( node);
        for(int i = 0; i< connectedNodes.size(); i++){
            int adjNode = connectedNodes.get( i);
            if( visited[ adjNode] == 0){ // if it's unvisited.. start dfs for this too
                dfs( adjNode, edges, visited, stack, adjList);
            }
        }
        
        // push to stack
        stack.push( node);
    }
}