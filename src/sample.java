
/*******************************************************************
* Name: 
* Class:
* Date:
* Notes:
*
********************************************************************/
import java.lang.Math;
import java.util.Random;

public class sample{

	/*static class ID implements Comparable<ID>{
		double price;
		int weight;
		double pricePerWeight;

		public ID(double a , int b){
			price = a;
			weight = b;
			pricePerWeight = (double)a/ (double)b;
		}
		public int compareTo(ID o) {
			if( price> o.price)
				return 1;
			if( price< o.price)
				return -1;
			return 0;
		}
	
	}*/
	
	
	
	private static double[] results;
	private static Random random = new Random();
	
    public static void main(String[] args){

    	int weight= 30;
        int[] weights= {10,40,25, 10};
        double[] prices= {30,10, 50,40};
    	
    	//int[] weights = randomIntArray(1200000, 50, 1);
    	//double[] prices = randomDoubleArray(1200000, 100, 10);
    	
 
    	
        double max = knapsack( prices, weights,weight);
        System.out.println();
        System.out.println("max profit = " + max);
        for(int a= 0 ;a<results.length ;a++ )
           System.out.println(a+ " : " +results[a] );
        
        
        
    }
    
    public static int[] randomIntArray(int size, int max, int min){
    	
    	int [] array = new int[size];
    	
    	for(int a =0; a< size; a++){
    		array[a] = random.nextInt(max - min +1) + min;
    	}	
    	return array;

    }

    public static double[] randomDoubleArray(int size, int max, int min){
    	
    	double[] array = new double[size];
    	
    	for(int a =0; a< size; a++){
    		array[(int) a] = (double) random.nextInt(max - min +1) + min;
    	}	
    	return array;

    }
    public static double knapsack( double[] prices, int[] weights, int weight){
    	
    	
        double[] sortedPrices = new double[prices.length];        
        int[] sortedWeights= new int[weights.length];
        ID[] items = new ID[prices.length];
        
        //storing memory for dynamic programming
        results = new double[(int) (weight+1)];
        
        for(int a=0;a<results.length;a++)
        	results[a]=-99999;
   
        for(int a=0; a<prices.length ; a++){
        	items[a]= new ID(prices[a], weights[a]  );
        	
        }
        
     // find the maximum bound
        double maxF = bound( items,weight);
        System.out.println("maxF = "+maxF);
        /**
         * we need to sort the price descending
         */
        QuickSort.quickSortPrice(items);//sort by price ascending
        
        System.out.println("after sort");
        for(int c = 0 ;c<prices.length ;c++){
        	sortedPrices[c] =items[c].price; // the price will become descending
        	sortedWeights[c]=items[c].weight;
      
        	
        }
        System.out.println("-----");
        
        //use dynamic programming to identify optimal maximun value the Knabsack can get 
        return maxprofit(sortedPrices,sortedWeights,weight,0, maxF); 

    }

    public static double maxprofit( double[] prices ,int[] weights, int weight, int index, double max){
    	double q;
    	
    	if(weight!=0 && results[weight-1]>=0 ){
    		return results[weight-1];
    	}
  
        if (weight<=0) {
            q= 0;
        }else{
        	q = 0;
	        for( int a = index; a <prices.length ;a++){
	        	if(weight - ( weights[a]) >= 0){
	        		q= Math.max ( q ,prices[a] + maxprofit(prices,weights, weight - ( weights[a]), a+1, max));
	        	}
	        	if(q > max){
	        		return 0;
	        	}
	        }
        }
        if( weight!=0){
        	results[weight-1]=q;
        }
        
        return q;

    }
    
    /*
     * get the bound for the knapsack: 
     * the maximum value the knapsack can get using Fractinal knappsack greedy approach
     * the 0/1 knapsack maximum value can't be greater than the bound
     */
    public static double bound( /*double[] prices ,int[] weights*/ ID[] items, double weight){
       
    	int k =0;
    	int bound =0;
        int totalWeight =0;
        QuickSort.quickSortPricePerWeight(items);
        
        while ((k<items.length) && (totalWeight + items[k].weight <= weight)){
			totalWeight += items[k].weight;
			bound += items[k].price;
			k++;
		}
		
		if(k < items.length){
			bound += (weight - totalWeight) * (items[k].pricePerWeight);
			
		}
        
        return bound;
    }


}
