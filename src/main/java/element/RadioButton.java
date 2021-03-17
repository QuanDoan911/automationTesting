package element;

public class RadioButton extends BaseElement {

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