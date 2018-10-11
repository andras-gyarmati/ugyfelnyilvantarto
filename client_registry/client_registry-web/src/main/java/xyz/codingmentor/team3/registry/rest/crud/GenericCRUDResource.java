package xyz.codingmentor.team3.registry.rest.crud;

import javax.interceptor.Interceptors;
import javax.ws.rs.core.Response;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.ICRUDResource;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.result.ResultType;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.interceptor.validator.ValidatorInterceptor;

/**
 *
 * @author brianelete
 * @param <D>
 * @param <E>
 */
public class GenericCRUDResource<D, E> implements ICRUDResource<D> {

    private final ICRUDService<E> crudService;
    private final IBuilder<D, E> builder;

    public GenericCRUDResource(ICRUDService<E> crudService, IBuilder<D, E> builder) {
        this.crudService = crudService;
        this.builder = builder;
    }

    @Override
    @Interceptors({ValidatorInterceptor.class})
    public Response create(D dto) throws RepositoryException {
        return Response.ok(builder.buildDTO(crudService.createEntity(builder.buildEntity(dto)))).build();
    }

    @Override
    public Response read(Long id) throws RepositoryException {
        return Response.ok(builder.buildDTO(crudService.getEntityById(id))).build();
    }

    @Override
    @Interceptors({ValidatorInterceptor.class})
    public Response update(D dto) throws RepositoryException {
        return Response.ok(builder.buildDTO(crudService.updateEntity(builder.buildEntity(dto)))).build();
    }

    @Override
    public Response delete(Long id) throws RepositoryException {
        crudService.removeEntity(id);
        return Response.ok(ResultType.SUCCESS).build();
    }

    @Override
    public Response getAll(int offset, int max) throws RepositoryException {
        return Response.ok(builder.buildDTOList(crudService.getAllEntity(offset, max))).build();
    }

    @Override
    public Response count() throws RepositoryException {
        return Response.ok(crudService.count()).build();
    }

    public ICRUDService<E> getCrudService() {
        return crudService;
    }

    public IBuilder<D, E> getBuilder() {
        return builder;
    }

}
