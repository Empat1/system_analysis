import java.util.ArrayList;
import java.util.List;

public class C {

    public static void main(String[] args) {

//        ArrayList<Subgraph> a = new ArrayList<>();
//
//        ArrayList<Integer> a1 = new ArrayList<>();
//        a1.add(1);
//        ArrayList<Integer> a2 = new ArrayList<>();
//        a2.add(6);
//        ArrayList<Integer> a3 = new ArrayList<>();
//        a3.add(1);
//        a3.add(9);
//        ArrayList<Integer> a4 = new ArrayList<>();
//        a4.add(2);
//        a4.add(4);
//        a4.add(7);
//        ArrayList<Integer> a5 = new ArrayList<>();
//        ArrayList<Integer> a6 = new ArrayList<>();
//        a6.add(4);
//        a6.add(9);
//        ArrayList<Integer> a7 = new ArrayList<>();
//        a7.add(5);
//        a7.add(7);
//        ArrayList<Integer> a8 = new ArrayList<>();
//        a8.add(8);
//        ArrayList<Integer> a9 = new ArrayList<>();
//        a9.add(0);
//        ArrayList<Integer> a10 = new ArrayList<>();
//        a10.add(8);
//
//
//        a.add(new Subgraph(a1));
//        a.add(new Subgraph(a2));
//        a.add(new Subgraph(a3));
//        a.add(new Subgraph(a4));
//        a.add(new Subgraph(a5));
//        a.add(new Subgraph(a6));
//        a.add(new Subgraph(a7));
//        a.add(new Subgraph(a8));
//        a.add(new Subgraph(a9));
//        a.add(new Subgraph(a10));
//
//
//
//        ArrayList<Edge> b = new ArrayList<>();
//        b.add(new Edge(0 , 1));
//        b.add(new Edge(1 , 6));
//        b.add(new Edge(2 , 1));
//        b.add(new Edge(2 , 9));
//        b.add(new Edge(3 , 2));
//        b.add(new Edge(3 , 4));
//        b.add(new Edge(3 , 7));
//        b.add(new Edge(5 , 9));
//        b.add(new Edge(6 , 7));
//        b.add(new Edge(7 , 8));
//        b.add(new Edge(8 , 0));
//        b.add(new Edge(9 , 8));

        C lab3 = new C();
        lab3.topologicalDecomposition(10 , E , Subgr);



    }

    static ArrayList<Edge> E = new ArrayList<>();
    static ArrayList<Subgraph> Subgr = new ArrayList<>();


    public void topologicalDecomposition(int countV, ArrayList<Edge> E , ArrayList<Subgraph> Sub){
        ArrayList<Integer> notUsedV = new ArrayList<>();

        for(int i =0 ;i < countV; i++){
            notUsedV.add(i);
        }

        while (notUsedV.size() > 0){
            ArrayList<Integer> R = new ArrayList<>(); //Достижимое
            R.add(notUsedV.get(0));
            ArrayList<Integer> Q = new ArrayList<>();//Контрдостижимое
            Q.add(notUsedV.get(0));
            int[] color = new int[countV];

            for(int i =0 ; i < notUsedV.size(); i++){
                for(int k = 0; k < countV; k++){
                    if(IndexOf(notUsedV , k) != -1)
                        color[k] = 1;
                    else
                        color[k] = 2;
                }
                if(DFS(notUsedV.get(0) , notUsedV.get(i) , E , color)) R.add(notUsedV.get(i));

                for(int k =0; k < countV; k++){
                    if(IndexOf(notUsedV , k) != -1)
                        color[k] = 1;
                    else
                        color[k] = 2;
                }

                if(DFS(notUsedV.get(i) , notUsedV.get(0) , E , color)) Q.add(notUsedV.get(i));

            }

            System.out.println("R ");
            R.forEach(s-> System.out.print(R + " : "));
            System.out.println("Q ");
            Q.forEach(s-> System.out.print(Q + " : "));
            System.out.println();

            ArrayList<Integer> intersection = intersection(R , Q);



            Sub.add(new Subgraph(intersection));
            for(int i =0 ; i < intersection.size(); i++){
                notUsedV.remove(intersection.get(i));
            }


        }

        Sub.forEach(System.out::println);

    }

    ArrayList<Integer> intersection(ArrayList<Integer> a , ArrayList<Integer> b){

        ArrayList<Integer> out = new ArrayList<>();


        for(int i : a){
            for (int j : b)
                if (i == j) {
                    out.add(i);
                    break;
                }
        }


        return out;
    }

    boolean DFS(int u, int endV, ArrayList<Edge> E, int[] color){
        color[u] = 2;
        if(u == endV) return true;
        for(int w = 0; w < E.size(); w++){
            if(color[E.get(w).v2] == 1 && E.get(w).v1 == u){
                if(DFS(E.get(w).v2 , endV , E , color)) return true;
                color[E.get(w).v2] = 1;
            }
        }
        return false;
    }
    public int IndexOf(ArrayList<Integer> arr, int element){
        for(int i =0 ; i < arr.size(); i++){
            if(arr.get(i) == element) return i;
        }

        return -1;
    }
}

class Subgraph{
    public ArrayList<Integer> v;

    public Subgraph(){
        v = new ArrayList<>();
    }

    public Subgraph(ArrayList<Integer> v) {
        this.v = v;
    }
}

class Edge {
    public  int v1, v2;

    public Edge(int v1 , int v2){
        this.v1 = v1;
        this.v2 = v2;
    }
}
