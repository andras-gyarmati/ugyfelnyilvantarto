package xyz.codingmentor.team3.registry.dbfiller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author brianelete
 */
public class Writer {

    File file;
    BufferedWriter writer;

    public Writer() {
        //empty
    }

    public void write(String text, String fileName) throws FileNotFoundException, IOException {
        file = new File("output/" + fileName);
        writer = new BufferedWriter(new FileWriter(file));
        writer.write(text);
        writer.close();
    }
}
