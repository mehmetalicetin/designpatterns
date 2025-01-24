package ch01.product.room;

public class ARoom implements Room {
	private ARoom(){}

	public static ARoom getInstance(){
		return new ARoom();
	}

}
