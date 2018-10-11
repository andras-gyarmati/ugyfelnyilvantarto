package xyz.codingmentor.consoleclient.service.io;

import java.awt.AWTException;
import java.awt.Robot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.consoleclient.api.IIOHandler;

/**
 *
 * @author Tibor Kun
 */
public class IOHandler implements IIOHandler {

    private final Scanner scanner;
    private final Handler handler;
    private final IOFormatter ioFormatter;
    private final NoNewLineIOFormatter nonewLineIOFormatter;
    private final String erorrMsg;
    private static final Logger LOG = Logger.getLogger(IOHandler.class.getName());
    private static IOHandler instance;

    private IOHandler() {
        this.scanner = new Scanner(System.in);
        this.handler = new ConsoleHandler();
        this.ioFormatter = new IOFormatter();
        this.nonewLineIOFormatter = new NoNewLineIOFormatter();
        this.erorrMsg = "Sorry, that's not valid. Please try again: ";
    }

    public static IOHandler getInstance() {
        if (null == instance) {
            instance = new IOHandler();
        }
        return instance;
    }

    @Override
    public String getString(String message) {
        out(message);
        return getString();
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public String getPassword() {
        try {
            return new String(System.console().readPassword());
        } catch (NullPointerException ex) {
            Logger.getLogger(IOHandler.class.getName()).log(Level.FINE, erorrMsg, ex);
        }
        return scanner.nextLine();
    }

    @Override
    public Integer getInteger() {
        Integer number = null;
        while (number == null) {
            String line = scanner.nextLine();
            try {
                number = Integer.parseInt(line);
                return number;
            } catch (NumberFormatException ex) {
                Logger.getLogger(IOHandler.class.getName()).log(Level.FINE, erorrMsg, ex);
                out(erorrMsg);
            }
        }
        return null;
    }

    @Override
    public Long getLong() {
        Long number = null;
        while (number == null) {
            String line = scanner.nextLine();
            try {
                number = Long.parseLong(line);
                return number;
            } catch (NumberFormatException ex) {
                Logger.getLogger(IOHandler.class.getName()).log(Level.FINE, erorrMsg, ex);
                out(erorrMsg);
            }
        }
        return null;
    }

    @Override
    public Date getDate() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US);
        out("Enter date(current time " + format.format(new Date()) + "): ");
        Date date = null;
        while (date == null) {
            String line = scanner.nextLine();
            try {
                date = format.parse(line);
                return date;
            } catch (java.text.ParseException ex) {
                Logger.getLogger(IOHandler.class.getName()).log(Level.FINE, null, ex);
                out(erorrMsg);
            }
        }
        return null;
    }

    @Override
    public void outln(String output) {
        formatter();
        LOG.log(Level.INFO, output);
        LOG.removeHandler(handler);
    }

    private void formatter() {
        LOG.setUseParentHandlers(false);
        handler.setFormatter(ioFormatter);
        LOG.addHandler(handler);
    }

    @Override
    public void out(String output) {
        noNewLineFormatter();
        LOG.log(Level.INFO, output);
        LOG.removeHandler(handler);
    }

    private void noNewLineFormatter() {
        LOG.setUseParentHandlers(false);
        handler.setFormatter(nonewLineIOFormatter);
        LOG.addHandler(handler);
    }

    public static void clearScreen() {
        if (null == System.console()) {
            try {
                Robot pressbot = new Robot();
                pressbot.keyPress(17); // Holds CTRL key.
                pressbot.keyPress(76); // Holds L key.
                pressbot.keyRelease(17); // Releases CTRL key.
                pressbot.keyRelease(76); // Releases L key.
                pressbot.delay(50);
            } catch (AWTException ex) {
                Logger.getLogger(IOHandler.class.getName()).log(Level.FINE, null, ex);
            }
        }
    }

}
