package element.common.imp;

import element.base.imp.BaseControl;
import element.base.imp.Clickable;
import element.common.IButton;

public class Button extends Clickable implements IButton {

	public Button(String locator) {
		super(locator);
	}
}
