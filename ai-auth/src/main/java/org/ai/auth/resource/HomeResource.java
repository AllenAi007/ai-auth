package org.ai.auth.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by hua.ai on 2016/5/9.
 */
@Path("")
public class HomeResource {


    @GET
    @Produces(MediaType.TEXT_HTML)
    public String get() {
        return "Welcome Home";
    }
}
