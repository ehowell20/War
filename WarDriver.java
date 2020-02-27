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
        // true if human turn
        boolean isHuman = false;
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
            isRoyal = printCard(card);
            // while royals are played, players alternate playing cards
            // mark that isHuman = false since comp plays first royal round
            isHuman = false;
            while (isRoyal)
            {
                chances = deck.cardChance(card);
                while (chances > 0)
                {
                    pause();
                    // print card
                    isRoyal = printCard(card);
                    // if royal, exit while loop
                    if (isRoyal)
                    {
                        break;
                    }
                    chances--;
                }
                // marks who is playing each round (will switch everytime another royal is placed)
                isHuman = !isHuman;
            }
            // if human loses, give pile to comp
            if (isHuman)
            {
                compCardsWon = 0;
            }
            // if comp loses, give pile to human
            else
            {
                playerCardsWon = 0;
            }
            // computer turn
            // picks a random card
            card = deck.pickCard();
            // print card
            isRoyal = printCard(card);
            // set isHuman to true since first move after royal must be human
            // while royals are played, players alternate playing cards
            while (isRoyal)
            {
                // updates number of chances
                chances = deck.cardChance(card);
                System.out.println("You have " + chances + " tries to place down a royal");
                while (chances > 0)
                {
                    pause();
                    // print card
                    isRoyal = printCard(card);
                    // if royal, exit while loop
                    if (isRoyal)
                    {
                        break;
                    }
                    chances--;
                }
                // marks who is playing each round (will switch everytime another royal is placed)
                isHuman = !isHuman;
            }
            // if human loses, give pile to comp
            if (isHuman)
            {
                compCardsWon = 0;
            }
            // if comp loses, give pile to human
            else
            {
                playerCardsWon = 0;
            }
        }
    }
    public static void pause()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Press any key to place a card");
        in.nextLine();
    }
    public static boolean printCard(int card)
    {
        // if card value is 1, 11, 12, or 13 show face letter (A, J, Q, K)
        // if royal, mark isRoyal as true
        switch (card)
        {
            default:
                // print out original card value
                System.out.println(card);
                return false;
            case 1:
                System.out.println("A");
                return true;
            case 11:
                System.out.println("J");
                return true;
            case 12:
                System.out.println("Q");
                return true;
            case 13:
                System.out.println("K");
                return true;
        }
    }
}