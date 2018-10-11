package xyz.codingmentor.consoleclient.service.io;

import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.team3.registry.entity.contactchannel.ContactChannelType;
import xyz.codingmentor.team3.registry.entity.event.EventType;
import xyz.codingmentor.team3.registry.entity.invitation.InvitationStatus;
import xyz.codingmentor.team3.registry.entity.person.PositionType;
import xyz.codingmentor.team3.registry.entity.project.ProjectState;

/**
 *
 * @author brianelete
 */
public class EnumReader {

    private static final String ERRORMSG = "Sorry, that's not valid. Please try again: ";

    private EnumReader() {
        // hide the implicit public  constructor
    }

    public static PositionType getPositionType() {
        PositionType value = null;
        while (null == value) {
            try {
                value = PositionType.valueOf(Application.IO.getString().toUpperCase());
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(EnumReader.class.getName()).log(Level.FINE, ERRORMSG, ex);
                Application.IO.out(ERRORMSG);
            }
        }
        return value;
    }

    public static ContactChannelType getContactChannelType() {
        ContactChannelType value = null;
        while (null == value) {
            try {
                value = ContactChannelType.valueOf(Application.IO.getString().toUpperCase());
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(EnumReader.class.getName()).log(Level.FINE, ERRORMSG, ex);
                Application.IO.out(ERRORMSG);
            }
        }
        return value;
    }

    public static InvitationStatus getInvitationStatus() {
        InvitationStatus value = null;
        while (null == value) {
            try {
                value = InvitationStatus.valueOf(Application.IO.getString().toUpperCase());
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(EnumReader.class.getName()).log(Level.FINE, ERRORMSG, ex);
                Application.IO.out(ERRORMSG);
            }
        }
        return value;
    }

    public static EventType getEventType() {
        EventType value = null;
        while (null == value) {
            try {
                value = EventType.valueOf(Application.IO.getString().toUpperCase());
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(EnumReader.class.getName()).log(Level.FINE, ERRORMSG, ex);
                Application.IO.out(ERRORMSG);
            }
        }
        return value;
    }

    public static ProjectState getProjectState() {
        ProjectState value = null;
        while (null == value) {
            try {
                value = ProjectState.valueOf(Application.IO.getString().toUpperCase());
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(EnumReader.class.getName()).log(Level.FINE, ERRORMSG, ex);
                Application.IO.out(ERRORMSG);
            }
        }
        return value;
    }

}
