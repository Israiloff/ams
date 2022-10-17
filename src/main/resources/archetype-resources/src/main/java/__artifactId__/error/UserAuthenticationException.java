#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.${artifactId}.error;

public class UserAuthenticationException extends Exception {
    public UserAuthenticationException() {
        super("User authentication error");
    }
}
