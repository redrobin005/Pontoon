package com.bham.pij.assignments.pontoon;
// @author Anwin Robin

import java.util.ArrayList;

public abstract class CardGame {

  private int               players;
  private ArrayList<Player> thePlayers;
  private Deck              gameDeck;

  public CardGame(int nplayers) {
    Deck aDeck = new Deck();
    gameDeck = aDeck;
    this.players = nplayers;
    thePlayers = new ArrayList<>(nplayers);
    for (int i = 0; i < nplayers; i++) {
      String playaName = String.valueOf(i);
      Player playa = new Player(playaName);
      thePlayers.add(playa);
    }
  }

  public abstract void dealInitialCards();

  public abstract int compareHands(Player hand1, Player hand2);

  public Deck getDeck() {
    return gameDeck;
  }

  public Player getPlayer(int i) {
    return thePlayers.get(i);
  }

  public int getNumPlayers() {
    return players;
  }

}