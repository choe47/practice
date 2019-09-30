package choe.practice;

public class Main {
	public static void main(String[] args) {
		StackFlow stack = new StackFlow();
		//stack start
		try {
			stack.push("1");
			stack.push("2");
			stack.push("3");
			stack.push("4");
			stack.push("5");
			stack.push("6");
			stack.push("7");
			stack.push("8");
			stack.push("9");
			stack.push("10");
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
