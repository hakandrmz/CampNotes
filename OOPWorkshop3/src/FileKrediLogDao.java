
public class FileKrediLogDao implements KrediLogDao{
	@Override
	public void save(Kredi kredi) {
		System.out.println("Kredi kayitlari dosyaya loglandi : " + kredi.getName());
		
	}
}
