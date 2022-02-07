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

    public String decryptionPassword(String encryptionPassword) {
        var arrayPasswordInAscii = encryptionPasswordToArray(encryptionPassword);
        return processingDecrypt(arrayPasswordInAscii);
    }

    private String processingDecrypt(int[] arrayInt) {
        var depas = new StringBuilder("");
        var array = new char[arrayInt.length];
        for (int i = 0; i < arrayInt.length; i++) {
            array[i] = (char) (arrayInt[i] - i * 2);
        }
        for (var c : array) {
            depas.append(c);
        }
        return depas.toString();
    }

    private int[] encryptionPasswordToArray(String encryptionPassword) {
        var arrayPassword = stringPasswordToArray(encryptionPassword);
        var intArrayPassword = new int[arrayPassword.length];
        for (int i = 0; i < arrayPassword.length; i++) {
            intArrayPassword[i] = Integer.parseInt(arrayPassword[i]);
        }
        return intArrayPassword;
    }

    private String[] stringPasswordToArray(String encryptionPassword) {
        int arraySize = encryptionPassword.length() / 3;
        var arrayPassword = new String[arraySize];

        for (int i = 0; i < arrayPassword.length; i++) {
            var beginIndex = i * 3;
            var endIndex = 3 + i * 3;
            arrayPassword[i] = encryptionPassword.substring(beginIndex, endIndex);
        }
        return arrayPassword;
    }
}
