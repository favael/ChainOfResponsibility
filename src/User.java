import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private User nextUser;
    private String name;
    private String surname;
    private Sex sex;
    private String id;
    private String birthday;


    public void setNextUser (User nextUser) {
        this.nextUser = nextUser;
    }


    public String getName () {
        return name;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getSurname () {
        return surname;
    }

    public void setSurname (String surname) {
        this.surname = surname;
    }

    public Sex getSex () {
        return sex;
    }

    public void setSex (Sex sex) {
        this.sex = sex;
    }

    public User (String name, String surname, Sex sex, String id, String birthday) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.id = id;
        this.birthday = birthday;
    }

    public String getBirthday () {
        return birthday;
    }

    public void setBirthday (String birthday) {
        this.birthday = birthday;
    }

    public User getNextUser () {
        return nextUser;
    }

    void checkBirthday (String birthday) {
        if (!birthday.equals("")) {
            String[] actualValue = birthday.split("-");
            List<Integer> integers = new ArrayList<>();

            for (String s : actualValue) {
                int i = Integer.parseInt(s);
                integers.add(i);
            }

            if (integers.get(0) <= 0 || integers.get(0) > 31) {
                System.out.println("Month have max 31days! Try Again!");
            } else if (integers.get(1) < 1 || integers.get(1) > 12) {
                System.out.println("Year have max 12 months! Try Again!");
            } else {
                System.out.println("Correct " + getName() + "'s birthday!  " + birthday);
            }
            if (getNextUser() != null)
                nextUser.checkBirthday(nextUser.getBirthday());
        } else if (getNextUser() != null) {
            System.out.println("Please put a date of born! Try again");
        nextUser.checkBirthday(nextUser.getBirthday());
    }
}}


enum Sex {
    Male, Female;
}
/*
Napisz mechanizm walidacji obiektu klasy User za pomocą łańcucha zobowiązań.
Klasa User powinna zawierać następujące pola:
- imię,
- nazwisko,
- płeć,
- id
- data urodzenia

Mechanizm powinien sprawdzać następujące rzeczy:
- czy data urodzenia jest przekazana w formacie dd-MM-yyyy
- czy id zawiera strukturę numery dowodu osobistego
- czy imię kończy się na w przypadku płci żeńskie,
  i czy nie kończy się na w przypadku płci męskiej
 */