package basic.javaPrograms;

public class FirstJavaProgram {
    private static double convert(double pounds) {
        return pounds * 0.45359237;
    }
    private static void fruits(char f) {
        switch(f) {
            case 'A':
                System.out.println("Apple");
                break;
            case 'B':
                System.out.println("Banana");
                break;
            case 'C':
                System.out.println("Cherries");
                break;
            case 'D':
                System.out.println("Dragon Fruit");
                break;
            case 'E':
                System.out.println("ElderBerry");
                break;
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello ");
        int a = 500;
        short b = 10;
        byte c = 30;
        long d = 70000 + 15 * a + b + c;
//        System.out.println(d);
//        System.out.println(convert(100));
        fruits('B');
    }

}
