package progetto.utils.classes.tests;

import progetto.utils.classes.Purchase;

class MockMakeReceipt implements Purchase {

	private StringBuilder builder = new StringBuilder();

	@Override
	public void addDown(String text) {
		builder.append(text + "\n");
	}

	@Override
	public void addTop(String text) {
		builder.insert(0, text + "\n");
	}

	@Override
	public String toString() {
		return builder.toString();
	}
}
