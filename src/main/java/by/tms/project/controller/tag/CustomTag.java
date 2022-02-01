package by.tms.project.controller.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ShchbetovaEK
 *
 * class CustomTag
 */
public class CustomTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatDateTime = localDateTime.format(format);
        try {
            out.print(formatDateTime);
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }
}