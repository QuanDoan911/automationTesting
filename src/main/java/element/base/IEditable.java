package element.base;

public interface IEditable extends IClickable {

    void enter(CharSequence... value);

    void clear();
}
