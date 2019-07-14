/*
 * TestKiller.java
 *
 * Created on 01 August 2006, 22:13
 */
package com.ptoye.TestKiller;

//import com.ptoye.partitions5.PartitionEventListener;
//import com.ptoye.partitions5.Partitions;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author PToye
 */
//TODO put actions into menu
//TODO change perm<>temp in custom colours (?? needs a lot of remembering)
//TODO help file??
public class TestKiller extends javax.swing.JFrame
//        implements PartitionEventListener,
//        Printable
{

  /**
   * Version for serialisation
   */
  static final long serialVersionUID = 1L;
  static final String titleString = "Killer Su Doku v.1.2";
  private OuterPane op = null;
//  private String filename = null;
//  private File gameSaveFile = null;
//  private File lastDirectory = null;
//  private final String fileExtension = "ksd";
//  private Partitions partitionWindow = null;
  private boolean pwIconified = false; //remembers if partitions window iconified when main window iconified
//  private TestKiller tk = null;
//  private boolean pwShown = false;
  private static String firstArg = null;
  private boolean dirty = false;
//  private Icon showPartsIcon = null;
//  private Icon hidePartsIcon = null;
  private GraphicsEnvironment ge;
  private Rectangle screensize;
//  private KDSFileFilter kDSff = new KDSFileFilter();

  /**
   * Creates new form TestKiller
   */
  public TestKiller() {
//    String userHome;
//    userHome = System.getProperty("user.home");
//    lastDirectory = new File(userHome, "/Desktop");
    initComponents();
//    showPartsIcon = btnPartitions.getIcon();
//    hidePartsIcon = new ImageIcon(getClass().getResource("images/HidePartitions.gif"));
//    if (hidePartsIcon == null) {
//      return;
//    }
    op = new OuterPane(this);
    getContentPane().add(op);
//    setContentPane(op);

    ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    screensize = ge.getMaximumWindowBounds();

    setSize(op.getPreferredSize());
//    setLocation((screensize.width - getWidth() - getInsets().right - getInsets().left), 0);
    pack();
    validate();
//    tk = this;
//    partitionWindow = new Partitions(this);
//    partitionWindow.setExtendedState(ICONIFIED);
//    partitionWindow.setVisible(true);
//    partitionWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//    int px=(int)Math.round(getLocation().getX()+getWidth());
//    partitionWindow.setLocation(px,
//        (int) Math.round(getLocation().getY()));
//    partitionWindow.setLocationRelativeTo(this);
//    SwingUtilities.invokeLater( new Runnable() {
//      public void run() {
//        partitionWindow.setVisible(true);
//        partitionWindow.setLocationRelativeTo(tk);
//
//      }
//    }
//    );
    if (firstArg != null) {
//      JOptionPane.showMessageDialog(this,"Argument: "+firstArg);
      File f = new File(firstArg);
      if (f != null) {
        if (!restoreGameFromFile(f)) {
          showMessage("Could not restore game - sorry");
        }
      }
    }
//    else
//    {
//      JOptionPane.showMessageDialog(this, "No arguments");
//    }
  }

  /**
   * Displays an error message on the monitor
   *
   * @param s Message to display
   */
  static void showMessage(String s) {
    JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.ERROR_MESSAGE);
  }

//  private void iconifyPartitionsWindow() {
//    partitionWindow.setExtendedState(ICONIFIED);
//    btnPartitions.setIcon(showPartsIcon);
//    jmiViewPart.setSelected(false);
//    pwIconified = true;
//  }

//  private void showPartitionsWindow() {
//    partitionWindow.setExtendedState(NORMAL);
//    btnPartitions.setIcon(hidePartsIcon);
//    jmiViewPart.setSelected(true);
//    pwIconified = false;
//  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jToolBar1 = new javax.swing.JToolBar();
    btnOpen = new javax.swing.JButton();
    btnSave = new javax.swing.JButton();
    btnSaveAs = new javax.swing.JButton();
    btnPartitions = new javax.swing.JToggleButton();
    jMenuBar1 = new javax.swing.JMenuBar();
    jmFile = new javax.swing.JMenu();
    jmiNew = new javax.swing.JMenuItem();
    jmiSave = new javax.swing.JMenuItem();
    jmiSaveAs = new javax.swing.JMenuItem();
    jmiRestore = new javax.swing.JMenuItem();
    jmiRestart = new javax.swing.JMenuItem();
    jmiExit = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JSeparator();
    jmiPrint = new javax.swing.JMenuItem();
    jmView = new javax.swing.JMenu();
    jmiViewPart = new javax.swing.JCheckBoxMenuItem();

    FormListener formListener = new FormListener();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setTitle(TestKiller.titleString);
    setLocationByPlatform(true);
    addWindowListener(formListener);

    jToolBar1.setRollover(true);

    btnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ptoye/TestKiller/images/folder-open_16-new.gif"))); // NOI18N
    btnOpen.setToolTipText("Open");
    btnOpen.setFocusable(false);
    btnOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnOpen.addActionListener(formListener);
    jToolBar1.add(btnOpen);

    btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ptoye/TestKiller/images/save_16.gif"))); // NOI18N
    btnSave.setToolTipText("Save");
    btnSave.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ptoye/TestKiller/images/save_16_disabled.gif"))); // NOI18N
    btnSave.setFocusable(false);
    btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnSave.addActionListener(formListener);
    jToolBar1.add(btnSave);

    btnSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ptoye/TestKiller/images/saveas_16.GIF"))); // NOI18N
    btnSaveAs.setToolTipText("Save as...");
    btnSaveAs.setFocusable(false);
    btnSaveAs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnSaveAs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnSaveAs.addActionListener(formListener);
    jToolBar1.add(btnSaveAs);

    btnPartitions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ptoye/TestKiller/images/ShowPartitions.gif"))); // NOI18N
    btnPartitions.setToolTipText("Shows the partitions window");
    btnPartitions.setFocusable(false);
    btnPartitions.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnPartitions.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnPartitions.addActionListener(formListener);
    jToolBar1.add(btnPartitions);

    getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

    jmFile.setText("Game");

    jmiNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
    jmiNew.setMnemonic('N');
    jmiNew.setText("New");
    jmiNew.setToolTipText("Start new game");
    jmiNew.addActionListener(formListener);
    jmFile.add(jmiNew);

    jmiSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
    jmiSave.setText("Save");
    jmiSave.setToolTipText("Save to ogirinal file");
    jmiSave.addActionListener(formListener);
    jmFile.add(jmiSave);

    jmiSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
    jmiSaveAs.setMnemonic('A');
    jmiSaveAs.setText("Save as...");
    jmiSaveAs.setToolTipText("Save to new file");
    jmiSaveAs.addActionListener(formListener);
    jmFile.add(jmiSaveAs);

    jmiRestore.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
    jmiRestore.setMnemonic('o');
    jmiRestore.setText("Open");
    jmiRestore.setToolTipText("O");
    jmiRestore.addActionListener(formListener);
    jmFile.add(jmiRestore);

    jmiRestart.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
    jmiRestart.setText("Restart");
    jmiRestart.addActionListener(formListener);
    jmFile.add(jmiRestart);

    jmiExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
    jmiExit.setMnemonic('x');
    jmiExit.setText("Exit");
    jmiExit.setToolTipText("");
    jmiExit.addActionListener(formListener);
    jmFile.add(jmiExit);
    jmFile.add(jSeparator1);

    jmiPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
    jmiPrint.setText("Print");
    jmiPrint.addActionListener(formListener);
    jmFile.add(jmiPrint);

    jMenuBar1.add(jmFile);

    jmView.setText("View");

    jmiViewPart.setText("Partitions window");
    jmiViewPart.addItemListener(formListener);
    jmView.add(jmiViewPart);

    jMenuBar1.add(jmView);

    setJMenuBar(jMenuBar1);

    pack();
  }

  // Code for dispatching events from components to event handlers.

  private class FormListener implements java.awt.event.ActionListener, java.awt.event.ItemListener, java.awt.event.WindowListener {
    FormListener() {}
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      if (evt.getSource() == btnOpen) {
        TestKiller.this.btnOpenActionPerformed(evt);
      }
      else if (evt.getSource() == btnSave) {
        TestKiller.this.btnSaveActionPerformed(evt);
      }
      else if (evt.getSource() == btnSaveAs) {
        TestKiller.this.btnSaveAsActionPerformed(evt);
      }
      else if (evt.getSource() == btnPartitions) {
        TestKiller.this.btnPartitionsActionPerformed(evt);
      }
      else if (evt.getSource() == jmiNew) {
        TestKiller.this.jmiNewActionPerformed(evt);
      }
      else if (evt.getSource() == jmiSave) {
        TestKiller.this.jmiSaveActionPerformed(evt);
      }
      else if (evt.getSource() == jmiSaveAs) {
        TestKiller.this.jmiSaveAsActionPerformed(evt);
      }
      else if (evt.getSource() == jmiRestore) {
        TestKiller.this.jmiRestoreActionPerformed(evt);
      }
      else if (evt.getSource() == jmiRestart) {
        TestKiller.this.jmiRestartActionPerformed(evt);
      }
      else if (evt.getSource() == jmiExit) {
        TestKiller.this.jmiExitActionPerformed(evt);
      }
      else if (evt.getSource() == jmiPrint) {
        TestKiller.this.jmiPrintActionPerformed(evt);
      }
    }

    public void itemStateChanged(java.awt.event.ItemEvent evt) {
      if (evt.getSource() == jmiViewPart) {
        TestKiller.this.jmiViewPartItemStateChanged(evt);
      }
    }

    public void windowActivated(java.awt.event.WindowEvent evt) {
      if (evt.getSource() == TestKiller.this) {
        TestKiller.this.formWindowActivated(evt);
      }
    }

    public void windowClosed(java.awt.event.WindowEvent evt) {
    }

    public void windowClosing(java.awt.event.WindowEvent evt) {
      if (evt.getSource() == TestKiller.this) {
        TestKiller.this.formWindowClosing(evt);
      }
    }

    public void windowDeactivated(java.awt.event.WindowEvent evt) {
      if (evt.getSource() == TestKiller.this) {
        TestKiller.this.formWindowDeactivated(evt);
      }
    }

    public void windowDeiconified(java.awt.event.WindowEvent evt) {
      if (evt.getSource() == TestKiller.this) {
        TestKiller.this.formWindowDeiconified(evt);
      }
    }

    public void windowIconified(java.awt.event.WindowEvent evt) {
      if (evt.getSource() == TestKiller.this) {
        TestKiller.this.formWindowIconified(evt);
      }
    }

    public void windowOpened(java.awt.event.WindowEvent evt) {
    }
  }// </editor-fold>//GEN-END:initComponents

  private void jmiRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRestartActionPerformed
//    op.getGp().restartGame();
  }//GEN-LAST:event_jmiRestartActionPerformed

  private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
//    pwIconified = (partitionWindow.getExtendedState() == ICONIFIED);
//    partitionWindow.setExtendedState(ICONIFIED);
  }//GEN-LAST:event_formWindowIconified

  private void formWindowDeiconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeiconified
    if (!pwIconified) {
//      partitionWindow.setExtendedState(NORMAL);
    }
  }//GEN-LAST:event_formWindowDeiconified

  private void jmiNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewActionPerformed
//    gameSaveFile = null;
//    filename = null;
//    setTitle(titleString);
//    if (op != null) {
//      getContentPane().remove(op);
//    }
//    op = new OuterPane(this);
//    getContentPane().add(op);
//    repaint();
  }//GEN-LAST:event_jmiNewActionPerformed

  private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
//    if (op != null) {
//      op.stopTimer();
//    }
  }//GEN-LAST:event_formWindowDeactivated

  private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
//    if (!pwShown) {
//      pwShown=true;
//      partitionWindow.setVisible(true);
//      partitionWindow.setLocationRelativeTo(this);
//    }
    if (op != null) {
//      op.startTimer();
    }
  }//GEN-LAST:event_formWindowActivated

  private void jmiSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaveActionPerformed
//    if (filename == null) {
//      jmiSaveAsActionPerformed(evt);
//    } else {
//      saveGameToFile(gameSaveFile);
//    }
  }//GEN-LAST:event_jmiSaveActionPerformed

  private void jmiPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPrintActionPerformed
//    PrinterJob pj = PrinterJob.getPrinterJob();
//    boolean printit;
//
////    pj.setPrintable(this);
//    printit = pj.printDialog();
//    System.out.println("Resolution=");
//    if (printit) {
//      try {
//        pj.print();
//      } catch (PrinterException ex) {
//        Logger.getLogger(TestKiller.class.getName()).log(Level.SEVERE, null, ex);
//      }
//    }
//    printAll(getGraphics());
  }//GEN-LAST:event_jmiPrintActionPerformed

//  @Override
//  public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
//    if (pageIndex > 0) {
//      return NO_SUCH_PAGE;
//    }
//    Graphics2D g2d = (Graphics2D) graphics;
//    g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
//    this.printAll(graphics);
//    return PAGE_EXISTS;
//
//  }

//  private void print() {
//    System.out.println("Frame " + this);
//    op.print();
//  }
  private void jmiSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaveAsActionPerformed
//
//    JFileChooser jfc = new JFileChooser();
//    jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//    jfc.setMultiSelectionEnabled(false);
//    jfc.addChoosableFileFilter(jfc.getAcceptAllFileFilter());
////    jfc.addChoosableFileFilter(new KDSFileFilter());
//    jfc.setFileFilter(kDSff);
//    jfc.setCurrentDirectory(lastDirectory);
//    jfc.setSelectedFile(gameSaveFile);
//    int saveResult = jfc.showSaveDialog(this);
//    if (saveResult == JFileChooser.APPROVE_OPTION) {
//      gameSaveFile = jfc.getSelectedFile();
//      if (gameSaveFile == null) {
//        showMessage("Null file found");
//        return;
//      }
//      int i = gameSaveFile.getName().lastIndexOf(".");
//      if (i == -1) {
//        gameSaveFile = new File(gameSaveFile.getAbsolutePath() + "." + fileExtension);
//      }
//      if (gameSaveFile.exists()) {
//        if (JOptionPane.showConfirmDialog(this,
//                "File already exists - do you want to overwrite it?",
//                "Backup to file",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
//          return;
//        }
//      }
//      setFileName();
//      lastDirectory = jfc.getCurrentDirectory();
//      saveGameToFile(gameSaveFile);
//    }
  }//GEN-LAST:event_jmiSaveAsActionPerformed

//  private void setFileName() {
//    filename = gameSaveFile.getName();
//    setTitle(titleString + " " + filename);
//  }

//  private void saveGameToFile(final File f) {
//    ObjectOutputStream oos;
//    try {
//      oos = new ObjectOutputStream(new FileOutputStream(f));
//      if (oos != null) {
//        System.out.println("Saving game to " + f.getName());
//        op.getGp().saveGame(oos);
//        try {
//          oos.close();
//        } catch (IOException ex) {
//        }
//      }
//    } catch (FileNotFoundException ex) {
//      showMessage("Cannot find file " + f.getName());
////      return;
//    } catch (IOException ex) {
//      showMessage("Cannot open file " + f.getName());
////      return;
//    }
//  }

  /**
   * Used to check whether the player wants to save a game before exiting or
   * starting a new game.
   *
   * Checks whether the current game needs saving. If so, it asks the player
   * whether they want to save. replying YES saves the game, NO or CANCEL
   * doesn't save.
   *
   * @return True if answer was YES or NO or the game doesn't need saving, False
   * if CANCEL
   */
  private boolean testDirtySave() {
    if (dirty) {
//      int dialogAnswer = JOptionPane.showConfirmDialog(this,
//              "You have an unsaved game. Save it?",
//              "Killer Sudoku",
//              JOptionPane.YES_NO_CANCEL_OPTION);
//
//      switch (dialogAnswer) {
//        case JOptionPane.CANCEL_OPTION:
//          return false;
//
//        case JOptionPane.YES_OPTION:
//          jmiSaveActionPerformed(null);
//          return true;
//
//        case JOptionPane.NO_OPTION:
//          return true;
//
//        default:
//          throw new AssertionError();
//      }
    } else {
      return true;

    }
    return true;
  }

  private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
    if (testDirtySave()) {
      //    dispose();
      System.exit(0);
    }

  }//GEN-LAST:event_jmiExitActionPerformed

  private void jmiRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRestoreActionPerformed
//    File f;
//
//    if (testDirtySave()) {
//      JFileChooser jfc = new JFileChooser();
//      jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//      jfc.setMultiSelectionEnabled(false);
//      jfc.addChoosableFileFilter(kDSff);
//      jfc.addChoosableFileFilter(jfc.getAcceptAllFileFilter());
//      jfc.setFileFilter(kDSff);
//      jfc.setCurrentDirectory(lastDirectory);
//      int restoreResult = jfc.showOpenDialog(this);
//      if (restoreResult == JFileChooser.APPROVE_OPTION) {
//        f = jfc.getSelectedFile();
//        if (f != null) {
//          if (restoreGameFromFile(f)) {
//            lastDirectory = jfc.getCurrentDirectory();
//            gameSaveFile = f;
//          }
//        }
//      }
//    }
  }//GEN-LAST:event_jmiRestoreActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    jmiExitActionPerformed(null);
}//GEN-LAST:event_formWindowClosing

private void btnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAsActionPerformed
//  jmiSaveAsActionPerformed(null);
}//GEN-LAST:event_btnSaveAsActionPerformed

private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
//   jmiRestoreActionPerformed(null);
}//GEN-LAST:event_btnOpenActionPerformed

private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
//  jmiSaveActionPerformed(null);
}//GEN-LAST:event_btnSaveActionPerformed

private void btnPartitionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartitionsActionPerformed
//  if (partitionWindow != null) {
//    if (partitionWindow.getExtendedState() != NORMAL) {
//      showPartitionsWindow();
//    } else {
//      iconifyPartitionsWindow();
//    }
//  }
}//GEN-LAST:event_btnPartitionsActionPerformed

private void jmiViewPartItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jmiViewPartItemStateChanged
//  if (partitionWindow != null) {
//
//    if (evt.getStateChange() == ItemEvent.SELECTED) {
//      showPartitionsWindow();
//    } else {
//      iconifyPartitionsWindow();
//    }
//  }
}//GEN-LAST:event_jmiViewPartItemStateChanged

  private boolean restoreGameFromFile(File f) {
//    ObjectInputStream ois;
//    try {
//      ois = new ObjectInputStream(new FileInputStream(f));
//      if (ois != null) {
//        System.out.println("Restoring game " + f.getName());
//        if (!op.getGp().restoreGame(ois)) {
////            op.getGp().cleanup(); // doesn't work yet
//          System.out.println("Restore failure");
//          System.exit(1);
//        }
//        try {
//          ois.close();
//        } catch (IOException ex) {
//        }
//        gameSaveFile = f;
//        setFileName();
//        validate();
////          System.out.println("Validated");
//        setVisible(true);
////          print();
//        System.out.println("Restored");
//      }
//    } catch (FileNotFoundException ex) {
//      showMessage("Cannot find file " + f.getName());
//      return false;
//    } catch (IOException ex) {
//      showMessage("Cannot open file " + f.getName());
//      return false;
//    }
    return true;
  }

//  private class KDSFileFilter extends javax.swing.filechooser.FileFilter {
//
//    @Override
//    public boolean accept(File f) {
//      if (f.isDirectory()) {
//        return true;
//      }
//
//      String ext = null;
//      String s = f.getName();
//      int i = s.lastIndexOf('.');
//
//      if (i > 0 && i < s.length() - 1) {
//        ext = s.substring(i + 1).toLowerCase();
//      }
//      return (ext == null || ext.equalsIgnoreCase(fileExtension));
//    }
//
//    @Override
//    public String getDescription() {
//      return "Killer Su Doku games";
//    }
//  }

  /**
   * Allows user to save game Enables icons, menu items etc.
   */
  public void EnableSave() {
    dirty = true;
    jmiSave.setEnabled(true);
    btnSave.setEnabled(true);
  }

  /**
   * Prevents user from saving game Disables icons, menu items etc.
   */
  public void DisableSave() {
    dirty = false;
    jmiSave.setEnabled(false);
    btnSave.setEnabled(false);

  }

  /**
   *
   */
  void minimiseMe() {
    this.setExtendedState(ICONIFIED);
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
//    JOptionPane.showMessageDialog(null,"No. of args:"+ args.length);
    if (args.length > 0) {
      firstArg = args[0];
//      showMessage("Argument: " + firstArg);
//      JOptionPane.showMessageDialog(null,args[0]);
    }
//    showMessage("Java library: "+ System.getProperty("sun.boot.library.path"));
//    showMessage("Java version: "+System.getProperty("java.version"));
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel(
                  UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        new TestKiller().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnOpen;
  private javax.swing.JToggleButton btnPartitions;
  private javax.swing.JButton btnSave;
  private javax.swing.JButton btnSaveAs;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JToolBar jToolBar1;
  private javax.swing.JMenu jmFile;
  private javax.swing.JMenu jmView;
  private javax.swing.JMenuItem jmiExit;
  private javax.swing.JMenuItem jmiNew;
  private javax.swing.JMenuItem jmiPrint;
  private javax.swing.JMenuItem jmiRestart;
  private javax.swing.JMenuItem jmiRestore;
  private javax.swing.JMenuItem jmiSave;
  private javax.swing.JMenuItem jmiSaveAs;
  private javax.swing.JCheckBoxMenuItem jmiViewPart;
  // End of variables declaration//GEN-END:variables

  /**
   * Called when the partitions window is iconified
   */
//  @Override
//  public void partitionWindowIconified() {
//    iconifyPartitionsWindow();
//  }
//
//  /**
//   * Called with the partitions window becomes visible
//   */
//  @Override
//  public void partitionWindowVisible() {
//    showPartitionsWindow();
//  }
}
