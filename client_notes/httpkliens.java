public Main {
	public static boolean run = true;
	public static void main(String[] args){
		while (run){
			CurrenUser currentUser = Index.run();
			MainMenu.run(currentUser);
		}
	}
}

public Index {
	public static void run(){
		/*
		beolvasás
		switch-case
		CurrenUser currentUser = null;
		while(currentUser == null){
			1. currentUser = Login.login();
			2. currentUser = Registration.reg();
			3. PageVisits.java
			q: kilép run = false
		}
		*/
	}
}



public Login {
	String username;
	String password;
	Long userId;
	int pagesize;
	
	public static CurrentUser login(){
		/*
		bekéri az adatokat
		lekérjük a userId-t a username alapján
		*/
		CurrentUser currentUser = new CurrentUser(userId, pagesize);
		return currentUser;
	}
	
}

public CurrentUser { //1 es menü
	Long userId;
	int pagesize;

	public CurrentUser(Long userId, int pagesize) {
		this.userId = userId;
		this.pagesize = pagesize;
	}
}

public Registration { //2es menü
	
	public static CurrentUser reg(){
		/*
		bekérni az a datokat
		person aki user létrehozása
		crud-ba felküldeni
		*/
		Login.login();
	}
}



