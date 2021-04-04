package element.common;

import element.base.IClickable;
import element.base.IEditable;

import java.util.List;

public interface ICombobox extends IEditable {

    String getSelected();

    void selectByText(String text);

    void selectByIndex(int index);

    void selectByValue(String value);

    List<String> getOptions();
}
