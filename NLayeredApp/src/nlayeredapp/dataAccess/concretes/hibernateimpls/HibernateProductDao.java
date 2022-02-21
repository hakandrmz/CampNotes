package nlayeredapp.dataAccess.concretes.hibernateimpls;

import nlayeredapp.dataAccess.abstracts.ProductDao;
import nlayeredapp.entities.concretes.Product;

public class HibernateProductDao implements ProductDao {
    @Override
    public void add(Product product) {
        System.out.println("hibernate kullanarak eklendi " + product.getName());
    }

    @Override
    public void update(Product product) {
        System.out.println("hibernate kullanarak g�ncellendi " + product.getName());
    }

    @Override
    public void delete(Product product) {
        System.out.println("hibernate kullanarak silindi " + product.getName());
    }
}
