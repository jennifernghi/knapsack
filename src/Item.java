
public class Item {
	private int value;
	private float weight;
	public Item(int value, float weight){
		this.value = value;
		this.weight = weight;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public float getWeight(){
		return this.weight;
	}
	
	public double getValuePerWeightRatio(){
		return (double) getValue() / (double) getWeight();
	}
}
