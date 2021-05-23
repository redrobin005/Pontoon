package com.bham.pij.assignments.pontoon;
/**
 * @author Anwin Robin
 */

public class Pontoon extends CardGame {

  public Pontoon(int numPlayers) {
    super(numPlayers);
  }

  @Override
  public void dealInitialCards() {
    // deal 2 random cards from the deck to every player in the game
    for (int i = 0; i < getNumPlayers(); i++) {
      getPlayer(i).dealToPlayer(getDeck().dealRandomCard());
      getPlayer(i).dealToPlayer(getDeck().dealRandomCard());
    }

  }

  @Override
  public int compareHands(Player hand1, Player hand2) {
    if (isPontoon(hand1) && isPontoon(hand2)) {
      return 0;
    } else if (isPontoon(hand1)) {
      return -1;
    } else if (isPontoon(hand2)) {
      return 1;
    } else if (isFiveCardTrick(hand1) && isFiveCardTrick(hand2)) {
      return 0;
    } else if (isFiveCardTrick(hand1)) {
      return -1;
    } else if (isFiveCardTrick(hand2)) {
      return 1;
    } else if (hand1.getBestNumericalHandValue() >
               hand2.getBestNumericalHandValue()) {
      return -1;
    } else if (hand1.getBestNumericalHandValue() <
               hand2.getBestNumericalHandValue()) {
      return 1;
    } else return 0;
  }

  public Boolean isPontoon(Player hand) {
    if (hand.getHandSize() == 2 && hand.getBestNumericalHandValue() == 21) {
      return true;
    } else
      return false;
  }

  public Boolean isFiveCardTrick(Player hand) {
    if (hand.getHandSize() == 5 && hand.getBestNumericalHandValue() == 21) {
      return true;
    } else
      return false;
  }
}