package org.pablo.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ContactsResponse {
    @JsonProperty("contacts")
    private List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }

}
