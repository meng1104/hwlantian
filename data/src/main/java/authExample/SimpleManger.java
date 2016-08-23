/*
package authExample;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by somebody on 2016/8/9.
 *//*

public class SimpleManger implements AuthenticationManager {
    static final List<GrantedAuthority> AUTHS = new ArrayList<GrantedAuthority>();
    static {
        AUTHS.add(new SimpleAuth("ROLE_USER"));
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(authentication.getName().equals(authentication.getCredentials())){
            return new UsernamePasswordAuthenticationToken(authentication.getName(),
                    authentication.getCredentials(),AUTHS);
        }

        throw new BadCredentialsException("....");
    }
}
*/
