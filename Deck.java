package com.bham.pij.assignments.pontoon;
/**
 * @author Anwin Robin
 */

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

  private Card.Suit       theSuit;
  private Card.Value      theValue;
  private ArrayList<Card> theDeck;
  private Card            aCard;

  public Deck() {
    reset();
    shuffle();
  }

  public void reset() {
    theDeck = new ArrayList<>(52);
    for (int i = 0; i < 52;) {
      while (i < 13) {
        theDeck.add(aCard);
        theSuit  = Card.Suit.values()[0];
        theValue = Card.Value.values()[i];
        Card card = new Card(theSuit, theValue);
        theDeck.set(i, card);
        ++i;
      }
      while (i < 26) {
        theDeck.add(aCard);
        theSuit  = Card.Suit.values()[1];
        theValue = Card.Value.values()[i - 13];
        Card card = new Card(theSuit, theValue);
        theDeck.set(i, card);
        ++i;
      }
      while (i < 39) {
        theDeck.add(aCard);
        theSuit  = Card.Suit.values()[2];
        theValue = Card.Value.values()[i - 26];
        Card card = new Card(theSuit, theValue);
        theDeck.set(i, card);
        ++i;
      }
      while (i < 52) {
        theDeck.add(aCard);
        theSuit  = Card.Suit.values()[3];
        theValue = Card.Value.values()[i - 39];
        Card card = new Card(theSuit, theValue);
        theDeck.set(i, card);
        ++i;
      }
    }
  }

  public void shuffle() {
    Collections.shuffle(theDeck);
  }

  public Card getCard(int i) {
    aCard = theDeck.get(i);
    return aCard;
  }

  public Card dealRandomCard() {
    shuffle();
    aCard = theDeck.get(1);
    theDeck.remove(1);
    return aCard;

  }

  public int size() {
    return theDeck.size();
  }
}
