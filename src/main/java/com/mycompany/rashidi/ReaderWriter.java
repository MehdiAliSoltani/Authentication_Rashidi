/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rashidi;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mehdi
 */
public class ReaderWriter {

    public boolean writeObjectToFile(String filename, User user) {
//        FileOutputStream file;
        ObjectOutputStream objFile = null;
        try {
//            file = new FileOutputStream(filename);
            objFile = new ObjectOutputStream(
                      new BufferedOutputStream(
                              Files.newOutputStream(Paths.get(filename))));
            objFile.writeObject(user);
            objFile.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    public boolean writeObjectsToFile(String filename, User[] users) {
        FileOutputStream file;
        ObjectOutputStream objFile = null;
        try {
              objFile = new ObjectOutputStream(
                      new BufferedOutputStream(
                              Files.newOutputStream(Paths.get(filename))));
            for (User user:users) {
                objFile.writeObject(user);
            }
            
            objFile.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
  /*  public List<User> readObjectsFromFile(String filename) {
        FileInputStream file;
        ObjectInputStream objFile = null;
        List<User> users = new ArrayList<User>();
        try {
            file = new FileInputStream(filename);
            objFile = new ObjectInputStream(file);
            objFile.readObject()
            objFile.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
  */  

}
