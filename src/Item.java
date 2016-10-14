import java.sql.Timestamp;

/**
 * Created by Joaki on 10/13/2016.
 */
public class Item {
    public String title = "";
    public int id = 0;
    public int userID = 0;
    public String image = "";
    public String description = "";
    public int valueOfItem = 0;
    public Timestamp datee = new Timestamp(0);
    public String tradeFor = "";
    public String category = "";
    public String city = "";

    public Item() {

    }
}


