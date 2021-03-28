package element.common;

import element.base.IEditable;

public interface ICheckBox extends IEditable {

    boolean isChecked();

    void check();

    void set(boolean value);

    void uncheck();
}
