
public class Box {
    int value;
    Box nextBox;
    int length = 0;
    public Box(int value) {
        this.value = value;
    }

    public void add(int a){

        get(length).nextBox = new Box(a);
        length++;
    }

    public Box get(int i){
        if(i == 0) return this;
        return nextBox.get(i-1);
    }
}
