package xyz.codingmentor.consoleclient.service.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tibor Kun
 */
public class URLProperty {

    private static final Properties PROP = new Properties();

    private URLProperty() {
        // hide the implicit public constructor
    }

    public static String getURL(String key) {
        try (InputStream input = new FileInputStream("src\\main\\resources\\URL.properties")) {
            PROP.load(input);
            return PROP.getProperty(key);
        } catch (IOException ex) {
            Logger.getLogger(URLProperty.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
