package element;

public class CheckBox extends BaseElement {

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