
public class Node {
	private int indexLevel;
	private int profit;
	private int upperBound;
	private float weight;
	
	public Node(int indexLevel, int profit, int upperBound, float weight){
		this.indexLevel = indexLevel;
		this.profit = profit;
		this.upperBound = upperBound;
		this.weight = weight;
	}
	
	public int getIndexLevel(){
		return this.indexLevel;
	}
	
	public int getProfit(){
		return this.profit;
	}
	
	public int getUpperBound(){
		return this.upperBound;
	}
	
	public float getWeight(){
		return this.weight;
	}
}
