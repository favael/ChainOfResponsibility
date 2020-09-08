package Users;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class User {
    static int numberOfErrors;
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
        String trim = birthday.trim();
        int iv1 = trim.indexOf("-");
        int iv2 = trim.lastIndexOf("-");

        if ((iv1 != 0 && iv1 <= 2) && iv2 - iv1 <= 3) {
            if (birthday.equals("")) {
                System.out.println(getName() + " - Correct birthday should look dd-MM-yyy");
                if (getNextUser() != null) {
                    nextUser.checkBirthday(nextUser.getBirthday());
                }
            }
            if (!birthday.equals("")) {
                String[] actualValue = birthday.split("-");
                List<Integer> integers = new ArrayList<>();
                for (String s : actualValue) {
                    int dateParsedToInt = Integer.parseInt(s);
                    integers.add(dateParsedToInt);
                }
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int yourAge = year - integers.get(2);
                if (yourAge > 100) {
                    System.out.println(getName() + "- Congratulation get " + yourAge + " years, if not put correct birthday date!");
                }
                if (yourAge < 0) {
                    System.out.println(getName() + " - You not born yet:(");
                }

                if (integers.get(1) == 2 && integers.get(0) > 28) {
                    System.out.println(getName() + "- February in " + integers.get(2) + " have max 28 days!");
                }

                if (integers.get(1) == 2 && integers.get(0) > 29 && integers.get(2) % 4 == 0) {
                    System.out.println(getName() + "- February in " + integers.get(2) + " have max 29 days!");
                }

                if (integers.get(1) % 2 != 0 && integers.get(0) != 0) {
                    if (integers.get(0) <= 0 || integers.get(0) > 30) {
                        System.out.println(getName() + "- Even month have max 30 day's! Try Again!");
                    }
                }

                if (integers.get(1) % 2 == 1 && integers.get(0) > 31 && integers.get(1) <=12) {
                    System.out.println(getName() + "- Even month have max 31 day's! Try Again!");
                }
                if (integers.get(0) == 0) {
                    System.out.println(getName() + "- Please add day of Your born! Try Again!");
                }
                if (integers.get(1) == 0) {
                    System.out.println(getName() + "- Please add month of Your born! Try Again!");
                }
                if ((integers.get(1) < 1 || integers.get(1) > 12) &&  integers.get(0) != 0) {
                    System.out.println(getName() + "- Year have max 12 months! Try Again!");
                }

                if (getNextUser() != null) {
                    nextUser.checkBirthday(nextUser.getBirthday());
                }
            }
        } else {
            System.out.println(getName() + " - Correct DOB should look dd-MM-yyyy");
        }
    }
}