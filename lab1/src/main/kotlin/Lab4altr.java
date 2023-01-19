import java.util.ArrayList;

public class Lab4altr {
    static int arr[][];
    int start = 0;

    public static void main(String[] args) {
        int[][] a = {{0, 1, 0, 0}
                ,{0, 0, 0, 1}
                ,{0, 0, 1, 0}
                ,{1, 0, 0, 0}};

        int[][] b = {{0 , 1, 0 , 0 , 0 , 0 , 0 }
                ,{0 , 0, 0, 0, 0, 1, 0}
                ,{1 , 0, 0, 0, 1, 0, 1}
                ,{0 , 0, 0, 0, 0, 1, 0}
                ,{0, 1, 0, 1, 0, 0, 0}
                ,{1, 0, 0, 0, 0, 0, 0}
                ,{0, 1, 0, 1, 0, 0, 0}};

        int[][] c = {{0, 1, 0, 0, 0, 1, 0, 0, 0, 0}
                ,{0, 0, 0, 1, 0 ,1, 0, 0, 0, 0}
                ,{0, 0, 0, 0, 0, 0, 1, 1, 0, 0}
                ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
                ,{0, 0, 0, 1, 0, 0, 0, 0, 1, 0}
                ,{0, 0, 1, 0, 0, 0, 1, 0, 0, 1}
                ,{0, 0, 0, 1, 0, 0, 0, 1, 0, 0}
                ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                ,{0, 0, 0, 0, 1, 0, 0, 1, 0, 0}
                ,{0, 0, 0, 0, 0, 0, 0, 0, 1, 0}};

//        arr = a;
//
//
//        print(t(arr));
        System.out.println();

//        Lab4altr lab4 = new Lab4altr();
//        lab4.DFS(0, 2);
//
//        print(t(arr));

        arr = t(c);

        Lab4altr lab4 = new Lab4altr();

        for(int i =0 ; i < arr.length; i++){
            lab4.startFindPath(i);
        }




        print(arr);
        System.out.println();

//        print(lab4.result);

        System.out.println();


    }



    int result[][];
    private void initResult(){
        result = new int[arr.length][arr.length];
        for (int i = 0 ; i < arr.length;i++){
            for(int j = 0 ; j < arr.length;j++){
                result [i][j] = 0;
            }
        }
        out = new int[arr.length];

    }

    int[] out;
    ArrayList<Integer> m0;
    ArrayList<Integer> m1;
    ArrayList<Integer> m11;
    ArrayList<Integer> m2;


    private void getNextH(){
        int nextInt;
        if(m11.size() > 0){
            nextInt = m11.get(0);
            m11.remove(0);
        }else if(m1.size() > 0){
            nextInt = m1.get(0);
            m1.remove(0);
        }
    }

    private void findPath(int start, int h , int step) {
        if (h == this.start){
            return;
        }else if(out[h] == 0) {
            out[h] = step;
        }else if(out[h] > step) {
            out[h] = step;
        }else {
            return;
        }

//        for(int i = 0; i < arr.length;i++){
//            if(arr[i][h] == 1)
//                findPath(h, i , step+1);
//        }
    }

    private void startFindPath(int start){
        initResult();

        for(int i = 0; i < arr.length; i++){
            if(arr[i][start] == 1)
                findPath(start, i , 1);
        }

        for(int i : out){
            System.out.print(i + " ");
        }
    }

    private int[] result(int[] arr){
        int[] resul = new int[arr.length];


        return null;
    }
//    private void graphTraversal(){
//        for(int i = 0 ; i < arr.length;i++){
//            if(arr[start][i] == 1) graphTraversal(2, i);
//
//        }
//    }

//        private void graphTraversal(int count, int h){
//        if(h == start) return;
//
//        for(int i = 0 ; i < arr.length;i++){
//            switch (arr[h][i]) {
////                case 0:
////                    arr[h][i] = count;
////                    graphTraversal(count+1, i);
////                    break;
//                case 1:
//                    graphTraversal(count+1, i);
//                    break;
//                default:
//                    if(arr[h][i] >= count){
//                        arr[h][i] = count;
//                        graphTraversal(count+1, i);
//                    }
//            }
//        }
//    }

//    private int DFS(int h, int count){
//        if(count > arr.length) return -1;
//
//        for(int i = 0; i < arr.length; i++){
//            arr[h][i] = result(h , i , count+1);
//        }
//        return -2;
//    }



//    private int result(int h , int i, int count){
//
//            if(arr[h][i] == 0){
//                arr[h][i] = DFS(i , count+1);
//            }else if(arr[h][i] == 1){
//                return count;
//            }else if(arr[h][i] > 1) {
//                return Math.max(arr[h][i] , DFS(i,count+1));
//            }
//
//
//        return -1;
//    }

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
