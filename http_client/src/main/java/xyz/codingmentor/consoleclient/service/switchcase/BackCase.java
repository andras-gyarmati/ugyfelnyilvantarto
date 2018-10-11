package xyz.codingmentor.consoleclient.service.switchcase;

/**
 *
 * @author brianelete
 */
public class BackCase extends AbstractCase {

    private final AbstractSwitch menuSwitch;

    public BackCase(String caseName, AbstractSwitch menuSwitch) {
        super(caseName, null);
        this.menuSwitch = menuSwitch;
    }

    @Override
    public void executeCase() {
        menuSwitch.stop();
    }

}
