package utils;

import annotation.UseCase;

import java.util.List;

/**
 * loc 20.2
 * @author zx
 *
 */
public class PasswordUtil {
    @UseCase(id = 47,description = "passwords must contain at least one numeric.")
    public boolean validatePassword(String password){
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49)
    public boolean checkForNewPassword(List<String> previousPasswords, String password){
        return !previousPasswords.contains(password);
    }
}
