package com.saminniss.passwordpassword.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {
    static List<String> site_titles = new ArrayList<String>(){{
        add(0, "Facebook");
        add(1, "Google");
        add(2, "Amazon");
        add(3, "Microsoft");
        add(4, "Hulu");
        add(5, "Spotify");
        add(6, "Netflix");
        add(7, "Sony");
        add(8, "Apple");
        add(9, "Twitter");
        add(10, "Twitch");
        add(11, "Reddit");
        add(12, "Instagram");
    }};

    private static List<String> passwords = new ArrayList<String>(){{
        add(0, "• at least 6 characters\n" +                                // Facebook
                "• Strong password (Try using uppercase, lowercase and/or symbols)");
        add(1, "• at least 8 characters\n" +                                // Google
                "• Username can't contain & = < , > + \n" +
                "• Username can't contain more than one period (.) in a row\n" +
                "• Username can begin or end with non-alphanumeric characters\n" +
                "• Don't reuse previous few passwords");
        add(2, "• at least 6 characters\n" +                                // Amazon
                "• Don't reuse password");
        add(3, "• at least 8 characters\n" +                                // Microsoft
                "• at least 2 uppercase\n" +
                "• at least 2 lowercase\n" +
                "• at least 2 numbers\n" +
                "• at least 2 symbols\n" +
                "This has changed recently. If your password is very old," +
                " you may only have needed 8 characters and some numbers.");
        add(4, "• at least 6 characters\n" +                                // Hulu
                "You can also sign in with Facebook (if you remember that password)");
        add(5, "• at least 4 characters\n" +                                // Spotify
                "You can also sign in with Facebook");
        add(6, "• at least 4 characters");                                  // Netflix
        add(7, "• at least 8 characters\n" +                                // Sony
                "• at least 1 letter\n" +
                "• at least 1 number\n" +
                "• no repeating characters\n" +
                "• cannot contain username or email address");
        add(8, "• at least 8 characters\n" +                                // Apple
                "• upper and lower case\n" +
                "• at least 1 number");
        add(9, "• at least 6 characters");                                  // Twitter
        add(10, "• at least 8 characters\n" +                               // Twitch
                "You can also log in with Facebook");
        add(11, "• at least 6 characters");                                 // Reddit
        add(12, "• at least 6 characters\n" +
                "You can also log in with Facebook");                                               // Instagram
    }};


    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = site_titles.size()-1;

    static {
        // Add some sample items.
        for (int i = 0; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        String content;

        content = site_titles.get(position);

        return new DummyItem(String.valueOf(position), content, makeDetails(position));
    }



    private static String makeDetails(int position) {
        String detail;

        detail = passwords.get(position);

        return detail;
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
