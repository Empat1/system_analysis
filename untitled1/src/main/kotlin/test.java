public class test {
    public static void main(String[] args) {
        double x = 0.00000001;
        double y = 0.00000001;
        double z = 0.9999;

        double x1 = Math.pow(x , 2);
        double y1 = Math.pow(y , 2);
        double z1 = Math.pow(z , 2);

        System.out.println(x1 + y1 + z1);

        double x2 = x / Math.sqrt(1 - x1);
        double y2 = x / Math.sqrt(1 - y1);
        double z2 = x / Math.sqrt(1 - z1);

        System.out.println(x2 + y2 + z2);
    }
}
