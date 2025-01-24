package ch01.product.room;

public class BRoom implements Room {
	private BRoom(){}

	public static BRoom getInstance(){
		return new BRoom();
	}
}
