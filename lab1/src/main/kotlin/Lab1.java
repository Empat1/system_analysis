public class Lab1  {
    public static void main(String[] args) {

        int[][] a = {{1 , 0 , 0 }
                    ,{0 , 0 , 1}
                    ,{1 , 1 , 0}};

        int[][] b = {{1 , 0  }
                ,{0 , 0 }};

        int[][] c = {{0 , 1 , 1 }
                ,{0 , 0 , 0}
                ,{1 , 1 , 0}};

        print(a);
        System.out.println((rights(a)));
        System.out.println((left(a)));

        print(b);
        System.out.println((rights(b)));
        System.out.println((left(b)));

        print(c);
        System.out.println((rights(c)));
        System.out.println((left(c)));

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

    static String left(int[][] arr){
        int[][] tM = t(arr);
        return rights(tM);
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
