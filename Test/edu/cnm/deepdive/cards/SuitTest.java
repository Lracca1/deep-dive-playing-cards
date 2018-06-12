package edu.cnm.deepdive.cards;

import static edu.cnm.deepdive.cards.Suit.CLUBS;
import static java.lang.Enum.valueOf;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SuitTest {

  private static final String[] SUIT_SYMBOLS = {
      "\u2663",
      "\u2666",
      "\u2665",
      "\u2660",
  };

  @Test
  void testToString() {
    for(Suit suit : Suit.values()) {
      assertTrue(suit.toString().equals(SUIT_SYMBOLS[suit.ordinal()]));
      System.out.println(suit);
    }
  }
}