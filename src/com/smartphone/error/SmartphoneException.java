/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.error;

/**
 *
 * @author andra
 */
public class SmartphoneException extends Exception {

    /**
     * Creates a new instance of <code>SmartphoneException</code> without detail
     * message.
     */
    public SmartphoneException() {
    }

    /**
     * Constructs an instance of <code>SmartphoneException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SmartphoneException(String msg) {
        super(msg);
    }
}
