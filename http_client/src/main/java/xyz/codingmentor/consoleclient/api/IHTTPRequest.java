package xyz.codingmentor.consoleclient.api;

import java.util.List;

/**
 *
 * @author Tibor Kun
 * @param <D>
 */
public interface IHTTPRequest<D> {

    D get(String url);

    List<D> getList(String url);

    D post(String url, Object object);

    D post(String url);

    D put(String url, Object object);

    D delete(String url);

}
