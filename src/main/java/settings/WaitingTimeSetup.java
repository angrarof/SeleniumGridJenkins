package settings;

abstract public class WaitingTimeSetup {
    private final static int WAIT_FOR_WEB_ELEMENT=20;
    private final static int WAIT_FOR_PAGE_LOAD=60;
    private final static int WAIT_IMPLICIT=30;

    public static int getWaitForWebElement() {
        return WAIT_FOR_WEB_ELEMENT;
    }

    public static int getWaitForPageLoad() {
        return WAIT_FOR_PAGE_LOAD;
    }

    public static int getWaitImplicit() {
        return WAIT_IMPLICIT;
    }
}
