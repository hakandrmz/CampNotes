
public class DbKrediLogDao implements KrediLogDao{

	@Override
	public void save(Kredi kredi) {
		System.out.println("Kredi kayitlari veritabanina loglandi : " + kredi.getName());
		
	}

}
