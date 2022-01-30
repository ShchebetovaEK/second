package by.tms.project.controller.command;

public class Router {

    public enum RouteType {
        FORWARD, REDIRECT
    }

    private String pagePath = PagePath.INDEX_PAGE;
    private RouteType routerType = RouteType.FORWARD;
    private Integer errorCode;
    private String errorMessage;

    public String getPage() {
        return pagePath;
    }

    public void setPage(String pagePath) {
        this.pagePath = pagePath;
    }

    public RouteType getRouterType() {
        return routerType;
    }

    public void setRouterType(RouteType routerType) {
        this.routerType = routerType;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public boolean hasError() {
        return errorCode != null;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
