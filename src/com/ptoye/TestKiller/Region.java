///*
// * Region.java
// *
// * Created on 28 December 2006, 15:59
// *
// * To change this template, choose Tools | Template Manager
// * and open the template in the editor.
// */
//package com.ptoye.TestKiller;
//
//import java.awt.BasicStroke;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.FontMetrics;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.geom.GeneralPath;
//import java.awt.geom.PathIterator;
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;
//import javax.swing.JComponent;
//
///**
// *
// * @author PToye
// */
///**
// * Class representing a region whose total sum is known
// */
//class Region extends JComponent implements Serializable {
//
//  /**
//   * Version no. for serialization
//   */
//  static final long serialVersionUID = 1L;
//  private static final float BORDER_WIDTH = 1f;
//  private static final float DASH_LENGTH = 4f;
//  private static final float[] dashes = {DASH_LENGTH, DASH_LENGTH};
//  private static final BasicStroke borderStroke =
//          new BasicStroke(BORDER_WIDTH, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
//          1f, dashes, 0);
//  private static final Font regionFont = new Font("SansSerif", Font.PLAIN, 10);
//  private FontMetrics borderFontMetric;
//  private static final int TEXT_X = 1;
//  private static final int TEXT_Y = -2;
//  private static final int borderInset = 3;
//  private static final int EAST = 0;
//  private static final int SOUTH = 1;
//  private static final int WEST = 2;
//  private static final int NORTH = 3;
//  /**
//   * X increments for directions (ESWN)
//   */
//  static final int[] incX = {1, 0, -1, 0};
//  /**
//   * Y increments for directions (ESWN)
//   */
//  static final int[] incY = {0, 1, 0, -1};
//  private OuterPane.GamePanel parentGame;
//  /**
//   * The sum as given
//   */
//  private int total;
//  private String totalString;
//  private int id;
//  /**
//   * The squares constituting the region
//   */
//  private Set<Square> contents;  // the squares in the region
//  private Square leadSquare;  // top left-hand square
//  private int leadXCoord, leadYCoord;    // X, Y coords of lead square wrt border
//  private GeneralPath border = null;
//
//  /**
//   * Constructor - never used
//   */
//  Region() {
//    TestKiller.showMessage("New region - null constructor");
//  }
//
//  /**
//   * Constructor as used in Killer Sudoko
//   *
//   * @param id Region Identifier
//   * @param parent Parent game
//   */
//  Region(int id, OuterPane.GamePanel parent) {
//    super();
//    this.id = id;
//    this.parentGame = parent;
//    setName("Region " + id);
//    contents = new HashSet<Square>(OuterPane.BIGSQUARES * 3 / 2);
//    border = new GeneralPath();
//    borderFontMetric = getFontMetrics(regionFont);
//    setOpaque(false);
//    setVisible(true);
//
////    System.out.println("New region "+id);
//  }
//
//  /**
//   * Add a square to the region
//   *
//   * @param s Square to add
//   */
//  void addSquare(Square s) {
//    if (!contents.contains(s)) {
//      contents.add(s);
//    }
//  }
//
//  /**
//   * Remove a square from the region
//   *
//   * @param s The square to remove
//   */
//  void removeSquare(Square s) {
//    if (contents.contains(s)) {
//      contents.remove(s);
//    }
//  }
//
//  /**
//   *
//   * @return total for the region
//   */
//  int getTotal() {
//    return total;
//  }
//
//  /**
//   * Set total
//   *
//   * @param total Sum of squares for the region
//   */
//  void setTotal(int total) {
//    this.total = total;
//    totalString = "" + total;
//  }
//
//  /**
//   * Forms boundary line display for region (assumed a new one) and updates
//   * total
//   *
//   * @param tot - total for region
//   * @return true if is was OK, false otherwise.
//   */
//  boolean checkNewRegion(int tot) {
////    System.out.println("Enter: squaresize= "+parentGame.getSquareSize());
//    int minXCoord = parentGame.getTotalSize() + 1;
//    int minYCoord = parentGame.getTotalSize() + 1;
//    int maxXCoord = -1;
//    int maxYCoord = -1;
//    int minY = OuterPane.BIGSQUARES+1;
//    int minX = OuterPane.BIGSQUARES+1;
//    int currentX, currentY; // in coords relative to region
//    Square currentSq;
//    int lastDirection;
////    int nextDirection;
//    int leadDirection;
//    boolean[] neighbours = new boolean[4];
//
//    int NWOffset = borderInset;
//    int SEOffset = parentGame.getSquareSize() - borderInset - 1;
//
//    total = tot;
//    totalString = "" + tot;
////    System.out.println("Checking region "+id);
//    leadYCoord = parentGame.getTotalSize() + 1;
//
//// search for bounds and lead square
//    for (Square s : contents) {
//      int sqX = s.getXIndex();
//      int sqY = s.getYIndex();
//      int sqXCoord = parentGame.coordArray[sqX];
//      int sqYCoord = parentGame.coordArray[sqY];
//      s.setMarked(false);
//      if ((sqY<minY) || ((sqY==minY) && (sqX<=minX))) {
//          leadSquare = s;
//          leadXCoord = sqXCoord;
//          leadYCoord = sqYCoord;
//          minY=sqY;
//          minX=sqX;
//      }
//      minXCoord = Math.min(minXCoord, sqXCoord);
//      minYCoord = Math.min(minYCoord, sqYCoord);
//      maxXCoord = Math.max(maxXCoord, sqXCoord);
//      maxYCoord = Math.max(maxYCoord, sqYCoord);
//
////      System.out.println("Square "+sqX+","+sqY);
//    }
//
//    setBounds(minXCoord, minYCoord,
//            maxXCoord - minXCoord + parentGame.getSquareSize(),
//            maxYCoord - minYCoord + parentGame.getSquareSize());
//    leadXCoord -= minXCoord;
//    leadYCoord -= minYCoord;
//
//    currentSq = leadSquare;
//    currentSq.setMarked(true);
//    if (currentSq.hasNeighbour(NORTH) || currentSq.hasNeighbour(WEST)) {
//      TestKiller.showMessage("Failure - lead square has N or W neighbour");
//      return false;
//    }
//    currentX = leadXCoord + TEXT_X + borderFontMetric.stringWidth(totalString) + borderInset;
//    currentY = leadYCoord + NWOffset;
//    border.reset();
//    border.setWindingRule(PathIterator.WIND_NON_ZERO);
//    border.moveTo(currentX, currentY);
//    if (currentSq.hasNeighbour(EAST) || currentSq.hasNeighbour(SOUTH)) {
//      if (currentSq.hasNeighbour(EAST)) {
//        leadDirection = EAST;
//      } else {
//        leadDirection = SOUTH;
//        currentX = leadXCoord + SEOffset;
////        currentY=leadYCoord+borderInset;
//        border.lineTo(currentX, currentY);
//      }
////      System.out.println("Lead square "+leadSquare.getXIndex()+","+leadSquare.getYIndex());
//      lastDirection = leadDirection;
//      boolean tracking = true;
//
//      do {
//        currentSq = parentGame.getSquare(currentSq.getXIndex() + incX[lastDirection],
//                currentSq.getYIndex() + incY[lastDirection]);
////        System.out.println("Tracking "+currentSq.getXIndex()+","+currentSq.getYIndex());
//        currentSq.setMarked(true);
//        //fill in the neighbours array - saves looking up twice
//        boolean anyNeighbours = false;
//        for (int i = 0; i < neighbours.length; i++) {
//          neighbours[i] = currentSq.hasNeighbour(i);
//          anyNeighbours |= neighbours[i];
//        }
//
//        if (!anyNeighbours) {
//          TestKiller.showMessage("Square " + currentSq.getXIndex() + "," + currentSq.getYIndex()
//                  + " has no neighbours in region " + id);
//          return false;
//        }
//
//        switch (lastDirection) {
//          case EAST:
//            if (neighbours[NORTH]) {
//              currentX = parentGame.getCoord(currentSq.getXIndex()) + NWOffset - minXCoord;
//              border.lineTo(currentX, currentY);
//              lastDirection = NORTH;
//            } else if (neighbours[EAST]) {
//              //do nothing - keep straight on
//            } else if (neighbours[SOUTH]) {
//              currentX = parentGame.getCoord(currentSq.getXIndex())
//                      + SEOffset - minXCoord;
//              border.lineTo(currentX, currentY);
//              lastDirection = SOUTH;
//            } else if (neighbours[WEST]) {
////              System.out.println("E-W "+currentX+","+currentY);
//              currentX = parentGame.getCoord(currentSq.getXIndex())
//                      + SEOffset - minXCoord;
////              System.out.println("E-W "+currentX+","+currentY);
//              border.lineTo(currentX, currentY);
//              currentY = parentGame.getCoord(currentSq.getYIndex())
//                      + SEOffset - minYCoord;
////              System.out.println("E-W "+currentX+","+currentY);
//              border.lineTo(currentX, currentY);
//              lastDirection = WEST;
//            } else {
//              TestKiller.showMessage("Square has no neighbours");
//              return false;
//            }
//            break;
//
//          case NORTH:
//            if (neighbours[WEST]) {
//              currentY = parentGame.getCoord(currentSq.getYIndex())
//                      + SEOffset - minYCoord;
//              border.lineTo(currentX, currentY);
//              lastDirection = WEST;
//            } else if (neighbours[NORTH]) {
//              //do nothing - keep straight on
//            } else if (neighbours[EAST]) {
//              if (currentSq == leadSquare && leadDirection == EAST) {
//                currentY = parentGame.getCoord(currentSq.getYIndex()) + NWOffset
//                        + borderFontMetric.getAscent() - minYCoord;
//                border.lineTo(currentX, currentY);
//                tracking = false;
//              } else {
//                currentY = parentGame.getCoord(currentSq.getYIndex()) + NWOffset - minYCoord;
//                border.lineTo(currentX, currentY);
//                lastDirection = EAST;
//              }
//            } else if (neighbours[SOUTH]) {
//              if (currentSq == leadSquare && leadDirection == SOUTH) {
//                currentY = parentGame.getCoord(currentSq.getYIndex()) + NWOffset
//                        + borderFontMetric.getAscent() - minYCoord;
//                border.lineTo(currentX, currentY);
//                tracking = false;
//              } else {
//                currentY = parentGame.getCoord(currentSq.getYIndex()) + NWOffset - minYCoord;
//                border.lineTo(currentX, currentY);
//                currentX = parentGame.getCoord(currentSq.getXIndex())
//                        + SEOffset - minXCoord;
//                border.lineTo(currentX, currentY);
//                lastDirection = SOUTH;
//              }
//            } else {
//              TestKiller.showMessage("Square has no neighbours");
//              return false;
//            }
//            break;
//
//          case WEST:
//            if (neighbours[SOUTH]) {
//              currentX = parentGame.getCoord(currentSq.getXIndex())
//                      + SEOffset - minXCoord;
//              border.lineTo(currentX, currentY);
//              lastDirection = SOUTH;
//            } else if (neighbours[WEST]) {
//              //do nothing - keep straight on
//            } else if (neighbours[NORTH]) {
//              currentX = parentGame.getCoord(currentSq.getXIndex()) + NWOffset - minXCoord;
//              border.lineTo(currentX, currentY);
//              lastDirection = NORTH;
//            } else if (neighbours[EAST]) {
//              currentX = parentGame.getCoord(currentSq.getXIndex()) + NWOffset - minXCoord;
//              border.lineTo(currentX, currentY);
//              if (currentSq == leadSquare && leadDirection == EAST) {
//                currentY = parentGame.getCoord(currentSq.getYIndex()) + NWOffset
//                        + borderFontMetric.getAscent() - minYCoord;
//                border.lineTo(currentX, currentY);
//                tracking = false;
//              } else {
//                currentY = parentGame.getCoord(currentSq.getYIndex()) + NWOffset - minYCoord;
//                border.lineTo(currentX, currentY);
//                lastDirection = EAST;
//              }
//            } else {
//              TestKiller.showMessage("Square has no neighbours");
//              return false;
//            }
//            break;
//
//          case SOUTH:
//            if (neighbours[EAST]) {
//              currentY = parentGame.getCoord(currentSq.getYIndex()) + NWOffset - minYCoord;
//              border.lineTo(currentX, currentY);
//              lastDirection = EAST;
//            } else if (neighbours[SOUTH]) {
//              //do nothing - keep straight on
//            } else if (neighbours[WEST]) {
//              currentY = parentGame.getCoord(currentSq.getYIndex()) + SEOffset - minYCoord;
//              border.lineTo(currentX, currentY);
//              lastDirection = WEST;
//            } else if (neighbours[NORTH]) {
//              currentY = parentGame.getCoord(currentSq.getYIndex()) + SEOffset - minYCoord;
//              border.lineTo(currentX, currentY);
//              currentX = parentGame.getCoord(currentSq.getXIndex())
//                      + NWOffset - minXCoord;
//              border.lineTo(currentX, currentY);
//              lastDirection = NORTH;
//            } else {
//              TestKiller.showMessage("Square has no neighbours");
//              return false;
//            }
//            break;
//
//        }
//      } while (tracking);
//
//    } else {
//      // must be only 1 square as no neighbours.
//      currentX = leadXCoord + SEOffset;
//      currentY = leadYCoord + NWOffset;
//      border.lineTo(currentX, currentY);
//      currentY = leadYCoord + SEOffset;
//      border.lineTo(currentX, currentY);
//      currentX = leadXCoord + NWOffset;
//      border.lineTo(currentX, currentY);
//      currentY = leadYCoord + TEXT_Y + borderFontMetric.getAscent() + NWOffset;
//      border.lineTo(currentX, currentY);
//    }
//
//    boolean ok = true;
//    for (Square s : contents) {
////      s.setBackColour(parentGame.NORMAL_BACK_COLOUR);
//      parentGame.showSqDeselected(s);
//      int SquareX=s.getX();
//      int SquareY=s.getY();
//      if (!s.isMarked() &&  !(border.contains(SquareX-minXCoord, SquareY-minYCoord))) {
////        String DebugString="Winding rule: "+border.getWindingRule() + "\n";
////        DebugString+="Square size= " + parentGame.getSquareSize() + "\n";
////        DebugString+="Point: " + (SquareX) + ", " +(SquareY ) + "\n";
////        DebugString+="Marked: "+s.isMarked()+"\n";
////        DebugString+="Contains: " + border.contains(SquareX, SquareY)+"\n";
////        PathIterator PI=border.getPathIterator(null);
////        double[] Coords=new double[6];
////        int Type;
////        do {
////          Type=PI.currentSegment(Coords);
////          DebugString+= "Segment type " + Type + ": "+ Coords[0]+", " + Coords[1]+"\n";
////          PI.next();
////        } while (!PI.isDone());
////        TestKiller.showMessage(DebugString);
//        TestKiller.showMessage("Region " + id + " contains non-contiguous square " + s.getXIndex()
//                + "," + s.getYIndex());
////        System.out.println(DebugString);
//
//        ok = false;
//      }
//
//    }
////    System.out.println("Exit: squaresize= "+parentGame.getSquareSize());
//    if (!ok) {
//      return false;
//    }
//
////    print();
//    repaint();
//
//    return true;
//  }
//
//  @Override
//  public void paintComponent(Graphics g) {
//
////    int  newX, newY;
//    super.paintComponent(g);
////    System.out.println("Painting region "+id + " "+this.toString());
//    Graphics2D g2 = (Graphics2D) g;
//    g2.setFont(regionFont);
//    g2.setColor(Color.BLACK);
//    g2.drawString(totalString, leadXCoord + TEXT_X, leadYCoord + TEXT_Y + borderFontMetric.getAscent());
//    g2.setStroke(borderStroke);
//    g2.draw(border);
//  }
//
//  /**
//   * Gets the set of squares which constitute the region
//   *
//   * @return The contents of the region
//   */
//  Set<Square> getContents() {
//    return contents;
//  }
//
//  /**
//   * Sets the parent game for the region
//   *
//   * @param parent The parent game
//   */
//  void setParent(OuterPane.GamePanel parent) {
//    this.parentGame = parent;
//  }
//
////  public OuterPane.GamePanel getParent() {
////    return parentGame;
////  }
////
//  /**
//   * Gets the number of squares in the region
//   *
//   * @return The number of squares
//   */
//  int getSquareCount() {
//    return contents.size();
//  }
//
////  /**
////   * Outputs the region's characteristics
////   */
////  public void print() {
////    System.out.println("Printing region " + id);
////    System.out.println("Total " + total);
////    System.out.println("Bounds " + getBounds());
////    System.out.println("Lead square " + leadSquare.getXIndex() + "," + leadSquare.getYIndex());
////    System.out.println("Lead coords " + leadXCoord + "," + leadYCoord);
////
////    for (Square s : contents) {
////      if (s != leadSquare) {
////        System.out.println("Square " + s.getXIndex() + "," + s.getYIndex());
////      }
////    }
////  }
//}
