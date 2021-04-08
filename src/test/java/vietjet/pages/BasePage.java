package vietjet.pages;

import element.common.imp.Label;

class BasePage {
    public boolean isPageDisplayed(Label pageName) {
        return pageName.isDisplayed();
    }
}
