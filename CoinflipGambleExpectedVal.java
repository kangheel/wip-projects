public class CoinflipGambleExpectedVal {
    public static void main(String[] args) {
        int winnings = 0;
        int money_used = 0;
        for (int i = 0; i < 1000000; i++) {
            int bal = 1;
            money_used++;
            
            for (int j = 0; j < 10; j++) {
                double random = Math.random();
                if (random >= 0.5) {
                    bal = 0;
                    break;
                }
                else if (random < 0.5) {
                    bal *= 2;
                }
            }
            winnings += bal;
            if (i % 1000 == 999) { 
                System.out.println("Trial "  + (i+1)+": Winnings - " + winnings + ", Money Spent - " + money_used + ", Profit - " + (winnings-money_used));   
            }
        }
    }
}