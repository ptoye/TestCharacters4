/*
 * Square.java
 *
 * Created on 28 December 2006, 15:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.ptoye.TestKiller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import javax.swing.JComponent;

/**
 *
 * @author PToye
 */
class Square extends JComponent implements Serializable  {
  static final long serialVersionUID = 3L;

  private static Font squareFont=new Font("SansSerif",Font.BOLD,18);
  private static Font symbolFont=new Font("SansSerif",Font.PLAIN,15);
  private static final String upDownArrow="" + '\u2195'; // characters for markers
  private static final String leftRightArrow="" + '\u2194';
  private static final String smallSquare="" + '\u25A1';
  private static final int symbolX1=11; // coords for marker characters
  private static final int symbolX2=27;
  private static final int symbolY1=19;
  private static final int symbolY2=42;

  /**
   * X index in grid
   */
  private int xIndex;
  /**
   * Y index in grid
   */
  private int yIndex;
  /**
   * The square's parent grid
   */
  private OuterPane.GamePanel gameParent;
  /**
   * Region it belongs to (or null if none)
   */
  private Region region;

  /**
   * The character to be displayed
   */
  private String charValue="";
  private int intValue;

  /**
   * The colour of the displayed character
   */
  private Color textColour;
  /**
   * The background colour
   */
  private Color backColour;
  /**
   * true if mouse hovering over it
   */
  private boolean dark;
  private boolean marked;
  private boolean confinedToSq, confinedToRow, confinedToCol;

  /**
   * Create a new square
   */
  Square(int x, int y, int val, Color tcol, Color bcol, OuterPane.GamePanel parent) {
    int ss=gameParent.getSquareSize();
    gameParent=parent;
    xIndex=x;
    yIndex=y;
    textColour=tcol;
    backColour=bcol;
    region=null;
    setName("Square"+x+":"+y);
    setBounds(parent.coordArray[x],parent.coordArray[y], ss,ss);
    setValue(val);
    setOpaque(true);
    setVisible(true);
    confinedToSq=false;
    confinedToRow=false;
    confinedToCol=false;
    dark=false;
  }

    Square(int x, int y, Color tcol, Color bcol, OuterPane.GamePanel parent, int size) {
    gameParent=parent;
    xIndex=x;
    yIndex=y;
    textColour=tcol;
    backColour=bcol;
    region=null;
    setName("Square"+x+":"+y);
    setBounds(parent.coordArray[x],parent.coordArray[y], size, size);
    setValue(0);
    setOpaque(true);
    setVisible(true);
    confinedToSq=false;
    confinedToRow=false;
    confinedToCol=false;
  }

  @Override
  public void paintComponent(Graphics g) {
    int ss=gameParent.getSquareSize();

    BasicStroke symbolStroke=new BasicStroke(1f);
//    final int ARROW_OFFSET=OuterPane.SQUARE_SIZE*2/3;

    super.paintComponent(g);
    Graphics2D g2=(Graphics2D) g;
//    System.out.println("Painting square "+xIndex+","+yIndex+":"+getBounds());
    g2.setFont(squareFont);
    FontMetrics fm=g2.getFontMetrics();
    g2.setColor(backColour);
    g2.fillRect(0,0,ss,ss);
    g2.setColor(textColour);
    Rectangle2D stringsize=fm.getStringBounds(charValue,g);
    g2.drawString(charValue,
        ss/2+symbolX1/2-(int)stringsize.getWidth()/2,
        ss/2+symbolX1/2+(int)stringsize.getHeight()/2-2);
    //TODO clean up positioning prior to allowing resizing
    g2.setStroke(symbolStroke);
    g2.setColor(Color.BLACK);
    g2.setFont(symbolFont);
    if (confinedToSq) {
      g2.drawString(smallSquare,symbolX1,symbolY1);
    }
    if (confinedToCol) {
      g2.drawString(upDownArrow, symbolX1, symbolY2);
    }
    if (confinedToRow) {
      g2.drawString(leftRightArrow, symbolX2, symbolY1);
    }
  }

  @Override
  public Dimension getPreferredSize() {
    int ss=gameParent.getSquareSize();
    return new Dimension(ss,ss);
  }

  void updateFromMoveOld(Move m) {
    textColour=m.getOldTextColour();
    confinedToCol=m.isOldConfCol();
    confinedToRow=m.isOldConfRow();
    confinedToSq=m.isOldConfSq();
    setValue(m.getOldValue());
    repaint();
  }

  void updateFromMoveNew(Move m) {
    textColour=m.getNewTextColour();
    confinedToCol=m.isNewConfCol();
    confinedToRow=m.isNewConfRow();
    confinedToSq=m.isNewConfSq();
    setValue(m.getNewValue());
    repaint();

  }

  void updateSize(int x, int y, int newSize) {
        setBounds(gameParent.coordArray[x], gameParent.coordArray[y],
            newSize, newSize);
  }

//  void print() {
////    for (MouseListener elem : getMouseListeners()) {
////      System.out.println("Square mouse listener "+elem);
////    }
//    if (intValue!=0) {
//      System.out.println("  Value "+charValue);
//    }
//  }

  void setBackColour(Color backColour) {
    this.backColour = backColour;
    repaint();
  }

  void setTextColour(Color textColour) {
    this.textColour = textColour;
    repaint();
  }

  void setConfinedToCol(boolean confinedToCol) {
    this.confinedToCol = confinedToCol;
  }

  void setConfinedToRow(boolean confinedToRow) {
    this.confinedToRow = confinedToRow;
  }

  void setConfinedToSq(boolean confinedToSq) {
    this.confinedToSq = confinedToSq;
  }

  public boolean isDark() {
    return dark;
  }

  public void setDark(boolean dark) {
    this.dark = dark;
  }


  final void setValue(int value) {
    intValue=value;
    if (value==0) {
     //TODO ?? clear confined markers here?
     charValue="";
    } else {
      charValue=""+value;
    }
//    repaint();
  }

  boolean isPermanent() {
    return (intValue!=0 && textColour.equals(OuterPane.PERM_COLOUR));
  }

  boolean hasValue() {
    return intValue!=0;
  }

  void toggleConfineRow() {
    confinedToRow=!confinedToRow;
    repaint();
  }

  void toggleConfineCol() {
    confinedToCol=!confinedToCol;
    repaint();
  }

  void toggleConfineSq() {
    confinedToSq=!confinedToSq;
    repaint();
  }

  int getXIndex() {
    return xIndex;
  }

  int getYIndex() {
    return yIndex;
  }

  int getIntValue() {
    return intValue;
  }

  Color getBackColour() {
    return backColour;
  }

  Color getTextColour() {
    return textColour;
  }

  boolean isConfinedToSq() {
    return confinedToSq;
  }

  boolean isConfinedToRow() {
    return confinedToRow;
  }

  boolean isConfinedToCol() {
    return confinedToCol;
  }

  Region getRegion() {
    return region;
  }

  void setRegion(Region region) {
    this.region = region;
  }

  boolean isMarked() {
    return marked;
  }

  void setMarked(boolean marked) {
    this.marked = marked;
  }

  void setParent(OuterPane.GamePanel parent) {
    this.gameParent = parent;
  }

  boolean hasNeighbour(int direction) {
    int newX=xIndex+Region.incX[direction];
    int newY=yIndex+Region.incY[direction];
    return newX>=0 && newY>=0 && newX<OuterPane.BIGSQUARES && newY<OuterPane.BIGSQUARES &&
        gameParent.getSquare(newX,newY).region==region;

  }
}
