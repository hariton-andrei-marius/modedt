/*
 * This entire project is property of their (first and for now unique) author: Hariton Andrei Marius.
 * You can’t copy and redistribute the material in any medium or format, for any purpose, except if authorized by the author of the material.
 * Copyright: Hariton Andrei Marius. All rights reserved.
 */
package ro.hariton.gui.windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import ro.hariton.gui.WrapperGUI;
import ro.hariton.gui.components.BarBottom;
import ro.hariton.gui.components.BarTop;
import ro.hariton.gui.components.ContainerMain;

/**
 *
 * @author harit
 */
public final class Principal extends JFrame {

    private WrapperGUI windowsManager;
    private JFrame frameMain;
    private JPanel panelMain;
    private JMenuBar topBar;

    private ContainerMain textEditor;
    private BarTop barTools;
    private BarBottom barInfo;

    public Principal(WrapperGUI windowsManager) {

        this.setWindowsManager(windowsManager);
        this.setFrameMain(new JFrame("Modedt"));
        this.setPanelMain(new JPanel());
        this.setTopBar(new JMenuBar());

        this.setTextEditor(new ContainerMain(this));
        this.setBarTools(new BarTop(this));
        this.setBarInfo(new BarBottom(this));

        this.getFrameMain().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.initializeInterface();

        this.getPanelMain().setLayout(new BorderLayout(5, 5));
        this.getPanelMain().add(this.getBarTools().getToolsView(), BorderLayout.PAGE_START);
        this.getPanelMain().add(this.getTextEditor().getEditorView(), BorderLayout.CENTER);
        this.getPanelMain().add(this.getBarInfo().getInfoView(), BorderLayout.PAGE_END);

        this.getFrameMain().setJMenuBar(topBar);
        this.getFrameMain().add(this.getPanelMain());
        this.getFrameMain().setSize(1280, 720);
        this.getFrameMain().setMinimumSize(new Dimension(800, 480));
        this.getFrameMain().setVisible(true);

    }

    // GETTERS and SETTERS
    public WrapperGUI getWindowsManager() {
        return windowsManager;
    }

    public void setWindowsManager(WrapperGUI windowsManager) {
        this.windowsManager = windowsManager;
    }

    public JFrame getFrameMain() {
        return frameMain;
    }

    public void setFrameMain(JFrame frameMain) {
        this.frameMain = frameMain;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JMenuBar getTopBar() {
        return topBar;
    }

    public void setTopBar(JMenuBar topBar) {
        this.topBar = topBar;
    }

    public ContainerMain getTextEditor() {
        return textEditor;
    }

    public void setTextEditor(ContainerMain textEditor) {
        this.textEditor = textEditor;
    }

    public BarTop getBarTools() {
        return barTools;
    }

    public void setBarTools(BarTop barTools) {
        this.barTools = barTools;
    }

    public BarBottom getBarInfo() {
        return barInfo;
    }

    public void setBarInfo(BarBottom barInfo) {
        this.barInfo = barInfo;
    }

    // OTHER
    private void initializeInterface() {
        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");
        JMenu menuTools = new JMenu("Tools");

        JMenuItem[] menuItems = new JMenuItem[10];

        this.setMenuItems(menuItems);
        this.setMenuItemsAccelerators(menuItems);
        this.setMenuItemsIcons(menuItems);
        this.setMenuItemsListeners(menuItems);
        this.assignMenuItems(menuFile, menuEdit, menuTools, menuItems);

        menuItems[8].setEnabled(false);

        this.getTopBar().add(menuFile);
        this.getTopBar().add(menuEdit);
        this.getTopBar().add(menuTools);
    }

    // FOR INITIALIZE INTERFACE
    private void setMenuItems(JMenuItem[] menuItems) {
        menuItems[0] = new JMenuItem("New");
        menuItems[1] = new JMenuItem("Open", KeyEvent.VK_T);
        menuItems[2] = new JMenuItem("Save");
        menuItems[3] = new JMenuItem("Print");
        menuItems[4] = new JMenuItem("Cut");
        menuItems[5] = new JMenuItem("Copy");
        menuItems[6] = new JMenuItem("Paste");
        menuItems[7] = new JMenuItem("Close");
        menuItems[8] = new JMenuItem("Settings");
        menuItems[9] = new JMenuItem("About");
    }

    private void setMenuItemsAccelerators(JMenuItem[] menuItems) {
        menuItems[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItems[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menuItems[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuItems[3].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        menuItems[4].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        menuItems[5].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        menuItems[6].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        menuItems[7].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
        menuItems[8].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menuItems[9].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.ALT_MASK));
    }

    private void setMenuItemsIcons(JMenuItem[] menuItems) {
        menuItems[0].setIcon(new ImageIcon(getClass().getResource("/images/new.png")));
        menuItems[1].setIcon(new ImageIcon(getClass().getResource("/images/open.png")));
        menuItems[2].setIcon(new ImageIcon(getClass().getResource("/images/save.png")));
        menuItems[3].setIcon(new ImageIcon(getClass().getResource("/images/print.png")));
    }

    private void setMenuItemsListeners(JMenuItem[] menuItems) {
        menuItems[0].addActionListener(this.windowsManager.getActionsListener());
        menuItems[1].addActionListener(this.windowsManager.getActionsListener());
        menuItems[2].addActionListener(this.windowsManager.getActionsListener());
        menuItems[3].addActionListener(this.windowsManager.getActionsListener());
        menuItems[4].addActionListener(this.windowsManager.getActionsListener());
        menuItems[5].addActionListener(this.windowsManager.getActionsListener());
        menuItems[6].addActionListener(this.windowsManager.getActionsListener());
        menuItems[7].addActionListener(this.windowsManager.getActionsListener());
        menuItems[8].addActionListener(this.windowsManager.getActionsListener());
        menuItems[9].addActionListener(this.windowsManager.getActionsListener());
    }

    private void assignMenuItems(JMenu menuFile, JMenu menuEdit, JMenu menuTools, JMenuItem[] menuItems) {
        menuFile.add(menuItems[0]);
        menuFile.add(menuItems[1]);
        menuFile.add(menuItems[2]);
        menuFile.addSeparator();
        menuFile.add(menuItems[3]);
        menuFile.addSeparator();
        menuFile.add(menuItems[7]);

        menuEdit.add(menuItems[4]);
        menuEdit.add(menuItems[5]);
        menuEdit.add(menuItems[6]);

        menuTools.add(menuItems[8]);
        menuTools.add(menuItems[9]);
    }
}
