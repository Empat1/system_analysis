import java.util.ArrayList;

public class Lab4_3 {

    public static void main(String[] args) {


        int[][] a =   {{0,5,1,0}
                        ,{0,0,7,4}
                        ,{0,1,0,6}
                        ,{0,0,0,0}};



        Lab4_3 lab = new Lab4_3();

        lab.arr =t(a);
        lab.startStep(0);
        lab.getNextStep();

        for(int i = 0; i < lab.arr.length; i++){
            System.out.print(lab.d[i] + " ");
        }
    }



    void startStep(int a){
        d = new int[arr.length];
        m0 = new ArrayList<>();
        m1 = new ArrayList<>();
        m11 = new ArrayList<>();
        m2 = new ArrayList<>();

        m2.add(a);

        for(int i = 0; i < arr.length; i++){
            if(i != a){
                m2.add(i);
            }
        }

        System.out.println();
    }

    private void getNextStep(){
        int nextInt = -1;
        int queue = 0;


       if(!m11.isEmpty()){
            queue = 2;
            nextInt = m11.get(0);
            m11.remove(0);

        }else if(!m1.isEmpty()){
            queue = 2;
            nextInt = m1.get(0);
            m1.remove(0);
        }else if(!m2.isEmpty()){
            queue = 1;
            nextInt = m2.get(0);
            m2.remove(0);

        }

        for(int i = 0; i < arr.length;i++){
            if(arr[i][nextInt] != 0){
                switch (queue){
                    case 1:
                        int k = arr[i][nextInt];
                        d[i] = k;
                        break;
                    case 2:
                        d[i] = Math.min(d[nextInt] , arr[nextInt][i]);
                        break;
                }

            }
        }

        switch (queue){
            case 1:
                m1.add(nextInt);
                break;
            case 2:
                m11.add(nextInt);
                break;
        }

    }

    int[][] arr;
    int[] d;
    ArrayList<Integer> m0;
    ArrayList<Integer> m1;
    ArrayList<Integer> m11;
    ArrayList<Integer> m2;


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
