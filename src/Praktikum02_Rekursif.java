import java.util.Scanner;

public class Praktikum02_Rekursif {
    /* Faktorial */
    public static int faktorialIteratif(int n) {
        if (n < 0) {
            return -1;
        }
        else if (n > 0) { // kecuali 1
            int faktorial = 1;
            for (int i = n ; i > 0; i--) {
                faktorial = faktorial * i;
//                System.out.print(faktorial+ " ");
            }
            return faktorial;
        }
        else {
            return 1;
        }
    }
    public static int faktorialRekursif(int n) {
        if(n == 1) return 1;
        else return n * faktorialRekursif(n-1);
    }
    /* Deret Fibonacci */
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
        if(n == 1 || n == 2) return 1;
        else return fibonaciRekursif(n-1) + fibonaciRekursif(n-2);
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

    /* Tower Hanoi */
    static int move = 1;
    static void Hanoi(int Cakram, char awal, char bantu, char tujuan) {
        if(Cakram >= 1) {
            Hanoi(Cakram - 1, awal, tujuan, bantu);
            move(Cakram, awal, tujuan);
            Hanoi(Cakram-1, bantu, awal, tujuan);
        }
    }
    static void move(int step, char awal, char tujuan) {
        System.out.print("Langkah " + move + ": ");
        move++;
        System.out.print("Pindahkan Cakram " + step);
        System.out.print(" dari " + awal);
        System.out.print(" ke " + tujuan);
        System.out.println();
    }
    public static void main(String[] args) {
//        int faktorial = faktorialIteratif(5);
//        int fakRekursif = faktorialRekursif(6);
//        int fiboIteratif = fibonaciIteratif(10);
//        int fiboRekursif = fibonaciRekursif(7);
//
//        int nilai = 10;
//        int fiboDP = fibonaciDP(nilai-1);
//
//
//        System.out.println("Nilai Fibonacci: " + fiboDP);

        Scanner input = new Scanner(System.in);
//        int suku;
//        System.out.print("Masukkan Deret yang diminta: ");
//        suku = input.nextInt();
//
//        System.out.println("Deret Fibonacci: ");
//        for (int i = 1 ; i <= suku; i++)
//        System.out.print(fiboRekursif(i) + " ");

        System.out.print("Masukkan Jumlah Cakram/Disc: ");
        int Cakram = input.nextInt();
        Hanoi(Cakram, 'A', 'B', 'C');
        System.out.println("Selamat, cakram selesai terpindahkan ke tiang tujuan!");
    }
}
