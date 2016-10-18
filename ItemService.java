import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static spark.Spark.*;

import java.sql.Timestamp;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;

import spark.ModelAndView;
import spark.Request;
import spark.template.pebble.PebbleTemplateEngine;
/**
 * Created by Joaki on 10/14/2016.
 */
public class ItemService {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        Database database = new Database();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(Calendar.getInstance().getTime());

        Item item = new Item();
        item.city = "Malmö";
        item.category = "Heminredning";
        item.tradeFor = "Pokémonkort";
        item.description = "Kortet är i bra skick, inköpt 2009";
        item.image = "imgur.com/93574hurt506";
        item.title = "Plansch";
        item.userID = 666;
        item.EstimatedPrice = 999999;
        item.datee = date;
        database.addItem(item);


    }
}