package com.alexduke.encryption;


public class Encryptor {
    private static Encryptor instance;
    public static final String EXCEPTION_MESSAGE_LENGTH_PASSWORD = "The minimum password length is 4 characters.";

    private Encryptor() {
    }

    public static Encryptor getEncryptor() {
        if (instance == null) {
            instance = new Encryptor();
        }
        return instance;
    }

    public String encryptPassword(String passwordOriginal) {
        checkLenghtPassword(passwordOriginal);

        String[] arrayPasswordInAsciiEncrypted = encryptToArray(passwordOriginal);
        return arrayToString(arrayPasswordInAsciiEncrypted);
    }

    private String[] encryptToArray(String passwordOriginal) {
        int sizeArray = passwordOriginal.length();
        String[] arrayPasswordInAscii = new String[sizeArray];


        for (int i = 0; i < sizeArray; i++) {
            char character = passwordOriginal.charAt(i);
            int asciiNum = character;
            int encryptedAsciiNum = asciiNum + i * 2;
            StringBuilder asciiToString = new StringBuilder("");
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
        StringBuilder pas = new StringBuilder("");
        for (String s : arrayPasswordInAsciiEncrypted) {
            pas.append(s);
        }
        return pas.toString();
    }

    private void checkLenghtPassword(String passwordOriginal) {
        if (passwordOriginal.length() <= 4) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_LENGTH_PASSWORD);
        }
    }
}


