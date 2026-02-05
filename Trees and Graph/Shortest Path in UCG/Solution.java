class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        // get the adjList w key: node, val: weight
        //  we will use a PQ rather than a normal Q..
        // because:
//         If you use a normal queue:
// Start at A
// Discover B (distance 10) → enqueue
// Discover C (distance 1) → enqueue
// Process B before C ❌
// You lock in a worse path before seeing the better one.

        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i< V; i++){
            adjList.add( new ArrayList<>());
        }
        
        // 0: {1, 1}, {2, 6}
        for(int[] e: edges){
            int keyNode = e[ 0];
            int adjNode = e[ 1];
            int weight = e[ 2];
            adjList.get( keyNode).add( new Pair( adjNode, weight));
            adjList.get( adjNode).add( new Pair( keyNode, weight)); // since it's undirected.. both will store each other's node
        }
        
        // dist[]
        int[] dist = new int[ V];
        Arrays.fill( dist, Integer.MAX_VALUE);
        
        // set source dist to itself as zero
        dist[ src] = 0;
        
        // pq should be min-heap based on dist
        PriorityQueue< int[]> pq = new PriorityQueue<>( (a, b) -> a[ 1] - b[ 1]); 
        pq.offer( new int[]{src, 0} ); 
        
        while( !pq.isEmpty()){
            int[] curr = pq.poll();
            int currNode = curr[ 0];
            int currDist = curr[ 1];
            if (currDist > dist[currNode]) continue; // a node can be pushed into pq multiple times..
            

            
            // get the adjNodes of currNode
            List< Pair> adjNodes = adjList.get( currNode);
            for(int i = 0; i< adjNodes.size(); i++){
                Pair p = adjNodes.get( i);
                int nextNode = p.adjNode;
                int nextDist = p.weight;
                
                // add to dist[ nextNode] if currDist + nextDist < dist[ nextNode]
                if( currDist + nextDist < dist[ nextNode]){
                    dist[ nextNode] = currDist + nextDist;
                    pq.offer( new int[] { nextNode, dist[ nextNode]});
                }
            }
        }
        
        return dist;
        
    }
}
class Pair{
    int adjNode;
    int weight;
    
    public Pair( int adjNode, int weight){
        this.adjNode = adjNode;
        this.weight = weight;
    }
}