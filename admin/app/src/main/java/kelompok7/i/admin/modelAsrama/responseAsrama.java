package kelompok7.i.admin.modelAsrama;
import java.util.List;

public class responseAsrama {
    private int kode;
    private String pesan;
    private List<AsramaData> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<AsramaData> getData() {
        return data;
    }

    public void setData(List<AsramaData> data) {
        this.data = data;
    }
}

