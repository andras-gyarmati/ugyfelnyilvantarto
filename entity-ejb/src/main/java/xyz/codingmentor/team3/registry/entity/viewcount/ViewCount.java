package xyz.codingmentor.team3.registry.entity.viewcount;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Tibor Kun
 */
@Entity
public class ViewCount implements Serializable {

    @Id
    private Long id;

    private int viewCount;

    public ViewCount() {
        //empty
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

}
