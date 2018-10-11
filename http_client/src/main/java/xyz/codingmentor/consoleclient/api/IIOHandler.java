package xyz.codingmentor.consoleclient.api;

import java.util.Date;

/**
 *
 * @author Tibor Kun
 */
public interface IIOHandler {

    String getString(String message);

    String getString();

    String getPassword();

    Integer getInteger();

    Long getLong();

    Date getDate();

    void outln(String output);

    void out(String output);

}
