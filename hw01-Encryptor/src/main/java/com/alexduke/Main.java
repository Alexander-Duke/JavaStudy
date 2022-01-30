package com.alexduke;

import com.alexduke.decoding.Decrypt;
import com.alexduke.encryption.Encryptor;
import com.alexduke.users.User;
import com.alexduke.users.UserAdmin;

public class Main {
    public static void main(String[] args) {
        User user01 = new UserAdmin("admin1", "987654321");
        String passwordOriginal = user01.getPassword();
        Encryptor encryptor01 = Encryptor.getInstance();
        String encryptionPassword = encryptor01.encryptPassword(passwordOriginal);
        System.out.println("encryptionPassword " + encryptionPassword);
        Decrypt decrypt = Decrypt.getInstance();
        String s = decrypt.decryptionPassword(encryptionPassword);
        System.out.println("decryptionPassword " + s);
    }
}
