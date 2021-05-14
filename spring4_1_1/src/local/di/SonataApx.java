package local.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SonataApx {

	public static void main(String[] args) {
		// herCar는 lifecycle을 직접 관리해야 된다.
		Sonata herCar = new Sonata();
		ApplicationContext context = new ClassPathXmlApplicationContext("local\\di\\sonataBean.xml");
		
		Sonata myCar = null;
		myCar = (Sonata)context.getBean("myCar");
		System.out.println(myCar.toString());
		
		Sonata yourCar = null;
		yourCar = (Sonata)context.getBean("yourCar");
		System.out.println(yourCar.toString());
		System.out.println("yourCar의 현재 속도는"+yourCar.getSpeed());
		
		// meCar부터 터질 것이다. - session -> HttpServlet이 필요하다.
		// forward가 없기 때문에
		// 여기는 web이 아니라 local이기 때문에
		Sonata meCar = null;
		meCar = (Sonata)context.getBean("yourCar");
		System.out.println(meCar.toString());
		System.out.println("meCar의 현재 속도는"+meCar.getSpeed());

		Sonata himCar = null;
		himCar = (Sonata)context.getBean("himCar");
		System.out.println(himCar.toString());
		System.out.println("himCar의 현재 속도는"+himCar.getSpeed());
	}

}
