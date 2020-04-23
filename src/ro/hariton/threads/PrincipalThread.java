/*
 * This entire project is property of their (first and for now unique) author: Hariton Andrei Marius.
 * You can’t copy and redistribute the material in any medium or format, for any purpose, except if authorized by the author of the material.
 * Copyright: Hariton Andrei Marius. All rights reserved.
 */
package ro.hariton.threads;

import ro.hariton.gui.ManagerGUI;
import ro.hariton.objects.Files;

/**
 * Main thread class
 *
 * @author Hariton Andrei Marius
 */
public class PrincipalThread implements Runnable {
    
    String name;
    Files files;
    ManagerGUI baseGUI;

    /**
     * The constructor of the main thread
     */
    public PrincipalThread() {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Files getFiles() {
        return files;
    }
    
    public void setFiles(Files files) {
        this.files = files;
    }
    
    public ManagerGUI getBaseGUI() {
        return baseGUI;
    }
    
    public void setBaseGUI(ManagerGUI baseGUI) {
        this.baseGUI = baseGUI;
    }

    /**
     * The run method of the thread
     */
    @Override
    public void run() {
        this.setName(Thread.currentThread().toString());
        this.setFiles(new Files());
        this.setBaseGUI(new ManagerGUI(this));
    }
}
