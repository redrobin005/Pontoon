package com.bham.pij.assignments.pontoon;
// @author Anwin Robin

import java.util.ArrayList;
import java.util.Collections;

public class Player {
  private String             name;
  private ArrayList<Integer> numericalHandValue;
  private int                totalHandVal;
  private int                bestNumericalHandValue;
  private ArrayList<Card>    cards = new ArrayList<>();
  private int                handSize;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void dealToPlayer(Card card) {
    if (cards.size() == 0) {
      numericalHandValue = new ArrayList<>();
      handSize = 0;
      totalHandVal = 0;
      bestNumericalHandValue = 0;
    }
    cards.add(card);
    ++handSize;
    sortHandValue(card);
  }

  public void sortHandValue(Card card) {
    if (handSize == 1) {
      numericalHandValue.add(0);
    }
    if (card.getValue() == Card.Value.ACE) {
      // add an extra element with the value of the previous first element
      numericalHandValue.add(numericalHandValue.get(0));
      // add 1 to the first element
      totalHandVal = numericalHandValue.get(0);
      totalHandVal += card.getNumericalValue().get(0);
      numericalHandValue.set(0, totalHandVal);
      // add 11 to remaining elements starting with index 1
      for (int i = 1; i < numericalHandValue.size(); ++i) {
        totalHandVal = numericalHandValue.get(i);
        totalHandVal += card.getNumericalValue().get(1);
        numericalHandValue.set(i, totalHandVal);
      }
    }
    // else if no an ace just add the current card value to the existing vals
    else {
      for (int i = 0; i < numericalHandValue.size(); ++i) {
        totalHandVal = numericalHandValue.get(i);
        totalHandVal += card.getNumericalValue().get(0);
        numericalHandValue.set(i, totalHandVal);
      }
    }
    Collections.sort(numericalHandValue);
  }

  public void removeCard(Card card) {
    cards.remove(card);
    --handSize;
  }

  public ArrayList<Integer> getNumericalHandValue() {
    return numericalHandValue;
  }

  public int getBestNumericalHandValue() {
    for (int i = (numericalHandValue.size() - 1); i >= 0; i--) {
//      if (numericalHandValue.get(i) <= 21) {
//        bestNumericalHandValue = numericalHandValue.get(i);
//        return bestNumericalHandValue;
//      }
      bestNumericalHandValue = numericalHandValue.get(i);
      return bestNumericalHandValue;
    }
    return bestNumericalHandValue;
  }



  public ArrayList<Card> getCards() {
    return cards;
  }

  public void setCards(ArrayList<Card> cards) {
    this.cards = cards;
  }

  public int getHandSize() {
    return handSize;
  }

}