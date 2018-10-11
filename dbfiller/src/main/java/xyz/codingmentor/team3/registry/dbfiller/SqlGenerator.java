package xyz.codingmentor.team3.registry.dbfiller;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author brianelete
 */
public class SqlGenerator {

    private int addressSize;
    private int clientSize;
    private String addresses;
    private String clients;
    private String people;
    private String users;
    private String projects;
    private String contactPerson;
    private String contactChannels;
    private String events;
    private String invitations;
    private String notes;
    private String firstName;
    private String lastName;
    private final List<Integer> userIds;
    private final List<Integer> cpIds;
    private final Random rnd;
    private final Reader reader;
    private List<String> cities;
    private List<String> pstates;
    private List<String> streets;
    private List<String> clientnames;
    private List<String> names;
    private List<String> position;
    private List<String> userData;
    private List<String> eventType;
    private List<String> note;

    public SqlGenerator() throws FileNotFoundException {
        this.cpIds = new ArrayList();
        this.userIds = new ArrayList();
        this.clientSize = 0;
        this.addressSize = 0;
        this.rnd = new Random();
        this.lastName = "";
        this.firstName = "";
        this.projects = "";
        this.events = "";
        this.invitations = "";
        this.notes = "";
        this.contactChannels = "";
        this.contactPerson = "";
        this.users = "";
        this.people = "";
        this.clients = "";
        this.addresses = "";
        this.reader = new Reader();
    }

    public void init() throws FileNotFoundException {
        cities = read("cities.txt");
        eventType = read("eventtypes.txt");
        note = read("notes.txt");
        pstates = read("pstates.txt");
        userData = read("users.txt");
        position = read("position.txt");
        names = read("names.txt");
        clientnames = read("clients.txt");
        streets = read("streets.txt");
    }

    public String generateAddress() {
        addressSize = 0;
        for (int i = 0; i < 50; i++) {
            String[] city = cities.get(rnd.nextInt(345)).split(",");
            for (int j = 0; j < 50; j++) {
                addresses += "INSERT INTO address VALUES (" + addressSize + ", '" + city[0] + "', '"
                        + city[1] + "', '"
                        + city[2] + "', '"
                        + city[3] + "', '"
                        + streets.get(rnd.nextInt(6868)) + " "
                        + rnd.nextInt(100) + "');\n";
                addressSize++;
            }
        }
        return addresses;
    }

    public String generateClient() {
        for (int i = 0; i < clientnames.size(); i++) {
            String companyType;
            if (rnd.nextInt(100) < 10) {
                companyType = " Inc.";
            } else {
                companyType = " Ltd.";
            }
            clients += "INSERT INTO client VALUES (" + i + ", '" + clientnames.get(i) + companyType + "', '+3655" + rnd.nextInt(9999999)
                    + "', 'logo" + i + ".png', " + rnd.nextInt(1000) + ");\n";
            clientSize++;
        }
        return clients;
    }

    public String generatePerson() {
        for (int i = 0; i < names.size(); i++) {
            String[] name = names.get(i).split(",");
            if (2 == name.length) {
                firstName = name[0];
                lastName = name[1];
            } else {
                firstName = name[0] + " " + name[1];
                lastName = name[2];
            }
            String dtype;
            if (rnd.nextInt(100) < 10) {
                dtype = "C";
                cpIds.add(i);
            } else {
                dtype = "U";
                userIds.add(i);
            }
            people += "INSERT INTO person VALUES(" + i + ", '" + dtype + "', '" + firstName + "', '" + lastName + "', '" + position.get(rnd.nextInt(position.size())) + "', 'picture" + i + ".jpg');\n";
        }
        return people;
    }

    public String generateUser() {
        System.out.println("userIds: " + userIds.size() + " userData: " + userData.size()); //debug
        for (int i = 0; i < userIds.size() - 1; i++) {
            String[] userNameAndPw = userData.get(i).split(",");
            users += "INSERT INTO user_table VALUES (" + userIds.get(i) + ", '"
                    + userNameAndPw[0] + "', '"
                    + userNameAndPw[1] + "');\n";
        }
        return users;
    }

    public String generateContactPerson() {
        System.out.println("cpIds: " + cpIds.size()); //debug
        for (int i = 0; i < cpIds.size() - 1; i++) {
            contactPerson += "INSERT INTO contact_person VALUES(" + cpIds.get(i) + ", " + rnd.nextInt(clientSize) + ");\n";
        }
        return contactPerson;
    }

    public String generateContactChannel() {
        int personId;
        for (int i = 0; i < 2500; i++) {
            if (i < cpIds.size() + userIds.size()) {
                contactChannels += "INSERT INTO contact_channel VALUES (" + i + ", 'EMAIL', 'business" + i + "@" + (char) (rnd.nextInt(25) + 97) + "mail.com', " + i + ");\n";
            } else if (i < (cpIds.size() + userIds.size()) * 2) {
                personId = i - (cpIds.size() + userIds.size());
                contactChannels += "INSERT INTO contact_channel VALUES (" + i + ", 'TELEPHONE', '+3655" + rnd.nextInt(9999999) + "', " + personId + ");\n";
            } else {
                personId = i - (cpIds.size() + userIds.size() * 2);
                contactChannels += "INSERT INTO contact_channel VALUES (" + i + ", 'FAX', '+3655" + rnd.nextInt(9999999) + "', " + personId + ");\n";
            }
        }
        return contactChannels;
    }

    public String generateEvent() {
        for (int i = 0; i < 50; i++) {
            String eventTypeCapitalise = eventType.get(rnd.nextInt(eventType.size()));
            events += "INSERT INTO event_table VALUES (" + i + ", '" + eventType.get(rnd.nextInt(eventType.size()))
                    + "', '" + daysAfterNow(rnd.nextInt(100) + 10)
                    + "', '" + daysAfterNow(rnd.nextInt(100) + 11) + "', '"
                    + eventTypeCapitalise.substring(0, 1) + eventTypeCapitalise.substring(1).toLowerCase()
                    + "', " + rnd.nextInt(clientSize) + ", "
                    + rnd.nextInt(addressSize) + ");\n";
        }
        return events;
    }

    public String generateInvitation() {
        for (int i = 0; i < 50; i++) {
            invitations += "INSERT INTO invitation VALUES (" + i + ", 'You are cordially invited to our event', " + i + ");\n";
        }
        return invitations;
    }

    public String generateNote() {
        String[] note0 = note.get(0).split(",");
        String[] note1 = note.get(1).split(",");
        String[] note2 = note.get(2).split(",");
        String[] note3 = note.get(3).split(",");
        for (int i = 0; i < 50; i++) {
            notes += "INSERT INTO note VALUES (" + i + ", '"
                    + note0[rnd.nextInt(note0.length)] + " "
                    + note1[rnd.nextInt(note1.length)] + "', '"
                    + note2[rnd.nextInt(note2.length)] + " "
                    + note3[rnd.nextInt(note3.length)] + "', "
                    + rnd.nextInt(cpIds.size() + userIds.size()) + ", " + i + ");\n";
        }
        return notes;
    }

    public String generateProject() {
        for (int i = 0; i < 50; i++) {
            projects += "INSERT INTO project VALUES (" + i + ", 'project" + i + "', '" + daysAfterNow(rnd.nextInt(40) + 10) + "', '" + pstates.get(rnd.nextInt(pstates.size())) + "', " + i + ");\n";
        }
        return projects;
    }

    private Date daysAfterNow(int days) {
        Calendar pastDate = Calendar.getInstance();
        pastDate.add(Calendar.DAY_OF_YEAR, days);
        return pastDate.getTime();
    }

    private List<String> read(String fileName) throws FileNotFoundException {
        return reader.read(fileName);
    }
}
