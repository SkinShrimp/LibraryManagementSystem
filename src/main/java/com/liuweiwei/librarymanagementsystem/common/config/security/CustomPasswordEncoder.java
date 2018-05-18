package com.liuweiwei.librarymanagementsystem.common.config.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * spring-security登陆的密码进行MD5加密传到数据库
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
        return encoder.encode(rawPassword.toString());
    }
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
        return encoder.matches(encodedPassword, rawPassword.toString());
    }

}
