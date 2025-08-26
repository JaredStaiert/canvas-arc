package org.jaredstaiert.canvas_arc.auth;

import org.jaredstaiert.canvas_arc.user.UserDTO;
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
                UserDTO response = new UserDTO(oidcUser.getAttribute("nickname"), oidcUser.getAttribute("email"));
                return ResponseEntity.ok(response);
            }
            case OAuth2User oauth2User -> {
                UserDTO response = new UserDTO(oauth2User.getAttribute("nickname"), oauth2User.getAttribute("email"));
                return ResponseEntity.ok(response);
            }
            default -> {
                return ResponseEntity.status(401).body(null);
            }
        }
    }
}
