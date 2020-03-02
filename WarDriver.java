import java.util.Scanner;

public class WarDriver
{
    public static void main(String[] args)
    {
        // if card = 0 no more cards in deck
        int card = 15;
        // number of cards in center pile
        int center = 0;
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
        // true if a player has placed down a royal within the chances allowed
        boolean hasWon = true;
        // true if royal card played
        boolean isRoyal = false;
        // true if human turn
        boolean isHuman = false;
        // creates new deck of cards
        Cards deck = new Cards();
        // shuffles deck
        deck.shuffleCards();
        System.out.println("Welcome! This game is Egyptian War without the slapping aspect");
        System.out.println("You can win cards when the other player cannot match the royal you put down");
        System.out.println("The number of chances you have will be told once a royal is put down");
        System.out.println("The cards won will be compared at the end and the winner will be announced");
        gameLoop:
        while (card != 0)
        {
            // player turn
            pause();
            // picks a random card
            card = deck.pickCard();
            // if no cards in deck exit game loop
            if (card == 0)
            {
                break gameLoop;
            }
            // add one to number of cards in center pile
            center++;
            // prints that the human placed the card
            System.out.print("Human: " );
            // print card
            isRoyal = printCard(card);
            // while royals are played, players alternate playing cards
            // mark that isHuman = false since comp plays first royal round
            isHuman = false;
            while (isRoyal)
            {
                chances = deck.cardChance(card);
                System.out.println("Chances for royal: " + chances);
                while (chances > 0)
                {
                    // resets royal flag
                    hasWon = false;
                    pause();
                    // play new random card
                    card = deck.pickCard();
                    // if no cards in deck exit game loop
                    if (card == 0)
                    {
                        break gameLoop;
                    }
                    // add one to number of cards in center pile
                    center++;
                    // prints if human or computer card placed
                    if (isHuman)
                    {
                        System.out.print("Human: ");
                    }
                    else
                    {
                        System.out.print("Computer: ");
                    }
                    // print card
                    isRoyal = printCard(card);
                    // if royal, exit while loop
                    if (isRoyal)
                    {
                        // flags that a player has put down a royal in time
                        hasWon = true;
                        break;
                    }
                    chances--;
                }
                if (hasWon)
                {
                    // marks who is playing each round (will switch everytime another royal is placed)
                    isHuman = !isHuman;
                }
            }
            // if human loses, give pile value to comp
            // checks if human last played and if a royal was not played in time
            if (isHuman && !hasWon)
            {
                compCardsWon = center;
                System.out.println("Computer won " + compCardsWon + " cards!");
                // reset pile value
                center = 0;
                // reset no royal played flag
                hasWon = true;
            }
            // if comp loses, give pile value to human
            // checks if human last played and if a royal was not played in time
            else if (!isHuman && !hasWon)
            {
                playerCardsWon = center;
                System.out.println("Human won " + playerCardsWon + " cards!");
                // reset pile value
                center = 0;
                // reset no royal played flag
                hasWon = true;
            }
            // computer turn
            // picks a random card
            card = deck.pickCard();
            // if no cards in deck exit game loop
            if (card == 0)
            {
                break gameLoop;
            }
            // add one to number of cards in center pile
            center++;
            // prints that computer placed the card
            System.out.print("Computer: ");
            // print card
            isRoyal = printCard(card);
            // set isHuman to true since first move after royal must be human
            isHuman = true;
            // while royals are played, players alternate playing cards
            while (isRoyal)
            {
                // updates number of chances
                chances = deck.cardChance(card);
                System.out.println("Chances for royal: " + chances);
                while (chances > 0)
                {
                    // resets royal flag
                    hasWon = false;
                    pause();
                    // play new random card
                    card = deck.pickCard();
                    // if no cards in deck exit game loop
                    if (card == 0)
                    {
                        break gameLoop;
                    }
                    // add one to number of cards in center pile
                    center++;
                    // prints if human or computer card placed
                    if (isHuman)
                    {
                        System.out.print("Human: ");
                    }
                    else
                    {
                        System.out.print("Computer: ");
                    }
                    // print card
                    isRoyal = printCard(card);
                    // if royal, exit while loop
                    if (isRoyal)
                    {
                        // flags that a player has put down a royal in time
                        hasWon = true;
                        break;
                    }
                    chances--;
                }
                if (hasWon)
                {
                    // marks who is playing each round (will switch everytime another royal is placed)
                    isHuman = !isHuman;
                }
            }
            // if human loses, give pile to comp
            // checks if human last played and if a royal was not played in time
            if (isHuman && !hasWon)
            {
                compCardsWon = center;
                System.out.println("Computer won " + compCardsWon + " cards!");
                System.out.println();
                // reset pile value
                center = 0;
                // reset no royal played flag
                hasWon = true;
            }
            // if comp loses, give pile to human
            // checks if human last played and if a royal was not played in time
            else if (!isHuman && !hasWon)
            {
                playerCardsWon = center;
                System.out.println("Human won " + playerCardsWon + " cards!");
                // reset pile value
                center = 0;
                // reset no royal played flag
                hasWon = true;
            }
        }
        System.out.println("No more cards in deck");
        if (playerCardsWon > compCardsWon)
        {
            System.out.println("Human Wins!");
        }
        else if (playerCardsWon < compCardsWon)
        {
            System.out.println("Computer Wins!");
        }
        else
        {
            System.out.println("Draw!");
        }
    }
    public static void pause()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Press enter to play card");
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