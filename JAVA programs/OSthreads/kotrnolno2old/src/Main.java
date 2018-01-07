import java.util.concurrent.Semaphore;

public class Main {

	public static Semaphore semaphore = new Semaphore(1);
	public static int globalVar = 222;
	
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new MyThread(1,3));
		Thread th2 = new Thread(new MyThread(2,5));
		Thread th3 = new Thread(new MyThread(3,7));
		Thread th4 = new Thread(new MyThread(4,17));
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}
}

/*да се напише многонишкова пр , която
стартира 4ри нишки.

 всяка от нишките има за цел да 

 проверява стойност от общата им памет
  и трябва да вземе решение в зависимост от тази стойност .

  всяка нишка притежава параметър k , 

  kogato stojnsta в общата памет не се дели целочислоно на k то никата инкрементира с единица споделената клекра и заспива за k 
секунди , 


Ако пък стоността на общата променлива е кратна на k , то съшата се инкрементира с k+1 , a нишката заспива за една секунда .

, но ако стоността на споделената променлива се дели на квадрата на K то нишката прибавя 2k +1 и не заспива . 


Стойностите на к за четирте нишки за съответно 3,5,7,17*/