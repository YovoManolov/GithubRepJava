
инстанциране  на  вложен клас 


public class Mobile{
	public int numberOfDoors;
	pubilic String brand;
	public String model;

	public Mobile(int numberOfDoors,String brand,String model){
		this.numberOfDoors = numberOfDoors;
		this.brand = brand;
		this.model = model;
	}


	public class MobileEngine{
		private float power;
		private String brand;

		public MobileEngine(float power,String brand){

			this.power = power;
			this.brand = brand;
		}

		public float getPower() {
			return power;
		}
		public void setPower(float power) {
			this.power = power;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}

	}

	public static void main(String[] args) {
		
		Моbile mob = new Mobile(5, "Audi", "A1");
		Mobile.MobileEngine egine = mob.new MobileEngine(2500,"Audi");
	}
}


Static inner classes
не е нужно да създаваме инстанция на външния клас , ако икаме да го инстанцираме
или да извикаме някой негов метод



public abstract class Question { 
	private string text;

	public Question(String text){
		this.text = text;
	}

	pubic void askQeustion(){
		System.out.println(this.text);
	}

	public abstract boolean checkAnswer(Object userAnswer);
}

public class OpenQuestion extends Question {
	private String answer;

	public OpenQuestion(String text, String answer) {
		super(text);
		this.answer = answer;
	}

	@Override
	public boolean checkAnswer(Object userAnswer) {
		if (userAnswer instanceof String) {
			String userAnsw = (String) userAnswer;
			if (this.answer.equals(userAnsw))
				return true;
		}
		return false;
	}
}

public class IntegerQuestion extends Question {
	private Integer answer;
	public IntegerQuestion(String text, Integer answer) {
		super(text);
		this.answer = answer;
	}

	@Override
	public boolean checkAnswer(Object userAnswer) {
		if (userAnswer instanceof Integer) {
			Integer userAnsw = (Integer) userAnswer;
			if (this.answer.equals(userAnsw))
				return true;
		}
		return false;
	}
}


public class Example {

	public enum Level {
		MEDIUM, MASTER
	}

	public Example(Level l) {
		if (l == Level.MEDIUM) {
			System.out.println("The test will be loaded with 
				default questions for MEDIUM level.");
			//////
			Example.FirstExample example = new Example.FirstExample();
			//////
			example.addIntegerQuestion(new IntegerQuestion("Kolko e 2x2?", 4));
			example.addIntegerQuestion(new IntegerQuestion("Kolko koli imash?",
					3));
			example.displayFirstExample();
		} else if (l == Level.MASTER) {
			System.out.println("The test will be loaded with 
						default question for MASTER level.");
			Example.SecondExample example = new Example.SecondExample();
			example.addQuestion(new OpenQuestion("Kak se kazva kotkata vi?", "Tinna"));
			example.addQuestion(new IntegerQuestion(
					"Kolko e 2 na stepen 3-ta?", 8));
			example.displaySecondExample();
		} else {
			System.out.println("No questions.");
		}
	}

	protected static class FirstExample {
		private List listOfquestions;
		private FirstExample() {
			this.listOfquestions = new ArrayList();
		}

		public FirstExample(List listOfquestions) {
			this.listOfquestions = listOfquestions;
		}

		public void displayFirstExample() {
			if (this.listOfquestions == null
					|| this.listOfquestions.size() == 0) {
				System.out.println("No question for First Example.");
			} else {
				for (IntegerQuestion i : listOfquestions) {
					i.askQuestion();
				}
			}
		}

		private void addIntegerQuestion(IntegerQuestion quest) {
			this.listOfquestions.add(quest);
		}
	}

	protected static class SecondExample {
		private List listOfquestions;
		private SecondExample() {
			this.listOfquestions = new ArrayList();
		}

		public SecondExample(List listOfquestions) {
			this.listOfquestions = listOfquestions;
		}

		public void displaySecondExample() {
			if (this.listOfquestions == null
					|| this.listOfquestions.size() == 0) {
				System.out.println("No question for Second Example.");
			} else {
				for (Question i : listOfquestions) {
					i.askQuestion();
				}
			}
		}

		private void addQuestion(Question quest) {
			this.listOfquestions.add(quest);
		}
	}
}

pubilic void Test{
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new IntegerQuestion("Kolko e visok Ivan?",185));
		list.add(new IntegerQuestion("Kolko teji Petq"),60);

		Example.FirstExample = new Example.FirstExample(list);
		ex.displayFirstExample();
	}
}



////local class
public class OuterClass {
	public Person pers;
	public OuterClass(Person pers) {
		this.pers = pers;
	}

	public void printSomethingForPerson() {

		class PersonalInformationPrinter {
			private Person p;

			public PersonalInformationPrinter(Person p) {
				this.p = p;
			}

			public void printPersonalInformation() {
				if (this.p != null) {
					System.out.println("Personal information:");
					System.out.println("Name: " + p.getName().
													getFirstName());
					System.out.println("Years: " + p.getYears());
				}
			}
		}
		PersonalInformationPrinter p = 
							new PersonalInformationPrinter(pers);
		p.printPersonalInformation();
	}
	
	public static void main(String[] args){
		OuterClass out = new OuterClass(new Person(new Name("Ivan",
							 "Ivanov", "Petrov"), 25));
		out.printSomethingForPerson();
	}
} 

Анонимен клас

public interface Printable {
	public abstract void printSomeInfo();
}

public static void main(String [] args){
	Printable printInstance = new Printable (){
		@Override 
		public void  printSomeInfo(){
			System.out.println("something");
		}
	}

	printInstance.printSomeInfo();
}


Ако 2 обекта са еднакви ,то те задължително трябва да имат 
еднакви хеш кодове 
Ако 2 обекта имат едни и същи хеш кодове , те могат , а могат 
и да не бъдат еднакви, в зависимост от устойчивостта на функцията
на колизии


ако на входа на хеш функцията подаваме различни по дължина 
множества, на изхода ще получаваме низове, който ще
 бъде с фиксирана 

Тук се намесва хеш функцията, която за всеки различен
 обект връща цяло число - неговата хеш стойност или метод hashCode(). 


public class Name {
	............ 

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1 ;

		result = prime * result 
			+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
			+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + 
			  ((secondName == null) ? 0 : secondName.hashCode());

		return result; 

	}

	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		

		Name other = Name(obj);
		if(firstName == null){
			if(other.firstName != null) return false;
		}else if (!firstName.equals(other.firstName)){
			return false;
		}

		if(lastName == null){
			if(other.lastName != null) return false;
		}else if (!lastName.equals(other.lastName)){
			return false;
		}

		if(secondName == null){
			if(other.secondName != null) return false;
		}else if(!secondName.equals(other.secondName)){
			return false;
		}

		return true;
	}
}




HashMap - константно време за достъп

load factor - Число м/у 0 и 1 
,показва до каква степен е разрешено да се запълва структурата преди
да се увеличи капацитета автоматично 
initial capacity - размера на структурата при създаването и.

по подразбиране 
	initial capacity = 16 
	loadFactor = 0.75

всяка двойка е обект от тип Entry 

Entry вложен клас в класа Map , достъпва се с Map.Entry.

За да обходим HashMap ни е нужен итератор , който да итерира множеството
(Set от всички Еntry-та)


public static void main(String[] args) {
	Map <Name,Person> mapOfPeople = new HashMap<Name, Person> ();
	Name name1 = new Name("Ivan","Ivanov","Ivanov");
	Person p1 = new Person (name1,25);
	Name name2 = new Name("Gerogi","Georgiev","Georgiev");
	Person p2 = new Person (name2,25);

	mapOfPeople.put(name1,p1);
	mapOfPeople.put(name2,p2);

	Iterator it  = mapOfPeople.entrySet().iterator();
// shte iterira okolo mnojestvo ot entry-ta
	while(it.hasNext()){
		Map.Entry <Name,Person> pair = (Map.Entry) it.next();
		System.out.println("The key is: "  + pair.getKey().getFirstName()
			+ " " + pair.getKey().getLastName() + 
			" The value is  " + pair.getValue().getName().getFirstName() + " " + 
			pair.getValue().getYears());
	}

}

1 - итаратор 
2 - foreach 

for(Map.Entry <Name , Person> me : mapOfPeople.entrySet()){
	System.out.println("Key: " + me.getKey().getFirstName() +
	 " &value: " me.getValue().getName().getFirstName() + " " + me.getValue().getYears());	

}



Друга известна импл на Map  е  HashTable. 
HashTable  представлява синхронизирана импл - предотвратява опастността
от конкурентен достъп.Когато няколко нишки се опитат да променят HashTable
, то първата достъпила я я заключва и другите остават да чакат да бъде
освободена.

LinkedHashMap - поддържа двойките по реда на постъпването им в нея 
ТreeMap - поддърва двойките сортирани в "natural order"  на ключовете 
им.

Entry class
	static class <K,V> implements Map.Entry <K,V>{
		final K key ;
		V value;
		Entry <K ,V> next; //при колизия сочи към следващото 
		//Entry

		int hash;
	}

При колизия , всяко Еntry може да се превърне в свързан списък

Ако няма колизия Entry e свързан списък с един елемент,
Всеки индекс на основния масив от Entry се нарича Bucket.


public class Name {

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result
						+((firstName == null)? 0 : firstName.hashCode());
		result = prime * result 
						+ ((lastName == null)? 0 : lastName.hashCode());

		return result;
	}
}

1.Ключът от двойката Entry <K,V> се хешира
2.По получения хеш се изчислява индекса
3.Ако  този bucket (на този индекс) има стойност null  се създава ново
Еntry и се записва на тази позиция .


Ако първият елемент на Bucket-a  е различен от null,то най-вероятно е
настъпила колизия.Подаденият ключ се сравнява (чрез equals()) с 
ключа на записаното Entry. Ако резултатът е  истина, някой се опитва да 
презапише  елемента и елемента се заменя.Ако е лъжа се продължава 
в случай ,че next != null.Ако сравненеието с всички ключове на този
bucket даде лъжа, то се добавя ново Entry като последен елемент в
свързания списък.

Всеки bucket съхранява първият елемент на свързан списък от тип Entry

LinkedList 
	+/- спрямо масива 
	+ : 
		добавяне/изтриване елемент
		не е необходим голям блок памет
	-: 
		по-бавни
		няма директен достъп до ел
		повече памет за съхранение на адреси 


LinkedList implements List
List extends Collection
List cannot be instantiated.
	 strap

	void add(int,Oject) добавя ел на позиция опр. от първият аргумент
	boolean remove (Oject) премахва елемент
	Object remove(int) премахва елемент на дадена позиция
	Object get(int) взема елемент със съответния индекс
	Boolean contains(Object) проверява дали даден ел е част от списъка
	int indexOf(Object) = връща позиция на елемента

LinkedList	<String> ll = new LinkedList <String>();
LinkedList() Създава празен списък
LinkedList(Collection c) Създава инициализиран списък с елем.
от колекцията Collection.

хибрид м/у свързан списък и лист ArrayList или ДИНАМИЧЕН МАСИВ

динамичният масив може да съхранява само елементи от референтен тип
(разположени в Heap-a)

Steck 
	push(T)
	pop()
	peek()
	size()
	contains()
	toArray()
	clear()

Stack <String> cars = new Stack();
	cars.push("Honda");
	cars.push("Opel");
	cars.push("Mazda");
	cars.push("Audi");

	System.out.println(cars.peek());


OUT : Audi



QUEUE

	offer()/add() добавят елемент в края на опашката
	offer() ако се очаква провал
	add() ако провалът е изключение
	peek() Връща ел от началото на опашката без да го премахва
	poll() връща ел от началото на опашката като го премахва
	contains()
	clear()


Comparator - интерфейс в Java . Предоставя възможност за сравняване
на обекти и подредба сортиране на структури данни .

Метод sort   на клас Collection , на който освен колекцията да се подаде 
и компаратор с който тя да бъде сортирана , в случай , че не е колекция от
числа или от стрингове.



public class Test(){
	static class Customer{
		private String name;
		private int years;
		Customer(String name,int years){
			this.name = name;
			this.years = years;
		} 
	}

	public static void main(String[] args) {
		List listOfCustomers = new ArrayList();
		listOfCustomers.add(new Customer("Adam",18));
		listOfCustomers.add(new Customer("Saly",19));
		listOfCustomers.add(new Customer("Bob",15));
		listOfCustomers.add(new Customer("Marry",21));

		Collection.sort(listOfCustomers, new Comparator(){

			@Override
			public int compare(Customer o1, Customer o2) {
				
				   String firstCustomerName = o1.name.toUpperCase();
				   String secondCustomerName = o2.name.toUpperCase();
				   
				   //asc
				   return firstCustomerName.compareTo(secondCustomerName);

				   //desc 
				   //return secondCustomerName.compareTo(firstCustomerName);
			}
		});

		for(Customer cust : listOfCustomers){
			System.out.println(cust.name);
		}
	}

}


Collection.sort(listOfCustomers , new Comparator(){
	@Override
	public int compare(Customer o1,Customer o2){
		String o1Name = o1.name.toUpperCase();
		String o2Name = o2.name.toUpperCase();
		
		return o1Name.compareTo(o2Name);
		//Desc return o2Name.compareTo(o1Name);
	}
})



байтови (8 bit) потоци - FileInputStream("input.txt");
				 FileOutputStream("output.txt")
знакови потоци - 16 битови данни формат Unicode
---------------------------------	
		FileReader
		FileWriter
---------------------------------	
		
 FileReader и FileWriter чете/пише по 
 2 байта наведнъж, за разлика от байтовите потоци


---------------------------------	
		FileInputStream
		FileOutputStream
---------------------------------	

InputStream f = new FileInputStream("C:/java/hello");


File f = new File("C:/java/hello");
InputStream f = new FileInputStream(f);


public static void main(String[] args) {
	try{
		byte[] writeArr = {1,2,3,4,5};
		OutputStream os = new FileOutputStream("test.txt");

		for(int i = 0; i <writeArr.length ; i ++ ){
			os.write(writeArr[i]);
		}
		os.close();

		InputStream is = new FileInputStream("test.txt");
		int size = is.available();
		/*Returns the number of bytes that can be read
		 (or skipped over) from this input stream 
		 without blocking by the next caller of a
		  method for this input stream. */

		for(int i = 0 ; i < size; i ++ ){ 
			System.out.print((char)is.read() + " "); 
		}
		is.close();
	}catch(IOExcetion e){
		System.out.print("IOException");
	}
}


Буферирани потоци
BufferedReader 
	чете символи
BufferedInputStream
	чете байтове

int buffSize = 5 * 1024;

BufferedReader buffReader = new BufferedReader(
			new FileReader("D:\\someFolder\\someFile.txt"),bufferSize);

 
public static void main(String[] args) {
	BufferedReader br = null;
	try{
		String currentLine ;
		br = new BufferedReader(
			new FileReader("D:\\someFolder\\someFile.txt"));

		while((currentLine = br.readLine()) != null){
			System.out.println(currentLine);
		}

	}catch(IOException e) { 
		e.printStackTrace();
	}finally{
		try{
			if(br != null) br.close();
		}catch(IOException e) { 
			e.printStackTrace();
		}
	}
}

Всички класове, чиито инстанци могат да бъдат затваряни, 
имплементират интерфейса  AutoCloseable .


String

valueOf(boolean b) − Returns the string 
			representation of the boolean argument.

valueOf(char c) − Returns the string 
			representation of the char argument.

valueOf(char[] data) − Returns the string 
			representation of the char array argument.

valueOf(char[] data, int offset, int count) − Returns the string 
			representation of a specific subarray of the char array argument.

valueOf(double d) − Returns the string 
			representation of the double argument.

valueOf(float f) − Returns the string 
			representation of the float argument.

valueOf(int i) − Returns the string 
			representation of the int argument.

valueOf(long l) − Returns the string 
			representation of the long argument.

valueOf(Object obj) − Returns the string 
			representation of the Object argument.


public static boolean isPalindrom(String str) {

// if length is 0 or 1 then String is palindrome

	if (str.length() == 0 || str.length() == 1)

		return true;

	/* check if the first and the last symbols are equal.         and  continue with the next internal couple of symbols.              */

	if (str.charAt(0) == str.charAt(str.length() - 1))

		return isPalindrom(str.substring(1, str.length() - 1));

	return false;

}

---------------------------
 u
---------------------------

append(String);
reverse();
isert(int offset , int i);
replase(int start,int end , Strnig str) 


StringBuffer strBuff = new StringBuffer("George");

strBuffer.append(" is from Bulgaria. ");

System.out.println(strBuff);

PatternSyntaxException - unchecked exceptions 
сигнализира за възникнала грешка в expression шаблона


[a-z-[mnp]] - малки букви от а до z bез буквите m,n,p 
[a-z-[m-p]] - малки букви от а до z bез буквите от m до p 

\s - интервал , табулация , нов ред , връщане в началото на 
ред ( еквивалентно на [\t\n\r])
\w - букви , цифри , долна черта , ( еквивалентно на [a-zA-Z0-9_]);
\W -Всички символи без букви , цифри , долна черта , ( еквивалентно на [^a-zA-Z0-9_]);


\S+ - поредица от няколко непразни символа 

* - пример (X*)  X се среща 0 или повече пъти 
+ - пример (X+)  X се среща 1 или повече пъти 
? - даден символ се среша 0 или 1 път


{X} - даден символ се среша X пъти
{X,Y} - даден символ се среша между X и Y пъти


private Pattern pattern;
private Matcher matcher;

public static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
public UserNameValidator(){
	pattern = Pattern.compile(USERNAME_PATTERN);
}

public boolean validateUserName(final String username){
	matcher = pattern.matcher(username);
	return matcher.matches();
}


Pattern  p = Pattern.compile(REGEX);
Matecher m = p.matcher(strToBeChecked);
bool result = m.matches();


"^[/w{3,15}]$" -username validator 
"^[a-zA-Z0-9_-\\+]+@[a-zA-Z0-9_-]{2,}.[a-zA-Z]"


"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@ [A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


public class PriceErrorException extends Exception{ 
	@Override
	public String getMessage(){
		return "Invalid price !";

	}

}


private static int readPriceTv() throws PriceErrorException {

	Scanner scanner = new Scanner(System.in);

	int userPrice = scanner.nextInt();
	if (userPrice > 500 || userPrice < 100) {
		throw new PriceErrorException();
	}
	return userPrice;
}



public class Example {
	public static void main(String[] args) {
		try {
			readPriceTv();
		} catch (PriceErrorException e) {
			System.out.println(e.getMessage());
		}
	}
}


array literal 

int [] ints2 = {1,2,3,4,5,6,7,8,9,10};

scanner.next() - чете стринг до празен интервал
scanner.nextLine() - чете до знак за нов ред
scaner.nextInt() - чете въведеното число от клавиатурата
scanner.nextDouble(); - чете реални числа 

след като се компилира всеки java  клас се свежда до 
междинен код - байт код , а не до изпълним код!
Този байт код по-късно се превежда на съответната платформа до машинен
(native) код и се изпълнява от т.нар java виртуална машина.
По този начин създателите на езика Sun постигат идеята за платформена
независимост.
Единственото нужно нещо е конкретната кофигурация да разполага
с инсталирана виртуална машина.


Pattern.matches(String regex, CharSequence input)