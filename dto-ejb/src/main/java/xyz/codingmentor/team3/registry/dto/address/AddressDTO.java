package xyz.codingmentor.team3.registry.dto.address;

import java.io.Serializable;
import javax.validation.constraints.Size;
import xyz.codingmentor.team3.registry.interceptor.validator.Validate;

/**
 *
 * @author brianelete
 */
@Validate
public class AddressDTO implements Serializable {

    private Long id;

    @Size(max = 255)
    private String zipCode;

    @Size(max = 255)
    private String state;

    @Size(max = 255)
    private String country;

    @Size(max = 255)
    private String city;

    @Size(max = 255)
    private String street;

    public AddressDTO() {
        // nothing to initialize
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "\nid=" + id
                + "\nzipCode=" + zipCode
                + "\nstate=" + state
                + "\ncountry=" + country
                + "\ncity=" + city
                + "\nstreet=" + street;
    }

}
