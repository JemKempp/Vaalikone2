package javaeetutorial.hello;
 

 
/
 * Root resource (exposed at "ReadAllCandidates" path)
 */
@Path("ReadAllCandidates")
public class ReadAllCandidates {
    @Context
    private UriInfo context;
 
    / Creates a new instance of ReadAllCandidates */
    public ReadAllCandidates() {
    }
    
    @GET
    public String get(@Context UriInfo ui) {
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        MultivaluedMap<String, String> pathParams = ui.getPathParameters();
    }
    /**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<html lang="en"><body><h1>Hello, World!!</h1></body></html>";
    }
}