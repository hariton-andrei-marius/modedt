/*
 * This entire project is property of their (first and for now unique) author: Hariton Andrei Marius.
 * You can’t copy and redistribute the material in any medium or format, for any purpose, except if authorized by the author of the material.
 * Copyright: Hariton Andrei Marius. All rights reserved.
 */
package ro.hariton.objects;

import java.util.ArrayList;
import java.util.TreeMap;
import ro.hariton.exceptions.FileException;

/**
 * List of files
 *
 * @author Hariton Andrei Marius
 */
public class Files {

    private TreeMap<String, FileImp> files;

    public Files() {
        this.setFiles(new TreeMap<>());
    }

    public Files(TreeMap<String, FileImp> files) {
        this.setFiles(files);
    }

    // GETTERS and SETTERS
    public TreeMap<String, FileImp> getFiles() {
        return files;
    }

    public void setFiles(TreeMap<String, FileImp> files) {
        this.files = files;
    }

    // OTHER
    /**
     * Adds a file
     *
     * @param f The file
     * @throws FileException File's exception
     * @throws CloneNotSupportedException Clone not supported exception
     * @throws NullPointerException Null pointer exception
     */
    public void addFile(FileImp f)
            throws FileException,
            CloneNotSupportedException, NullPointerException {
        if (!files.containsKey(f.getPath().toString())) {
            files.put(f.getPath().toString(), (FileImp) f.clone());
        } else {
            throw new FileException("Already exists");
        }
    }

    public String getLastName()
            throws CloneNotSupportedException {

        FileImp file = null;

        for (FileImp f : files.values()) {
            if (f.getPath().getPath().equals((files.lastKey()))) {
                file = (FileImp) f.clone();
            }
        }

        if (file != null) {
            System.out.println(file.getName());
            return file.getName();

        }

        return "";
    }

}
