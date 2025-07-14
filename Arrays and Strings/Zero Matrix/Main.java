public class Main {

    public static void main(String[] args) {
        int[][] arr = {
            {1, 3, 0},
            {4, 5, 6},
            {7, 8, 0}
        };
        
        
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        for(int i  =0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j] == 0 && !visited[i][j]){
                    spreadZero(i, j, arr, visited);
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
    static void spreadZero(int i, int j, int[][] arr, boolean[][] visited) {
        int iUp = i, iDown = i;
        int jLeft = j, jRight = j;
    
        System.out.println("SpreadZero called for i: "+i+", j:"+j);
        while (iUp >= 0) {
            if(arr[iUp][j] != 0){
                arr[iUp][j] = 0;
                visited[iUp][j] = true;
            }
            iUp--;
        }
        System.out.println("iUp out of loop at iUp: "+iUp);
        while (iDown < arr.length) {
            if(arr[iDown][j] != 0){
                arr[iDown][j] = 0;
                visited[iDown][j] = true;
            }
            iDown++;
        }
        System.out.println("iDown out of loop at iDown: "+iDown);
    
        while (jLeft >= 0) {
            if (arr[i][jLeft] != 0 ){
                arr[i][jLeft] = 0;
                visited[i][jLeft] = true;
            }
            jLeft--;
        }
        System.out.println("jLeft out of loop at jLeft: "+jLeft);

        while (jRight < arr[0].length) {
            if (arr[i][jRight] == 0 ) {
                arr[i][jRight] = 0;
                visited[i][jRight] = true;
            }
            jRight++;
        }
        System.out.println("jRight out of loop at jRight: "+jRight);
    }
}