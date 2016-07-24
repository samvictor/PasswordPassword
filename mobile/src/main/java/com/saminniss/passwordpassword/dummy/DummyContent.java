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
        add(0, "FACEBOOK");
        add(1, "GOOGLE");
        add(2, "AMAZON");
        add(3, "MICROSOFT");
        add(4, "HULU");
        add(5, "SPOTIFY");
        add(6, "NETFLIX");
        add(7, "SONY");
        add(8, "APPLE");
        add(9, "TWITTER");
        add(10, "TWITCH");
        add(11, "REDDIT");
        add(12, "INSTAGRAM");
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

        detail = "Some details about number " + position;

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
