package progetto.utils.classes;

import java.util.Date;

public class DateTime implements ReceiptMaker {
	Date dateTime;
	public DateTime(Date date) {
		this.dateTime = date;
	}
	
	@Override
	public void print(Purchase receipt) {
		receipt.addDown(dateTime.toString());
	}

}
