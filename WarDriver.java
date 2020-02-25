import java.util.Scanner;

public class WarDriver
{
    public static void main(String[] args)
    {
        int card = 0;
        // player has half deck
        int playerCards = 26;
        // player won cards
        int playerCardsWon = 0;
        // computer has half deck
        int compCards = 26;
        // computer won cards
        int compCardsWon = 0;
        // number of cards player can put down to try and put down a royal
        int chances = 0;
        boolean hasWon = false;
        boolean isRoyal = false;
        // creates new deck of cards
        Cards deck = new Cards();
        // shuffles deck
        deck.shuffleCards();
        while (!hasWon)
        {
            // player turn
            pause();
            // picks a random card
            card = deck.pickCard();
            // print card
            switch (card)
            {
                // if card value is 1, 11, 12, or 13 show face letter (A, J, Q, K)
                // if royal, mark isRoyal as true
                // if royal, change chances value to the number of tries other player has
                default:
                    // print out original card value
                    System.out.println(card);
                    isRoyal = false;
                    break;
                case 1:
                    System.out.println("A");
                    isRoyal = true;
                    chances = 4;
                    break;
                case 11:
                    System.out.println("J");
                    isRoyal = true;
                    chances = 1;
                    break;
                case 12:
                    System.out.println("Q");
                    isRoyal = true;
                    chances = 2;
                    break;
                case 13:
                    System.out.println("K");
                    isRoyal = true;
                    chances = 3;
            }
            // computer turn
            // picks a random card
            card = deck.pickCard();
            // print card
            switch (card)
            {
                // if card value is 1, 11, 12, or 13 show face letter (A, J, Q, K)
                // if royal, mark isRoyal as true
                // if royal, change chances value to the number of tries other player has
                default:
                    // print out original card value
                    System.out.println(card);
                    isRoyal = false;
                    break;
                case 1:
                    System.out.println("A");
                    isRoyal = true;
                    chances = 4;
                    break;
                case 11:
                    System.out.println("J");
                    isRoyal = true;
                    chances = 1;
                    break;
                case 12:
                    System.out.println("Q");
                    isRoyal = true;
                    chances = 2;
                    break;
                case 13:
                    System.out.println("K");
                    isRoyal = true;
                    chances = 3;
            }
            // if royal, human plays cards
            if (isRoyal)
            {
                // human places down cards until hits limit or plays royal
                for (int i = 0; i < chances; i++)
                {
                    pause();
                    // if royal, computer places down cards until hits limit or plays royal
                    // if no royals and chances up, stack count gets added to computer points
                }
            }
        }
    }
    public static void pause()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Press any key to place a card");
        in.nextLine();
    }
}