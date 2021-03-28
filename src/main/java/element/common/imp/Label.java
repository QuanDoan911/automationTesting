package element.common.imp;

import element.base.imp.Clickable;
import element.common.ILabel;

public class Label extends Clickable implements ILabel {

    public Label(String locator) {
        super(locator);
    }
}