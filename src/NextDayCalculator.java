import java.util.Scanner;

public class NextDayCalculator {
    //check leap year
    public static boolean checkLeapYear(int year) {
        boolean checkLeapYear = true;
        if (year % 400 == 0) checkLeapYear = true;
        else {
            if (year % 100 == 0) checkLeapYear = false;
            else {
                return (year % 4 == 0);
            }
        }
        return checkLeapYear;
    }

    //check valid date
    public static boolean checkValidDate(int day, int month, int year) {
        boolean dateValid;
        boolean dayValid = day > 0 && day <= 31;
        boolean monthValid = month > 0 && month <= 12;
        boolean yearValid = year > 0;

        switch (month) {
            case 2:
                if ((checkLeapYear(year))) dayValid = (day <= 29);
                else dateValid = (day <= 28);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayValid = (day <= 30);
                break;
        }
        dateValid = dayValid && monthValid && yearValid;
        return dateValid;
    }

    //get next day of input date
    public static String getNextDay(int day, int month, int year) {
        int nextDay = day + 1;
        switch (month) {
            case 2:
                if ((checkLeapYear(year)) && nextDay > 29) {
                    nextDay = 1;
                    month += 1;
                } else {
                    if ((!checkLeapYear(year)) && nextDay > 28) {
                        nextDay = 1;
                        month += 1;
                    }
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if (nextDay > 31) {
                    nextDay = 1;
                    month += 1;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (nextDay > 30) {
                    nextDay = 1;
                    month += 1;
                }
                break;
            case 12:
                if (nextDay > 31) {
                    nextDay = 1;
                    month = 1;
                    year += 1;
                }
                break;
        }
        String date = nextDay + "/" + month + "/" + year;
        return date;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int day, month, year;
        boolean dateValid;
        do {
            System.out.print("Enter day: ");
            day = input.nextInt();
            System.out.print("Enter month: ");
            month = input.nextInt();
            System.out.print("Enter year: ");
            year = input.nextInt();
            dateValid = checkValidDate(day, month, year);
            if (!dateValid) System.out.println("Invalid date");
        } while (!dateValid);
    System.out.print("Next day is: " + getNextDay(day, month, year));
    }
}
