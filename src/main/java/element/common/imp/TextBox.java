package element.common.imp;

import element.base.imp.BaseControl;
import element.base.imp.Editable;
import element.common.ITextBox;

public class TextBox extends Editable implements ITextBox {

    public TextBox(String locator) {
        super(locator);
    }
}