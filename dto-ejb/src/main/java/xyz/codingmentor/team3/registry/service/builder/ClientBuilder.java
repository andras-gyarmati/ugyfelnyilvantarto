package xyz.codingmentor.team3.registry.service.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.client.ClientDTO;
import xyz.codingmentor.team3.registry.entity.address.Address;
import xyz.codingmentor.team3.registry.entity.client.Client;
import xyz.codingmentor.team3.registry.entity.contactperson.ContactPerson;
import xyz.codingmentor.team3.registry.entity.event.Event;
import xyz.codingmentor.team3.registry.entity.project.Project;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;

/**
 *
 * @author brianelete
 */
@BuilderQualifier(EntityModel.CLIENT)
public class ClientBuilder implements IBuilder<ClientDTO, Client> {

    @Inject
    @CRUDServiceQualifier(EntityModel.ADDRESS)
    ICRUDService<Address> addressCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.CONTACTPERSON)
    ICRUDService<ContactPerson> contactPersonCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.PROJECT)
    ICRUDService<Project> projectCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.EVENT)
    ICRUDService<Event> eventCRUDService;

    @Override
    public Client buildEntity(ClientDTO dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setName(dto.getName());
        client.setTaxNumber(dto.getTaxNumber());
        client.setLogo(dto.getLogo());
        try {
            client.setAddress(addressCRUDService.getEntityById(dto.getAddressId()));
        } catch (RepositoryException ex) {
            Logger.getLogger(ClientBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        client.setContactPeople(readContactPerson(dto));
        client.setProjects(readProjects(dto));
        client.setEvents(readEvents(dto));
        return client;
    }

    @Override
    public ClientDTO buildDTO(Client entity) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(entity.getId());
        clientDTO.setName(entity.getName());
        clientDTO.setTaxNumber(entity.getTaxNumber());
        clientDTO.setLogo(entity.getLogo());
        clientDTO.setAddressId(entity.getAddress().getId());
        clientDTO.setContactPersonIdList(readContactPerson(entity));
        clientDTO.setProjectsIdList(readProjects(entity));
        clientDTO.setEventsIdList(readEvents(entity));
        return clientDTO;
    }

    private List<ContactPerson> readContactPerson(ClientDTO dto) {
        List<ContactPerson> contactPeople = new ArrayList();
        if (null != dto.getContactPersonIdList()) {
            dto.getContactPersonIdList().forEach((contactPersonId) -> {
                try {
                    contactPeople.add(contactPersonCRUDService.getEntityById(contactPersonId));
                } catch (RepositoryException ex) {
                    Logger.getLogger(ClientBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        return contactPeople;
    }

    private List<Project> readProjects(ClientDTO dto) {
        List<Project> projects = new ArrayList();
        if (null != dto.getProjectsIdList()) {
            dto.getProjectsIdList().forEach((projectId) -> {
                try {
                    projects.add(projectCRUDService.getEntityById(projectId));
                } catch (RepositoryException ex) {
                    Logger.getLogger(ClientBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        return projects;
    }

    private List<Event> readEvents(ClientDTO dto) {
        List<Event> events = new ArrayList();
        if (null != dto.getEventsIdList()) {
            dto.getEventsIdList().forEach((eventId) -> {
                try {
                    events.add(eventCRUDService.getEntityById(eventId));
                } catch (RepositoryException ex) {
                    Logger.getLogger(ClientBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        return events;
    }

    private List<Long> readContactPerson(Client entity) {
        List<Long> contactPersonIdList = new ArrayList();
        if (null != entity.getContactPeople()) {
            entity.getContactPeople().forEach((contactPerson) -> {
                contactPersonIdList.add(contactPerson.getId());
            });
        }
        return contactPersonIdList;
    }

    private List<Long> readProjects(Client entity) {
        List<Long> projectsIdList = new ArrayList();
        if (null != entity.getProjects()) {
            entity.getProjects().forEach((project) -> {
                projectsIdList.add(project.getId());
            });
        }
        return projectsIdList;
    }

    private List<Long> readEvents(Client entity) {
        List<Long> eventsIdList = new ArrayList();
        if (null != entity.getEvents()) {
            entity.getEvents().forEach((event) -> {
                eventsIdList.add(event.getId());
            });
        }
        return eventsIdList;
    }

}
