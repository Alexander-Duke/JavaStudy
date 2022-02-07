package com.alexduke.decoding;

public class Decrypt {
    private static Decrypt instance;

    private Decrypt() {
    }

    public static Decrypt getDecryptor() {
        if (instance == null) {
            instance = new Decrypt();
        }
        return instance;
    }

    public String decryptionPassword(String encryptedPassword) {
        int[] arrayPasswordInAscii = encryptionPasswordToArray(encryptedPassword);
        return processingDecrypt(arrayPasswordInAscii);
    }

    private String processingDecrypt(int[] arrayPasswordInAscii) {
        var encryptedPasswordString = new StringBuilder();
        var encryptedPasswordChar = new char[arrayPasswordInAscii.length];
        for (int i = 0; i < arrayPasswordInAscii.length; i++) {
            encryptedPasswordChar[i] = (char) (arrayPasswordInAscii[i] - i * 2);
        }
        for (char i : encryptedPasswordChar) {
            encryptedPasswordString.append(i);
        }
        return encryptedPasswordString.toString();
    }

    private int[] encryptionPasswordToArray(String encryptedPassword) {
        String[] arrayPassword = stringPasswordToArray(encryptedPassword);
        var intArrayPassword = new int[arrayPassword.length];
        for (int i = 0; i < arrayPassword.length; i++) {
            intArrayPassword[i] = Integer.parseInt(arrayPassword[i]);
        }
        return intArrayPassword;
    }

    private String[] stringPasswordToArray(String encryptedPassword) {
        int arraySize = encryptedPassword.length() / 3;
        var arrayPassword = new String[arraySize];

        for (int i = 0; i < arrayPassword.length; i++) {
            int beginIndex = i * 3;
            int endIndex = 3 + i * 3;
            arrayPassword[i] = encryptedPassword.substring(beginIndex, endIndex);
        }
        return arrayPassword;
    }
}
