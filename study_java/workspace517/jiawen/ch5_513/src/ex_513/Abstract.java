package ex_513;

public class Abstract{
	public static void main(String[]args){
		Rectangle r =new Rectangle(10,8);
		System.out.println(r.getArea());
		Square s=new Square(8);
		System.out.println(s.getArea());
		Ellipse e=new Ellipse(7,4);
		System.out.println(e.getArea());}} 
abstract class Shape{
	public abstract double getArea();}
 class Rectangle extends Shape{
private double length;
private double heigth;
public Rectangle(double length,double height){
	this.length=length;
	this.heigth=height;}
public Rectangle(){}
public double getArea(){
return length*heigth;}}
 class Square extends Rectangle{
	public Square(double length){
		 super(length,length); }
	public Square(){}
	public double getArea(){
		return super.getArea();}}
 class Ellipse extends Square{
	 private double majorAxis,minorAxis;
	 public Ellipse(double majorAxis,double minorAxis){
		 this .majorAxis=majorAxis;
		 this.minorAxis=minorAxis;}
	 public double getArea(){
		 return Math.PI*majorAxis*minorAxis/4.0; 
		 }
	 }