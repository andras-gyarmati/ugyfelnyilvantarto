package xyz.codingmentor.consoleclient;

import xyz.codingmentor.team3.registry.dto.user.UserDTO;

/**
 *
 * @author brianelete
 */
public class CurrentUser {

    UserDTO userDTO;
    int pagesize;

    public CurrentUser(UserDTO userDTO, int pagesize) {
        this.userDTO = userDTO;
        this.pagesize = pagesize;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public boolean isAsmin() {
        return userDTO.getRoleIdList().contains(1L);
    }

}
