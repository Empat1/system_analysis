import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lab3 {
    public static void main(String[] args) {
        int[][] a = {{1 , 0 , 0 }
                ,{0 , 0 , 1}
                ,{1 , 1 , 0}};


        int[][] b = {{0 , 1, 0 , 0 , 0 , 0 , 0 }
                ,{0 , 0, 0, 0, 0, 1, 0}
                ,{1 , 0, 0, 0, 1, 0, 1}
                ,{0 , 0, 0, 0, 0, 1, 0}
                ,{0, 1, 0, 1, 0, 0, 0}
                ,{0, 0, 0, 0, 0, 0, 0}
                ,{0, 1, 0, 1, 0, 0, 0}};

        int[][] c = {{0,1,0,0,1,0,0}
                ,{0,1,0,1,0,0,0}
                ,{0,0,0,1,0,0,0}
                ,{0,0,0,0,1,0,0}
                ,{0,0,0,0,1,0,0}
                ,{0,0,1,0,0,0,1}
                ,{0,0,0,1,0,1,0}};

        Lab3 lab3 = new Lab3();


        for(Set<Integer> it : lab3.decomposition(c)){
            System.out.print("lvl ");
            it.forEach(System.out::print);
            System.out.println();
        }

        int[][] arr = lab3.numberDug(c);

        print(arr);

        Set<Integer> sets = new HashSet<>();
        sets.add(6);
        sets.add(5);
        System.out.println( lab3.findDug(arr , sets));

//        lab3.subGraf(c , 6);
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



