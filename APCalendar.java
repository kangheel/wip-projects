public class APCalendar {
    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 == 0 ^ year % 400 != 0);
    }
    public static void main(String[] args) {
        System.out.println(isLeapYear(2004));
        System.out.println(numberOfLeapYears(2000, 2012));
    }
    private static int numberOfLeapYears(int year1, int year2) {
        int ret = 0;
        for (int i = year1; i <= year2; i++) {
            if (isLeapYear(i)) {
                ret++;
            }
        }
        return ret;
    }
    private static int dayOfWeek(int month, int day, int year) {
        return (firstDayOfYear(year)+dayOfYear(month, day, year)) % 7;
    }

    private static int dayOfYear(int month, int day, int year) {
        return 0;
    }

    private static int firstDayOfYear(int year) {
        return 0;
    }
}