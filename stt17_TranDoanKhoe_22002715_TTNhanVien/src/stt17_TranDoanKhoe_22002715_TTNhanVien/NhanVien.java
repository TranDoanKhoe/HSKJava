package stt17_TranDoanKhoe_22002715_TTNhanVien;

public class NhanVien {
    private String maNV;
    private String ho;
    private String tenNV;
    private String phai;
    private int tuoi;
    private double tienLuong;

    public NhanVien(String maNV, String ho, String tenNV, String phai, int tuoi, double tienLuong) {
        this.maNV = maNV;
        this.ho = ho;
        this.tenNV = tenNV;
        this.phai = phai;
        this.tuoi = tuoi;
        this.tienLuong = tienLuong;
    }


    public String getMaNV() {
        return maNV;
    }

    public String getHo() {
        return ho;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getPhai() {
        return phai;
    }

    public int getTuoi() {
        return tuoi;
    }

    public double getTienLuong() {
        return tienLuong;
    }
}
