package com.example.pandemikent.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name ="vaccineCertificate")
public class VaccineCertificate {
    @Id
    @Column
    private String username;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public VaccineCertificate() {

    }

    public VaccineCertificate(String username, String fileName, String fileType, byte[] data) {
        this.username = username;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

}
