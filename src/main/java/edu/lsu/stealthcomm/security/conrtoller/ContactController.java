package edu.lsu.stealthcomm.security.conrtoller;

import edu.lsu.stealthcomm.user.model.UserModel;
import edu.lsu.stealthcomm.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/contacts")
@AllArgsConstructor
public class ContactController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserModel> addContact(@RequestParam String contactUsername) {
        // Find the user in the database by their username.
        // Assume userService.findByUsername(contactUsername) returns the user object.
        UserModel contact = userService.findByUsername(contactUsername);

        if (Objects.isNull(contact)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contact);
    }
}
