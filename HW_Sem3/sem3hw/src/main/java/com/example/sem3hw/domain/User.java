package com.example.sem3hw.domain;

public class User {
    //region Поля
    private String name;
    private String email;
    private int age;
    //endregion
    //region Вспомогательные методы
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //endregion
}
