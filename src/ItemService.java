import java.util.Arrays;
import java.util.List;
import static spark.Spark.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;

import spark.ModelAndView;
import spark.Request;
import spark.template.pebble.PebbleTemplateEngine;
/**
 * Created by Joaki on 10/14/2016.
 */
public class ItemService {

    public static void main(String[] args) throws Exception{
        Gson gson = new Gson();
        Database database = new Database();
        database.setup();

        port(8080);

        get("/", (request, response) -> {
            response.body("");
            response.status(200);

            return response.body();
        });
    }

    private static String preferredResponseType (Request request){

        List<String> types = Arrays.asList(request.headers("Accept").split("\\s*,\\s*"));


        for (String type: types) {
            switch (type) {
                case "application/json":
                case "application/xml":
                case "text/html":
                    return type;
                default:
            }
        }

        // Om vi inte stöder något av formaten, skicka tillbaka det första formatet
        return types.get(0);

    }
}
