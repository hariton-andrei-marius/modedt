/*
 * This entire project is property of their (first and for now unique) author: Hariton Andrei Marius.
 * You can’t copy and redistribute the material in any medium or format, for any purpose, except if authorized by the author of the material.
 * Copyright: Hariton Andrei Marius. All rights reserved.
 */
package ro.hariton.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import ro.hariton.objects.FileImp;
import ro.hariton.objects.Path;

/**
 * Actions listener for Menu of Principal window
 *
 * @author Hariton Andrei Marius
 */
public class ListenerGUI implements ActionListener {

    private ManagerGUI windowsManager;

    public ListenerGUI(ManagerGUI windowsManager) {
        this.setWindowsManager(windowsManager);
    }

    public ManagerGUI getWindowsManager() {
        return windowsManager;
    }

    public void setWindowsManager(ManagerGUI windowsManager) {
        this.windowsManager = windowsManager;
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        switch (s) {
            case "About":
                JOptionPane.showMessageDialog(this.windowsManager.getMainWindow().getFrameMain(), "Author & Copyright: Hariton Andrei Marius. All rights reserved.");
                break;
            case "Settings":
                break;
            case "Close": {
                System.exit(0);
                break;
            }
            case "New":
                this.windowsManager.getMainWindow().getTextEditor().getEditorArea().setText("");
                break;
            case "Cut":
                this.windowsManager.getMainWindow().getTextEditor().getEditorArea().cut();
                break;
            case "Copy":
                this.windowsManager.getMainWindow().getTextEditor().getEditorArea().copy();
                break;
            case "Paste":
                this.windowsManager.getMainWindow().getTextEditor().getEditorArea().paste();
                break;
            case "Print": {
                JTextPane textAreaPrint = new JTextPane();

                textAreaPrint.setText(this.windowsManager.getMainWindow().getTextEditor().getEditorArea().getText());
                textAreaPrint.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 8));

                try {
                    textAreaPrint.print();
                } catch (PrinterException evt) {
                    JOptionPane.showMessageDialog(this.windowsManager.getMainWindow().getFrameMain(), evt.getMessage());
                }

                break;
            }
            case "Open": {
                JFileChooser fileChooser = new JFileChooser();
                int response = fileChooser.showOpenDialog(null);

                if (JFileChooser.APPROVE_OPTION != response) {
                    JOptionPane.showMessageDialog(this.windowsManager.getMainWindow().getFrameMain(), "Operation deleted !");
                } else {
                    File fi = new File(fileChooser.getSelectedFile().getAbsolutePath());

                    try {

                        String readLine, readedLines = "";
                        FileReader fr = new FileReader(fi);
                        BufferedReader bufferedReader = new BufferedReader(fr);

                        while ((readLine = bufferedReader.readLine()) != null) {
                            String separator = readedLines.length() > 0 ? "\n" : "";

                            readedLines = readedLines + separator + readLine;
                        }

                        Path path = new Path(fi.getPath(), fi.getCanonicalPath(), fi.getAbsolutePath());

                        this.getWindowsManager().getThread().getFiles().addFile(new FileImp(path, fi.getName(), readedLines.length()));

                        this.windowsManager.getMainWindow().getTextEditor().getEditorArea().setText(readedLines);
                        this.windowsManager.getMainWindow().getBarTree().setDirectoryContent(this.getWindowsManager().getThread().getFiles());

                        // TESTING PANES FEATURES
                        //SimpleAttributeSet attributeSet = new SimpleAttributeSet();
                        //StyleConstants.setForeground(attributeSet, Color.ORANGE);
                        //textArea.getStyledDocument().setCharacterAttributes(5, 15, attributeSet, rootPaneCheckingEnabled);
                    } catch (Exception evt) {
                        JOptionPane.showMessageDialog(this.windowsManager.getMainWindow().getFrameMain(), evt.getMessage());
                    }
                }

                break;
            }
            case "Save": {
                JFileChooser fileChooser = new JFileChooser();
                int response = fileChooser.showSaveDialog(null);

                if (JFileChooser.APPROVE_OPTION != response) {
                    JOptionPane.showMessageDialog(this.windowsManager.getMainWindow().getFrameMain(), "Operation deleted !");
                } else {
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                    try {
                        FileWriter fileWriter = new FileWriter(file, false);
                        BufferedWriter bufferedWriter;

                        bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(this.windowsManager.getMainWindow().getTextEditor().getEditorArea().getText());
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException evt) {
                        JOptionPane.showMessageDialog(this.windowsManager.getMainWindow().getFrameMain(), evt.getMessage());
                    }
                }

                break;
            }
            default:
                break;
        }
    }
}
