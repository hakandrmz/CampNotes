
public class HibernateKrediDao implements KrediDao{

	@Override
	public void add(Kredi kredi) {
		System.out.println("Hibernate Kredi Eklendi. : " + kredi.getName());
		
	}

	@Override
	public void update(Kredi kredi) {
		System.out.println("Hibernate Kredi Guncellendi. : " + kredi.getName());
		
	}

	@Override
	public void delete(Kredi kredi) {
		System.out.println("Hibernate Kredi Silindi. : " + kredi.getName());
		
	}

}
