/*
 * This entire project is property of their (first and for now unique) author: Hariton Andrei Marius.
 * You can’t copy and redistribute the material in any medium or format, for any purpose, except if authorized by the author of the material.
 * Copyright: Hariton Andrei Marius. All rights reserved.
 */
package ro.hariton.gui.components;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import ro.hariton.gui.windows.Principal;

/**
 * Info bar for Principal window
 *
 * @author Hariton Andrei Marius
 */
public class BarBottom {
    
    private Principal parent;
    private JTextField infoView;
    
    public BarBottom(Principal mainWindow) {
        this.setParent(mainWindow);
        this.setInfoView(new JTextField(this.getParent().getWindowsManager().getThread().getName()));
        this.getInfoView().setEnabled(false);
        this.getInfoView().setBorder(BorderFactory.createEmptyBorder());
    }
    
    public Principal getParent() {
        return parent;
    }
    
    public void setParent(Principal parent) {
        this.parent = parent;
    }
    
    public JTextField getInfoView() {
        return infoView;
    }
    
    public void setInfoView(JTextField infoView) {
        this.infoView = infoView;
    }
}
