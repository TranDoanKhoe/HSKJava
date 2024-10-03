package tuan04_Sach;

import java.io.Serializable;
import java.util.Objects;

public class Sach implements Serializable{
	private String maSach;
	private String tuaSach;
	private int namXuatBan;
	private int soTrang;
	private String tacGia;
	private String nhaXuatBan;
	private double donGia;
	private String ISBN;
	
	public Sach() {
		
	}
	
	public Sach(String maSach, String tuaSach, int namXuatBan, int soTrang, String tacGia, String nhaXuatBan,
			double donGia, String iSBN) {
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.namXuatBan = namXuatBan;
		this.soTrang = soTrang;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.donGia = donGia;
		this.ISBN = iSBN;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTuaSach() {
		return tuaSach;
	}

	public void setTuaSach(String tuaSach) {
		this.tuaSach = tuaSach;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}

	@Override
	public String toString() {
		return String.format("Ma sach: %s - Tua sach: %s - Nam Xuat Ban: %d - So Trang: %d - Tac Gia: %s - Nha Xuat Ban: %s - Don Gia: %.2f - ISBN: %s\n", 
				maSach, tuaSach, namXuatBan, soTrang, tacGia, nhaXuatBan, donGia, ISBN);
	}
}
