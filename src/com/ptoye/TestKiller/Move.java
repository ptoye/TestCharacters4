///*
// * Move.java
// *
// * Created on 23 January 2007, 11:34
// *
// * To change this template, choose Tools | Template Manager
// * and open the template in the editor.
// */
//
//package com.ptoye.TestKiller;
//
//import java.awt.Color;
//import java.io.Serializable;
//
///**
// * Represents a primitive change to a single square on the grid.
// * @author PToye
// */
//public class Move implements Serializable {
//  /**
//   * Serialisation ID
//   */
//  final long serialVersionUID = 1L;
//
//  /**
//   * True if this is the first change in a sequence
//   */
//  private boolean start;
//  /**
//   * The X-coord of the square
//   */
//  private int sqX;
//  /**
//   * The Y-coord of the square
//   */
//  private int sqY;
//  /**
//   * The old intValue
//   */
//  private int oldValue;
//  /**
//   * The new intValue
//   */
//  private int newValue;
//
////  /**
////   * The old backColour
////   */
////  private Color oldBackColour;
////  /**
////   * The new backColour
////   */
////  private Color newBackColour;
//  /**
//   * The old textColour
//   */
//  private Color oldTextColour;
//   /**
//   * The new textColour
//   */
//  private Color newTextColour;
//  /**
//   * The old confinedToSq
//   */
//  private boolean oldConfSq;
//  /**
//   * The new confinedToSq
//   */
//  private boolean newConfSq;
//  /**
//   * The old confinedToRow
//   */
//  private boolean oldConfRow;
//  /**
//   * The new confinedToRow
//   */
//  private boolean newConfRow;
//  /**
//   * The old confinedToCol
//   */
//  private boolean oldConfCol;
//  /**
//   * The new confinedToCol
//   */
//  private boolean newConfCol;
//
//  /** Creates a new instance of Move
//   * @param start True if this is the first of a sequence
//   * @param sqX X offset of square
//   * @param sqY Y offset of square
//   * @param oldValue Old value
//   * @param newValue New value
//   * @param oldTextColour Old text colour
//   * @param newTextColour New text colour
//   * @param oldConfSq If was confined to big square
//   * @param newConfSq If will be confined to big square
//   * @param oldConfRow If was confined to row
//   * @param newConfRow If will be confined to row
//   * @param oldConfCol If was confined to column
//   * @param newConfCol If will be confined to column
//   */
//  public Move(boolean start, int sqX, int sqY,
//      int oldValue, int newValue,
////      Color oldBackColour, Color newBackColour,
//      Color oldTextColour, Color newTextColour,
//      boolean oldConfSq, boolean newConfSq,
//      boolean oldConfRow, boolean newConfRow,
//      boolean oldConfCol, boolean newConfCol) {
//    this.start=start;
//    this.sqX=sqX;
//    this.sqY=sqY;
//    this.oldValue=oldValue;
//    this.newValue=newValue;
////    this.oldBackColour=oldBackColour;
////    this.newBackColour=newBackColour;
//    this.oldTextColour=oldTextColour;
//    this.newTextColour=newTextColour;
//    this.oldConfSq=oldConfSq;
//    this.newConfSq=newConfSq;
//    this.oldConfRow=oldConfRow;
//    this.newConfRow=newConfRow;
//    this.oldConfCol=oldConfCol;
//    this.newConfCol=newConfCol;
//  }
//
//  /**
//   * Creates a new Move object.
//   *  Fills in fields from the given square
//   * @param start Value for start field
//   * @param sq Square to get values from
//   */
//  public Move(boolean start, Square sq) {
//    this.start=start;
//    sqX=sq.getXIndex();
//    sqY=sq.getYIndex();
//    oldValue=sq.getIntValue();
//    newValue=oldValue;
//    oldTextColour=sq.getTextColour();
//    newTextColour=oldTextColour;
//    oldConfCol=sq.isConfinedToCol();
//    newConfCol=oldConfCol;
//    oldConfRow=sq.isConfinedToRow();
//    newConfRow=oldConfRow;
//    oldConfSq=sq.isConfinedToSq();
//    newConfSq=oldConfSq;
//
//  }
//
//  /**
//   * Updates a move from existing square
//   * @param sq The square which is used for the updating
//   */
//  public void updateFromSquare(Square sq) {
//    if (sqX!=sq.getXIndex() || sqY!=sq.getYIndex()) {
//      TestKiller.showMessage("UpdateMove called with wrong parameters");
//      System.exit(1);
//    }
//    newValue=sq.getIntValue();
//    newTextColour=sq.getTextColour();
//    newConfCol=sq.isConfinedToCol();
//    newConfRow=sq.isConfinedToRow();
//    newConfSq=sq.isConfinedToSq();
//  }
//
//  /**
//   *
//   * @return Whether the move is the start of a sequence
//   */
//  public boolean isStart() {
//    return start;
//  }
//
//  /**
//   *
//   * @return X offset of move
//   */
//  public int getSqX() {
//    return sqX;
//  }
//
//  /**
//   *
//   * @return Y offset of move
//   */
//  public int getSqY() {
//    return sqY;
//  }
//
//  /**
//   *
//   * @return Old value of move
//   */
//  public int getOldValue() {
//    return oldValue;
//  }
//
//  /**
//   *
//   * @return New value of move
//   */
//  public int getNewValue() {
//    return newValue;
//  }
////
////  public Color getOldBackColour() {
////    return oldBackColour;
////  }
////
////  public Color getNewBackColour() {
////    return newBackColour;
////  }
//
//  /**
//   *
//   * @return Old text colour of move
//   */
//  public Color getOldTextColour() {
//    return oldTextColour;
//  }
//
//  /**
//   *
//   * @return New text colour of move
//   */
//  public Color getNewTextColour() {
//    return newTextColour;
//  }
//
//  /**
//   *
//   * @return Whether square before change was confined to big square
//   */
//  public boolean isOldConfSq() {
//    return oldConfSq;
//  }
//
//  /**
//   *
//   * @return Whether square after change is confined to big square
//   */
//  public boolean isNewConfSq() {
//    return newConfSq;
//  }
//
//  /**
//   *
//   * @return Whether square before change was confined to row
//   */
//  public boolean isOldConfRow() {
//    return oldConfRow;
//  }
//
//  /**
//   *
//   * @return Whether square after change is confined to row
//   */
//  public boolean isNewConfRow() {
//    return newConfRow;
//  }
//
//  /**
//   *
//   * @return Whether square before change was confined to column
//   */
//  public boolean isOldConfCol() {
//    return oldConfCol;
//  }
//
//  /**
//   *
//   * @return Whether square after change is confined to column
//   */
//  public boolean isNewConfCol() {
//    return newConfCol;
//  }
//
//  /**
//   *
//   * @param start true if this move is the first of a sequence
//   */
//  public void setStart(boolean start) {
//    this.start = start;
//  }
//
//  /**
//   *
//   * @param newValue new value for suqare in move
//   */
//  public void setNewValue(int newValue) {
//    this.newValue = newValue;
//  }
//
//  /**
//   *
//   * @param newTextColour new text colour for square in move
//   */
//  public void setNewTextColour(Color newTextColour) {
//    this.newTextColour = newTextColour;
//  }
////
////  public void setNewBackColour(Color newBackColour) {
////    this.newBackColour = newBackColour;
////  }
//
//  /**
//   *
//   * @param newConfSq true if square is confined to big square
//   */
//  public void setNewConfSq(boolean newConfSq) {
//    this.newConfSq = newConfSq;
//  }
//
//  /**
//   *
//   * @param newConfRow true if square is confined to row
//   */
//  public void setNewConfRow(boolean newConfRow) {
//    this.newConfRow = newConfRow;
//  }
//
//  /**
//   *
//   * @param newConfCol true if square is confined to column
//   */
//  public void setNewConfCol(boolean newConfCol) {
//    this.newConfCol = newConfCol;
//  }
//
//  /**
//   * Toggles whether square in move is confined to big square
//   */
//  public void toggleConfSq() {
//    newConfSq=!oldConfSq;
//  }
//
//  /**
//   * Toggles whether square in move is confined to row
//   */
//  public void toggleConfRow() {
//    newConfRow=!oldConfRow;
//  }
//
//  /**
//   * Toggles whether square in move is confined to column
//   */
//  public void toggleConfCol() {
//    newConfCol=!oldConfCol;
//  }
//
//  /**
//   * Prints move to system output stream
//   */
//  public void print() {
//    StringBuilder s=new StringBuilder(" Move "+(start?"*":"")+sqX+","+sqY);
//    System.out.println(" "+s.toString());
//  }
//}
