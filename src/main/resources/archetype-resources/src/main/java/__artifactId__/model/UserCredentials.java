#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.${artifactId}.model;

import lombok.Value;

import java.util.Map;

@Value(staticConstructor = "of")
public class UserCredentials {
    String username;
    Map<String, Object> claims;
}
