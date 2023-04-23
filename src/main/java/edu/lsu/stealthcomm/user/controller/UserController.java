package edu.lsu.stealthcomm.user.controller;

import edu.lsu.stealthcomm.security.service.KeyPairGeneratorService;
import edu.lsu.stealthcomm.user.dtos.UserInput;
import edu.lsu.stealthcomm.user.dtos.UserOutput;
import edu.lsu.stealthcomm.user.model.UserModel;
import edu.lsu.stealthcomm.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.KeyPair;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private final KeyPairGeneratorService keyPairGeneratorService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserOutput> register(@RequestBody UserInput request) throws Exception {
        KeyPair keyPair = keyPairGeneratorService.generateKeyPair();
        // Store the private key securely on the user's device.
        String publicKey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
        String privateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
        // Save user details and public key in the database.
        UserOutput user = UserOutput.builder()
                .username(request.getUsername())
                .publicKey(publicKey)
                .privateKey(privateKey)
                .build();
        UserModel userModel = UserModel.builder()
                .username(request.getUsername())
                .publicKey(publicKey)
                .build();
        userService.save(userModel);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> getAll(){
        try{
            List<UserModel> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
