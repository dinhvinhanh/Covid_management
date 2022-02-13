package com.ifi.covidweb.entity;

import javax.persistence.Column;
import java.util.Date;

public class PatientConcreteBuilder implements PatientBuilder{

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

    @Override
    public PatientBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public PatientBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PatientBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public PatientBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public PatientBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public PatientBuilder setInjectTime(Integer injectTime) {
        this.injectTime = injectTime;
        return this;
    }

    @Override
    public PatientBuilder setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public PatientBuilder setDiscoveryDay(Date discoveryDay) {
        this.discoveryDay = discoveryDay;
        return this;
    }

    @Override
    public PatientBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public PatientBuilder setIconPath(String iconPath) {
        this.iconPath = iconPath;
        return this;
    }

    public Patient build() {
        return new Patient(id, name, age, gender, status, injectTime, birthday, discoveryDay, address, iconPath);
    }

}


