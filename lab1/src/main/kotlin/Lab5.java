import java.util.ArrayList;

public class Lab5 {
    public static void main(String[] args) {
        Lab5 lab5 = new Lab5();
        lab5.test2();
    }

    private double getR(int[][] arr){
        int n = arr.length-1;
        return sumVertices(arr) * 0.5/ n - 1.0;
    }

    private double e(int arr[][]){

        double countE = sumVertices(arr)/2;

        double n = arr.length;

        double e2 = 0;
        for(int i = 0; i < n; i++){
            int degreev =0;
            for(int j = 0; j <n;j++)
                degreev +=arr[i][j];
            e2 += degreev*degreev;
        }

        e2 -= 4 * countE * countE / n;

        return e2;

    }

    private int sumVertices(int[][] arr){

        int count = 0;
        for(int[] row : arr){
            for(int cell : row ){
                if(cell == 1){
                    count+=cell;
                }
            }
        }
        return count;
    }

    private void test2(){
//         int[][] A =
//             {{0,1,1,1,1}
//             ,{1,0,1,1,1}
//             ,{1,1,0,1,1}
//             ,{1,1,1,0,1}
//             ,{1,1,1,1,0}};
//           int[][] A =
//             {{0,1,0,0,0}
//             ,{1,0,1,0,0}
//             ,{0,1,0,1,0}
//             ,{0,0,1,0,1}
//             ,{0,0,0,1,0}};

           int[][] A =
             {{0,1,0,0,0}
             ,{1,0,1,0,0}
             ,{0,1,0,1,0}
             ,{0,0,1,0,1}
             ,{0,0,0,1,0}};

        System.out.println(getR(A));
        System.out.println(e(A));

        //   int[,] A =
        //     {{0,0,0,0,0}
        //     ,{0,0,0,0,0}
        //     ,{0,0,0,0,0}
        //     ,{0,0,0,0,0}
        //     ,{0,0,0,0,0}};

    }

    private void test(){
        ArrayList<Integer> row0 = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(0);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(0);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(0);
        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(1);
        row4.add(2);
        row4.add(3);
        ArrayList<Integer> row5 = new ArrayList<>();
        row5.add(2);
        row5.add(3);
        ArrayList<Integer> row6 = new ArrayList<>();
        row6.add(4);
        row6.add(5);
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        arrayList.add(row0);
        arrayList.add(row1);
        arrayList.add(row2);
        arrayList.add(row3);
        arrayList.add(row4);
        arrayList.add(row5);
        arrayList.add(row6);

        int[][] arr = incidenceToAdjacency(arrayList , 7);
        print(t(arr));
        System.out.println(getR(arr));
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
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }

    private int[][] incidenceToAdjacency(ArrayList<ArrayList<Integer>> incidence , int verticesCount){
        int[][] arr = new int[verticesCount][verticesCount];

        for(int i =0 ; i < incidence.size(); i++){
            for(int cell : incidence.get(i)){
                arr[i][cell] = 1;
            }
        }

        return arr;
    }

}
