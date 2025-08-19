package org.jaredstaiert.rpg_toolbackend.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${demo-user-email}")
    private String demoUser;

    @Value("${demo-user-pass}")
    private String demoPass;

    @Value("${auth0-issuer}")
    private String domain;

    @Value("${auth0-secret}")
    private String secret;

    @Value("${auth0-cid}")
    private String clientId;

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal Object principal) {
        System.out.println(principal.toString());
        switch (principal) {
            case OidcUser oidcUser -> {
                return ResponseEntity.ok(oidcUser.getAttributes());
            }
            case OAuth2User oauth2User -> {
                return ResponseEntity.ok(oauth2User.getAttributes());
            }
            default -> {
                return ResponseEntity.status(401).body(null);
            }
        }
    }
}
