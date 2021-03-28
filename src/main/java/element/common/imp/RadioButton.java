package element.common.imp;

import element.base.imp.Editable;
import element.common.IRadioButton;

public class RadioButton extends Editable implements IRadioButton {

    public RadioButton(String locator) {
        super(locator);
    }

    public void check() {
        click();
    }

    public boolean isChecked() {
        return isSelected();
    }
}