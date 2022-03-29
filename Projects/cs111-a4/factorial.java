public class factorial {

    public static void main(String[] args) {
        int n = factorials(Integer.parseInt(args[0]));
        System.out.println(n);
    }

    public static int factorials(int a) {
        if (a == 0) {
            return 1;
        }
        return a + (factorials(a - 1));

    }

}