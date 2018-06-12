package edu.cnm.deepdive.cards;

import edu.cnm.deepdive.cards.Deck.InsufficientCardsException;
import java.util.Arrays;
import java.util.Scanner;

public class InteractiveBlackjackHand extends BlackjackHand {

  private Scanner scanner;

  public InteractiveBlackjackHand(Deck deck, Scanner scanner) throws InsufficientCardsException {
    super(deck);
    this.scanner = scanner;
  }

  @Override
  public void play() throws InsufficientCardsException {
    boolean stay = false;
    while (!isBusted() && (getValue() < 21) && !stay) {
      showHand();
      Boolean hit = null;
      while (hit == null) {
        System.out.print("Hit? [Y/n]");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.isEmpty() || input.charAt(0) == 'y') {
          hit = true;
          hit();
        } else if (input.charAt(0) == 'n') {
          hit = false;
          stay = true;
        }
      }
    }
    if (!stay) {
      showHand();
    }
  }

  private void showHand() {
    String status;
    if (isBusted()) {
      status = "busted!";
    } else if (isBlackjack()) {
      status = "Blackjack!";
    } else {
      status = String.format("%d", getValue());
    }
    System.out.printf("Current hand: %s (%s)%n",
        Arrays.toString(getHand()), status);
  }
}
