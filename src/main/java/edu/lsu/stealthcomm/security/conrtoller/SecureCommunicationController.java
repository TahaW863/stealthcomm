package edu.lsu.stealthcomm.security.conrtoller;

import edu.lsu.stealthcomm.security.service.DiffieHellmanService;
import edu.lsu.stealthcomm.user.model.UserModel;
import lombok.AllArgsConstructor;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Base64;

@RestController
@RequestMapping("/messages")
@AllArgsConstructor
public class SecureCommunicationController {

    /*private final DiffieHellmanService diffieHellmanService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageRequest request) {
        // Find the recipient in the database by their public key.
        // Assume userService.findByPublicKey(request.getRecipientPublicKey()) returns the recipient object.
        UserModel recipient = userService.findByPublicKey(request.getRecipientPublicKey());

        if (recipient == null) {
            return ResponseEntity.notFound().build();
        }

        // Perform the Diffie-Hellman key exchange.
        AsymmetricCipherKeyPair ephemeralKeyPair = diffieHellmanService.generateEphemeralKeyPair();
        BigInteger sharedSecretKey = diffieHellmanService.calculateSharedSecretKey(
                (DHPrivateKeyParameters) ephemeralKeyPair.getPrivate(),
                new DHPublicKeyParameters(new BigInteger(Base64.getDecoder().decode(request.getRecipientPublicKey())), dhParameters));

        // Encrypt the message using the shared secret key and a symmetric encryption algorithm like AES.
        // Send the encrypted message and ephemeral public key to the recipient.

        // For simplicity, the encrypted message and ephemeral public key are returned as a string.
        String encryptedMessage = encryptMessage(request.getMessage(), sharedSecretKey);
        String ephemeralPublicKey = Base64.getEncoder().encodeToString(ephemeralKeyPair.getPublic().getEncoded());
        String response = String.format("Encrypted message: %s%nEphemeral public key: %s", encryptedMessage, ephemeralPublicKey);

        return ResponseEntity.ok(response);
    }

    private String encryptMessage(String message, BigInteger sharedSecretKey) {
        // Implement your chosen symmetric encryption algorithm, e.g., AES, using the shared secret key.
        // For the sake of example, we'll return the original message.
        return message;
    }*/
}
