package MyPack;

class AccountBalance {

	public static void main(String[] args) {
		Balance current [] = new Balance[3];
		
		current[0] = new Balance("yovo" , 654.53);
		current[1] = new Balance("daniel" , 543.2322);
		current[2] = new Balance("Stamat" , - 54335.3242);

		
		for(int i = 0; i<3; i++){
			current[i].show();
		}
	}

}


