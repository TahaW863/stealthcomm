package edu.lsu.stealthcomm.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserOutput {
    private String username;
    private String publicKey;
    private String privateKey;
}
