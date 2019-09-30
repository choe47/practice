package choe.practice;

public class Main {
	public static void main(String[] args) {
		Base base = new Base()
	}
}
class Base{
	public void func() {
		innerFunc();
	}

	protected void innerFunc() {
		System.out.println("Base>innerFunc()");
	}
}


class Derived extends Base{
	@Override
	protected void innerFunc() {
		System.out.println("Derived>innerFunc()");
	}
}
