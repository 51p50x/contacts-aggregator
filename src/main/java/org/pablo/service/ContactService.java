package org.pablo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.pablo.data.Contact;
import org.pablo.data.ContactsResponse;

import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class ContactService {

    @Inject
    @RestClient
    private KennectContactService contactService;

    public List<Contact>  getAllContacts() {
        List<Contact> allContacts = new ArrayList<>();

        Response response = contactService.getContacts(1);
        ContactsResponse contactsResponse = response.readEntity(ContactsResponse.class);
        allContacts.addAll(contactsResponse.getContacts());

        int totalPages = Integer.parseInt(response.getHeaderString("Total-Pages"));
        for (int page = 2; page <= totalPages; page++) {
            response = contactService.getContacts(page);
            contactsResponse = response.readEntity(ContactsResponse.class);
            allContacts.addAll(contactsResponse.getContacts());
        }

        return allContacts;
    }
}
