package wildcard.learning;

import java.util.List;

public class Store<T> {
	List<T> list;
	
	Store(List<T> list){
		this.list=list;
	}
	
	int size(){
		return list.size();
	}
	
	//this method only accepts the Type of the current generic class type parameter type
	boolean isBigStore(Store<T> otherStore){
		if(list.size()>otherStore.size()){
			return true;
		}else{
			return false;
		}		
	}
	//? accepts any type
	boolean isBigStoreThanOtherTypeStore(Store<?> otherStore){
		if(list.size()>otherStore.size()){
			return true;
		}else{
			return false;
		}		
	}
}
