package xyz.codingmentor.consoleclient.service.io;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author Tibor Kun
 */
public class IOFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return record.getMessage() + "\n";
    }
}
