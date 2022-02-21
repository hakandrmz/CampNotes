package guru.hakandurmaz;

import java.util.ArrayList;

public class Hafta2 {
	public static void main(String[] args) {
		
		ArrayList<Integer> superSayilar = new ArrayList<Integer>();

		for (int sayi = 2; sayi < 10000; sayi = sayi + 2) {
			int toplam = 0;
			for (int i = 1; i < sayi/2+1; i++) {
				if (sayi % i == 0) {
					toplam += i;
				}
			}
			if (toplam == sayi) {
				superSayilar.add(sayi);
			}
			System.out.println(sayi);
		}
	}
}
