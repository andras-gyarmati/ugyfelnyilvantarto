package xyz.codingmentor.team3.registry.service.builder;

import xyz.codingmentor.team3.registry.dto.role.RoleDTO;
import xyz.codingmentor.team3.registry.entity.role.Role;
import xyz.codingmentor.team3.registry.api.IBuilder;
import xyz.codingmentor.team3.registry.qualifier.EntityModel;
import xyz.codingmentor.team3.registry.qualifier.BuilderQualifier;

/**
 *
 * @author brianelete
 */
@BuilderQualifier(EntityModel.ROLE)
public class RoleBuilder implements IBuilder<RoleDTO, Role> {

    @Override
    public Role buildEntity(RoleDTO dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setRoleType(dto.getRoleType());
        return role;
    }

    @Override
    public RoleDTO buildDTO(Role entity) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(entity.getId());
        roleDTO.setRoleType(entity.getRoleType());
        return roleDTO;
    }

}
