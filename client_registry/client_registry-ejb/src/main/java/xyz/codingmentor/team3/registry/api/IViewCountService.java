package xyz.codingmentor.team3.registry.api;

import xyz.codingmentor.team3.registry.entity.user.User;

/**
 *
 * @author brianelete
 */
public interface IViewCountService {

    public void increase(User user);

    public int get();

}
