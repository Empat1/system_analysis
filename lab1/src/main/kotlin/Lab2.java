import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Lab2 {
    public static void main(String[] args) {

        int[][] a = {{0, 1, 0, 0}
                    ,{0, 0, 1, 0}
                    ,{0, 0, 1, 1}
                    ,{0, 0, 0, 0}};

        int[][] b = {{0 , 1, 0 , 0 , 0 , 0 , 0 }
                ,{0 , 0, 0, 0, 0, 1, 0}
                ,{1 , 0, 0, 0, 1, 0, 1}
                ,{0 , 0, 0, 0, 0, 1, 0}
                ,{0, 1, 0, 1, 0, 0, 0}
                ,{0, 0, 0, 0, 0, 0, 0}
                ,{0, 1, 0, 1, 0, 0, 0}};

        int[][] at = t(a);
        int[][] bt = t(b);

//        findLvl0(at).forEach(System.out::println);
//        findLvl0(bt).forEach(System.out::println);

//        isFindLvL(bt ,findLvl0(bt))

        ArrayList<ArrayList<Integer>> lvl = lvlplas(bt , findLvl0(bt));
//        for (ArrayList<Integer> list : lvl){
//            for(int num: list)
//                System.out.print((num + " -"));
//            System.out.println();
//        }

        print(b);
        System.out.println();

        int[][] answer = replaceCells(t(bt) , newOrder(lvl , bt.length));
        print(answer);

    }


    private static int[] newOrder(ArrayList<ArrayList<Integer>> lists , int size){
        int i =0;
        int[] newOrder = new int[size];

        for(ArrayList<Integer> list : lists){
            for(int n: list )
                newOrder[i++] = n;
        }

        return newOrder;
    }

    private static int[][] replaceCells(int[][] arr, int[] newOrder){
        int[][] newCell =new int[arr.length][arr[0].length];

        for(int i =0 ; i< arr.length;i++){
            for(int j = 0; j < arr[0].length; j++){
                newCell[i][j] = arr[newOrder[i]-1][newOrder[j]-1];
                System.out.println("меняем " + (newOrder[i]-1) + " - " + (newOrder[j]-1)+ " на " + i + " - " + j + " = " + arr[i][j]);
            }
        }

        return newCell;
    }

    private static String lvlString(ArrayList<ArrayList<Integer>> lvl){
        String s = "";

        for(int i =0 ; i < lvl.size();i++){
            s+="Уровень " + i + "\n";
            for(int num : lvl.get(i)){
                s+= num +" ";
            }
            s+="\n";
        }
        return s;
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
            if(flag){
                lvl0.add(i+1);
            }
        }

        return lvl0;
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

    //Распределяет по всем уровням
    static ArrayList<ArrayList<Integer>> lvlplas(int[][] arr ,ArrayList<Integer> lvl1){
        ArrayList<ArrayList<Integer>> lvls = new ArrayList<>();
        lvls.add(lvl1);

        boolean isChange = true;//изменилось ли что-то

        while (isChange){
            ArrayList<Integer> nextLvlNoRepeat = new ArrayList<>();
            ArrayList<Integer> nextLvl = findNextLvl(arr , lvls.get(lvls.size()-1));
            isChange = false;

            for(int i =0 ; i< nextLvl.size();i++){
                if(!isFindLvLs(lvls , nextLvl.get(i)) && !isFindLvL(nextLvlNoRepeat, nextLvl.get(i))){
                    isChange = true;
                    nextLvlNoRepeat.add(nextLvl.get(i));
                }else{
                    System.out.println("Не сработало");
                }
            }

            if(isChange){
                lvls.add(nextLvlNoRepeat);
            }
        }

        return lvls;
    }





    static boolean isFindLvL(ArrayList<Integer> lvl, int number){
        for(int n : lvl){
            if(n == number) return true;
        }
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

    static String rights(int[][] arr){
        String s = "";
        for(int i = 0 ; i < arr.length;i++){
            s += "G(" + (i+1) +")=" + rights(arr[i]) + "\n";
        }
        return s;
    }

    static String rights(int[] arr){
        String s = "";
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == 1) s+= i + 1 +" ";
        }
        if(s.equals("")) return "{нет вершин}";
        return "{"+s+"}";
    }
}
