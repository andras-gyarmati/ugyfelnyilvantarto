package xyz.codingmentor.consoleclient.service.switchcase.index;

import xyz.codingmentor.consoleclient.service.switchcase.AbstractSwitch;
import xyz.codingmentor.consoleclient.service.switchcase.BackCase;

/**
 *
 * @author brianelete
 */
public class IndexSwitch extends AbstractSwitch {

    public IndexSwitch() {
        super("INDEX");
    }

    @Override
    public void fillCases() {
        addCase(new BackCase("Exit", this));
        addCase(new RegCase());
        addCase(new LoginCase());
        addCase(new ViewCountCase());
    }

}
