package com.otie.gdstruc.midterms;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CardStack playerDeck = new CardStack(30);
        CardStack discardedPile = new CardStack(30);
        CardStack holding = new CardStack(30);

        Scanner scanner = new Scanner(System.in);   //This allows user input

        //Add cards to the playerDeck
        for (int i = 0; i < 30; i++)
        {
            Card card = new Card("Card_" + (i + 1));  //Create 30 cards with a generic name for the player deck
            playerDeck.push(card);
        }

        Random commandList = new Random(); //To randomize the chosen command in each round
        int command;

        // Random generators to randomize the amount of cards getting transferred in each round
        Random cardsToDraw = new Random();
        Random cardsToDiscard = new Random();
        Random cardsToGetFromPile = new Random();
        int number;

        while (!playerDeck.isEmpty())   //This loop will continue until the player deck becomes empty
        {
            command = commandList.nextInt(3) + 1;  //Each command has a 1/3 chance of happening

            System.out.println("Command chosen: " + command);

            if (command == 1)  //Run the draw command
            {
                System.out.println("*DRAW X CARDS FROM THE PLAYER DECK*");
                number = cardsToDraw.nextInt(5) + 1;  //We add 1 to get a value from 1 to 5

                System.out.println("Cards in the player deck: " + playerDeck.size());
                System.out.println("Number of cards to draw: " + number);

                for (int i = 0; i < number; i++)
                {
                    if (playerDeck.isEmpty())  //Break or end the command here if the player deck is already empty
                    {
                        break;
                    }
                    holding.push(playerDeck.pop());  //This puts a card at the top of the holding stack
                }
            }
            else if (command == 2)  //Run the discard command
            {
                System.out.println("*DISCARD X CARDS INTO THE DISCARDED PILE*");
                number = cardsToDiscard.nextInt(5) + 1;

                System.out.println("Cards in your deck: " + holding.size());
                System.out.println("Number of cards to discard: " + number);

                if (holding.isEmpty())  //Nothing gets discarded if the player isn't holding any cards
                {
                    System.out.println("No cards in the player's hand to discard");
                }
                else
                {
                    for (int i = 0; i < number; i++)
                    {
                        if (holding.isEmpty())  //Break or end the command here if there are no more cards to discard
                        {
                            break;
                        }
                        discardedPile.push(holding.pop());  //This places a card at the top of the discarded pile stack
                    }
                }
            }
            else if (command == 3)   //Get x cards from the discarded pile
            {
                System.out.println("*GET X CARDS FROM THE DISCARDED PILE*");
                number = cardsToGetFromPile.nextInt(5) + 1;

                System.out.println("Number of cards to get from pile: " + number);
                System.out.println("Cards in the discarded deck: " + discardedPile.size());

                if (discardedPile.isEmpty())
                {
                    System.out.println("No cards in the discarded pile to get");
                }
                else
                {
                    for (int i = 0; i < number; i++)
                    {
                        if (discardedPile.isEmpty())  //Break or end the command here if the discarded pile is empty already
                        {
                            break;
                        }
                        holding.push(discardedPile.pop());  //This places a card at the top of the holding stack
                    }
                }
            }
            System.out.println("Cards that the player is currently holding:");
            holding.printStack();
            System.out.println("Number of remaining cards in the player deck: " + playerDeck.size());
            System.out.println("Number of cards in the discarded pile: " + discardedPile.size());
            System.out.println();   // Just to add space in between lines
            System.out.println("Type anything or just press ENTER to continue to the next round");
            String input = scanner.nextLine();
            if (input.equals("") || input.equals("\n"))  // Check if user just presses the enter key to avoid having to press enter twice
            {
                System.out.println();  // Just to add space in between lines
                continue;  // Continue on to the next round as normal
            }
            System.out.println();   // Just to add space in between lines
        }
    }
}