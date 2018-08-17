/***************************************
 *                                     *
 *  JBoss: The OpenSource J2EE WebOS   *
 *                                     *
 *  Distributable under LGPL license.  *
 *  See terms of license at gnu.org.   *
 *                                     *
 ***************************************/

package org.jboss.example.counter;

import java.io.IOException;
import java.io.Serializable;
import org.apache.log4j.Logger;

/**
 *
 * @author  Stan Silvert
 */
public class Counter implements Serializable {
    public static final Logger LOG = Logger.getLogger(Counter.class);
    
    private int counter = 0;
    
    /** Creates a new instance of NotSerializable */
    public Counter() {
        LOG.info("************************");
        LOG.info("Counter is being created");
        LOG.info("************************");
    }
    
    public void increment() {
        this.counter++;
    }
    
    public int getValue() {
        return this.counter;
    }
    
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        LOG.info("****************************");
        LOG.info("Serialization is under way.");
        LOG.info("Counter = " + this.counter);
        LOG.info("****************************");
        
        out.defaultWriteObject();
    }
    
    private void readObject(java.io.ObjectInputStream in)
        throws IOException, ClassNotFoundException {
            
        in.defaultReadObject();
        
        LOG.info("****************************");
        LOG.info("I've been desrialized!!!");
        LOG.info("Counter = " + counter);
        LOG.info("****************************");
        
    }

}
