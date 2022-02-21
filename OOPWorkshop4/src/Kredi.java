
public class Kredi {
	private int id;
	private String name;
	private int minAmount;
	private int maxAmount;
	

	public Kredi(int id, String name, int minAmount, int maxAmount) {
		
		this.id = id;
		this.name = name;
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

	public int getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}
	
	
	
	
}
