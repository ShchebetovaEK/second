package by.tms.project.controller.tag;

//import jakarta.servlet.jsp.JspException;
//import jakarta.servlet.jsp.JspWriter;
//import jakarta.servlet.jsp.tagext.TagSupport;
//
//public class IncludeHeaderTag implements TagSupport {
        //extends TagSupport {
//    private String var;
//    private Role role;
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public void setVar(String var) {
//        this.var = var;
//    }
//
//    @Override
//    public int doStartTag() {
//        switch (role) {
//            case ADMIN:
//                this.pageContext.setAttribute(var, "admin/admin_header.jsp");
//                break;
//            case MANAGER:
//                this.pageContext.setAttribute(var, "manager/manager_header.jsp");
//                break;
//            case USER:
//                this.pageContext.setAttribute(var, "header.jsp");
//                break;
//            case GUEST:
//                this.pageContext.setAttribute(var, "header.jsp");
//                break;
//        }
//        return SKIP_BODY;
//    }