package progetto.utils.classes.tests;

import static org.junit.Assert.assertEquals;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import progetto.utils.classes.DateTime;
import progetto.utils.classes.DownReceipt;
import progetto.utils.classes.Purchase;
import progetto.utils.classes.ReceiptMaker;
import progetto.utils.classes.TopReceipt;

public class ReceiptDecoratorTest {
	private Purchase receipt;;
	private Date date;
	Clock clock;

	@Before
	public void setup() {
		clock = Clock.fixed(Instant.parse("2024-01-05T09:30:00.00Z"), ZoneId.of("Europe/Rome"));
		date = new Date(clock.millis());
		receipt = new MockMakeReceipt();
		receipt.addDown("Items\n");
	}

	@Test
	public void makeDateReceiptTest() {
		DateTime receiptDate = new DateTime(date);
		receiptDate.print(receipt);
		assertEquals(receipt.toString(), "Items\n\n" + date.toString() + "\n");
	}

	@Test
	public void makeTopReceiptTest() {
		ReceiptMaker top = new TopReceipt(new DateTime(date), "Bookshop\n1st Avenue 1234");
		top.print(receipt);
		assertEquals(receipt.toString(), "Bookshop\n1st Avenue 1234\n" + "Items\n\n" + date.toString() + "\n");
	}

	@Test
	public void makeDownReceipt() {
		ReceiptMaker down = new DownReceipt(new DateTime(date), "Thanks for the purchase!");
		down.print(receipt);
		assertEquals(receipt.toString(), "Items\n\n" + "Thanks for the purchase!\n" + date.toString() + "\n");
	}

	@Test
	public void makeReceipt() {
		ReceiptMaker fullReceipt = new TopReceipt(new DownReceipt(new DateTime(date), "Thanks for the purchase!"),
				"Bookshop\n1st Avenue 1234");
		fullReceipt.print(receipt);
		assertEquals(receipt.toString(),
				"Bookshop\n1st Avenue 1234\n" + "Items\n\n" + "Thanks for the purchase!\n" + date.toString() + "\n");
	}
}
