/*
 * This entire project is property of their (first and for now unique) author: Hariton Andrei Marius.
 * You can’t copy and redistribute the material in any medium or format, for any purpose, except if authorized by the author of the material.
 * Copyright: Hariton Andrei Marius. All rights reserved.
 */
package ro.hariton.objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * File's object implementation
 *
 * @author Hariton Andrei Marius
 */
public class FileImp implements Cloneable {

    private Path path;
    private String name;
    private Integer charsNumber;
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public FileImp() {
        this.setPath(new Path());
        this.setName("");
        this.setCharsNumber(0);
    }

    public FileImp(Path path, String name, Integer charsNumber) {
        this.setPath(path);
        this.setName(name);
        this.setCharsNumber(charsNumber);
    }

    public FileImp(Path path, String name, Integer charsNumber, File file, FileReader fileReader, BufferedReader bufferedReader) {
        this(path, name, charsNumber);

        this.setFile(file);
        this.setFileReader(fileReader);
        this.setBufferedReader(bufferedReader);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCharsNumber() {
        return charsNumber;
    }

    public void setCharsNumber(Integer charsNumber) {
        this.charsNumber = charsNumber;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    /**
     * Makes the "File" objects clone-able
     *
     * @return A clone of the current "File" object
     * @throws CloneNotSupportedException Clone not supported exception
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        FileImp f = (FileImp) super.clone();
        return f;
    }
}
