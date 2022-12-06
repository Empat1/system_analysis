import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Box a = new Box(1);


        for (int i = 0; i < 100; i++){
            a.add(i);
            System.out.println(a.get(i).value);
        }

//        List<Integer> list = new ArrayList<>();
//        list.remove()

    }
}
