package com.jeremy.ppe_2.dummy;

import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static String SEARCH;

    public static Formations FORMATIONS;

    public static void setSearch(String search) {
        SEARCH   = search;
        ITEM_MAP = new HashMap<String, DummyItem>();

        new LoadData().execute(new String[] { "http://192.168.0.174:8888/serveur/index.php/formation" });
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static class LoadData extends AsyncTask<String, Integer, String[]> {
        @Override
        protected String[] doInBackground(String... params) {
            Reader reader = null;

            try {
                reader = new InputStreamReader(new URL(params[0]).openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            Gson gson                       = new GsonBuilder().create();
            JsonParser parser               = new JsonParser();
            JsonArray formationsArray       = parser.parse(reader).getAsJsonArray();

            for (JsonElement obj : formationsArray )
            {
                Formation formation = gson.fromJson(obj, Formation.class);
                addItem(new DummyItem(formation.getId().toString(), formation));
            }

            return null;
        }
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public Formation content;

        public DummyItem(String id, Formation content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content.getNom();
        }
    }
}
