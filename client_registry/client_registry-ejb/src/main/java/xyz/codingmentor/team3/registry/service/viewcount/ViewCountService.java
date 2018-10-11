package xyz.codingmentor.team3.registry.service.viewcount;

import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import xyz.codingmentor.team3.registry.api.IViewCountService;
import xyz.codingmentor.team3.registry.entity.user.User;
import xyz.codingmentor.team3.registry.entity.viewcount.ViewCount;
import xyz.codingmentor.team3.registry.qualifier.Login;

/**
 *
 * @author brianelete
 */
public class ViewCountService implements IViewCountService {

    @PersistenceContext(unitName = "ClientRegistryPU")
    private EntityManager entityManager;

    public ViewCountService() {
        //empty
    }

    @Override
    @Transactional
    public void increase(@Observes @Login User user) {
        ViewCount viewCount = entityManager.find(ViewCount.class, 0L);
        if (null != user) {
            viewCount = createViewCount(viewCount);
            viewCount.setViewCount(viewCount.getViewCount() + 1);
            entityManager.merge(viewCount);
        }
    }

    private ViewCount createViewCount(ViewCount viewCount) {
        if (null == viewCount) {
            ViewCount viewCntr = new ViewCount();
            viewCntr.setId(0L);
            viewCntr.setViewCount(0);
            entityManager.persist(viewCntr);
            return viewCntr;
        }
        return viewCount;
    }

    @Override
    @Transactional
    public int get() {
        return entityManager.find(ViewCount.class, 0L).getViewCount();
    }

}
