package com.sb.entity;

public enum AddressType {

    HOME("Home Address"),
    WORK("Work Address"),
    OTHER("Other");

    public final String value;

    private AddressType(String value) {
        this.value = value;
    }
}
