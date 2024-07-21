package org.pablo;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.pablo.data.Contact;
import org.pablo.service.ContactService;

import java.util.List;

@Path("/contacts")
public class ContactsResource {
    @Inject
    private ContactService contactService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getContacts(@HeaderParam("token") String token){

        return contactService.getAllContacts();
    }
}
