package circle;

class Circle {
	private int nRadius;
	
	public int getRadius() {
		return nRadius;
	}
	public void setRadius(int nRadius) {
		this.nRadius = nRadius;
	} // 获取 设置半径
	/**
	 * 得到圆的面积
	 * @return area
	 */
	public double getArea() {
		return Math.PI * nRadius * nRadius;
	}
	public static void main(String[] args) {
		Circle a = new Circle();
		a.setRadius(10);
		
		System.out.println(a.getArea());
	}
}
