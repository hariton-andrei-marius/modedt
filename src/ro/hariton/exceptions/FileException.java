/*
 * This entire project is property of their (first and for now unique) author: Hariton Andrei Marius.
 * You can’t copy and redistribute the material in any medium or format, for any purpose, except if authorized by the author of the material.
 * Copyright: Hariton Andrei Marius. All rights reserved.
 */
package ro.hariton.exceptions;

/**
 * File's exception class
 *
 * @author Hariton Andrei Marius
 */
public class FileException extends Exception {

    /**
     * Constructor with generic message
     */
    public FileException() {
        super("Generic file exception");

        System.out.println(this.toString());
    }

    /**
     * Constructor with custom message
     *
     * @param ex The exception's message
     */
    public FileException(String ex) {
        super(ex);

        System.out.println(this.toString());
    }
}
