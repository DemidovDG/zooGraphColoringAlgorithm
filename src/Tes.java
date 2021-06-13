import java.util.Arrays;

public class Tes {
    public static void main(String[] args) {
        boolean[][] bol = new boolean[4][4];
        for (int i = 0; i < bol.length; i++) {
            for (int j = 0; j < bol.length; j++) {
                System.out.print(bol[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
