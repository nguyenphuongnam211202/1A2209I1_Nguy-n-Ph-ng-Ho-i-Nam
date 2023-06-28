package codegym.dao;

import codegym.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    public static final String GET_PRODUCT_BY_ID = "call products.get_product_by_id(?)";
    public static final String SELECT_ALL_PRODUCT = "call products.select_all_product();";
    public static final String GET_ID_BY_NAME = "call products.get_id_by_name(?);";
    public static final String INSERT_INTO_PRODUCT = "INSERT INTO product(name,cost,quantity,color,`describe`,id_category ) VALUES (?, ?, ?, ?, ?, ?);";

    private static final String UPDATE_PRODUCT_SQL = "update product set name = ?,cost= ?, quantity =?, color = ?, `describe` =?, id_category =? where id = ?;";
    public static final String DELETE_PRODUCT = "delete from product where id = ?";
    public static final String SEARCH_SQL = "select id, `name`,cost,quantity,color,`describe`,categoryName from products.product join products.category on product.id_category = category.id_category where id like ? or `name` like ? or cost like ? or quantity like ? or color like ? or `describe` like ? or categoryName like ? order by id;";
    private String jdbcURL = "jdbc:mysql://localhost:3306/products";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";

    public ProductDAO() {
    }


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public Product findById(int id) {
        Product product = null;
        try (Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(GET_PRODUCT_BY_ID)) {
            System.out.println(GET_PRODUCT_BY_ID);
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int cost = rs.getInt("cost");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String describe = rs.getString("describe");
                String categoryName = rs.getString("categoryName");
                product = new Product(id, name, cost, quantity, color, describe, categoryName);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_PRODUCT)) {
            System.out.println(SELECT_ALL_PRODUCT);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int cost = rs.getInt("cost");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String describe = rs.getString("describe");
                String categoryName = rs.getString("categoryName");
                productList.add(new Product(id, name, cost, quantity, color, describe, categoryName));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        Connection connection = getConnection();
        System.out.println(INSERT_INTO_PRODUCT);
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_PRODUCT);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getCost());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setString(5, product.getDescribe());
        preparedStatement.setInt(6, getIdByName(product.getCategory()));
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();

    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);
        preparedStatement.setString(1,product.getName());
        preparedStatement.setInt(2,product.getCost());
        preparedStatement.setInt(3,product.getQuantity());
        preparedStatement.setString(4,product.getColor());
        preparedStatement.setString(5,product.getDescribe());
        preparedStatement.setInt(6,getIdByName(product.getCategory()));
        preparedStatement.setInt(7, product.getId());
        preparedStatement.executeUpdate();
        System.out.println(preparedStatement);

    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
        preparedStatement.setInt(1,id);
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();

    }

    public List<Product> searh(String key ){
        List<Product> productList = new ArrayList<>();
        try(Connection connection = getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL)) {
          preparedStatement.setString(1,"%" + key + "%");
          preparedStatement.setString(2,"%" + key + "%");
          preparedStatement.setString(3,"%" + key + "%");
          preparedStatement.setString(4,"%" + key + "%");
          preparedStatement.setString(5,"%" + key + "%");
          preparedStatement.setString(6,"%" + key + "%");
          preparedStatement.setString(7,"%" + key + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int cost = rs.getInt("cost");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String describe = rs.getString("describe");
                String categoryName = rs.getString("categoryName");
                productList.add(new Product(id, name, cost, quantity, color, describe, categoryName));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public int getIdByName(String name) {
        int id = 0;
        try (Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(GET_ID_BY_NAME)) {
            callableStatement.setString(1, name);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id_category");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }


}
