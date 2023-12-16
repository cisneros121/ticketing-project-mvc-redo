package com.cydeo.enums;

public enum Gender {

    MALE("male"),FEMALE("female"),STATUS("IN PROGRESS");

private final String value;

    Gender(String value){

this.value=value;

    }


    public String getGender(){

        return value;
    }


}
