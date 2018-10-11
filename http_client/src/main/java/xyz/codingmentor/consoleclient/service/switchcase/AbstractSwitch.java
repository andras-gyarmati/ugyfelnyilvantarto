package xyz.codingmentor.consoleclient.service.switchcase;

import java.util.HashMap;
import java.util.Map;
import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.ICase;
import xyz.codingmentor.consoleclient.api.ISwitch;
import xyz.codingmentor.consoleclient.service.io.IOHandler;

/**
 *
 * @author brianelete
 */
public abstract class AbstractSwitch implements ISwitch {

    private final Map<String, ICase> cases;
    private String switchMessage;
    private boolean isRunning;
    private final String menuName;

    public AbstractSwitch(String menuName) {
        this.menuName = menuName;
        this.cases = new HashMap<>();
        this.isRunning = true;
    }

    @Override
    public void start() {
        fillCases();
        loop();
    }

    public abstract void fillCases();

    public void loop() {
        initMessage();
        while (isRunning) {
            IOHandler.clearScreen();
            initMessage();
            Application.IO.outln(switchMessage);
            selectCase(Application.IO.getString());
        }
    }

    public void addCase(ICase newCase) {
        cases.put(Integer.toString(cases.size()), newCase);
    }

    public void initMessage() {
        switchMessage = "> " + menuName.toUpperCase() + " "
                + ((Application.getCurrentUser().getUserDTO().getUsername() == null) ? ""
                : "(user:" + Application.getCurrentUser().getUserDTO().getUsername() + ") ") + "Please select an option:\n";
        for (Map.Entry<String, ICase> entry : cases.entrySet()) {
            switchMessage += ("0".equals(entry.getKey()) ? "" : entry.getValue().getSeparator()) + entry.getKey() + ":" + entry.getValue().getCaseName();
        }
    }

    @Override
    public void selectCase(String caseNo) {
        if (cases.containsKey(caseNo)) {
            cases.get(caseNo).run();
        } else {
            Application.IO.outln("Wrong input!");
        }
    }

    @Override
    public void stop() {
        isRunning = false;
    }

    public String getMenuName() {
        return menuName;
    }

}
