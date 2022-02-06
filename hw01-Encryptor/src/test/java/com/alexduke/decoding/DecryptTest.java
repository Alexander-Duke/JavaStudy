package com.alexduke.decoding;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.alexduke.config.EncryptorTestConfig.DURATION_LIMIT_IN_MILLISECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;


class DecryptTest {
    private static Decrypt decrypt;

    @BeforeAll
    public static void init() {
        decrypt = Decrypt.getDecryptor();
    }

    @Test
    void decryptionPassword_shouldDecodedEncryptedPassword() {
        String encryptedPassword = "057058059060061062063064065";
        String decryptedPassword = "987654321";
        String decryptionPassword = decrypt.decryptionPassword(encryptedPassword);
        assertEquals(decryptedPassword, decryptionPassword);
    }

    @Test
    void decryptionPassword_ShouldReturnFasterThan100milliseconds() {
        String EncryptedPassword = "057058059060061062063064065";
        assertTimeout(Duration.ofMillis(DURATION_LIMIT_IN_MILLISECONDS), () -> decrypt.decryptionPassword(EncryptedPassword));
    }
}