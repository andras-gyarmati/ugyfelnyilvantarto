package xyz.codingmentor.consoleclient.service.switchcase;

import xyz.codingmentor.consoleclient.api.ICase;

/**
 *
 * @author Tibor Kun
 */
public abstract class AbstractSwitchCase extends AbstractSwitch implements ICase {

    private final String caseName;

    public AbstractSwitchCase(String caseName) {
        super(caseName);
        this.caseName = caseName;
    }

    @Override
    public abstract void fillCases();

    @Override
    public void run() {
        start();
    }

    @Override
    public String getSeparator() {
        return " / ";
    }

    @Override
    public String getCaseName() {
        return caseName;
    }

}
