
public class Main {

	public static void main(String[] args) {
		Kredi kredi1 = new Kredi(1, "Ciftci Kredisi", 5000, 10000);
		Kredi kredi2 = new Kredi(2, "Ihtiyac Kredisi", 3000, 25000);
		Kredi kredi3 = new Kredi(3, "Ev Kredisi", 250000, 1000000);
		
		
		
		KrediManager krediManager1 = new KrediManager(new JdbcKrediDao(), new KrediLogDao[] {new FileKrediLogDao(),new DbKrediLogDao()});
		KrediManager krediManager2 = new KrediManager(new HibernateKrediDao(),new KrediLogDao[] {new FileKrediLogDao()});
		
		krediManager1.add(kredi1,7500);
		System.out.println("----------------------------------------------------");
		krediManager1.add(kredi2,1000);
		System.out.println("----------------------------------------------------");
		krediManager1.add(kredi3,300000);
		System.out.println("----------------------------------------------------");
		krediManager1.update(kredi2);
		System.out.println("----------------------------------------------------");
		krediManager1.delete(kredi3);
		System.out.println("----------------------------------------------------");
		
		
		krediManager2.add(kredi1,7500);
		System.out.println("----------------------------------------------------");
		krediManager2.add(kredi2,1000);
		System.out.println("----------------------------------------------------");
		krediManager2.add(kredi3,300000);
		System.out.println("----------------------------------------------------");
		krediManager2.update(kredi2);
		System.out.println("----------------------------------------------------");
		krediManager2.delete(kredi3);
		

	}

}
