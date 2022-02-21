package nlayeredapp.business.concretes;

import nlayeredapp.business.abstracts.ProductService;
import nlayeredapp.dataAccess.abstracts.ProductDao;
import nlayeredapp.entities.concretes.Product;

public class ProductManager implements ProductService {
    private ProductDao productDao;

    public ProductManager(ProductDao productDao) {
        this.productDao=productDao;
    }

    public void add(Product product) {
        productDao.add(product);
    }

    public void update(Product product) {
        productDao.update(product);
    }

    public void delete(Product product) {
        productDao.delete(product);
    }
}
