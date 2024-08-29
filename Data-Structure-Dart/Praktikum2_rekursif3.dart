import 'dart:io';

int move = 1;

void hanoi(int cakram, String awal, String bantu, String tujuan) {
  if (cakram >= 1) {
    hanoi(cakram - 1, awal, tujuan, bantu);
    moveCakram(cakram, awal, tujuan);
    hanoi(cakram - 1, bantu, awal, tujuan);
  }
}

void moveCakram(int step, String awal, String tujuan) {
  print("Langkah $move:");
  move++;
  print("Pindahkan Cakram $step dari $awal ke $tujuan");
}

void towerOfHanoi(int n, String sumber, String tujuan, String bantuan) {
  if (n == 1) {
    print('Langkah $move: Pindahkan cakram 1 dari $sumber ke $tujuan');
    move++;
  } else {
    towerOfHanoi(n - 1, sumber, bantuan, tujuan);
    print('Langkah $move: Pindahkan cakram $n dari $sumber ke $tujuan');
    move++;
    towerOfHanoi(n - 1, bantuan, tujuan, sumber);
  }
}

void main() {
  var input = stdin;
  stdout.write("Masukkan Jumlah Cakram/Disc: ");
  int cakram = int.parse(input.readLineSync()!);
  towerOfHanoi(cakram, 'A', 'B', 'C');
  print("Selamat, cakram selesai terpindahkan ke tiang tujuan!");
}
