package org.sid.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Company implements Serializable {
    @Id
    private  String name;
    private int balance;
    @OneToMany(mappedBy = "company")
    private Collection<User> users;

    public Company() {
    }

    public Company(String name, int balance, Collection<User> users) {
        this.name = name;
        this.balance = balance;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
