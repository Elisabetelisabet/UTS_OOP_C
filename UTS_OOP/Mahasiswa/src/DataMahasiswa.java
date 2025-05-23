
/**
 *
 * @author INSTIKI
 */
import java.util.Scanner;
import mahasiswa.Mahasiswa;

public class DataMahasiswa {
    private Mahasiswa[] mahasiswaArray;
    private int totalMahasiswa;

    // Constructor
    public DataMahasiswa() {
        mahasiswaArray = new Mahasiswa[10];  // Array untuk menyimpan data mahasiswa (maks 10)
        totalMahasiswa = 0;
    }

    // Menampilkan semua data mahasiswa
    public void tampilkanData() {
        if (totalMahasiswa == 0) {
            System.out.println("Tidak ada data mahasiswa.");
        } else {
            System.out.println("Data Mahasiswa:");
            for (int i = 0; i < totalMahasiswa; i++) {
                System.out.println("ID: " + mahasiswaArray[i].getId() +
                                   ", Nama: " + mahasiswaArray[i].getNama() +
                                   ", Jurusan: " + mahasiswaArray[i].getJurusan());
            }
        }
    }

    // Menambah data mahasiswa
    public void tambahMahasiswa(Mahasiswa mahasiswa) {
        if (totalMahasiswa < mahasiswaArray.length) {
            mahasiswaArray[totalMahasiswa] = mahasiswa;
            totalMahasiswa++;
        } else {
            System.out.println("Data mahasiswa sudah penuh.");
        }
    }

    // Mengubah data mahasiswa pada indeks tertentu
    public void ubahMahasiswa(int index, Mahasiswa mahasiswa) {
        if (index >= 0 && index < totalMahasiswa) {
            mahasiswaArray[index] = mahasiswa;
            System.out.println("Data mahasiswa berhasil diubah.");
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    // Menghapus data mahasiswa pada indeks tertentu
    public void hapusMahasiswa(int index) {
        if (index >= 0 && index < totalMahasiswa) {
            for (int i = index; i < totalMahasiswa - 1; i++) {
                mahasiswaArray[i] = mahasiswaArray[i + 1];
            }
            mahasiswaArray[totalMahasiswa - 1] = null;
            totalMahasiswa--;
            System.out.println("Data mahasiswa berhasil dihapus.");
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    // Menampilkan menu aplikasi
    public void tampilkanMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n=== Menu Aplikasi Data Mahasiswa ===");
            System.out.println("1. Tampilkan Data");
            System.out.println("2. Tambah Data Mahasiswa");
            System.out.println("3. Ubah Data Mahasiswa");
            System.out.println("4. Hapus Data Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer input

            switch (pilihan) {
                case 1:
                    tampilkanData();
                    break;
                case 2:
                    System.out.print("Masukkan ID Mahasiswa: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Jurusan Mahasiswa: ");
                    String jurusan = scanner.nextLine();
                    Mahasiswa mahasiswa = new Mahasiswa(id, nama, jurusan);
                    tambahMahasiswa(mahasiswa);
                    break;
                case 3:
                    tampilkanData();
                    System.out.print("Masukkan index mahasiswa yang ingin diubah: ");
                    int indexUbah = scanner.nextInt();
                    scanner.nextLine();  // Membersihkan buffer input
                    System.out.print("Masukkan ID Mahasiswa baru: ");
                    String idBaru = scanner.nextLine();
                    System.out.print("Masukkan Nama Mahasiswa baru: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan Jurusan Mahasiswa baru: ");
                    String jurusanBaru = scanner.nextLine();
                    Mahasiswa mahasiswaBaru = new Mahasiswa(idBaru, namaBaru, jurusanBaru);
                    ubahMahasiswa(indexUbah - 1, mahasiswaBaru);
                    break;
                case 4:
                    tampilkanData();
                    System.out.print("Masukkan index mahasiswa yang ingin dihapus: ");
                    int indexHapus = scanner.nextInt();
                    hapusMahasiswa(indexHapus - 1);
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    public static void main(String[] args) {
        DataMahasiswa dataMahasiswa = new DataMahasiswa();
        dataMahasiswa.tampilkanMenu();
    }
}

