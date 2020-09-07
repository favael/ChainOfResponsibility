package Users;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private User nextUser;
    private final String name;
    private final String birthday;

    public void setNextUser (User nextUser) {
        this.nextUser = nextUser;
    }

    public String getName () {
        return name;
    }

    public User (String name, String surname, Sex sex, String id, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getBirthday () {
        return birthday;
    }

    public User getNextUser () {
        return nextUser;
    }

    public void checkBirthday (String birthday) {
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
    }
}


/*
Napisz mechanizm walidacji obiektu klasy Users.User za pomocą łańcucha zobowiązań.
Klasa Users.User powinna zawierać następujące pola:
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