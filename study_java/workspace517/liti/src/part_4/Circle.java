package part_4;
// <li 4-2> 
class Circle {
		private int centerX; //变量成员，第一圆心和半径
		private int centerY;
		private int radius;
		public void setRadius (int radius) { //方法成员，设置半径
			this.radius = radius;
		}
		public int getRadius () { // 获取半径
			return radius;
		}
		public float getArea () {
			return (float)Math.PI * radius *radius;
		}
		void out() {
			System.out.printf("x = %d y = %d\n", centerX, centerY);
			System.out.println("area = " + getArea());
		}
		public static void main(String[] args) {
			Circle a = new Circle();
			a.centerX = 10;
			a.centerY = 10;
			a.setRadius(2);
			/* float area = a.getArea(); */
			a.out();
		}
}
