package nlayeredapp.dataAccess.abstracts;

import nlayeredapp.entities.concretes.Product;

public interface ProductDao {
    void add(Product product);
    void update(Product product);
    void delete(Product product);
}
