package com.alexduke.encryption;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class EncryptorTest {
    private static Encryptor encrypt;

    @BeforeAll
    public static void createEncryptor() {
        encrypt = Encryptor.getInstance();
    }

    @Test
    public void encryptPasswordShouldEncrypt() {
        String actual = "987654321";
        String expected = "057058059060061062063064065";
        String decryptionPassword = encrypt.encryptPassword(actual);
        assertEquals(expected, decryptionPassword);
    }

    @Test
    public void PasswordLength3CharactersAnExceptionShouldBeThrown() {
        String actual = "123";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            encrypt.encryptPassword(actual);
        });
        String expectedMessage = "The minimum password length is 4 characters.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void encryptShouldReturnFasterThan100milliseconds() {
        String actual = "987654321987654321";
        assertTimeout(Duration.ofMillis(100), () -> encrypt.encryptPassword(actual));
    }

}