package com.alexduke.encryption;


public class Encryptor {
    public static final String EXCEPTION_MESSAGE_LENGTH_PASSWORD = "The minimum password length is 4 characters.";
    private static Encryptor instance;

    private Encryptor() {
    }

    public static Encryptor getEncryptor() {
        if (instance == null) {
            instance = new Encryptor();
        }
        return instance;
    }

    public String encryptPassword(String passwordOriginal) {
        checkLengthPassword(passwordOriginal);
        String[] arrayPasswordInAsciiEncrypted = encryptToArray(passwordOriginal);
        return arrayToString(arrayPasswordInAsciiEncrypted);
    }

    private String[] encryptToArray(String passwordOriginal) {
        int sizeArray = passwordOriginal.length();
        var arrayPasswordInAscii = new String[sizeArray];

        for (int i = 0; i < sizeArray; i++) {
            int asciiNum = passwordOriginal.charAt(i);
            int encryptedAsciiNum = asciiNum + i * 2;
            var asciiToString = new StringBuilder("");
            asciiToString.append(encryptedAsciiNum);
            if (asciiToString.length() == 1) {
                asciiToString.insert(0, "00");
            } else if (asciiToString.length() == 2) {
                asciiToString.insert(0, "0");
            }
            arrayPasswordInAscii[i] = asciiToString.toString();
        }
        return arrayPasswordInAscii;
    }

    private String arrayToString(String[] arrayPasswordInAsciiEncrypted) {
        var stringEncryptedPassword = new StringBuilder();
        for (String s : arrayPasswordInAsciiEncrypted) {
            stringEncryptedPassword.append(s);
        }
        return stringEncryptedPassword.toString();
    }

    private void checkLengthPassword(String passwordOriginal) {
        if (passwordOriginal.length() <= 4) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_LENGTH_PASSWORD);
        }
    }
}


