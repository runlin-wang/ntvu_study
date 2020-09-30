package test;

import java.util.*;

class Worker {
	String name;
	int age;
	int salary;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getSalary() {
		return salary;
	}

	Worker() {}
	Worker(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public static class P210_T5_502 {
		public static void main(String args[]) {
			Worker zhang3 = new Worker("zhang3", 18, 3000);
			Worker li4 = new Worker("li4", 25, 3500);
			Worker wang5 = new Worker("wang5", 22, 3200);
			Worker zhao6 = new Worker("zhao6", 40, 4000);
			List<Worker> list = new ArrayList<Worker>();
			list.add(zhang3);
			list.add(li4);
			list.add(wang5);
			list.add(1, zhao6);
			list.remove(wang5);
			System.out.println("所有工人信息如下：");
			for (int i = 0; i < list.size(); i++) {
				Worker worker = list.get(i);
				System.out.println(worker.getName() + "\t" + worker.getAge() + "\t" + worker.getSalary());
			}
			System.out.println("-----------");
			Iterator<Worker> it = list.iterator();
			while (it.hasNext()) {
				Worker worker = it.next();
				System.out.println(worker.getName() + "\t" + worker.getAge() + "\t" + worker.getSalary());
			}

		}
	}
}