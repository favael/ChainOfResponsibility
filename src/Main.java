import Users.*;

public class Main {
    public static void main (String[] args) {
        User[] users = {
                /*
                To check method which testing DOB change DOB in model
                 */
                new UserRaf("Rafal", "Dogoda", Sex.Male, "ABC12345", "01-1-2000"),
                new UserDom("Dominika", "Zagorska", Sex.Female, "CDE92912", "1-1-2000"),
                new UserGreg("Grzegorz", "Skrzypczak", Sex.Male, "GFH723847", "1-1-2000"),
                new UserJessica("Jessica", "Kowalska", Sex.Female, "WD212732", "1-1-2020"),
                new UserJanusz("Janusz", "Bolkowski", Sex.Male, "ZXC209438", "1-1-2020"),
                new UserFranek("Franciszek", "Smuda", Sex.Male, "YTR435478", "1-1-2020"),
                new UserAndrzejek("Andrzej","Kwasniewski", Sex.Male, "PLC489248", "1-1-2020")
        };

        setNextUser(users);
        users[0].checkBirthday(users[0].getBirthday());
    }

    private static void setNextUser (User[] users) {
        for (int i = 0; i < users.length -1; i++) {
            users[i].setNextUser(users[i +1]);
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

