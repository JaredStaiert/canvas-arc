package org.jaredstaiert.canvas_arc.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{name}")
    public ResponseEntity<UserDTO> getUserByName(@PathVariable String name) {
        UserDTO response = userService.getUserByUserName(name);
        return ResponseEntity.ok(response);
    }
}
