package xyz.codingmentor.consoleclient.service.switchcase.index;

import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;

/**
 *
 * @author brianelete
 */
public class ViewCountCase extends AbstractCase {

    private final IHTTPRequest<Integer> httpRequest;

    public ViewCountCase() {
        super("View Count", URLProperty.getURL("ViewCount.url"));
        this.httpRequest = new HTTPRequest<>(Integer.class);
    }

    @Override
    public void executeCase() {
        Integer viewcount = httpRequest.get(getUrl());
        if (null != viewcount) {
            Application.IO.outln("View count: " + viewcount.toString());
        } else {
            Application.IO.outln("Error! Please try again.");
        }
        Application.IO.getString("Press any key to continue..");
    }

}
