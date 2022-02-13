package com.ifi.covidweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "CV_PATIENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {
    private static final long serialVersionUID = 1L;
    @SequenceGenerator(
            name = "CV_PATIENT_GENERATOR", sequenceName = "CV_PATIENT_SEQ", allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CV_PATIENT_GENERATOR")
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "INJECT_TIME")
    private Integer injectTime;
    @Column(name = "BIRTHDAY")
    private Date birthday;
    @Column(name = "DISCOVERY_DAY")
    private Date discoveryDay;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "ICON_PATH")
    private String iconPath;

    public Patient(String name, Integer age, String gender, String status, Integer injectTime, Date birthday, Date discoveryDay, String address, String iconPath) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.status = status;
        this.injectTime = injectTime;
        this.birthday = birthday;
        this.discoveryDay = discoveryDay;
        this.address = address;
        this.iconPath = iconPath;
    }
}
