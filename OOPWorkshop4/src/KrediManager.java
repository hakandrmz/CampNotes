

public class KrediManager {
	private KrediDao krediDao;
	private KrediLogDao[] krediLogDaos;
	public KrediManager(KrediDao krediDao, KrediLogDao[] krediLogDaos) {
		this.krediDao = krediDao;
		this.krediLogDaos = krediLogDaos;	
	}
	
	public void add(Kredi kredi, int requestedAmount) {
		
		if(requestedAmount>kredi.getMinAmount() && requestedAmount<kredi.getMaxAmount()) {
			this.krediDao.add(kredi);
			for(KrediLogDao krediLogDao : krediLogDaos) {
				krediLogDao.save(kredi);
			}
			
		}else {
			System.out.println("Istediginiz miktar kredi icin uygun degil");
			for(KrediLogDao krediLogDao : krediLogDaos) {
				krediLogDao.save(kredi);
			}
		}
	}
	public void update(Kredi kredi) {
		
			this.krediDao.update(kredi);
			for(KrediLogDao krediLogDao : krediLogDaos) {
				krediLogDao.save(kredi);
			}
			
		
	}
	public void delete(Kredi kredi) {
	
		this.krediDao.delete(kredi);
		for(KrediLogDao krediLogDao : krediLogDaos) {
			krediLogDao.save(kredi);
		}
}
	
	
	
	
	

}
