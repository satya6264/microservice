package com.coforge.AdminService.Entity;

import javax.persistence.*;

@Entity
@Table(name="branch_details")
public class BranchDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    int branchId;
    String branchCity;
    String branchName;

    public  BranchDetails(){

    }
    public BranchDetails(String branchCity, String branchName) {
        this.branchCity = branchCity;
        this.branchName = branchName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchCity() {
        return branchCity;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
