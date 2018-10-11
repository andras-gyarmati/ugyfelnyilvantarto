package xyz.codingmentor.team3.registry.dto.client;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Validate
public class ClientDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String taxNumber;

    @Size(max = 255)
    private String logo;

    @NotNull
    private Long addressId;
    
    private List<Long> contactPersonIdList;
    private List<Long> projectsIdList;
    private List<Long> eventsIdList;

    public ClientDTO() {
        // empty on purpose
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public List<Long> getContactPersonIdList() {
        return contactPersonIdList;
    }

    public void setContactPersonIdList(List<Long> contactPersonIdList) {
        this.contactPersonIdList = contactPersonIdList;
    }

    public List<Long> getProjectsIdList() {
        return projectsIdList;
    }

    public void setProjectsIdList(List<Long> projectsIdList) {
        this.projectsIdList = projectsIdList;
    }

    public List<Long> getEventsIdList() {
        return eventsIdList;
    }

    public void setEventsIdList(List<Long> eventsIdList) {
        this.eventsIdList = eventsIdList;
    }

    @Override
    public String toString() {
        return "\nid=" + id
                + "\nname=" + name
                + "\ntaxNumber=" + taxNumber
                + "\nlogo=" + logo
                + "\naddressId=" + addressId
                + "\ncontactPersonIdList=" + contactPersonIdList
                + "\nprojectsIdList=" + projectsIdList
                + "\neventsIdList=" + eventsIdList;
    }

}
