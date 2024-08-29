void main() {
  // var names = <String>{"lutfi", "hakim"};

  Set<String> nama = {};
  nama.add("Lutfi");
  nama.add("Hakim");
  nama.add("coba");
  print(nama);

  nama.remove("Hakim");
  print(nama.length);

  print(nama);
}
