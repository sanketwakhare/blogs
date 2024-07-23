package com.core.app.blogs.common.utils;

import com.core.app.blogs.common.constants.GenericConst;

public class SlugService {
    /**
     * Generates a slug from the title
     *
     * @param title Title of the article
     * @return Slug generated from the title
     */
    public static String generateSlug(String title) {
        try {
            String randomHex = getRandomHex();
            return title.toLowerCase()
                    .replaceAll("[:;,.~`()+*&^%#$@!]", GenericConst.EMPTY_STRING)
                    .replaceAll(GenericConst.SPACE, GenericConst.HYPHEN)
                    + GenericConst.HYPHEN + randomHex;
        } catch (Exception e) {
            // TODO: create custom exception and remove this
            throw new RuntimeException("Error generating slug form title" + title);
        }
    }

    private static String getRandomHex() {
        long random = (long) (Math.random() * 100000000000000L);
        return Long.toHexString(random);
    }
}
