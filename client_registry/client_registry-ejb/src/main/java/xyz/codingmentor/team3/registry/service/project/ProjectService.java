package xyz.codingmentor.team3.registry.service.project;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.api.IProjectService;
import xyz.codingmentor.team3.registry.entity.address.Address;
import xyz.codingmentor.team3.registry.entity.client.Client;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannel;
import xyz.codingmentor.team3.registry.entity.contactperson.ContactPerson;
import xyz.codingmentor.team3.registry.entity.person.Person;
import xyz.codingmentor.team3.registry.entity.project.Project;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.interceptor.log.LoggingInterceptor;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;

/**
 *
 * @author Daróczi Kristóf
 */
@Stateless
@Interceptors(LoggingInterceptor.class)
public class ProjectService implements IProjectService {

    @Inject
    @CRUDServiceQualifier(EntityModel.CLIENT)
    private ICRUDService<Client> clientCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.ADDRESS)
    private ICRUDService<Address> addressCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.CONTACTPERSON)
    private ICRUDService<ContactPerson> contactPersonCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.CONTACTCHANNEL)
    private ICRUDService<ContactChannel> contactChannelCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.PROJECT)
    private ICRUDService<Project> projectCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.PERSON)
    private ICRUDService<Person> personCRUDService;

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public void addAddressToClient(Long addressId, Long clientId) throws RepositoryException {
        Address address = addressCRUDService.getEntityById(addressId);
        Client client = clientCRUDService.getEntityById(clientId);
        client.setAddress(address);
        clientCRUDService.updateEntity(client);
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public void addContactChannelToPerson(Long contactChannelId, Long personId) throws RepositoryException {
        ContactChannel contactChannel = contactChannelCRUDService.getEntityById(contactChannelId);
        Person person = personCRUDService.getEntityById(personId);
        contactChannel.setPerson(person);
        person.getContactChannels().add(contactChannel);
        contactChannelCRUDService.updateEntity(contactChannel);
        personCRUDService.updateEntity(person);
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public void addContactPersonToClient(Long contactPersonId, Long clientId) throws RepositoryException {
        Client client = clientCRUDService.getEntityById(clientId);
        ContactPerson contactPerson = contactPersonCRUDService.getEntityById(contactPersonId);
        contactPerson.setClient(client);
        client.getContactPeople().add(contactPerson);
        contactPersonCRUDService.updateEntity(contactPerson);
        clientCRUDService.updateEntity(client);
    }

    @Override
    @RolesAllowed(value = {"ADMIN", "USER"})
    public void addProjectToClient(Long projectId, Long clientId) throws RepositoryException {
        Client client = clientCRUDService.getEntityById(clientId);
        Project project = projectCRUDService.getEntityById(projectId);
        project.setClient(client);
        client.getProjects().add(project);
        projectCRUDService.updateEntity(project);
        clientCRUDService.updateEntity(client);
    }

}
