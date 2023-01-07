import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Lab3 {
    public static void main(String[] args) {
//        int[][] a = {{1 , 0 , 0 }
//                ,{0 , 0 , 1}
//                ,{1 , 1 , 0}};

//        int[][] a = {{1 , 1 , 0 }
//                ,{0 , 0 , 0}
//                ,{0 , 0 , 1}};

        int[][] a = {{2, 2, 2, 2, 2}
                    ,{2, 1, 0, 0, 2}
                    ,{2, 0, 0, 1, 2}
                    ,{2, 1, 1, 0, 2}
                    ,{2, 2, 2, 2, 2}};

        int[][] d = {{0,1,0,0}
                    ,{1,0,0,0}
                    ,{0,0,0,0}
                    ,{0,1,1,0}};

        int test1[][] = {{1, 1, 1, 1, 1, 1}
                        ,{2, 2, 2, 2, 2, 2}
                        ,{3, 3, 3, 3, 3, 3}
                        ,{4, 4, 4, 4, 4, 4}
                        ,{5, 5, 5, 5, 5, 5}
                        ,{6, 6, 6, 6, 6, 6}};

        int[][] b = {{0 , 1, 0 , 0 , 0 , 0 , 0 }
                ,{0 , 0, 0, 0, 0, 1, 0}
                ,{1 , 0, 0, 0, 1, 0, 1}
                ,{0 , 0, 0, 0, 0, 1, 0}
                ,{0, 1, 0, 1, 0, 0, 0}
                ,{0, 0, 0, 0, 0, 0, 0}
                ,{0, 1, 0, 1, 0, 0, 0}};

        int[][] c = {{0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                    {0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        int[][] c1 = {{0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0,  0},
                {0, 1, 0, 0, 0, 0, 0, 0,  1},
                {0, 0, 1, 0, 1, 0, 0, 0,  1},
                {0, 0, 0, 0, 0, 0, 0, 0,  0},
                {0, 0, 0, 0, 5, 0, 0, 0,  0},
                {0, 0, 0, 0, 0, 4, 0, 1,  0},
                {2, 0, 0, 0, 0, 0, 0, 0,  0},
                {3, 0, 0, 0, 0, 0, 0, 0,  0}};

        int[][] test = {{0,0,0,0,0,0},
                        {0,1,1,1,1,1},
                        {0,1,2,2,2,2},
                        {0,1,2,3,3,3},
                        {0,1,2,3,4,4},
                        {0,1,2,3,4,5}};


        int[][] test2 = {{5,5,5,5,5,5},
                        {5,4,4,4,4,4},
                        {5,4,3,3,3,3},
                        {5,4,3,2,2,2},
                        {5,4,3,2,1,1},
                        {5,4,3,2,1,0}};



//        print(margeH(a.clone(), 1,2));
        System.out.println();
//        print(margeH(a.clone(), 0,1));
//        System.out.println();
//        print(margeH(a.clone(), 0,2));

        Lab3 lab3 = new Lab3();
//
//
        for(Set<Integer> it : lab3.decomposition(c)){
            System.out.print("lvl ");
            it.forEach( element ->  System.out.print(element + 1 + " "));
            System.out.println();
        }

        int[][] arr = c.clone();

        for(Set<Integer> it : lab3.decomposition(c)){
            HashSet<Integer> include = new HashSet<>();
            int start = -1;
            for(int element : it){
                if(start == -1)  start = element;
                else {
                    int left = start - lab3.findIndexInRange(start, include);
                    int right = element - lab3.findIndexInRange(element, include);
                    arr = margeH(arr, left , right);
                    include.add(element);
                }
            }
        }
        print(arr);





////
//        int[][] arr = lab3.numberDug(c);
////

////
//        Set<Integer> sets = new HashSet<>();
//        sets.add(6);
//        sets.add(5);
//        System.out.println( lab3.findDug(arr , sets));
//
//        print(t(margeH(t(c) ,0 , 6 )));
//
//

//        lab3.subGraf(c , 6);
    }

    private int findIndexInRange(int end, HashSet<Integer> range){
        return (int) range.stream().filter(it ->  it < end).count();
    }

    static void print(int[][] arr){
        for(int i = 0; i < arr.length;i++ ){
            for (int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    private String findDug(int[][] arr ,Set<Integer> s){
        String out = "Дуги ";

        for(int i : s){
            for(int j : s){
                if(arr[i][j] != 0) out += " " + arr[i][j];
            }
        }
        return out;
    }



    private int[][] numberDug(int[][] arr){
        int[][] e  = new int[arr.length][arr.length];
        int num =1;
        for(int i = 0;  i < arr.length;i++){
            for (int j = 0; j < arr.length;j++){
                if(arr[i][j] == 1)e[i][j] = num++;
                else e[i][j] = 0;
            }
        }

        return e;
    }


    static int[][] margeH(int arr[][], int n1 , int n2){
        int[][] out = new int[arr.length-1][arr.length-1];

        if(n1 > n2) throw new NullPointerException("N1 > N2");

        for(int i = 0 ; i < arr.length;i++){
            for(int j = 0; j < arr.length; j++) {
                int i1 = i;
                int j1 = j;
                if(i1 >= n2) i1--;
                if(j1 >= n2) j1--;

                if (i < n1 && j < n1)
                    out[i][j] = arr[i][j];
                else if(i == n1 && j == n2)
                    out[i][i] = Math.max(arr[i][i], arr[j][j]);
                else if (i >= n2 || j >= n2)
                    out[i1][j1] = arr[i][j];
                else if(n1 == i) {
                    out[n1][j1] = Math.max(arr[n1][j], arr[n2][j]);
                } else if (n1 == j) {
                    out[i1][n1] = Math.max(arr[i][n1], arr[i][n2]);
                }
            }
        }

        return out;
    }

//    static int[][] margeH(int arr[][], int n1 , int n2){
//        int[][] out = new int[arr.length-1][arr.length-1];
//
//        for(int i = 0; i< arr.length;i++){
//
//            int i1 = i;
//            if(i >= n2) i1--;
//
//            int a = arr[n1][i1];
//            int b = arr[n2][i1];
//
//            out[n1][i1] = Math.max(a, b);
//            out[i1][n1] = Math.max(arr[i1][n1], arr[i1][n2]);
//            if(n1 == i1) out[i1][i1] = 0;
//        }

////        System.out.println("step1");
////        print(out);
////        System.out.println("end step1");
//
//        for(int i =0 ; i < arr.length;i++){
//            if(n1 == i ) continue;
//
//            for(int j = 0; j < arr.length; j++){
//                if( n1 == j)
//                    continue;
//                int i2 = i;
//                int j2 = j;
//                if(n2 < i2)
//                    i2--;
//                if(n2 <j2)
//                    j2--;
//
//                out[i2][j2] = arr[i][j];
//            }
//        }
//
//
//        return out;
//    }

    ArrayList<Set<Integer>> decomposition(int[][] arr){
        ArrayList<Set<Integer>> arcs = new ArrayList<>();


        Set<Integer> saveH = new HashSet<>();

        for(int i = 0;i < arr.length;i++){
            if(!saveH.contains(i)){

                Set<Integer> a = subGraf(arr , i);
                arcs.add(a);
                saveH.addAll(a);
            }

        }

        return arcs;
    }
    Set<Integer> subGraf(int[][] arr , int n){
        Set<Integer> q = findQ(arr , n);
        Set<Integer> r = findR(arr , n);

        return getIntersection(q , r);
    }

    Set<Integer> getIntersection(Set<Integer> a , Set<Integer> b){
        Set<Integer> intersection = new HashSet<>();

        for(int n : a){
            if(b.contains(n)) intersection.add(n);
        }

        return intersection;
    }

    Set<Integer> findQ(int[][] a, int find){
        Set<Integer> set = new HashSet<>();
        set.add(find);

        return findQ(a , set);
    }
    Set<Integer> findQ(int[][] a ,  Set<Integer> find){
        return findR(t(a) , find);
    }

    Set<Integer> findR(int[][] a , int find){
        Set<Integer> set = new HashSet<>();
        set.add(find);

        return findR(a , set);
    }
    Set<Integer> findR(int[][] a , Set<Integer> find){
        Set<Integer> out = find;

        boolean flag = true;

        while (flag) {
            Set<Integer> iteration = new HashSet<>(out);

            flag = false;
            for (int n : out) {
                Set<Integer> iter = getLine(a, n);
                for (int ni : iter) {
                    if (iteration.add(ni))
                        flag = true;
                }

            }

            out.addAll(iteration);
        }

        return out;

    }

    Set<Integer> getLine(int[][] arr, int n ){
        Set<Integer> out = new HashSet<>();

        for(int i =0 ; i< arr.length;i++){
            if(arr[n][i] == 1) out.add(i);
        }

        return out;
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
}



