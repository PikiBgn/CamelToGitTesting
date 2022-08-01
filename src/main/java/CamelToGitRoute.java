

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.git.GitConstants;



public class CamelToGitRoute extends RouteBuilder  {

    private static CamelToGitRoute camelToGit;

    CamelToGitRoute(){}

    public static CamelToGitRoute getInstance() {
        if(camelToGit==null){
            return camelToGit = new CamelToGitRoute();
        }
        else {
            return camelToGit;
        }
    }

    @Override
    public void configure()  {
        CamelToGitRoute();
    }


    private void CamelToGitRoute(){
        from("file:/src/main/resources/Input?noop=true")
                .routeId("CamelToGit")
                .setHeader(GitConstants.GIT_FILE_NAME, constant("CamelToGit.xml"))
                .to("git://C:/Users/pluczak/IdeaProjects/CamelToGitTest?operation=add")
                .setHeader(GitConstants.GIT_COMMIT_MESSAGE, constant("Sending File"))
                .to("git://C:/Users/pluczak/IdeaProjects/CamelToGitTestt?operation=commit")
                .to("git://C:/Users/pluczak/IdeaProjects/CamelToGitTest?operation=push&remotePath=https://github.com/PikiBgn/CamelToGitTesting.git")
                .log("File sent to github!");

    }



}
