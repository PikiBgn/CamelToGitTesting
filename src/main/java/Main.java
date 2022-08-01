import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {
    public static void main(String[] args) throws Exception {
        CamelContext ctx = new DefaultCamelContext();
        CamelToGitRoute route = new CamelToGitRoute();
        ctx.addRoutes(route);
        ctx.start();
    }
}
