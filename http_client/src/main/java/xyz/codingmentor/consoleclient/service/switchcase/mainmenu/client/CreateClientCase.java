package xyz.codingmentor.consoleclient.service.switchcase.mainmenu.client;

import xyz.codingmentor.consoleclient.Application;
import xyz.codingmentor.consoleclient.api.IHTTPRequest;
import xyz.codingmentor.consoleclient.service.entitycreator.EntityCreator;
import xyz.codingmentor.consoleclient.service.http.HTTPRequest;
import xyz.codingmentor.consoleclient.service.property.URLProperty;
import xyz.codingmentor.consoleclient.service.switchcase.AbstractCase;
import xyz.codingmentor.team3.registry.dto.client.ClientDTO;

/**
 *
 * @author brianelete
 */
public class CreateClientCase extends AbstractCase {

    private final IHTTPRequest<ClientDTO> httpRequest;
    private ClientDTO clientDTO;

    public CreateClientCase() {
        super("Create Client", URLProperty.getURL("Clients.url"));
        this.httpRequest = new HTTPRequest<>(ClientDTO.class);
        this.clientDTO = new ClientDTO();
    }

    @Override
    public void getInput() {
        clientDTO = new ClientDTO();
        Application.IO.out("Name: ");
        clientDTO.setName(Application.IO.getString());
        Application.IO.out("Logo: ");
        clientDTO.setLogo(Application.IO.getString());
        Application.IO.out("Tax number: ");
        clientDTO.setTaxNumber(Application.IO.getString());
        Long address = EntityCreator.getAddress();
        clientDTO.setAddressId(address);
    }

    @Override
    public void executeCase() {
        clientDTO = httpRequest.post(getUrl(), clientDTO);
        if (null != clientDTO) {
            EntityCreator.getContactPerson(clientDTO.getId());
            Application.IO.outln("Client " + clientDTO.getName() + " successfully saved!");
            ClientDTO responseClientDTO = httpRequest.get(getUrl() + clientDTO.getId());
            if (null != responseClientDTO) {
                Application.IO.outln(responseClientDTO.toString());
            }
        } else {
            Application.IO.outln("Invalid data! Please try again.");
        }
        Application.IO.getString("Press any key to continue..");
    }

}
