package element;

public class TextBox extends BaseElement {

	public TextBox(String locator) {
		super(locator);
	}

	public void enter(CharSequence... keysToSend) {
		findElement().sendKeys(keysToSend);
	}
}