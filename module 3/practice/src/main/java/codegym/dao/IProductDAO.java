package codegym.dao;
import codegym.model.Product;
import codegym.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public Product findById(int id);
    public List<Product> selectAll();
    public void insertProduct(Product product) throws SQLException;
    public void updateProduct(Product product) throws  SQLException;

    public void deleteProduct(int id) throws  SQLException;

    public int getIdByName(String name);


}
