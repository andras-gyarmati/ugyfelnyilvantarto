package xyz.codingmentor.consoleclient.service.pager;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.api.IPager;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import xyz.codingmentor.consoleclient.service.io.IOHandler;

/**
 *
 * @author brianelete
 * @param <T>
 */
public class Pager<T> implements IPager {

    private final Class<T> t;
    private IHTTPRequest<T> httpRequest;
    private IHTTPRequest<Integer> countRequest;
    private int offset;
    private final int pagesize;
    private boolean isRunning;
    private int page;
    private Integer resultCount;
    private String msg;

    public Pager(Class<T> t, String msg) {
        this.t = t;
        this.pagesize = Application.getCurrentUser().getPagesize();
        this.isRunning = true;
        this.msg = msg;
        resultCount = 0;
    }

    @Override
    public void printList(String url) {
        init(url);
        do {
            printPage(url);
        } while (isRunning);
    }

    private void init(String url) {
        offset = 0;
        page = 1;
        isRunning = true;
        httpRequest = new HTTPRequest<>((Class<T>) getInstanceOfT().getClass());
        countRequest = new HTTPRequest<>(Integer.class);
        resultCount = countRequest.get(url + "count");
        if (null != resultCount) {
            msg += " / total results: " + resultCount;
        } else {
            msg += " / total results: failed to load";
            resultCount = 0;
        }
    }

    @Override
    public void readInput() {
        printControlMsg();
        switch (Application.IO.getString().toLowerCase()) {
            case "c":
                page = Math.max(--page, 1);
                offset = Math.max(offset - pagesize, 0);
                break;
            case "v":
                page++;
                offset += pagesize;
                break;
            case "0":
                isRunning = false;
                break;
            default:
                Application.IO.out("Wrong input!");
                Application.IO.getString();
                break;
        }
    }

    private void printControlMsg() {
        String pageNumberMsg = "";
        if (0 != resultCount) {
            pageNumberMsg = "/" + (int) Math.ceil(Math.max(1, resultCount) / (double) Math.max(0, pagesize));
        }
        Application.IO.outln("\n<<:C | page: " + page + pageNumberMsg + " | V:>> 0:back");
    }

    private void printPage(String url) {
        List<T> list;
        list = getPage(url);
        IOHandler.clearScreen();
        Application.IO.outln(msg);
        if (list.isEmpty() && page > 1) {
            page--;
            offset -= pagesize;
            list = getPage(url);
        }
        for (T element : list) {
            Application.IO.outln(element.toString());
        }
        readInput();
    }

    private List<T> getPage(String url) {
        List<T> list;
        list = httpRequest.getList(url + "?offset=" + offset + "&max=" + pagesize);
        return list;
    }

    public T getInstanceOfT() {
        try {
            return t.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Pager.class.getName()).log(Level.FINE, null, ex);
            return null;
        }
    }

}
