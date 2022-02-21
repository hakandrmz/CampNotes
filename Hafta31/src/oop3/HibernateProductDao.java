package oop3;

public class HibernateProductDao implements ProductDao {

	@Override
	public void add(Product product) {
		System.out.println("hibernate kullanarak eklendi " + product.getName());		
	}

	@Override
	public void update(Product product) {		
		System.out.println("hibernate kullanarak güncellendi " + product.getName());
	}

	@Override
	public void delete(Product product) {		
		System.out.println("hibernate kullanarak silindi " + product.getName());
	}
	

}
