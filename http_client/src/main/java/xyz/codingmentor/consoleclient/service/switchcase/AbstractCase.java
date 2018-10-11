package xyz.codingmentor.consoleclient.service.switchcase;

import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.ICase;
import xyz.codingmentor.consoleclient.service.io.IOHandler;

/**
 *
 * @author Tibor Kun
 */
public abstract class AbstractCase implements ICase {

    private String caseName;
    private final String url;

    public AbstractCase(String caseName, String url) {
        this.caseName = caseName;
        this.url = url;
    }

    @Override
    public void run() {
        IOHandler.clearScreen();
        Application.IO.outln(caseMsg());
        getInput();
        executeCase();
    }

    public String caseMsg() {
        return "> " + getCaseName();
    }

    public void getInput() {
        // empty
    }

    public abstract void executeCase();

    @Override
    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    @Override
    public String getSeparator() {
        return " / ";
    }

    public String getUrl() {
        return url;
    }

}
