package boundedtype.learning;

import java.util.ArrayList;
import java.util.List;

public class BoundedTypeRunner {
	public static void main(String[] args) {
		//As we all already know that subclass is a parent class and parent class is not a sub class (is-a relationship)
		
		//Object class is the grant parent of all the class 
		Object object =new Object();
		String str="udayan";
		object=str;//since string is the child class of object
		
		Employee employee=new Employee();
		Accountant accountant=new Accountant();
		HRManager hrManager=new HRManager();
		employee=accountant;//allowed since accountant is a employee
		//whereas for Arraylist of different object type
		ArrayList<Object> objectList=new ArrayList<>();
		ArrayList<Employee> employeeList=new ArrayList<>();
		ArrayList<Accountant> accountantList=new ArrayList<>();
		//below two statement are not valid when compare to the statement --->employee=accountant;
		//Type mismatch: cannot convert from ArrayList<Accountant> to ArrayList<Employee>
		//employeeList=accountantList;
		//objectList=employeeList;
		
		//To overcome these we can use wildcard '*' (represent any type)
		//called as outbounded type or unbounded type in java generics
		//gives more flexibility 
		ArrayList<?> employeeList2=new ArrayList<>();
		employeeList2=accountantList;//allowed since it consider the employeeList2 as raw type
		//it is called as upper bounded , here Employee Type is the upper bounded , ? represents any lower bounded and it 
		//it allows either Employee and its all subtypes 
		//it restricts or limits its flexibility 
		//it is used wherever we are going to support new extended version from its upperbounded Type
		//the extends keyword represent both class and interface as well.
		ArrayList<? extends Employee>  employeeList3=new ArrayList<>();
		employeeList3=employeeList;//here employeeList contains the element of upper bounded type 'Employee'
		employeeList3=accountantList;//here AccountantList contains the sub type element of Employee class(upper bounded)
		//employeeList3=objectList;//because ObjectList contains object type which is available in the top of the class hierarchy
		
		
		//Employee Type is the lower bound , and it restricts other type elements and only accepts either Employee and its all super types
		//it's only used where we are not going to support any new subtypes below the lower bounded type mentioned
		ArrayList<? super Employee> employeeList4=new ArrayList<>();
		//employeeList4=accountantList;//not allowed accountantList contains the Accountant type which lower than Employee Type in the class hierarchy
		employeeList4=objectList;//allowed since object is a super type to Employee type 
		employeeList.add(new Employee());
		accountantList.add(new Accountant());
		makeEmployeeWork(employeeList);
		//makeEmployeeWork(accountantList);//compiler not allowed this statement it is just as like the previous statement at line number 25 employeeList=accountantList;
		makeNewEmployeeWork(accountantList);
	}
	
	public static void makeEmployeeWork(List<Employee> employeeList){
		for(Employee emp:employeeList){
			emp.work();
		}
	}
	
	public static void makeNewEmployeeWork(List<? extends Employee> employeeList){
		// it will become a problem suppose if employee object doesn't contain the method work.
		//just comment the method work which is present inside the Employee class
		//if we do so the below foreach will not work and throw compile time error
		//to solve that compiletime error we need to do downcasting the employeeList into (ArrayList<Accountant>)
		//because compiler doesnt know which type of child object or Employee object will be parse in to the makeNewEmployeeWork method
		for(Employee emp:employeeList){
			emp.work();
		}
	}
}
