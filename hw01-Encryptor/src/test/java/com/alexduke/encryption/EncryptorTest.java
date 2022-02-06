package com.alexduke.encryption;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.alexduke.config.EncryptorTestConfig.DURATION_LIMIT_IN_MILLISECONDS;
import static com.alexduke.encryption.Encryptor.EXCEPTION_MESSAGE_LENGTH_PASSWORD;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class EncryptorTest {
    private static Encryptor encrypt;

    @BeforeAll
    public static void init() {
        encrypt = Encryptor.getEncryptor();
    }

    @Test
    void encryptPassword_ShouldEncrypt() {
        String originalPassword = "987654321";
        String encryptedPassword = "057058059060061062063064065";
        String passwordEncryptedByEncryptor = encrypt.encryptPassword(originalPassword);
        assertEquals(encryptedPassword, passwordEncryptedByEncryptor);
    }

    @Test
    void encryptPassword_ShouldBeThrownAnExceptionIfPasswordShort() {
        String originalShortPassword = "123";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            encrypt.encryptPassword(originalShortPassword);
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(EXCEPTION_MESSAGE_LENGTH_PASSWORD));
    }

    @Test
    void encryptPassword_ShouldReturnFast() {
        String actual = "987654321987654321";
        assertTimeout(Duration.ofMillis(DURATION_LIMIT_IN_MILLISECONDS), () -> encrypt.encryptPassword(actual));
    }

}