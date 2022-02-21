package oop3;

public class JdbcProductDao implements ProductDao {

	@Override
	public void add(Product product) {
		System.out.println("jdbc kullanarak eklendi " + product.getName());		
	}

	@Override
	public void update(Product product) {		
		System.out.println("jdbc kullanarak güncellendi " + product.getName());
	}

	@Override
	public void delete(Product product) {		
		System.out.println("jdbc kullanarak silindi " + product.getName());
	}
	
}
