package com.ifi.covidweb.entity;

public class Test {
    public static void main(String[] args) {

        PatientBuilder patientBuilder = new PatientConcreteBuilder()
                .setName("Vinh")
                .setAge(12);

        System.out.println(patientBuilder.build());
    }
}
