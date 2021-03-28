package element.common;

import element.base.IClickable;
import element.base.IEditable;

import java.util.List;

public interface ICombobox extends IEditable {

    String getSelected();

    void select(String text);

    void select(int index);

    List<String> getOptions();
}
