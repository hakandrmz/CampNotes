package oop3;

public class ProductManager {
	
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
