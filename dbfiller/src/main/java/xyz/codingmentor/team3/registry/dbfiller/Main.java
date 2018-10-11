package xyz.codingmentor.team3.registry.dbfiller;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author brianelete
 */
public class Main {

    public Main() {
        //empty
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        SqlGenerator generator = new SqlGenerator();
        generator.init();
        Writer writer = new Writer();
        String addresses = generator.generateAddress();
        writer.write(addresses, "01_addresses.sql");
        String clients = generator.generateClient();
        writer.write(clients, "02_clients.sql");
        String people = generator.generatePerson();
        writer.write(people, "03_people.sql");
        String users = generator.generateUser();
        writer.write(users, "04_users.sql");
        String contactPeople = generator.generateContactPerson();
        writer.write(contactPeople, "05_contactpeople.sql");
        String contactChannels = generator.generateContactChannel();
        writer.write(contactChannels, "06_contactchannels.sql");
        String events = generator.generateEvent();
        writer.write(events, "07_events.sql");
        String invitations = generator.generateInvitation();
        writer.write(invitations, "08_invitations.sql");
        String notes = generator.generateNote();
        writer.write(notes, "09_notes.sql");
        String projects = generator.generateProject();
        writer.write(projects, "10_projects.sql");
    }
}
