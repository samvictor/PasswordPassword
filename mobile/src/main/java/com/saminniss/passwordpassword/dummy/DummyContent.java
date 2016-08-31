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


    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;
        public final String text_color;
        public final String bg_color;

        public DummyItem(String id, String content, String details, String text_color, String bg_color) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.text_color = text_color;
            this.bg_color = bg_color;
        }

        @Override
        public String toString() {
            return content;
        }
    }

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


    private static List<ArrayList<String>> site_colors = new ArrayList<ArrayList<String>>(){{
        add(0, new ArrayList<String>(){{add("#eeeeee");add("#224477");}}); // facebook
        add(1, new ArrayList<String>(){{add("#dc2020");add("#ffffff");}}); // google
        add(2, new ArrayList<String>(){{add("#ff6622");add("#181818");}}); // amazon
        add(3, new ArrayList<String>(){{add("#ffffff");add("#44aaff");}}); // microsoft
        add(4, new ArrayList<String>(){{add("#55d055");add("#181818");}}); // hulu
        add(5, new ArrayList<String>(){{add("#ffffff");add("#409040");}}); // spotify
        add(6, new ArrayList<String>(){{add("#ee3333");add("#181818");}}); // netflix
        add(7, new ArrayList<String>(){{add("#eeeeee");add("#202050");}}); // sony
        add(8, new ArrayList<String>(){{add("#333333");add("#aaaaaa");}}); // apple
        add(9, new ArrayList<String>(){{add("#ffffff");add("#64baff");}}); // twitter
        add(10, new ArrayList<String>(){{add("#ffffff");add("#7044bd");}}); // twitch
        add(11, new ArrayList<String>(){{add("#101010");add("#f77623");}}); // reddit
        add(12, new ArrayList<String>(){{add("#ffffff");add("#8854ff");}}); // instagram
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
        String content, text_color, bg_color;

        content = site_titles.get(position);
        text_color = site_colors.get(position).get(0);
        bg_color = site_colors.get(position).get(1);

        return new DummyItem(String.valueOf(position), content, makeDetails(position), text_color, bg_color);
    }



    private static String makeDetails(int position) {
        String detail;

        detail = passwords.get(position);

        return detail;
    }
}
