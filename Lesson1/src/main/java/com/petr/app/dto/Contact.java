package com.petr.app.dto;

import lombok.*;

public class Contact {
    @NonNull
    private String fullName;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String email;

    public Contact(@NonNull String fullName, @NonNull String phoneNumber, @NonNull String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Геттеры и сеттеры

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return fullName + " | " + phoneNumber + " | " + email;
    }

    public String toNewLine() {
        return fullName + ';' + phoneNumber + ';' + email;
    }
}
