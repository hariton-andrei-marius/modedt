/*
 * This entire project is property of their (first and for now unique) author: Hariton Andrei Marius.
 * You can’t copy and redistribute the material in any medium or format, for any purpose, except if authorized by the author of the material.
 * Copyright: Hariton Andrei Marius. All rights reserved.
 */
package ro.hariton.gui;

import javax.swing.*;
import ro.hariton.gui.windows.Principal;
import ro.hariton.threads.PrincipalThread;

/**
 * Parent of Principal window and Children of Principal thread
 *
 * @author Hariton Andrei Marius
 */
public class WrapperGUI extends JFrame {

    private PrincipalThread thread;
    private ListenerGUI actionsListener;
    private Principal mainWindow;

    /**
     * The constructor of the base container
     */
    public WrapperGUI(PrincipalThread thread) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.exit(500);
        }

        this.setThread(thread);
        this.setActionsListener(new ListenerGUI(this));
        this.setMainWindow(new Principal(this));

    }

    // GETTERS AND SETTERS
    public PrincipalThread getThread() {
        return thread;
    }

    public void setThread(PrincipalThread thread) {
        this.thread = thread;
    }

    public ListenerGUI getActionsListener() {
        return this.actionsListener;
    }

    public void setActionsListener(ListenerGUI actionsListener) {
        this.actionsListener = actionsListener;
    }

    public Principal getMainWindow() {
        return this.mainWindow;
    }

    public void setMainWindow(Principal mainWindow) {
        this.mainWindow = mainWindow;
    }
}
