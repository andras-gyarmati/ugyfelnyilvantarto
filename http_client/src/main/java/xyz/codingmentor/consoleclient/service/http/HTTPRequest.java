package xyz.codingmentor.consoleclient.service.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;

/**
 *
 * @author Tibor Kun
 * @param <D>
 */
public class HTTPRequest<D> implements IHTTPRequest<D> {

    private final Class<D> d;
    private final ObjectMapper mapper;

    public HTTPRequest(Class<D> d) {
        this.d = d;
        this.mapper = new ObjectMapper();
    }

    @Override
    public D get(String url) {
        try {
            return createReturn(responseGetJson(url));
        } catch (IOException ex) {
            Logger.getLogger(HTTPRequest.class.getName()).log(Level.FINE, null, ex);
            return null;
        }
    }

    @Override
    public List<D> getList(String url) {
        try {
            return createReturnList(responseGetJson(url));
        } catch (IOException ex) {
            Logger.getLogger(HTTPRequest.class.getName()).log(Level.FINE, null, ex);
            return new ArrayList<>();
        }
    }

    @Override
    public D post(String url, Object object) {
        try {
            return createReturn(responsePostJson(url, object));
        } catch (IOException ex) {
            Logger.getLogger(HTTPRequest.class.getName()).log(Level.FINE, null, ex);
            return null;
        }
    }

    @Override
    public D post(String url) {
        try {
            return createReturn(responsePostEmpty(url));
        } catch (IOException ex) {
            Logger.getLogger(HTTPRequest.class.getName()).log(Level.FINE, null, ex);
            return null;
        }
    }

    @Override
    public D put(String url, Object object) {
        try {
            return createReturn(responsePutJson(url, object));
        } catch (IOException ex) {
            Logger.getLogger(HTTPRequest.class.getName()).log(Level.FINE, null, ex);
            return null;
        }
    }

    @Override
    public D delete(String url) {
        try {
            return createReturn(responseDeleteJson(url));
        } catch (IOException ex) {
            Logger.getLogger(HTTPRequest.class.getName()).log(Level.FINE, null, ex);
            return null;
        }
    }

    public String responseGetJson(String url) throws IOException {
        return Request
                .Get(url).connectTimeout(1000).socketTimeout(1000)
                .execute().returnContent().asString();

    }

    public String responsePostJson(String url, Object object) throws IOException {
        return Request
                .Post(url).useExpectContinue()
                .bodyString(inputJson(object), ContentType.APPLICATION_JSON)
                .execute().returnContent().asString();
    }

    public String responsePostEmpty(String url) throws IOException {
        return Request
                .Post(url).useExpectContinue()
                .execute().returnContent().asString();

    }

    public String responsePutJson(String url, Object object) throws IOException {
        return Request
                .Put(url).useExpectContinue()
                .bodyString(inputJson(object), ContentType.APPLICATION_JSON)
                .execute().returnContent().asString();
    }

    public String responseDeleteJson(String url) throws IOException {
        return Request
                .Delete(url).connectTimeout(1000).socketTimeout(1000)
                .execute().returnContent().asString();
    }

    private String inputJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(HTTPRequest.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public D createReturn(String responseJson) throws IOException {
        return mapper.readValue(responseJson, d);
    }

    public List<D> createReturnList(String responseJson) throws IOException {
        return mapper.readValue(responseJson, TypeFactory.defaultInstance().constructCollectionType(List.class, d));
    }

}
