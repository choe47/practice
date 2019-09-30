package choe.practice;

import java.util.ArrayList;
import java.util.List;

public class StackFlow {
	private List<String> stack = new ArrayList<String>();
	private int maxStack = 10;

	//文字列を一つ追加
	public void push(String pushStack) throws Exception {
		if (stack.size() >= maxStack) {
			throw new Exception("Stack Over Flow");
		} else {
			stack.add(pushStack);
			return;
		}
	}

	//文字列を一つ取り出し
	public String pop() {
		if (stack.size() > 0) {
			String popStack = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			return popStack;
		} else {
			return null;
		}
	}
	public int getAvailableCapacity() {
		return maxStack - stack.size();
	}
	public void clear() {
		stack.clear();
		return;
	}
}
