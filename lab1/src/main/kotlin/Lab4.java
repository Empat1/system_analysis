import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Lab4 {
    public static void main(String[] args) {

        int[][] a = {{0, 1, 0, 0}
                ,{0, 0, 1, 0}
                ,{0, 0, 1, 1}
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

        int[][] d = {{0, 1, 0, 0, 1, 0, 0, 0, 0, 0}
                ,{0, 0, 0, 1, 0 ,1, 0, 0, 0, 0}
                ,{0, 0, 0, 0, 0, 0, 1, 1, 0, 0}
                ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
                ,{0, 0, 0, 1, 0, 0, 0, 0, 1, 0}
                ,{0, 0, 0, 0, 0, 1, 1, 0, 0, 0}
                ,{0, 0, 0, 0, 0, 0, 1, 1, 0, 0}
                ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                ,{0, 0, 0, 0, 1, 0, 0, 1, 0, 0}
                ,{0, 0, 0, 0, 0, 0, 0, 0, 1, 0}};

        int[][] at = t(c);
        int[][] bt = t(b);


        int start=0;

//        y = t(c);
//        print(t(y));

//        findLvl0(at).forEach(System.out::println);

        ArrayList<ArrayList<Integer>> lvl = lvlplas(at , findLvl0(at));
//
        for(ArrayList<Integer> l : lvl){
            System.out.println();
            l.forEach(it -> System.out.print(it + " "));
        }
//
        int[][] answer = findPath(at , lvl);
        System.out.println();

        print(t(answer));

    }


    int[][] a = {{0, 1, 0, 0}
            ,{0, 0, 1, 0}
            ,{0, 0, 1, 1}
            ,{0, 0, 0, 0}};

    static int[][] y;

    @NotNull
    static int[][] findPath(int[][] arr , ArrayList<ArrayList<Integer>> lvls){
        int[][] nA = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length;i++){
            for(int j =0 ; j < arr.length;j++){
                if(arr[i][j] == 1) nA[i][j] = 1;
                else nA[i][j] = getLvlPath(i+1 , j+1 , lvls);
            }
        }

        return nA;

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

    static int getLvlPath(int a , int b, ArrayList<ArrayList<Integer>> lvls){
        int la = getLvl(a , lvls);
        int lb = getLvl(b , lvls);
        if(la == -1 || lb == -1  ) return -1;
        return la - lb;
//        return Math.max(la , lb)- Math.min(la , lb);
    }

    static int getLvl(int number, ArrayList<ArrayList<Integer>> lvls){

       for(int i =0 ; i< lvls.size();i++){
           for(int n : lvls.get(i)){
               if(n == number) return i+1;
           }
       }

        return -1;
    }
    static ArrayList<Integer> findNextLvl(int[][] arr , ArrayList<Integer> lvlAfter){
        ArrayList<Integer> lvl = new ArrayList<>();

        int n;
        for(int i: lvlAfter){
            for(int j = 0; j < arr.length; j++){
                if(arr[j][i-1] == 1) {
                    n = j + 1;
                    lvl.add(n);
                }
            }
        }

        return lvl;
    }


    static ArrayList<Integer> findLvl0(int[][] arr){
        ArrayList<Integer> lvl0 =new ArrayList<Integer>();
        boolean flag;

        for(int i =0 ; i < arr.length;i++){
            flag = true;
            for(int j = 0; j < arr.length;j++){
                if(arr[i][j] == 1) {
                    flag = false;
                    break;
                }
            }
//            if(arr[i][start] == 1) lvl0.add(i+1);
            if(flag){
                lvl0.add(i+1);
                return lvl0;
            }
        }

        return lvl0;
    }
    static ArrayList<ArrayList<Integer>> lvlplas(int[][] arr ,ArrayList<Integer> lvl1){
        ArrayList<ArrayList<Integer>> lvls = new ArrayList<>();
        lvls.add(lvl1);

        boolean isNotStart = true;//изменилось ли что-то

        while (isNotStart){
            ArrayList<Integer> nextLvlNoRepeat = new ArrayList<>();
            ArrayList<Integer> nextLvl = findNextLvl(arr , lvls.get(lvls.size()-1));
            isNotStart = inStart(arr, lvl1);

            for(int i =0 ; i< nextLvl.size();i++){
                if(!isFindLvLs(lvls , nextLvl.get(i)) && !isFindLvL(nextLvlNoRepeat, nextLvl.get(i))){
                    isNotStart = true;
                    nextLvlNoRepeat.add(nextLvl.get(i));
                }else{
                    System.out.println("Не сработало");
                }
            }

            if(isNotStart){
                lvls.add(nextLvlNoRepeat);
            }
        }

        return lvls;
    }

    static boolean inStart(int[][] arr ,ArrayList<Integer> lvl1){
        return false;
    }

    static boolean isFindLvLs(ArrayList<ArrayList<Integer>> lvls ,int number){
        //Теоретически можно повысить скорость используя таблицу
        for (ArrayList<Integer> lvl : lvls){
            for (int num: lvl){
                if(num == number)
                    return true;
            }
        }
        return false;
    }


    static boolean isFindLvL(ArrayList<Integer> lvl, int number){
        for(int n : lvl){
            if(n == number) return true;
        }
        return false;
    }
    static void print(int[][] arr){
        for(int i = 0; i < arr.length;i++ ){
            for (int j = 0; j < arr[0].length; j++){
                if(arr[i][j] < 0){
                    System.out.print(arr[i][j] + " ");
                }else{
                    System.out.print(" " + arr[i][j] + " ");
                }

            }
            System.out.println();
        }
    }


}
