/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.exception;

/**
 *
 * @author root
 */
public class EntityInstanceNotFound extends Exception {

    /**
     * Creates a new instance of <code>EntityInstanceNotFound</code> without
     * detail message.
     */
    public EntityInstanceNotFound() {
    }

    /**
     * Constructs an instance of <code>EntityInstanceNotFound</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EntityInstanceNotFound(String msg) {
        super(msg);
    }
}
