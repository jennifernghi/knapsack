
public class RecursiveO1Knapsack {

	public static int knapsack(int W, int prices[], int weights[], int n){
		if(n==0 || W == 0){
			return 0;
		}
		
		if(weights[n-1] > W){
			return knapsack(W, prices, weights, n-1);
		}else{
			return Math.max(prices[n-1] + knapsack(W - weights[n-1], prices, weights, n-1), knapsack(W, prices, weights, n-1));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weight= 30;
        int[] weights= {10,40,25, 10};
        int[] prices= {30,10, 50,40};
        
        System.out.println(knapsack(weight, prices, weights, weights.length));
	}

}
