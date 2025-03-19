package chapter07;

public class ProductExample {
	public static void main(String[] args) {
		Product<TV, String> product1 = new Product<>();
		product1.setKind(new TV());
		product1.setModel("스마트TV");
		
		TV tv = product1.getKind();//new TV()
//		chapter07.TV@71e7a66b(패키지,클래스@해시코드)
		System.out.println(tv);
		
		String tvModel = product1.getModel();//스마트 TV
		System.out.println(tvModel);
		
		Product<Car, String> product2 = new Product<>();
		product2.setKind(new Car());
		product2.setModel("디젤");
		
		Car car = product2.getKind();// new Car()
//		chapter07.Car@5f150435(패키지,클래스@해시코드)
		System.out.println(car);
		
		String carModel = product2.getModel();// 디젤
		System.out.println(carModel);
	}
}
