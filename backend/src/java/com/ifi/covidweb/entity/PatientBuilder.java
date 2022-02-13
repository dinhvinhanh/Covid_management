package com.ifi.covidweb.entity;

import java.util.Date;

public interface PatientBuilder {

    PatientBuilder setId(Integer id);

    PatientBuilder setName(String name);

    PatientBuilder setAge(Integer age);

    PatientBuilder setGender(String gender);

    PatientBuilder setStatus(String status);

    PatientBuilder setInjectTime(Integer injectTime);

    PatientBuilder setBirthday(Date birthday);

    PatientBuilder setDiscoveryDay(Date discoveryDay);

    PatientBuilder setAddress(String address);

    PatientBuilder setIconPath(String iconPath);

    Patient build();
}
