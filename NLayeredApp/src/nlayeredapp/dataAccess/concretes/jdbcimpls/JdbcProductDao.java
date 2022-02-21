package nlayeredapp.dataAccess.concretes.jdbcimpls;

import nlayeredapp.dataAccess.abstracts.ProductDao;
import nlayeredapp.entities.concretes.Product;

public class JdbcProductDao implements ProductDao {
    @Override
    public void add(Product product) {
        System.out.println("jdbc kullanarak eklendi " + product.getName());
    }

    @Override
    public void update(Product product) {
        System.out.println("jdbc kullanarak g�ncellendi " + product.getName());
    }

    @Override
    public void delete(Product product) {
        System.out.println("jdbc kullanarak silindi " + product.getName());
    }
}
