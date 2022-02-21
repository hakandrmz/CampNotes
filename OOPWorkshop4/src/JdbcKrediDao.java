
public class JdbcKrediDao implements KrediDao{

	@Override
	public void add(Kredi kredi) {
		System.out.println("Jdbc Kredi Eklendi. : " + kredi.getName());
		
	}

	@Override
	public void update(Kredi kredi) {
		System.out.println("Jdbc Kredi Guncellendi. : " + kredi.getName());
		
	}

	@Override
	public void delete(Kredi kredi) {
		System.out.println("Jdbc Kredi Silindi. : " + kredi.getName());
		
	}

}
