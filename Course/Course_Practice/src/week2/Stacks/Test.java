package week2.Stacks;

public class Test {
	
	public static void main(String[] args) {
//		testArrayStack();
		
		testLinkedListStack();
		
	}
	
	private static void testArrayStack() {
		MyStringArrayStack stringArr = new MyStringArrayStack();
		stringArr.push("Ashish");
		stringArr.push("Shubham");
		stringArr.push("Aditya");
		stringArr.push("Vipin");
		stringArr.push("Srishti");
		stringArr.printArr();
		
		stringArr.push("Vineet");
		stringArr.printArr();
		
		stringArr.push("Akash");
		stringArr.printArr();
				
		stringArr.pop();
		stringArr.printArr();
		System.out.println(stringArr.get());
		
		stringArr.pop();
		stringArr.printArr();
		System.out.println(stringArr.get());
		
		stringArr.pop();
		stringArr.printArr();
		System.out.println(stringArr.get());
		
		stringArr.pop();
		stringArr.printArr();
		System.out.println(stringArr.get());
				
		stringArr.pop();
		stringArr.printArr();
		System.out.println(stringArr.get());
		
		stringArr.pop();
		stringArr.printArr();
		System.out.println(stringArr.get());
	}
	
	private static void testLinkedListStack() {
		MyStringLinkedListStack listStack = new MyStringLinkedListStack();
		listStack.push("Ashish");
		listStack.push("Shubham");
		listStack.push("Aditya");
		listStack.push("Vipin");
		listStack.push("Srishti");
		listStack.printStack();
		
		listStack.push("Vineet");
		listStack.printStack();
		/*

		listStack.push("Akash");
		listStack.printStack();
				
		listStack.pop();
		listStack.printStack();
		System.out.println(listStack.get());
		
		listStack.pop();
		listStack.printStack();
		System.out.println(listStack.get());
		
		listStack.pop();
		listStack.printStack();
		System.out.println(listStack.get());
		
		listStack.pop();
		listStack.printStack();
		System.out.println(listStack.get());
				
		listStack.pop();
		listStack.printStack();
		System.out.println(listStack.get());
		
		listStack.pop();
		listStack.printStack();
		System.out.println(listStack.get());
		*/
	}
}
