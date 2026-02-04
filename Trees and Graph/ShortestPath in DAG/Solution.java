// User function Template for Java
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        // src is from node( 0)
        
        // adjList w key: node, value: List< Pair> where Pair will be adjNode, Edge weight
        List< List< Pair>> adjList = new ArrayList<>();
        
        for(int i = 0; i< V; i++){
            adjList.add( new ArrayList<>());
        }
        
        // fill adjList
        // [ 0, 1, 2] -> from Node 0 to Node 1 with weight 2
        for(int[] i: edges){
            int keyNode = i[ 0];
            int adjNode = i[ 1];
            int weight = i[ 2];
            adjList.get( keyNode).add( new Pair(adjNode, weight ));
        }
        
        // now let's get the topoSort: using DFS & Stack
        int[] visited = new int[ V];
        Arrays.fill( visited, 0); 
        
        Stack< Integer> stack = new Stack<>();
        for(int i = 0; i< V; i++){
            if( visited[ i] == 0){
                dfs( i, visited, adjList, stack);
            }
        }
        
        // now pop acc to topoSort & get the weight
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // source node

        // 4️⃣ Relax edges in topo order
        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair p : adjList.get(node)) {
                    int adj = p.Node;
                    int wt = p.Weight;
                    dist[adj] = Math.min(dist[adj], dist[node] + wt);
                }
            }
        }
        
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        
        return dist;
        
    }
   
    public void dfs( int node, int[] visited, List< List< Pair>> adjList, Stack< Integer> stack){
        // mark this visited..
        visited[ node] = 1;
        
        // see outgoing nodes from this 
        List< Pair> outgoingNodes = adjList.get( node);
        for( Pair p: outgoingNodes){
            int outNode = p.Node;
            if( visited[ outNode] == 0){
                dfs( outNode, visited, adjList, stack);
            }
        }
        
        // push to stack 
        stack.push( node);
    }
}
class Pair{
    int Node;
    int Weight;
    
    public Pair(int Node, int Weight){
        this.Node = Node;
        this.Weight = Weight;
    }
}