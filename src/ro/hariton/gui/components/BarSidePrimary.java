/*
 * This entire project is property of their (first and for now unique) author: Hariton Andrei Marius.
 * You can’t copy and redistribute the material in any medium or format, for any purpose, except if authorized by the author of the material.
 * Copyright: Hariton Andrei Marius. All rights reserved.
 */
package ro.hariton.gui.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.TreeMap;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import ro.hariton.gui.windows.Principal;
import ro.hariton.objects.FileImp;
import ro.hariton.objects.Files;

/**
 * Directory tree bar for Principal window
 *
 * @author Hariton Andrei Marius
 */
public class BarSidePrimary {

    private Principal parent;
    private JScrollPane treeView;
    private JTree directoryContent;
    private DefaultMutableTreeNode top;

    public BarSidePrimary(Principal mainWindow) {
        this.setParent(mainWindow);

        this.top = new DefaultMutableTreeNode("Current Project");
        //createNodes(top);

        this.setDirectoryContent(new JTree(this.top));
        this.setTreeView(new JScrollPane(directoryContent));
        this.getDirectoryContent().setEnabled(false);
        this.getDirectoryContent().setEditable(false);
    }

    // GETTERS and SETTERS
    public JScrollPane getTreeView() {
        return treeView;
    }

    public void setTreeView(JScrollPane treeView) {
        this.treeView = treeView;
    }

    public JTree getDirectoryContent() {
        return directoryContent;
    }

    public void setDirectoryContent(JTree directoryContent) {
        this.directoryContent = directoryContent;
    }

    public void setDirectoryContent(Files files) {
        //this.top.set
        // TODO: understand why tree update is so ball-breaking :)
    }

    public Principal getParent() {
        return parent;
    }

    public void setParent(Principal parent) {
        this.parent = parent;
    }

    // OTHER
    private void createNodes(DefaultMutableTreeNode top) {
        /*DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode item = null;

        category = new DefaultMutableTreeNode("Current Directory");
        top.add(category);

        item = new DefaultMutableTreeNode("Current File");
        category.add(item);
        item = new DefaultMutableTreeNode("Current File");
        top.add(item);*/

        top.add(new DefaultMutableTreeNode("Current File"));
    }

}
