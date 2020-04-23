/*
 * This entire project is property of their (first and for now unique) author: Hariton Andrei Marius.
 * You can’t copy and redistribute the material in any medium or format, for any purpose, except if authorized by the author of the material.
 * Copyright: Hariton Andrei Marius. All rights reserved.
 */
package ro.hariton.gui.components;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import ro.hariton.gui.windows.Principal;

/**
 * Tools bar for Principal window
 *
 * @author Hariton Andrei Marius
 */
public class BarTop {

    private Principal parent;
    private JTextField toolsArea;
    private JScrollPane toolsView;

    public BarTop(Principal mainWindow) {
        this.setParent(mainWindow);
        this.setToolsArea(new JTextField("No tools available"));
        this.setToolsView(new JScrollPane(this.getToolsArea()));
        this.getToolsArea().setEnabled(false);
        this.getToolsArea().setBorder(BorderFactory.createEmptyBorder());
    }

    public Principal getParent() {
        return parent;
    }

    public void setParent(Principal parent) {
        this.parent = parent;
    }

    public JScrollPane getToolsView() {
        return toolsView;
    }

    public void setToolsView(JScrollPane toolsView) {
        this.toolsView = toolsView;
    }

    public JTextField getToolsArea() {
        return toolsArea;
    }

    public void setToolsArea(JTextField toolsArea) {
        this.toolsArea = toolsArea;
    }
}
