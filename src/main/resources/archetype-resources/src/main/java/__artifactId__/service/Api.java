#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.${artifactId}.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;
import uz.anorbank.error.UserAuthenticationException;
import ${package}.${artifactId}.model.UserCredentials;
import uz.anorbank.rjvalidation.constraint.CmNotBlank;
import uz.devops.rpc4rj.annotation.*;

import javax.validation.Valid;

@Validated
@RJRpcService("/api")
public interface Api {

    @PreAuthorize("hasRole('SAMPLE_ROLE')")
    @RJRpcMethod("sample.method.get.user.credentials")
    @RJRpcErrors({
            @RJRpcError(exception = UserAuthenticationException.class, code = UserAuthenticationException.CODE)
    })
    Mono<UserCredentials> getUserCredentials(@Valid @CmNotBlank @RJRpcParam("data") String data);
}
