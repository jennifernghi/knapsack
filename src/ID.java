
public class ID {
	double price;
	int weight;
	double pricePerWeight;

	public ID(double a , int b){
		this.price = a;
		this.weight = b;
		this.pricePerWeight = (double)a / (double)b;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public int getWeight(){
		return this.weight;
	}
	
	public double getPricePerWeight(){
		return this.pricePerWeight;
	}
}
