package com.ifi.covidweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "CV_USER")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

}