package manager;

import db.DBConnectionProvider;
import model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    private Connection connection;
    private UserManager userManager = new UserManager();
    private CategoryManager categoryManager = new CategoryManager();

    public ItemManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void addItem(Item item) {
        String sql = "INSERT INTO task(title,price,category_id,pic_url,user_id) VALUES(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, item.getTitle());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, item.getCategory().getId());
            ps.setString(4, item.getPicUrl());
            ps.setInt(5, item.getUser().getId());
            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                item.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Item getItemById(int id) {
        String sql = "SELECT * FROM item WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return getItemFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Item> getAllItems() {
        String sql = "SELECT * FROM item";
        Statement statement = null;
        List<Item> items = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
           while(resultSet.next()) {
               items.add(getItemFromResultSet(resultSet));
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public List<Item> getLast20Items() {
        String sql = "SELECT * FROM item ORDER BY id DESC LIMIT 20";
        List<Item> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                result.add(getItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

   public void deleteItemById(int id) {
        String sql = "DELETE FROM item WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }

   public List<Item> getAllUserItems(int userId) {
        String sql = "SELECT * FROM item WHERE user_id = " + userId;
        List<Item> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                result.add(getItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
   }

    private Item getItemFromResultSet(ResultSet resultSet) {
        try {
            return Item.builder()
                    .id(resultSet.getInt(1))
                    .title(resultSet.getString(2))
                    .price(resultSet.getDouble(3))
                    .category(categoryManager.getCategoryById(resultSet.getInt(4)))
                    .picUrl(resultSet.getString(5))
                    .user(userManager.getUserById(resultSet.getInt(6)))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
