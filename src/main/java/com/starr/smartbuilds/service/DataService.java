/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.service;

import com.starr.smartbuilds.dao.ChampionDAO;
import com.starr.smartbuilds.dao.ItemDAO;
import com.starr.smartbuilds.dao.TagDAO;
import com.starr.smartbuilds.entity.Champion;
import com.starr.smartbuilds.entity.Item;
import com.starr.smartbuilds.entity.Tag;
import com.starr.smartbuilds.util.Constants;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tanya
 */
@Service
public class DataService {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private TagDAO tagDAO;

    @Autowired
    private ChampionDAO championDAO;

    public void getItemsDataFromRiotAPI() throws IOException, ParseException {
        String line;
        String result = "";
        URL url = new URL("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/item?itemListData=tags&api_key=" + Constants.API_KEY);
        //Get connection
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        System.out.println("resp:" + responseCode);
        System.out.println("resp msg:" + conn.getResponseMessage());

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        System.out.println("BUFFER----");
        while ((line = br.readLine()) != null) {
            result += line;
        }

        conn.disconnect();
        getItemsFromData(result);
    }

    private void getItemsFromData(String data) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(data);
        JSONObject json_data = (JSONObject) json.get("data");
        Set<String> tags = new HashSet<String>();

        for (Object arr : json_data.values()) {
            JSONObject json_arr = (JSONObject) arr;
            Long id = (Long) json_arr.get("id");
            String description = (String) json_arr.get("description");
            String plaintext = (String) json_arr.get("plaintext");
            String name = (String) json_arr.get("name");
            JSONArray json_tags = (JSONArray) json_arr.get("tags");
            String tag_str = "";
            if (json_tags != null) {
                for (Object obj : json_tags) {
                    String tag = (String) obj;
                    if (!tag.equals("") && !tag.equals("")) {
                        tag_str += tag + "&";
                    }
                    tags.add(tag);
                }
            }
            Item item = new Item();
            item.setId(id);
            item.setDescription(description);
            item.setName(name);
            item.setPlaintext(plaintext);
            item.setTag_str(tag_str);

            itemDAO.addItem(item);

        }

        for (String tag_name : tags) {
            Tag tag = new Tag();
            tag.setName(tag_name);
            tagDAO.addTag(tag);
        }
        saveManyToMany();
    }

    private void saveManyToMany() {
        List<Item> items = itemDAO.listItems();
        List<Tag> tags = tagDAO.listTags();

        for (Item item : items) {
            Set<Tag> tags_set = new HashSet<Tag>();
            String[] itemTags = item.getTag_str().split("&");
            for (Tag tag : tags) {
                for (String item_tag : itemTags) {
                    if (tag.getName().equals(item_tag)) {
                        tags_set.add(tag);
                    }
                }
            }
            item.setTags(tags_set);
            itemDAO.updateItem(item);
        }
    }

    public void getChampionsDataFromRiotAPI() throws IOException, ParseException {
        String line;
        String result = "";
        URL url = new URL("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion?api_key=" + Constants.API_KEY);
        //Get connection
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        System.out.println("resp:" + responseCode);
        System.out.println("resp msg:" + conn.getResponseMessage());

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        System.out.println("BUFFER----");
        while ((line = br.readLine()) != null) {
            result += line;
        }

        conn.disconnect();
        getChampionsFromData(result);
    }

    private void getChampionsFromData(String data) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(data);
        JSONObject json_data = (JSONObject) json.get("data");
        for (Object arr : json_data.values()) {
            JSONObject json_arr = (JSONObject) arr;
            Long id = (Long) json_arr.get("id");
            String name = (String) json_arr.get("name");
            String key = (String) json_arr.get("key");
            Champion champ = new Champion();
            champ.setId(id);
            champ.setName(name);
            champ.setKeyChamp(key);
            championDAO.addChampion(champ);
        }
    }

    private String getSummonerIdDataFromRiotAPI(String region, String summonerName) throws MalformedURLException, IOException, ParseException {
        String line;
        String result = "";
        URL url = new URL("https://" + region + ".api.pvp.net/api/lol/" + region + "/v1.4/summoner/by-name/" + summonerName + "?api_key=" + Constants.API_KEY);
        //Get connection
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        System.out.println("resp:" + responseCode);
        System.out.println("resp msg:" + conn.getResponseMessage());

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        System.out.println("BUFFER----");
        while ((line = br.readLine()) != null) {
            result += line;
        }

        conn.disconnect();
        return result;
    }

    public Long getSummonerIdFromData(String region, String summonerName) throws ParseException, IOException {
        try {
            String data = getSummonerIdDataFromRiotAPI(region, summonerName);
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(data);
            JSONObject json_data = (JSONObject) json.get(summonerName.toLowerCase());
            Long id = (Long) json_data.get("id");
            return id;
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    private String getSummonerDataFromRiotAPI(String region, Long summonerID) throws MalformedURLException, IOException {
        String line;
        String result = "";
        URL url = new URL("https://" + region + ".api.pvp.net/api/lol/" + region + "/v2.5/league/by-summoner/" + summonerID + "/entry?api_key=" + Constants.API_KEY);
        //Get connection
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        System.out.println("resp:" + responseCode);
        System.out.println("resp msg:" + conn.getResponseMessage());

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        System.out.println("BUFFER----");
        while ((line = br.readLine()) != null) {
            result += line;
        }

        conn.disconnect();
        return result;
    }

    public String getSummonerTierFromData(String region, Long summonerID) throws IOException, ParseException {
        try {
            String tier = null;
            String data = getSummonerDataFromRiotAPI(region, summonerID);
              System.out.println(data);
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(data);
            System.out.println(json.toString());
            System.out.println("id:"+summonerID.toString());
            JSONArray json_data = (JSONArray) json.get(summonerID.toString());
            for (Object arr : json_data) {
                JSONObject json_arr = (JSONObject) arr;
                String queue = (String) json_arr.get("queue");
                if (queue.equals("RANKED_SOLO_5x5")) {
                    tier = (String) json_arr.get("tier");
                }
            }
            if (tier == null) {
                return "UNRANKED";
            } else {
                return tier;
            }
        } catch (FileNotFoundException ex) {
            return "UNRANKED";
        }
    }
}
