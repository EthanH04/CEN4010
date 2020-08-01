package com.bookstore.BookStoreDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Authors {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer authorId;
    @Column(name = "firstName")
    private String fname;
    @Column(name = "lastName")
    private String lname;
    @Column(name = "biography")
    private String bio;
    @Column(name = "publisher")
    private String publisher;
    
    public Authors() {
        
    }

    public Integer getId() {
        return authorId;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getBio() {
        return bio;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setId(Integer authorId) {
        this.authorId = authorId;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
}
