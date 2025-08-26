package org.jaredstaiert.canvas_arc.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserByUserName(String name) {
        User user = userRepository.findById(name).orElse(null);

        if (user == null) {
            return null;
        }

        return new UserDTO(user.getUserName(), user.getEmail());
    }
}
