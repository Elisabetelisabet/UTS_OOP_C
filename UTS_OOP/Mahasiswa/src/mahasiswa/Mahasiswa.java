
package mahasiswa;

/**
 *
 * @author INSTIKI
 */
public class Mahasiswa {
    private String id;
    private String nama;
    private String jurusan;

    // Constructor
    public Mahasiswa(String id, String nama, String jurusan) {
        this.id = id;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    // Getter dan Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}

