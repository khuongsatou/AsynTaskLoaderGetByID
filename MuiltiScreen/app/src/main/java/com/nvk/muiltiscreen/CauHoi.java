package com.nvk.muiltiscreen;

public class CauHoi {
    private int id;
    private String noiDung;
    private int linhVucID;
    private String phuongAnA;
    private String phuongAnB;
    private String phuongAnC;
    private String phuongAnD;
    private String dapAn;
    private Boolean xoa;

    public CauHoi() {
    }

    public CauHoi(int id, String noiDung, int linhVucID, String phuongAnA, String phuongAnB, String phuongAnC, String phuongAnD, String dapAn, Boolean xoa) {
        this.id = id;
        this.noiDung = noiDung;
        this.linhVucID = linhVucID;
        this.phuongAnA = phuongAnA;
        this.phuongAnB = phuongAnB;
        this.phuongAnC = phuongAnC;
        this.phuongAnD = phuongAnD;
        this.dapAn = dapAn;
        this.xoa = xoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getLinhVucID() {
        return linhVucID;
    }

    public void setLinhVucID(int linhVucID) {
        this.linhVucID = linhVucID;
    }

    public String getPhuongAnA() {
        return phuongAnA;
    }

    public void setPhuongAnA(String phuongAnA) {
        this.phuongAnA = phuongAnA;
    }

    public String getPhuongAnB() {
        return phuongAnB;
    }

    public void setPhuongAnB(String phuongAnB) {
        this.phuongAnB = phuongAnB;
    }

    public String getPhuongAnC() {
        return phuongAnC;
    }

    public void setPhuongAnC(String phuongAnC) {
        this.phuongAnC = phuongAnC;
    }

    public String getPhuongAnD() {
        return phuongAnD;
    }

    public void setPhuongAnD(String phuongAnD) {
        this.phuongAnD = phuongAnD;
    }

    public String getDapAn() {
        return dapAn;
    }

    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }

    public Boolean getXoa() {
        return xoa;
    }

    public void setXoa(Boolean xoa) {
        this.xoa = xoa;
    }
}
