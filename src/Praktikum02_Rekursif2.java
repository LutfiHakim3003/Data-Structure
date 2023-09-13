import java.util.Scanner;

public class Praktikum02_Rekursif2 {
    public static int fibonaciIteratif(int n) {
        int fibo = 0, f1 = 1, f2 = 1;
        if (n == 1 | n == 2) {
            return 1;
        } else {
            for(int i = 3; i <= n; i++) {
                fibo = f1 + f2;
                f1 = f2;
                f2 = fibo;
            }
        }
        return  fibo;
    }
    public static  int fibonaciRekursif(int n) {
        if(n == 1 || n == 2){
            return 1;
        } else {
            return fibonaciRekursif(n-1) + fibonaciRekursif(n-2);
        }
    }
    public static int fibonaciDP(int m) {
        int[] result = new int[m+1];
        if(m <= 1){
            return 1;
        } else {
            result[0] = 1;
            result[1] = 1;
            for (int i = 2; i <= m; i++) {
                result[i] = result[i - 1] + result[i - 2];
            }
            return result[m];
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Batasan Suku yang diminta: ");
        int nilai;
        nilai = input.nextInt();
        System.out.println("Deret Fibonacci: ");
        for(int i=1; i<=nilai; i++) {
            System.out.print(fibonaciRekursif(i) + " ");
        }
        System.out.println();
    }
}