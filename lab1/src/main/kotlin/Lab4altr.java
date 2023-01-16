import java.util.ArrayList;

public class Lab4altr {
    static int arr[][];
    int start = 0;

    public static void main(String[] args) {
        int[][] a = {{0, 1, 0, 0}
                ,{0, 0, 0, 1}
                ,{0, 0, 1, 0}
                ,{1, 0, 0, 0}};

        arr = a;


        print(t(arr));
        System.out.println();

        Lab4altr lab4 = new Lab4altr();
        lab4.DFS(0, 2);

        print(t(arr));
    }

    private void findPath(int start, int[][] arr){
        for (int[] row : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (row[j] != 0) {
                    if(row[j]+1<0){

                    }else {

                    }
                }
            }
        }
    }


    private void graphTraversal(){
        for(int i = 0 ; i < arr.length;i++){
            if(arr[start][i] == 1) graphTraversal(2, i);

        }
    }

        private void graphTraversal(int count, int h){
        if(h == start) return;

        for(int i = 0 ; i < arr.length;i++){
            switch (arr[h][i]) {
//                case 0:
//                    arr[h][i] = count;
//                    graphTraversal(count+1, i);
//                    break;
                case 1:
                    graphTraversal(count+1, i);
                    break;
                default:
                    if(arr[h][i] >= count){
                        arr[h][i] = count;
                        graphTraversal(count+1, i);
                    }
            }
        }
    }

    private int DFS(int h, int count){
        if(count > arr.length) return -1;

        for(int i = 0; i < arr.length; i++){
            arr[h][i] = result(h , i , count+1);
        }
        return -2;
    }

    private int result(int h , int i, int count){

            if(arr[h][i] == 0){
                arr[h][i] = DFS(i , count+1);
            }else if(arr[h][i] == 1){
                return count;
            }else if(arr[h][i] > 1) {
                return Math.max(arr[h][i] , DFS(i,count+1));
            }


        return -1;
    }

    static int[][] t(int[][] arr){
        int[][] tM = new int[arr.length][arr.length];

        for(int i = 0 ; i < arr.length;i++){
            for(int j = 0 ; j < arr.length;j++){
                tM[i][j] = arr[j][i];
            }
        }

        return tM;
    }

    static void print(int[][] arr){
        for(int i = 0; i < arr.length;i++ ){
            for (int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
