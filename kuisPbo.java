package com.company;


class Member{
    String nama;
    String ID;
    int bukuDipinjam;
    boolean suratBebasPerpustakaan = false;
    int pinjaman = 0;
    int jumlahHadir = 0;
    Absen absen;
    Buku buku;
    SuratBebasPerpustakaan suratPerpustakaan;

    Member(String inputnama, String inputID){
        this.nama = inputnama;
        this.ID = inputID;
    }

    void setNama(String inputNama){
        this.nama = inputNama;
    }

    void setID(String inputID){
        this.ID = inputID;
    }

    String getNama(){
        return nama;
    }

    String getID(){
        return ID;
    }

    void hadir(Absen absen){
        this.absen = absen;
        absen.jumlahPengunjung();
        jumlahHadir++;
        System.out.println(this.nama + " Datang Pada Tanggal" + absen.detailTanggal());
        System.out.println("_________________________________________________________________");
    }

    void pinjamBuku(Buku buku){
        this.buku = buku;
        pinjaman ++;
        buku.bukuDipinjam();
        System.out.println(buku.getJudul() + "\nDipinjam Oleh " + this.nama);
    }

    void dataBuku(Buku buku){
        this.buku = buku;
        buku.detailBuku();
    }

    void mintaSuratBebasPerpustakaan(){
        if(this.pinjaman <= 0){
            System.out.println("Nama : " + this.nama);
            System.out.println(this.nama + " Belum Meminjam Buku ");
            System.out.println(this.nama + " Telah Mengajukan Surat Bebas Perpustakaan");
            System.out.println("_________________________________________________________________");
        }

        else{
            System.out.println("Nama : " + this.nama);
            System.out.println(this.nama + " Telah Meminjam Buku ");
            System.out.println(this.nama + " Tidak Dapat Mengajukan Surat Bebas Perpustakaan");
            System.out.println("_________________________________________________________________");
        }
    }

    void membuatSurat(SuratBebasPerpustakaan suratPerpustakaan){
        this.suratPerpustakaan = suratPerpustakaan;
        suratBebasPerpustakaan = true;
    }

    void tampilSurat(){
        suratPerpustakaan.detailSurat();
    }
}

class Absen{
    int tanggal;
    int bulan;
    int tahun;
    int jumlahKehadiran;

    Absen(int tanggal, int bulan, int tahun){
        this.tanggal = tanggal;
        this.bulan = bulan;
        this.tahun = tahun;
    }

    String detailTanggal(){
        return "Tanggal " + this.tanggal + "-" + this.bulan + "-" + this.tahun;
    }

    void jumlahPengunjung(){
        this.jumlahKehadiran++;
    }

    void kehadiran(){

        System.out.println("Tanggal " + tanggal + "-" + bulan + "-" +tahun);
        System.out.println("Pengunjung \t: " + this.jumlahKehadiran + " Pengunjung");
        System.out.println("_________________________________________________________________");
    }
}

class KatalogBuku{
    String kategori;
    String tema;

    KatalogBuku(String inputKategori, String inputTema){
        this.kategori = inputKategori;
        this.tema = inputTema;
    }

    void detailKatalog(){
        System.out.println("Kategori \t: \t" + this.kategori);
        System.out.println("Tema \t\t: \t" + this.tema);
        System.out.println("_________________________________________________________________");
    }

}

class Buku{
    String judul;
    String tema;
    String pengarang;
    String penerbit;
    int tahunTerbit;
    int banyakBuku = 0;
    KatalogBuku katalogBuku;

    Buku(String inputJudul, String inputTema, String inputPengarang, String inputPenerbit, int inputTahunTerbit, int inputBanyakBuku, KatalogBuku katalogBuku){
        this.judul = inputJudul;
        this.tema = inputTema;
        this.pengarang = inputPengarang;
        this.penerbit = inputPenerbit;
        this.banyakBuku = inputBanyakBuku;
        this.tahunTerbit = inputTahunTerbit;
        this.katalogBuku = katalogBuku;
    }

    void detailBuku(){
        System.out.println("_________________________________________________________________");
        System.out.println("Buku \t\t:\t" + this.judul);
        System.out.println("Pengarang \t:\t" + this.pengarang);
        System.out.println("Terbit \t\t:\t" + this.tahunTerbit);
        System.out.println("Tersedia \t:\t" + this.banyakBuku);
        System.out.println("_________________________________________________________________");
    }

    String getJudul(){
        return judul;
    }

    void bukuDipinjam(){
        banyakBuku -= 1;
    }

    void KatalogBerdasarkanTema(KatalogBuku katalogBuku){
        this.katalogBuku = katalogBuku;
    }

    void tampilKatalog(){
        System.out.println(this.judul);
        katalogBuku.detailKatalog();
    }

}

class SuratBebasPerpustakaan{
    String nama;
    String ID;
    Member member;

    SuratBebasPerpustakaan(Member member){
        this.nama = member.getNama();
        this.ID = member.getID();
    }

    void detailSurat(){
        System.out.println("SURAT BEBAS PERPUSTAKAAN");
        System.out.println("Nama \t:" + this.nama);
        System.out.println("ID \t\t:" + this.ID);
        System.out.println(this.nama + "Tidak Memiliki Tanggung Jawab pada Perpustakaan");
    }

}

public class Main {

    public static void main(String[] args) {

        // Instansiasi Member
        Member member1 = new Member("Muhammad Indra ","01111");
        Member member2 = new Member("Kelvin", "01112");

        // Instansiasi Katalog Buku
        KatalogBuku sejarah  = new KatalogBuku("Buku", "Sejarah");
        KatalogBuku majalah = new KatalogBuku("Majalah","Otomotif");
        KatalogBuku pemrograman = new KatalogBuku("Buku", "Pemrograman");

        //Instansiasi Buku
        Buku buku1 = new Buku("Islam dalam Arus Sejarah Indonesia","Sejarah","Jajat Burhanudin","Perdana Media",2017,43, sejarah);
        Buku buku2 = new Buku("IMBAS PPKM DARURAT DI SEKTOR OTOMOTIF","Otomotif", "Gramedia", "Gramedia", 2021, 20, majalah);
        Buku buku3 = new Buku("Konsep dan Implementasi PYTHON KASUS BIG DATA", "Pemrograman","Rosihan Ari Yuana","Loko Media",2019, 32, pemrograman);

        //Instansiasi Absen
        Absen senin = new Absen(2,3,2022);


        //Proses Absensi
        member1.hadir(senin);
        member2.hadir(senin);

        //Cek Kehadiran
        senin.kehadiran();

        //Meminjam Buku
        member2.pinjamBuku(buku3);

        //Ketersediaan Buku
        member1.dataBuku(buku2);
        member2.dataBuku(buku3);

        //Cek Katalog Buku
        buku2.tampilKatalog();

        //Mengajukan Surat Bebas Perpustakaan
        member1.mintaSuratBebasPerpustakaan();
        member2.mintaSuratBebasPerpustakaan();

        //Membuat surat
        member1.membuatSurat(new SuratBebasPerpustakaan(member1));

        //Cek Surat
        member1.tampilSurat();








    }
}
