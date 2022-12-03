package com.dh9c4.buihongson.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "truonghoc")
public class Truonghoc {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "masv_son")
	private long masv;
	@Column(name = "tensv")
	private String tensv;
	@Column(name = "diem")
	private float Diem;
	@Column(name = "dadonghocphi")
	private boolean dadonghocphi;
	@Column(name = "tenlop")
	private String tenlop;
	public Truonghoc() {
	}
	
	
	public Truonghoc(String tensv, float diem, boolean dadonghocphi, String tenlop) {
		super();
		this.tensv = tensv;
		Diem = diem;
		this.dadonghocphi = dadonghocphi;
		this.tenlop = tenlop;
	}


	public long getMasv() {
		return masv;
	}
	public void setMasv(long masv) {
		this.masv = masv;
	}
	public String getTensv() {
		return tensv;
	}
	public void setTensv(String tensv) {
		this.tensv = tensv;
	}
	public float getDiem() {
		return Diem;
	}
	public void setDiem(float diem) {
		Diem = diem;
	}
	public boolean isDadonghocphi() {
		return dadonghocphi;
	}
	public void setDadonghocphi(boolean dadonghocphi) {
		this.dadonghocphi = dadonghocphi;
	}
	public String getTenlop() {
		return tenlop;
	}
	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	@Override
	public String toString() {
		return "Truonghoc [masv=" + masv + ", tensv=" + tensv + ", Diem=" + Diem + ", dadonghocphi=" + dadonghocphi
				+ ", tenlop=" + tenlop + "]";
	}
	
}
