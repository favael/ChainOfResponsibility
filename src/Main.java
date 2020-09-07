public class Main {
    public static void main (String[] args) {
        User[] users = {
                new UserRaf("Rafal", "Dogoda", Sex.Male, "ABC12345", "26-09-1986"),
                new UserDom("Dominika", "Zagorska", Sex.Female, "CDE92912", "08-12-1995"),
                new UserGreg("Grzegorz", "Skrzypczak", Sex.Male, "GFH723847", ""),
                new UserJessica("Jessica", "Kowalska", Sex.Female, "WD212732", "30-02-2002"),
                new UserJanusz("Janusz", "Bolkowski", Sex.Male, "ZXC209438", "02-01-1980"),
                new UserFranek("Franciszek", "Smuda", Sex.Male, "YTR435478", "01-01-997")
        };

    users[0].setNextUser(users[1]);
    users[1].setNextUser(users[2]);
    users[2].setNextUser(users[3]);
    users[3].setNextUser(users[4]);
    users[4].setNextUser(users[5]);

users[0].checkBirthday(users[0].getBirthday());
    }
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

