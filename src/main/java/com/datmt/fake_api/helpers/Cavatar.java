package com.datmt.fake_api.helpers;

import java.util.List;
import java.util.Random;

public class Cavatar {
    private static List<String> avatars = List.of(
            "cat-image-placeholder"
    );


    public static String random() {
        return avatars.get(new Random().nextInt(avatars.size()));
    }
}
