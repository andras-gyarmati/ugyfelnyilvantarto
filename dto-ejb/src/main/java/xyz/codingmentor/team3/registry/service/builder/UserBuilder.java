package xyz.codingmentor.team3.registry.service.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.api.ICRUDService;
import xyz.codingmentor.team3.registry.dto.user.UserDTO;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannel;
import xyz.codingmentor.team3.registry.entity.role.Role;
import xyz.codingmentor.team3.registry.entity.user.User;
import xyz.codingmentor.team3.registry.exception.RepositoryException;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;
import xyz.codingmentor.team3.registry.qualifier.CRUDServiceQualifier;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;

/**
 *
 * @author brianelete
 */
@BuilderQualifier(EntityModel.USER)
public class UserBuilder implements IBuilder<UserDTO, User> {

    @Inject
    @CRUDServiceQualifier(EntityModel.CONTACTCHANNEL)
    ICRUDService<ContactChannel> contactChannelCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.ROLE)
    ICRUDService<Role> roleCRUDService;

    @Override
    public User buildEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPosition(dto.getPosition());
        user.setProfilePicturePath(dto.getProfilePicturePath());
        user.setContactChannels(readContactChannels(dto));
        user.setUsername(dto.getUsername());
        user.setPassword(sha256Hex(dto.getPassword()));
        user.setRoles(readRoles(dto));
        return user;
    }

    @Override
    public UserDTO buildDTO(User entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getId());
        userDTO.setFirstName(entity.getFirstName());
        userDTO.setLastName(entity.getLastName());
        userDTO.setPosition(entity.getPosition());
        userDTO.setProfilePicturePath(entity.getProfilePicturePath());
        userDTO.setContactChannelIdList(readContactChannels(entity));
        userDTO.setUsername(entity.getUsername());
        userDTO.setPassword("*****");
        userDTO.setRoleIdList(readRoles(entity));
        return userDTO;
    }

    private List<ContactChannel> readContactChannels(UserDTO dto) {
        List<ContactChannel> contactChannels = new ArrayList();
        if (null != dto.getContactChannelIdList()) {
            dto.getContactChannelIdList().forEach((contactChannelId) -> {
                try {
                    contactChannels.add(contactChannelCRUDService.getEntityById(contactChannelId));
                } catch (RepositoryException ex) {
                    Logger.getLogger(UserBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        return contactChannels;
    }

    private List<Role> readRoles(UserDTO dto) {
        List<Role> roles = new ArrayList();
        if (null != dto.getRoleIdList()) {
            dto.getRoleIdList().forEach((roleId) -> {
                try {
                    roles.add(roleCRUDService.getEntityById(roleId));
                } catch (RepositoryException ex) {
                    Logger.getLogger(UserBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        return roles;
    }

    private List<Long> readContactChannels(User entity) {
        List<Long> contactChannelIdList = new ArrayList();
        if (null != entity.getContactChannels()) {
            entity.getContactChannels().forEach((contactChannel) -> {
                contactChannelIdList.add(contactChannel.getId());
            });
        }
        return contactChannelIdList;
    }

    private List<Long> readRoles(User entity) {
        List<Long> roleIdList = new ArrayList();
        if (null != entity.getRoles()) {
            entity.getRoles().forEach((role) -> {
                roleIdList.add(role.getId());
            });
        }
        return roleIdList;
    }

}
