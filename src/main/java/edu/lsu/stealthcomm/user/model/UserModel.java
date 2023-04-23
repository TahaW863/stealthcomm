package edu.lsu.stealthcomm.user.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Document(collection = "Users")
public class UserModel {
    private String id;
    private String username;
    private String publicKey;
}
