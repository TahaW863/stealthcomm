package edu.lsu.stealthcomm.user.service;

import edu.lsu.stealthcomm.user.model.UserModel;
import edu.lsu.stealthcomm.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void save(UserModel user) {
        log.info("Saving user: {}", user);
        userRepository.save(user);
    }
    public UserModel findByUsername(String username) {
        log.info("Finding user by username: {}", username);
        return userRepository.findByUsername(username);
    }

    public List<UserModel> getAllUsers() {
        log.info("Getting all users");
        return userRepository.findAll();
    }
}
