package com.alexduke;

import com.alexduke.decoding.Decrypt;
import com.alexduke.encryption.Encryptor;
import com.alexduke.users.UserAdmin;

//Main
public class Main {
    public static void main(String[] args) {
        var user01 = new UserAdmin("admin1", "987654321");
        var passwordOriginal = user01.getPassword();
        var encryptor01 = Encryptor.getEncryptor();
        var encryptionPassword = encryptor01.encryptPassword(passwordOriginal);
        System.out.println("encryptionPassword " + encryptionPassword);
        var decrypt = Decrypt.getDecryptor();
        var s = decrypt.decryptionPassword(encryptionPassword);
        System.out.println("decryptionPassword " + s);
    }
}
