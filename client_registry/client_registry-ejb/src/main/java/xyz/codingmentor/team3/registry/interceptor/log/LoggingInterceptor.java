package xyz.codingmentor.team3.registry.interceptor.log;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Daróczi Kristóf
 */
@Interceptor
public class LoggingInterceptor {

    @Inject
    private Logger LOGGER;

    private String returnValues = " ";

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        String parameterNames = "";
        String parameterValues = "";
        for (Object parameter : ic.getParameters()) {
            parameterNames = parameterNames + parameter.getClass().getTypeName() + " ";
            parameterValues = parameterValues + parameter.toString() + "";
        }
        Object result = ic.proceed();
        if (null != result) {
            printParameters(result);
        }
        LOGGER.log(Level.INFO, "Method name: " + ic.getMethod().getName() + ", Incoming parameters:" + parameterNames + ", Values: " + parameterValues + ", Returning value: " + returnValues);
        return result;
    }

    private void printParameters(Object object) {
        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                returnValues = returnValues + " " + field.getName() + " : " + field.get(object);
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }

}
