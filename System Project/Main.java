abstract class Anime {
	private String name;
	private int age;
	private String ability;
	
	Anime(String name, int age, String ability){
		this.name = name;
		this.age = age;
		this.ability = ability;
	}
	
	abstract public void sorcerer();
	public void info() {
		System.out.println("Override me");
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAbility() {
		return ability;
	}
	
}

class Sorcerer extends Anime {
	private String de;
	
	Sorcerer(String name, int age, String ability, String de) {
		super(name, age, ability);
		this.de = de;
	}
	
	public String getDE() {
		return de;
	}
	
	public void sorcerer() {
		System.out.println("Name : " + getName());
		System.out.println("Age : " + getAge());
		System.out.println("Ability : " + getAbility());
		System.out.println("Domain Expansion : " + getDE());
	}
	
	
	public void info() {
		System.out.println("\n\n" + getName() + " is a Sorcerer from the Three-Major Clans, Gojo Clan. He is the first to wield both " + getAbility() + " after so many years, " + 
	"he's also the STRONGEST SORCERER OF THE MODERN ERA");
	}

	
}


public abstract class Main {

	public static void main(String[] args) {
		
		Sorcerer s = new Sorcerer("Gojo Satoru", 28, "Limitless Technique || Six Eyes", "Infinite Void");
		s.sorcerer();
		s.info();

	}

}

/*
		 Scanner s = new Scanner(System.in);

		  try{
			  System.out.print("Enter a number : ");
			  int x = s.nextInt();

			  System.out.print("Enter another number : ");
		      int y = s.nextInt();

		      float z = x / y;

		      System.out.print("\nAnswer : " + z);
		  }
		  catch(ArithmeticException e) {
			  System.out.println("\nError in division operation!");
		  }
		  catch(InputMismatchException e) {
			  System.out.println("\nCheck your input again!");
		  }
		  finally {
			   System.out.println("\n\nThis will just print");
		       s.close();
		  }

*/