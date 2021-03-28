package element.common.imp;

import element.base.imp.BaseControl;
import element.base.imp.Editable;
import element.common.ICheckBox;

public class CheckBox extends Editable implements ICheckBox {

    public CheckBox(String locator) {
        super(locator);
    }

    public boolean isChecked() {
        return isSelected();
    }

    public void check() {
        if (!isChecked())
            click();
    }

    public void set(boolean value) {
        if (value) {
            check();
        } else {
            uncheck();
        }
    }

    public void uncheck() {
        if (isChecked())
            click();
    }
}