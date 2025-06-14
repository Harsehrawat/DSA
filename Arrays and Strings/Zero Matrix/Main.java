public class Main {

    public static void main(String[] args) {
        int[][] arr = {
            {1, 0, 3},
            {4, 5, 6},
            {7, 8, 0}
        };
        
        
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        for(int i  =0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j] == 0 && !visited[i][j]){
                    dfs(arr,i,j,visited);
                }
            }
        }

        for(int[] i : arr){
            System.out.println("");
            System.out.print("[");
            for(int j : i){
                System.out.print(j + ",");
            }
            System.out.println("]");
        }

    }
    static void dfs(int[][] arr,int i,int j,boolean[][] visited){
        // expand in all 4 directions 
        // up
        int iUp = i;
        while(iUp >= 0){
            arr[iUp][j] = 0;
            visited[iUp][j] = true;
            iUp--;
        };

        int iDown = i;
        while(iDown < arr.length){
            arr[iDown][j] = 0;
            visited[iDown][j] = true;
            iDown++;
        }

        int jLeft = j;
        while (jLeft >= 0) {
            arr[i][jLeft] = 0;
            visited[i][jLeft] = true;
            jLeft--;
        }

        int jRight = j;
        while(jRight < arr[0].length){
            arr[i][jRight] = 0;
            visited[i][jRight] = true;
            jRight++;
        }
    }
}