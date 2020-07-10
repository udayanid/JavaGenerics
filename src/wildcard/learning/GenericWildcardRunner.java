package wildcard.learning;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericWildcardRunner {
	public static void main(String[] args) {
		ArrayList<String> stringList=new ArrayList<>(Arrays.asList("sanjai","udayan","rajan","kandhan"));
		ArrayList<String> stringList2=new ArrayList<>(Arrays.asList("one","two","three"));

		ArrayList<Integer> integerList=new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		ArrayList<Double> doubleList=new ArrayList<>(Arrays.asList(10.0,20.0,30.0));	
		
		Store<String> stringStore=new Store<>(stringList);
		Store<String> stringStore2=new Store<>(stringList2);

		Store<Integer> integerStore=new Store(integerList);
		Store<Double> doubleStore = new Store(doubleList);
		
		//System.out.println(stringStore.isBigStore(integerStore));
		//The above statement throw compile time error becasue 'The method isBigStore(Store<String>) in the type Store<String> is not applicable for the arguments (Store<Integer>)'
		//but it will accept store of ListofString object,because the current object belongs to string type and it only accept string type List 
		System.out.println(stringStore.isBigStore(stringStore2));	
		//to overcome these problem we can use wildcard ? in the generic class method
		System.out.println(stringStore.isBigStoreThanOtherTypeStore(integerStore));
	}
}
