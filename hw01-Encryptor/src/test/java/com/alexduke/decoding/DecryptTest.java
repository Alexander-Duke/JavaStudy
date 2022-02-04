package com.alexduke.decoding;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;


class DecryptTest {
    private static Decrypt decrypt;

    @BeforeAll
    public static void createEncryptor() {
        decrypt = Decrypt.getInstance();
    }

    @Test
    void decryptionPasswordShouldDecoded() {
        String actual = "057058059060061062063064065";
        String expected = "987654321";
        String decryptionPassword = decrypt.decryptionPassword(actual);
        assertEquals(expected, decryptionPassword);
    }

    @Test
    public void decryptShouldReturnFasterThan100milliseconds() {
        String actual = "057058059060061062063064065";
        assertTimeout(Duration.ofMillis(100), () -> decrypt.decryptionPassword(actual));
    }
}