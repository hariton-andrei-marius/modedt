/*
 * This entire project is property of their (first and for now unique) author: Hariton Andrei Marius.
 * You can’t copy and redistribute the material in any medium or format, for any purpose, except if authorized by the author of the material.
 * Copyright: Hariton Andrei Marius. All rights reserved.
 */
package ro.hariton.objects;

/**
 * Path data (versions) of File
 *
 * @author Hariton Andrei Marius
 */
public class Path {

    private String path;
    private String canonical;
    private String absolute;

    public Path() {
        this.setPath("");
        this.setCanonical("");
        this.setAbsolute("");
    }

    public Path(String path, String canonical, String absolute) {
        this.setPath(path);
        this.setCanonical(canonical);
        this.setAbsolute(absolute);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCanonical() {
        return canonical;
    }

    public void setCanonical(String canonical) {
        this.canonical = canonical;
    }

    public String getAbsolute() {
        return absolute;
    }

    public void setAbsolute(String absolute) {
        this.absolute = absolute;
    }

    @Override
    public String toString() {
        return this.getPath();
    }
}
