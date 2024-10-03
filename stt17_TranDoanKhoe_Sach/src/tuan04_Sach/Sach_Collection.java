package tuan04_Sach;

import java.io.Serializable;
import java.util.ArrayList;


public class Sach_Collection implements Serializable{
	private ArrayList<Sach> listSach;

	public Sach_Collection() {
		listSach = new ArrayList<Sach>();
	}
	
	public boolean themSach(Sach sach) {
		if(listSach.contains(sach))
			return false;
		else {
			listSach.add(sach);
			return true;
		}
	}
	
	public Sach timKiemSach(String maSachTK) {
		for (Sach sach : listSach) {
			if(sach.getMaSach().equalsIgnoreCase(maSachTK)) {
				return sach;
			}
		}
		return null;
	}
	
	public boolean xoaSach(String maSachXoa) {
		Sach sachXoa = timKiemSach(maSachXoa);
		if(sachXoa != null)
		{
			listSach.remove(sachXoa);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void suaSach(String maSachSua, Sach sachMoi) {
	    Sach sachCanSua = timKiemSach(maSachSua);
	    
	    if (sachCanSua != null) {
	        sachCanSua.setTuaSach(sachMoi.getTuaSach());
	        sachCanSua.setNamXuatBan(sachMoi.getNamXuatBan());
	        sachCanSua.setSoTrang(sachMoi.getSoTrang());
	        sachCanSua.setTacGia(sachMoi.getTacGia());
	        sachCanSua.setNhaXuatBan(sachMoi.getNhaXuatBan());
	        sachCanSua.setDonGia(sachMoi.getDonGia());
	        sachCanSua.setISBN(sachMoi.getISBN());
	    }else 
	    	return;
	}


	public ArrayList<Sach> getListSach() {
		return listSach;
	}

	public void setListSach(ArrayList<Sach> listSach) {
		this.listSach = listSach;
	}
	
	public Sach getElement(int index) {
		if(index <0 || index >= listSach.size())
			return null;
		return listSach.get(index);
	}
	
	public int getSize() {
		return listSach.size();
	}
}
