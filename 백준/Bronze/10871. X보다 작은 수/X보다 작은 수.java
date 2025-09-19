import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, x, result;
        n = in.nextInt(); x = in.nextInt();

        for (int i = 0; i < n; i++) {
            result = in.nextInt();
            if (result < x) System.out.print(result + " ");
        }


    }

}
