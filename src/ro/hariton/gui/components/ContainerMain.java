/*
 * This entire project is property of their (first and for now unique) author: Hariton Andrei Marius.
 * You can’t copy and redistribute the material in any medium or format, for any purpose, except if authorized by the author of the material.
 * Copyright: Hariton Andrei Marius. All rights reserved.
 */
package ro.hariton.gui.components;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import ro.hariton.gui.windows.Principal;

/**
 * Editor container for Principal window
 *
 * @author Hariton Andrei Marius
 */
public class ContainerMain {

    private Principal parent;
    private JTextPane editorArea;
    private JScrollPane editorView;

    public ContainerMain(Principal mainWindow) {
        this.setParent(mainWindow);
        this.setEditorArea(new JTextPane());
        this.setEditorView(new JScrollPane(this.getEditorArea()));
        // remember set background and foreground of editor area
    }

    public Principal getParent() {
        return parent;
    }

    public void setParent(Principal parent) {
        this.parent = parent;
    }

    public JTextPane getEditorArea() {
        return editorArea;
    }

    public void setEditorArea(JTextPane editorArea) {
        this.editorArea = editorArea;
        this.editorArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
    }

    public JScrollPane getEditorView() {
        return editorView;
    }

    public void setEditorView(JScrollPane editorView) {
        this.editorView = editorView;
        this.editorView.setPreferredSize(new Dimension(800, 600));
    }
}
