import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joaki on 10/13/2016.
 */
public class Database{

    private Connection connection = null;

    public Database() throws ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:dittmottmitt.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void finalize() throws Throwable{
        try {
            connection.close();
        } catch(SQLException e){
        }
        super.finalize();
    }

    public void setup() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS dittmotmitt");
            statement.executeUpdate("CREATE TABLE dittmotmitt (id INTEGER PRIMARY KEY AUTOINCREMENT, userID INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, image TEXT, description TEXT, valueOfItem TEXT, datee CURRENT_TIMESTAMP, tradeFor TEXT, category TEXT, city TEXT)");

            statement.executeUpdate("INSERT INTO dittmotmitt VALUES (/*1,*/, /*1,*/ 'Plansch', 'http://i.imgur.com/HdXNgtS.jpg', 'Fin unik plansch', '1337, '2016-10-13 13:37:00', Garderob, Heminredning, 'Malmö')");
            statement.executeUpdate("INSERT INTO dittmotmitt VALUES (/*2,*/, /*2,*/ 'Tecknad Plansch', 'http://i.imgur.com/9iPUb8L.jpg', 'Planschen är i bra skick.', '666, '2016-10-13 16:45:10', Blomma, Heminredning, 'Malmö')");
            statement.executeUpdate("INSERT INTO dittmotmitt VALUES (/*3,*/, /*3,*/ 'Fotboll', 'http://www.paow.se/wp-content/uploads/2013/01/fotboll.jpg', 'Fin unik fotboll', '2500', '2016-10-14 11:47:50',Innebandyboll, Sport och Fritid, 'Malmö')");
            statement.executeUpdate("INSERT INTO dittmotmitt VALUES (/*4,*/, /*4,*/ " +
                    "'Pokémonkort', 'http://pokemonkungen.weebly.com/uploads/1/1/8/6/11865388/658581.jpg', 'Pokemonkort i fint skick', '10000, '2016-11-15 16:11:10', Pokémonkort, Hobby, 'Malmö')");

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

    public List<Item> fetchItems() {
        List<Item> items = new ArrayList<Item>();

        try {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM items");
            while (rs.next()) {
                Item item = new Item();

                item.id = rs.getInt("id");
                item.userID = rs.getInt("userID");
                item.title = rs.getString("title");
                item.image = rs.getString("image");
                item.description = rs.getString("description");
                item.valueOfItem = rs.getInt("valueOfItem");
                item.datee = Timestamp.valueOf(rs.getString("datee"));
                item.tradeFor = rs.getString("tradeFor");
                item.category = rs.getString("category");
                item.city = rs.getString("city");

                items.add(item);
            }

            statement.close();
        }
         catch(SQLException e) {
             e.printStackTrace();
         }

        return items;
    }

    public Item fetchItem(int id) {
        Item item = null;

        try{
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT FROM items WHERE ID = " + id);
            if(rs.next()){
                item.id = rs.getInt("id");
                item.userID = rs.getInt("userID");
                item.title = rs.getString("title");
                item.image = rs.getString("image");
                item.description = rs.getString("description");
                item.valueOfItem = rs.getInt("valueOfItem");
                item.datee = Timestamp.valueOf(rs.getString("datee"));
                item.tradeFor = rs.getString("tradeFor");
                item.category = rs.getString("category");
                item.city = rs.getString("city");
            }

            statement.close();
        } catch(SQLException e){
            e.printStackTrace();
        }

        return item;
    }

    public void addItem(Item item){
        try {
            Statement statement = connection.createStatement();

              String sql = "INSERT INTO items (userID, title, image, description, valueOfItem, datee, tradeFor, category, city) "
                      + "VALUES ('" + item.userID + "', "
                      + "'" + item.title + "', "
                      + "'" + item.image + "', "
                      + "'" + item.description + "', "
                      + "'" + item.valueOfItem + "', "
                      + "'" + item.datee.toString() + "', "
                      + "'" + item.tradeFor + "', "
                      + "'" + item.category + "', "
                      + "'" + item.city + "');";
            statement.executeUpdate(sql);

            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateItem(Item item){
        try {
            Statement statement = connection.createStatement();

            String sql = "UPDATE items SET id = " + item.id + ", "
                    +"userID = '" + item.userID + "', "
                    + "'" + item.title + "', "
                    + "'" + item.image + "', "
                    + "'" + item.description + "', "
                    + "'" + item.valueOfItem + "', "
                    + "'" + item.datee.toString() + "', "
                    + "'" + item.tradeFor + "', "
                    + "'" + item.category + "', "
                    + "'" + item.city + "' "
                    + "WHERE id = " + item.id + ";";

            statement.executeUpdate(sql);

            statement.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteItem(int id) {
        try {
            Statement statement = connection.createStatement();

            statement.executeUpdate("DELETE FROM items WHERE ID = " + id);

            statement.close();
        }    catch(SQLException e){
                e.printStackTrace();
            }

    }
    }

