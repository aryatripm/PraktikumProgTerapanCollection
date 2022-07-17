package com.arya.tugas2_praktikum;

public class Student {
    private Integer nrp;
    private String nama;
    private Integer nilaiIpa;
    private Integer nilaiIps;

    public Student(Integer nrp, String nama, Integer nilaiIpa, Integer nilaiIps) {
        this.nrp = nrp;
        this.nama = nama;
        this.nilaiIpa = nilaiIpa;
        this.nilaiIps = nilaiIps;
    }

    public Integer getNrp() {
        return nrp;
    }

    public void setNrp(Integer nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getNilaiIpa() {
        return nilaiIpa;
    }

    public void setNilaiIpa(Integer nilaiIpa) {
        this.nilaiIpa = nilaiIpa;
    }

    public Integer getNilaiIps() {
        return nilaiIps;
    }

    public void setNilaiIps(Integer nilaiIps) {
        this.nilaiIps = nilaiIps;
    }

    @Override
    public String toString() {
        return nama;
    }
}
