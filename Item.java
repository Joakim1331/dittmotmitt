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
    public int EstimatedPrice = 0;
    public String datee = "";
    public String tradeFor = "";
    public String category = "";
    public String city = "";

    public Item() {
    }

    public void setItem(String title, int id, String image, String description, int EstimatedPrice, String datee, String tradeFor,
                       String category, String city){
        this.title = title;
        this.id = id;
        this.image = image;
        this.description = description;
        this.EstimatedPrice = EstimatedPrice;
        this.datee = datee;
        this.tradeFor = tradeFor;
        this.category = category;
        this.city = city;
    }

    public String getTitle(){
        return title;
    }

    public String getImage(){
        return image;
    }

    public String getDescription(){
        return description;
    }

    public int getEstimatedPrice(){
        return EstimatedPrice;
    }

    public String getDate(){
        return datee;
    }

    public String getTradeFor(){
        return tradeFor;
    }

    public String getCategory(){
        return category;
    }

    public String getCity(){
        return city;
    }

}


