package element.common.imp;

import element.base.imp.Clickable;
import element.common.ILink;

public class Link extends Clickable implements ILink {

    public Link(String locator) {
        super(locator);
    }
}