/*
package authExample;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SyncFailedException;

*/
/**
 * Created by somebody on 2016/8/9.
 *
 * spring security exmaple
 *//*


public class AuthExample {
    private static SimpleManger am =new SimpleManger();
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("please enter your name :");
            String name =reader.readLine();
            System.out.println("please enter your password :");
            String password=reader.readLine();
            try{
            Authentication auth
                    =new UsernamePasswordAuthenticationToken(name,password);
            Authentication re = am.authenticate(auth);
            SecurityContextHolder.getContext().setAuthentication(re);
            break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Successfully authenticated. Security context contains: " +
                SecurityContextHolder.getContext().getAuthentication());

    }
}
*/
