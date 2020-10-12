package org.sid.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Id
    private  int balance;
    @ManyToOne
    private Company company;

    public User() {
    }

    public User(int balance, Company company) {
        this.balance = balance;
        this.company = company;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
