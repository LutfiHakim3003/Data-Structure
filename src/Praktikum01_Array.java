//import java.util.Arrays;

public class Praktikum01_Array {
    /* Contoh 4 */
//        public char[] createArray() {
//            char[] s = new char[26];
//            for(int i=0; i<s.length; i++)
//                s[i] = (char) ('A' + i);
//            return s;
//        }
    public static void main(String[] args) {
        /* Contoh 1 */
//      int angka[][] = new int[5][];
//      angka[0] = new int[2];
//      angka[1] = new int[3];
//      angka[2] = new int[4];
//      angka[3] = new int[5];
//      angka[4] = new int[6];
//
//      angka[1][2]  = 10;
////      System.out.println(angka[1][2]);
//          angka[1] = 20;
//          angka[2] = 30;
//          angka[3] = 40;

//      System.out.println(angka[4]);
//      for(int i=1; i<2; i++){
//          for(int j=0; j<3; j++) {
//              System.out.print(angka[i][j] + " ");
//          }
//      }

        // Array Literal
//      float[] diameter = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
//        for(int i=0; i<diameter.length; i++) {
//          System.out.println(diameter[i] + " ");
//      }

        /* Contoh 2 */
//        int[] a = new int[5];
//        boolean[] b = new boolean[6];
//
//        for(int i=0; i<a.length; i++) {
//             System.out.println(a[i]);
//        }
//        for(int j=0; j<b.length; j++) {
//            System.out.println(b[j]);
//        }

        /* Contoh 3 */
//        int[] listUkuran = new int[5];
//        byte b = 4;
//        char c = 'c';
//        short s = 7;
//
//        listUkuran[0] = b;
//        listUkuran[1] = c;
//        listUkuran[2] = s;
//
//        for (int i=0; i<listUkuran.length; i++) {
//            System.out.println(listUkuran[i]);
//        }

        /* Contoh 4 */
//        char[] hasil = new char[26];
//        Main Arr = new Main();
//        hasil = Arr.createArray();
//        for(int i=0; i<hasil.length; i++)
//            System.out.println(hasil[i]+" ");

        /* Contoh 5 */
//        String[] kode = new String[3];
//        kode[0] = "D";
//        kode[1] = "P";
//        kode[2] = "S";
//
//        for(int i=0; i<kode.length; i++)
//            System.out.println(kode[i]);

        /* Contoh 6 */
//        String nama[] = new String[20], line;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int i=0, p;
//
//        try{
//            while(true) {
//                System.out.println("Masukkan Nama Mahasiswa ke- = " + i);
//                line = reader.readLine();
//                if (line.equals("***")) break;
//                nama[i] = line;
//                i++;
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }

//        p = i;
//        Arrays.sort(nama,0,p);
//        System.out.println("Nama Mahasiswa:");
//        for(i=0; i<p; i++) {
//            System.out.println(nama[i]);
//        }

        // Array Multidimensi
//        int angka1[][] = new int[5][5];
//        angka1[0][0] = 10;
//        angka1[3][1] = 20;
//
//        for(int m=0; m<angka1.length; m++) {
//            for(int n=0; n<angka1.length; n++) {
//                System.out.print(angka1[m][n] + " ");
//            }
//            System.out.println();
//        }

//        int angka[][] = new int[5][];
//        angka[0] = new int[2];
//        angka[1] = new int[3];
//        angka[2] = new int[4];
//        angka[3] = new int[5];
//        angka[4] = new int[6];
//
//        angka[1][2]  = 10;
//
//        for(int i=1; i<2; i++){
//            for(int j=0; j<3; j++) {
//                System.out.print(angka[i][j] + " ");
//            }
//        }

        // Array Multidimensi 2
//        int[][] twoDim = new int[2][];
//        twoDim[0] = new int[3];
//        twoDim[1] = new int[5];
//
//        System.out.println("Length pada indeks ke-0 =" + twoDim[0].length);
//        System.out.println("Length pada indeks ke-0 =" + twoDim[1].length);

//        Array Multidimensi Random
//        int arrMulti[][] = new int[4][];
//        int i, j, r, awal;
//
//        System.out.println("Kolom yang dibangkitkan");
//        for(i=0; i<arrMulti.length; i++) {
//            r = (int) (Math.random() * 10+i);
//            arrMulti[i] = new int[r];
//            System.out.println("Baris ke-"+i+" = " + r);
//        }
//        System.out.println("\nMengisi Matrik");
//        awal = 2;
//        for(i=0; i<arrMulti.length; i++) {
//            for(j=0; j<arrMulti[i].length; j++) {
//                arrMulti[i][j] = awal + (j+i);
//                System.out.print(arrMulti[i][j] + " ");
//            }
//            awal++;
//            System.out.println();
//        }
        // Array Multidimensi 4
//        int[] myArray = new int[6];
//        int i;
//        for(i=0; i<myArray.length; i++) {
//            myArray[i] = i;
//            System.out.print(myArray[i] + " ");
//        }
//        System.out.println("\nSetelah Array diperbesar");
//        myArray = new int[10];
//        for (i=0; i<myArray.length; i++) {
//            myArray[i] = i;
//            System.out.print(myArray[i] + " ");
//        }
    }
}