package xyz.codingmentor.team3.registry.dbfiller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author brianelete
 */
public class Reader {

    Scanner fileIn;
    String line;

    public Reader() {
        //empty
    }

    public List<String> read(String fileName) throws FileNotFoundException {
        this.fileIn = new Scanner(new File(fileName));
        List<String> lines = new ArrayList<>();
        while (fileIn.hasNextLine()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        return lines;
    }
}
