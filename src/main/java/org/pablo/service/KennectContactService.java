package org.pablo.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;


@RegisterRestClient(configKey = "extensions-api")
@ClientHeaderParam(name = "Authorization", value = "Bearer {getAuthorizationHeader}")
@Path("/contacts")
public interface KennectContactService {

    default String getAuthorizationHeader(){
        final Config config = ConfigProvider.getConfig();
        return config.getValue("api.token", String.class);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getContacts(@QueryParam("page") int page);
}
