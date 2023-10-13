package com.barzigan.www.barziganlms.utils;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomString {

    public static String gerRandomString(int n) {
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomString = new String(array, StandardCharsets.UTF_8);

        return randomString.chars()
                .mapToObj(i -> (char) i)
                .filter(ch -> (ch >= 'a' && ch <= 'z')
                        || (ch >= 'A' && ch <= 'Z')
                        || (ch >= '0' && ch <= '9'))
                .limit(n)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}