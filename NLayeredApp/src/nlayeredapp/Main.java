package nlayeredapp;

import nlayeredapp.business.concretes.ProductManager;
import nlayeredapp.dataAccess.concretes.hibernateimpls.HibernateProductDao;
import nlayeredapp.dataAccess.concretes.jdbcimpls.JdbcProductDao;
import nlayeredapp.entities.concretes.Product;

public class Main {
	public static void main(String[] args) {
		Product product = new Product(1,"Elma",15,1,new String[] {});
		Product product2 = new Product(1,"Armut",11,2,new String[] {});

		ProductManager manager = new ProductManager(new JdbcProductDao());
		manager.add(product);

		ProductManager manager2 = new ProductManager(new HibernateProductDao());
		manager2.add(product2);
		manager2.delete(product2);
	}
}
