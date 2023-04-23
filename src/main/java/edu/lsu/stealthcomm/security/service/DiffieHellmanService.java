package edu.lsu.stealthcomm.security.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.agreement.DHBasicAgreement;
import org.bouncycastle.crypto.generators.DHBasicKeyPairGenerator;
import org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;

@Service
@Slf4j
@AllArgsConstructor
public class DiffieHellmanService {
    private final DHParameters dhParameters;

    public AsymmetricCipherKeyPair generateEphemeralKeyPair() {
        DHBasicKeyPairGenerator keyPairGenerator = new DHBasicKeyPairGenerator();
        SecureRandom random = new SecureRandom();
        keyPairGenerator.init(new DHKeyGenerationParameters(random, dhParameters));
        return keyPairGenerator.generateKeyPair();
    }

    public BigInteger calculateSharedSecretKey(DHPrivateKeyParameters privateKey, DHPublicKeyParameters publicKey) {
        DHBasicAgreement agreement = new DHBasicAgreement();
        agreement.init(privateKey);
        return agreement.calculateAgreement(publicKey);
    }
}
