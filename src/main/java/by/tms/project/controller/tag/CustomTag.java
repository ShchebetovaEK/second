package by.tms.project.controller.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspTagException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

/**
 * @author ShchebetovaEK
 *
 *  class CustomTag.
 */

public class CustomTag extends TagSupport {
    private static final String AUTHOR = "@autor ShchebetovaEK";

    /**
     *
     * @return
     * @throws JspException
     */
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print(AUTHOR);
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

}
