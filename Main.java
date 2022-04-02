package com.company;
class anggotaPerpustakaan {
    String nama;
    String IDPerpustakaan;
    int jumlahHadir = 0;
    int jumlahTidakHadir = 0;
    int transaksiBerlangsung = 0;
    boolean kepemilikanSuratBebasPerpustakaan = false;
    TanggalAbsensi tanggalAbsensi;
    Buku buku;
    SuratBebasPerpustakaan suratBebasPerpustakaan;



    anggotaPerpustakaan(String inputNama, String inputIDPerpustakaan){
        this.nama = inputNama;
        this.IDPerpustakaan = inputIDPerpustakaan;
    }

    void setNama(String inputNama){
        this.nama = inputNama;
    }
    void setIDPerpustakaan (String inputIDPerpustakaan){
        this.IDPerpustakaan = inputIDPerpustakaan;
    }

    String getNama (){
        return nama;
    }
    String getIDPerpustakaan (){
        return IDPerpustakaan;
    }

    void hadir (TanggalAbsensi tanggalAbsensi){
        this.tanggalAbsensi = tanggalAbsensi;
        tanggalAbsensi.anggotaHadir();
        jumlahHadir++;
        System.out.println("Pengunjung " + nama + " Telah direkam datang ke perpustakaan pada " + tanggalAbsensi.detailTanggal());
    }

    void tidakHadir (TanggalAbsensi tanggalAbsensi){
        this.tanggalAbsensi = tanggalAbsensi;
        tanggalAbsensi.anggotaTidakHadir();
        jumlahTidakHadir++;
        System.out.println("Pengunjung " + nama + " Telah direkam tidak datang ke perpustakaan pada " + tanggalAbsensi.detailTanggal() );
        tanggalAbsensi.detailTanggal();

    }

    void pinjamBuku (Buku buku){
        this.buku = buku;
        this.transaksiBerlangsung ++;
        buku.dipinjam();
        System.out.println("\nBuku dengan judul \"" + buku.getJudulBuku() + "\" BERHASIL DIPINJAM anggota " + this.nama);

    }

    void kembalikanBuku(Buku buku){
        this.buku = buku;
        this.transaksiBerlangsung --;
        buku.dikembalikan();
        System.out.println("\nBuku dengan judul \"" + buku.getJudulBuku() + "\" BERHASIL DIKEMBALIKAN anggota " + this.nama);

    }

    void cekDataBuku(Buku buku){
        this.buku = buku;
        buku.tampilDetailBuku();
    }

    void ajukanSuratBebasPerpustakaan(){
        if(this.transaksiBerlangsung <= 0) {
            System.out.println("\n\tAnggota Perpustakaan Atas Nama " + this.nama );
            System.out.println("\tAnda Tidak Memiliki Transaksi/Peminjaman yang sedang berlangsung" );
            System.out.println("\tSELAMAT ANDA DAPAT MENGAJUKAN SURAT BEBAS PUSTAKA" );
        }

        else{
            System.out.println("\n\tAnggota Perpustakaan Atas Nama " + this.nama );
            System.out.println("\tAnda Memiliki Transkasi/Peminjaman sebanyak "+ this.transaksiBerlangsung + " yang sedang berlangsung" );
            System.out.println("\tANDA TIDAK DAPAT MENGAJUKAN SURAT BEBAS PUSTAKA" );
        }
    }
    void buatSuratBebasPerpustakaan(SuratBebasPerpustakaan suratBebasPerpustakaan){
        this.suratBebasPerpustakaan = suratBebasPerpustakaan;
        kepemilikanSuratBebasPerpustakaan = true;
    }

    void lihatSuratBebasPerpustakaan(){
        suratBebasPerpustakaan.detailSuratBebasPustaka();
    }



}

class TanggalAbsensi {
    String hari;
    String tanggal ;
    int jumlahAnggotaPerpustakaanHadir;
    int jumlahAnggotaPerpustakaanTidakHadir;

    TanggalAbsensi(String inputHari, String inputTanggal){
        this.hari = inputHari;
        this.tanggal = inputTanggal;
    }

    String detailTanggal(){
        return "Hari " + this.hari + ",Tanggal " + this.tanggal;
    }


    void anggotaHadir() {
        this.jumlahAnggotaPerpustakaanHadir++;
    }

    void anggotaTidakHadir (){
        this.jumlahAnggotaPerpustakaanTidakHadir++;
    }

    void cekJumlahKehadiran(){

        System.out.println("\n_________________________________________");
        System.out.println("Hari " + hari + ", Tanggal "+ tanggal);
        System.out.println("Pengunjung Datang \t\t\t:" +this.jumlahAnggotaPerpustakaanHadir + " Orang");
        System.out.println("Pengunjung Tidak Datang \t:" +this.jumlahAnggotaPerpustakaanTidakHadir + " Orang");
        System.out.println("_________________________________________");
    }
}


class Buku {
    String judulBuku;
    String penulisBuku;
    String penerbitBuku;
    int jumlahHalBuku;
    int tahunTerbitBuku;
    int jumlahBuku;
    KatalogBukuSubjek katalogBukuSubjek;

    Buku(String inputJudulBuku,String inputPenulisBuku,String inputPenerbitBuku, int inputJumlahHalBuku, int inputTahunTerbitBuku, int inputJumlahBuku,KatalogBukuSubjek inputKatalogBuku){
        this.judulBuku = inputJudulBuku;
        this.penulisBuku = inputPenulisBuku;
        this.penerbitBuku = inputPenerbitBuku;
        this.jumlahHalBuku = inputJumlahHalBuku;
        this.tahunTerbitBuku = inputTahunTerbitBuku;
        this.jumlahBuku = inputJumlahBuku;
        this.katalogBukuSubjek = inputKatalogBuku;

    }

    Buku(String inputJudulBuku,String inputPenulisBuku,String inputPenerbitBuku, int inputJumlahHalBuku, int inputTahunTerbitBuku, int inputJumlahBuku){
        this.judulBuku = inputJudulBuku;
        this.penulisBuku = inputPenulisBuku;
        this.penerbitBuku = inputPenerbitBuku;
        this.jumlahHalBuku = inputJumlahHalBuku;
        this.tahunTerbitBuku = inputTahunTerbitBuku;
        this.jumlahBuku = inputJumlahBuku;
    }

    Buku(String inputJudulBuku,String inputPenulisBuku, int inputJumlahHalBuku, int inputTahunTerbitBuku, int inputJumlahBuku){
        this.judulBuku = inputJudulBuku;
        this.penulisBuku = inputPenulisBuku;
        this.jumlahHalBuku = inputJumlahHalBuku;
        this.tahunTerbitBuku = inputTahunTerbitBuku;
        this.jumlahBuku = inputJumlahBuku;
    }

    void tampilDetailBuku(){
        System.out.println("\n_________________________________________________");
        System.out.println("Judul Buku\t\t:\t" + this.judulBuku);
        System.out.println("Penulis \t\t:\t" + this.penulisBuku);
        System.out.println("Penerbit \t\t:\t" + penerbitBuku);
        System.out.println("Halaman  \t\t:\t" + this.jumlahHalBuku + " Halaman");
        System.out.println("Tahun Terbit\t:\t" + this.tahunTerbitBuku);
        System.out.println("\nKETERSEDIAAN\t:\t" + this.jumlahBuku + " Buku");
        System.out.println("_________________________________________________");
    }

    String getJudulBuku (){
        return judulBuku;
    }

    void dipinjam(){
        jumlahBuku -= 1;
    }

    void dikembalikan(){
        jumlahBuku += 1;
    }

    void masukKatalogBukuBerdasarkanSubjek(KatalogBukuSubjek katalogBukuSubjek) {
        this.katalogBukuSubjek = katalogBukuSubjek;
    }

    void lihatKatalogBuku(){
        System.out.println("\n__________________________________________________________");
        System.out.println("\t\t\t\t" + this.judulBuku + "\t\t");
        katalogBukuSubjek.detailKatalog();
    }

}

class KatalogBukuSubjek {
    String kategori;
    String subjek;
    String kode;

    KatalogBukuSubjek(String inputKateogri, String inputSubjek, String inputKode) {
        this.kategori = inputKateogri;
        this.subjek = inputSubjek;
        this.kode = inputKode;
    }

    void detailKatalog(){
        System.out.println("__________________________________________________________");
        System.out.println("KODE KATALOG :\t" + this.kode);
        System.out.println("KATEGORI   \t:\t" + this.kategori);
        System.out.println("SUBJEK\t\t:\t" + this.subjek);
        System.out.println("___________________________________________________________");
    }


}

class SuratBebasPerpustakaan{
    anggotaPerpustakaan anggotaPerpustakaan;
    String nama;
    String IDPerpustakaan;

    SuratBebasPerpustakaan(anggotaPerpustakaan anggotaPerpustakaan){
        this.nama = anggotaPerpustakaan.getNama();
        this.IDPerpustakaan = anggotaPerpustakaan.getIDPerpustakaan();
    }

    void detailSuratBebasPustaka (){
        System.out.println("\n__________________________________________________________");
        System.out.println("\t\t\t\t\t SURAT BEBAS PUSTAKA\t\t\t");
        System.out.println("__________________________________________________________");

        System.out.println(" Nama Pustakawan    : " + this.nama);
        System.out.println(" ID Pustakawan      : " + this.IDPerpustakaan);
        System.out.println("\nANGGOTA INI SUDAH TIDAK MEMILIKI BEBAN PERTANGGUNGJAWABAN\nLAGI PADA PERPUSTAKAAN");
        System.out.println("__________________________________________________________");
    }
}





public class Main {

    public static void main(String[] args) {

        //INSTANSIASI OBJEK ANGGOTA PERPUSTAKAAN
        anggotaPerpustakaan anggota1 = new anggotaPerpustakaan("Arif Yudha Nurhidayat","000001");
        anggotaPerpustakaan anggota2 = new anggotaPerpustakaan("Agung Rangga Mukti","000002");
        anggotaPerpustakaan anggota3 = new anggotaPerpustakaan("Berlian Ananda Purwaningsih","000003");

        //INSTANSIASI KATEGORI KATALOG BUKU
        KatalogBukuSubjek agama = new KatalogBukuSubjek("AGAMA","Agama","200");
        KatalogBukuSubjek bibilografi = new KatalogBukuSubjek("UMUM","Bibilografi","010");
        KatalogBukuSubjek kesehatanDanObatobatan = new KatalogBukuSubjek("TEKNOLOGI","Kesehatan dan Obat-Obatan","610");
        KatalogBukuSubjek publikasiUmum_InformasiUmumDanKomputer = new KatalogBukuSubjek("UMUM","Publikasi Umum,Informasi Umum dan Komputer","000");

        //INSTANSIASI OBJEK BUKU PERPUSTAKAAN
        Buku buku1 = new Buku("ANALISIS TULISAN TANGAN","H FUAD NASHORI","Pustaka Pelajar",251,2010,100,publikasiUmum_InformasiUmumDanKomputer);
        Buku buku2 = new Buku("COSNNITIVE BEHAVIOURAL THERAPY","MAJA PITAMIC",177,2011,50);
        Buku buku3 = new Buku("Bimbingan Konseling","Fenti Hikmawati","RajaGrafindo Persada",160,2012,80);

        //INSTANSIASI OBJEK JADWAL ABSENSI
        TanggalAbsensi Satu_9_2022 = new TanggalAbsensi("Rabu","Satu_9_2022");

        //PROSES ABSEN ANGGOTA PERPUSTAKAAN
        anggota1.tidakHadir(Satu_9_2022);
        anggota2.hadir(Satu_9_2022);
        anggota3.hadir(Satu_9_2022);

        //CEK DATA REKAP KEHADIRAN PENGUNJUNG PERPUSTAKAAN PADA TANGGAL 1_9_2002
        Satu_9_2022.cekJumlahKehadiran();

        //MEMINJAM BUKU PERPUSTAKAAN
        anggota1.pinjamBuku(buku2);
        anggota1.pinjamBuku(buku3);
        anggota2.pinjamBuku(buku1);
        anggota2.pinjamBuku(buku2);

        //CEK KETERSEDIAAN DAN DATA BUKU
        anggota1.cekDataBuku(buku1);
        anggota2.cekDataBuku(buku2);
        anggota3.cekDataBuku(buku3);

        //MENGEMBALIKAN BUKU PERPUSTAKAAN
        anggota1.kembalikanBuku(buku2);
        anggota2.kembalikanBuku(buku1);

        //JOIN KATALOG BUKU
        buku3.masukKatalogBukuBerdasarkanSubjek(publikasiUmum_InformasiUmumDanKomputer);
        buku2.masukKatalogBukuBerdasarkanSubjek(kesehatanDanObatobatan);

        //CEK DETAIL KATALOG BUKU
        buku1.lihatKatalogBuku();

        //CEK PENGAJUAN SURAT BEBAS PUSTAKA
        anggota1.ajukanSuratBebasPerpustakaan();
        anggota3.ajukanSuratBebasPerpustakaan();

        //MEMBUAT SURAT BEBAS PUSTAKA
        anggota3.buatSuratBebasPerpustakaan(new SuratBebasPerpustakaan(anggota3));

        //CEK DETAIL SURAT BEBAS PUSTAKA
        anggota3.lihatSuratBebasPerpustakaan();




    }
}
