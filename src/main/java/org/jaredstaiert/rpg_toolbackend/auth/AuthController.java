package org.jaredstaiert.rpg_toolbackend.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal Object principal) {
        if (principal instanceof OidcUser oidcUser) {
            return ResponseEntity.ok(oidcUser.getAttributes());
        }
        if (principal instanceof OAuth2User oauth2User) {
            return ResponseEntity.ok(oauth2User.getAttributes());
        }
        return ResponseEntity.status(401).body(null); // or your fallback
    }


    //auth/me
    //check if cookie is valid?

    // Receive auth token
    public void callback() {

    }

    // Logout endpoint
    public void logOut() {

    }

    // Check authentication status
    public void checkAuth() {}
}
