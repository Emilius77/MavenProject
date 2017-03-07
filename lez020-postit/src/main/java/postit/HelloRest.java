/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author tss
 */

@Path("hello")
public class HelloRest {
    
    @GET
    public String msg() {
        return "hello from REST ...";
    }
}
