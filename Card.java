package com.bham.pij.assignments.pontoon;
/**
 * @author Anwin Robin
 */

import java.util.ArrayList;

public class Card {
  // enums created
  public static enum Suit {CLUBS, HEARTS, DIAMONDS, SPADES;}
  public static enum Value {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
    JACK, QUEEN, KING
  }

  //fields created that are enum type
  private Suit  suit;
  private Value value;

  // arraylist to store numerical values
  private ArrayList<Integer> numericalValue = new ArrayList<Integer>();

  // constructor takes enum type parameters and assigns these to the fields
  public Card(Suit suitPara, Value valPara) {
    setSuit(suitPara);
    setValue(valPara);
  }

  // setters and getters
  public Suit getSuit() { return suit; }
  public void setSuit(Suit s) { suit = s; }
  public Value getValue() {
    return value;
  }
  public void setValue(Value v) {
    value = v;
    if(value == Value.ACE){
      numericalValue.add(0, 1);
      numericalValue.add(1, 11);
    }
    else {
      switch (value){
        case TWO: numericalValue.add(2); break;
        case THREE: numericalValue.add(3); break;
        case FOUR: numericalValue.add(4); break;
        case FIVE: numericalValue.add(5); break;
        case SIX: numericalValue.add(6); break;
        case SEVEN: numericalValue.add(7); break;
        case EIGHT: numericalValue.add(8); break;
        case NINE: numericalValue.add(9); break;
        case TEN:
        case JACK:
        case QUEEN:
        case KING: numericalValue.add(10); break;
      }
    }
  }

  public ArrayList<Integer> getNumericalValue() {
    return numericalValue;
  }

}