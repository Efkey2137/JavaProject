package com.example.demo4;

public class Uzytkownik {
    public String name;
    public int age;
    public String gender;

    public Uzytkownik(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "["+name+" "+age+" - "+gender+"]";
    }
}
