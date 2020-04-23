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
 * Options bar for Principal window
 *
 * @author Hariton Andrei Marius
 */
public class BarSideSecondary {

    private Principal parent;
    private JTextField optionsArea;
    private JScrollPane optionsView;

    public BarSideSecondary(Principal mainWindow) {
        this.setParent(mainWindow);
        this.setOptionsArea(new JTextField("No options available"));
        this.setOptionsView(new JScrollPane(this.getOptionsArea()));
        this.getOptionsArea().setEnabled(false);
        this.getOptionsArea().setBorder(BorderFactory.createEmptyBorder());
    }

    public Principal getParent() {
        return parent;
    }

    public void setParent(Principal parent) {
        this.parent = parent;
    }

    public JScrollPane getOptionsView() {
        return optionsView;
    }

    public void setOptionsView(JScrollPane optionsView) {
        this.optionsView = optionsView;
    }

    public JTextField getOptionsArea() {
        return optionsArea;
    }

    public void setOptionsArea(JTextField optionsArea) {
        this.optionsArea = optionsArea;
    }

}
