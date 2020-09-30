package t5_210;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		List<Worker> list = new ArrayList<Worker>();
		Worker w1 = new Worker("zhang3", 18, 3000);
		Worker w2 = new Worker("li4", 25, 3500);
		Worker w3 = new Worker("wang5", 22, 3200);
		Worker w4 = new Worker("zhao6", 24, 3300);
		// 创建一个 List
		list.add(w1);
		list.add(w2);
		list.add(w3); // 增加三个工人
		list.add(1, w4); // 在 li4 前插入一个工人
		list.remove(w3); // 删除 wang5 的信息
		
		for (int i = 0; i < list.size(); i++) {
			Worker w = list.get(i);
			System.out.println(w.getName() + " " + w.getAge() + " " + w.getSalary());
		}
		// 利用 for 循环遍历，打印 List 中所有工人的信息
		System.out.println("===========");
		
		Iterator<Worker> it = list.iterator();
		Worker w = new Worker();
		while(it.hasNext()) {
			w = it.next();
			w.work();
		}
		// 利用迭代遍历，对 List 中所有的工人调用 work 方法
	}
}
