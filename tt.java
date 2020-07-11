public class tt {
    public static void main(String[] args) {
        longestStreak("CCAAAAATTT!");
    }
    public static void longestStreak(String str) {
        String prev = str.substring(0,1);
        int streak = 0;
        int maxStreak = 0;
        char maxStreakChar = '1';
        for (int i = 1; i < str.length()-1; i++) {
            String cur = str.substring(i,i+1);
            if (prev.equals(cur)) {
                streak++;
            }
            else {
                prev = cur;
                if (maxStreak < streak) {
                    maxStreakChar = str.charAt(i-1);
                }
                maxStreak = streak;
            }
        }
        System.out.println(maxStreakChar + " " + maxStreak);
    }
}