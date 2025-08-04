package org.jaredstaiert.rpg_toolbackend.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // Entry point to BFF
    @GetMapping("/login")
    public ResponseEntity<?> getUser(@AuthenticationPrincipal OidcUser principal) {
        if (principal == null) {
            // Not authenticated
            return ResponseEntity.status(401).build();
        }

        // You can customize this map as needed for your frontend/app
        Map<String, Object> userInfo = Map.of(
                "id", principal.getSubject(),
                "name", principal.getFullName(),
                "email", principal.getEmail(),
                "avatarUrl", principal.getPicture() // May be null if not provided by IdP
                // Add roles/permissions if you manage them
        );

        // Optionally: find/create/update user in your own DB here

        return ResponseEntity.ok(userInfo);
    }

    // Receive auth token
    public void callback() {

    }

    // Logout endpoint
    public void logOut() {

    }

    // Check authentication status
    public void checkAuth() {}
}
