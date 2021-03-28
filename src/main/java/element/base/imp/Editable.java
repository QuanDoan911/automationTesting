package element.base.imp;

import element.base.IEditable;

public class Editable extends Clickable implements IEditable {

    public Editable(String locator) {
        super(locator);
    }

    public void enter(CharSequence... value) {
        findElement().sendKeys(value);
    }

    @Override
    public void clear() {
        findElement().clear();
    }
}
