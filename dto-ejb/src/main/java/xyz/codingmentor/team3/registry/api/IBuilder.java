package xyz.codingmentor.team3.registry.api;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author brianelete
 * @param <D>
 * @param <E>
 */
public interface IBuilder<D, E> {

    E buildEntity(D dto);

    D buildDTO(E entity);

    default List<D> buildDTOList(List<E> entityList) {
        List<D> dtoList = new ArrayList();
        for (E entity : entityList) {
            dtoList.add(buildDTO(entity));
        }
        return dtoList;
    }

}
