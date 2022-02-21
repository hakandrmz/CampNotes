package nlayeredapp.business.abstracts;

import nlayeredapp.entities.concretes.Product;

public interface ProductService {
    void add(Product product);
    void update(Product product);
    void delete(Product product);
}
