class Solution {
    // public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    //     // maxNodes 'k' nodes allowed b/w src & dst

    //     List< List< Pair>> adjList = new ArrayList<>();

    //     for(int i = 0; i< n; i++){
    //         adjList.add( new ArrayList<>());
    //     }

    //     for(int[] flight: flights){
    //         adjList.get( flight[ 0]).add( new Pair( flight[ 1], flight[ 2]));
    //     }

    //     // since i've to filter based on least fairPrice .. i'd search w PQ w minHeap on fairPrice
        
    //     // my pq strucutre: { currCity, ongoingFairFromSrc} 
    //     PriorityQueue< int[]> pq = new PriorityQueue<>( (a, b) -> a[ 1] - b[ 1]);
    //     int[] fairPrice = new int[ n];
    //     Arrays.fill( fairPrice, Integer.MAX_VALUE);

    //     int allowedCities = k + 2;
        
    //     fairPrice[ src] = 0;
    //     pq.offer( new int[]{ src, fairPrice[ src]});

    //     while( !pq.isEmpty()){
    //         // extract the currCity
    //         int[] currLoc = pq.poll();
    //         int currCity = currLoc[ 0];
    //         int currFair = currLoc[ 1];
    //         allowedCities --; // one city visited

    //         if( allowedCities == 0) continue; // if nomore cities can be visited.. don't complete the process for this currCity

    //         // explore the connecting routes from currCity
    //         List< Pair> connectingRoutes = adjList.get( currCity);
    //         for(int i = 0; i< connectingRoutes.size(); i++){
    //             Pair p = connectingRoutes.get( i);
    //             int nextCity = p.adjCity;
    //             int nextFair = p.fair;

    //             // so from currCity to nextCity.. my collective Fair would be currFair + nextFair
    //             int totalFair = nextFair + currFair;
    //             if( totalFair < fairPrice[ nextCity]){
    //                 // update lesser fair & add to pq
    //                 fairPrice[ nextCity] = totalFair;
    //                 pq.offer( new int[]{ nextCity, fairPrice[ nextCity]});
    //             }
    //             // if i've already a path to reach nextCity .. w lesser current total fair.. don't add it to pq

    //         }
    //     }

    //     return ( fairPrice[ dst] == Integer.MAX_VALUE) ? -1: fairPrice[ dst];
    // }

    public int findCheapestPrice( int n, int[][] flights, int src, int dst, int k){
        // earlier i was assigning allowedCities as global
        // But the number of stops is a per-path constraint, not global

        // So.. each path should store it's own stops count in PQ 
        // & no requirement of fairPrice[] for same reason

        List< List< Pair>> adjList = new ArrayList<>();

        for(int i = 0; i< n; i++){
            adjList.add( new ArrayList<>());
        }

        for(int[] flight: flights){
            adjList.get( flight[ 0]).add( new Pair( flight[ 1], flight[ 2]));
        }


        int[][] best = new int[n][k + 2];
        for (int[] row : best){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // this time.. pq struct will look like: { city, fairPrice, stops}
        PriorityQueue< int[]> pq = new PriorityQueue<>( (a, b) -> a[ 1] - b[ 1]);
        pq.offer( new int[]{ src, 0, 0});

        while( !pq.isEmpty()){
            // extract the currCity
            int[] currLoc = pq.poll();
            int currCity = currLoc[ 0];
            int currFair = currLoc[ 1];
            int stops = currLoc[ 2];

            if( currCity == dst) return currFair;

            if( stops > k) continue; // skip the process for this route as it's not possible

            List< Pair> connectingRoutes = adjList.get( currCity);
            for(int i = 0; i< connectingRoutes.size(); i++){
                Pair p = connectingRoutes.get( i);
                int nextCity = p.adjCity;
                int nextFair = p.fair;

                // only add if nextFair+currFair < best[ nextCity][ stops]
                if( nextFair + currFair < best[ nextCity][ stops + 1]){
                    best[nextCity][stops + 1] = currFair + nextFair;
                    pq.offer( new int[]{ nextCity, currFair + nextFair, stops + 1});
                }

            }

        }
        return -1;
    }  
}

class Pair{
    int adjCity;
    int fair;

    public Pair( int adjCity, int fair){
        this.adjCity = adjCity;
        this.fair = fair;
    }
}