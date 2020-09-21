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
import java.util.TreeMap;
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

    private WrapperGUI windowsManager;

    public ListenerGUI(WrapperGUI windowsManager) {
        this.setWindowsManager(windowsManager);
    }

    public WrapperGUI getWindowsManager() {
        return windowsManager;
    }

    public void setWindowsManager(WrapperGUI windowsManager) {
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
                this.onAbout();
                break;
            case "Settings":
                this.onSettings();
                break;
            case "Close":
                this.onClose();
                break;
            case "New":
                this.onNew();
                break;
            case "Cut":
                this.onCut();
                break;
            case "Copy":
                this.onCopy();
                break;
            case "Paste":
                this.onPaste();
                break;
            case "Print":
                this.onPrint();
                break;
            case "Open":
                this.onOpen();
                break;
            case "Save":
                this.onSave();
                break;
            default:
                break;
        }
    }

    // FOR SWITCH
    private void onAbout() {
        JOptionPane.showMessageDialog(
                this.windowsManager.getMainWindow().getFrameMain(),
                "Version: 0.4.0.4 Alpha.\nCopyright: Hariton Andrei Marius.\nAll rights reserved."
        );
    }

    private void onSettings() {
    }

    private void onClose() {
        System.exit(0);
    }

    private void onNew() {
        this.windowsManager.getMainWindow().getTextEditor().getEditorArea().setText("");
        this.windowsManager.getMainWindow().getBarTools().getToolsArea().setText("New File");
    }

    private void onCut() {
        this.windowsManager.getMainWindow().getTextEditor().getEditorArea().cut();
    }

    private void onCopy() {
        this.windowsManager.getMainWindow().getTextEditor().getEditorArea().copy();
    }

    private void onPaste() {
        this.windowsManager.getMainWindow().getTextEditor().getEditorArea().paste();
    }

    private void onPrint() {
        JTextPane textAreaPrint = new JTextPane();

        textAreaPrint.setText(this.windowsManager.getMainWindow().getTextEditor().getEditorArea().getText());
        textAreaPrint.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 8));

        try {
            textAreaPrint.print();
        } catch (PrinterException evt) {
            JOptionPane.showMessageDialog(this.windowsManager.getMainWindow().getFrameMain(), evt.getMessage());
        }
    }

    private void onOpen() {
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

                this.getWindowsManager().getThread().getFiles().setFiles(new TreeMap<>());
                this.getWindowsManager().getThread().getFiles().addFile(new FileImp(path, fi.getName(), readedLines.length()));

                this.windowsManager.getMainWindow().getTextEditor().getEditorArea().setText(readedLines);

                try {
                    this.windowsManager.getMainWindow().getBarTools().getToolsArea().setText(this.windowsManager.getThread().getFiles().getLastName());
                } catch (CloneNotSupportedException ex) {
                }
            } catch (Exception evt) {
                JOptionPane.showMessageDialog(this.windowsManager.getMainWindow().getFrameMain(), evt.getMessage());
            }
        }
    }

    private void onSave() {
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
    }
}
