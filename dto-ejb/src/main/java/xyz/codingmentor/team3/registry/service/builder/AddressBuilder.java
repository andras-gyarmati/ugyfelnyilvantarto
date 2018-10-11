package xyz.codingmentor.team3.registry.service.builder;

import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.dto.address.AddressDTO;
import xyz.codingmentor.team3.registry.entity.address.Address;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@BuilderQualifier(EntityModel.ADDRESS)
public class AddressBuilder implements IBuilder<AddressDTO, Address> {

    @Override
    public Address buildEntity(AddressDTO dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setZipCode(dto.getZipCode());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        return address;
    }

    @Override
    public AddressDTO buildDTO(Address entity) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(entity.getId());
        addressDTO.setZipCode(entity.getZipCode());
        addressDTO.setState(entity.getState());
        addressDTO.setCountry(entity.getCountry());
        addressDTO.setCity(entity.getCity());
        addressDTO.setStreet(entity.getStreet());
        return addressDTO;
    }

}
