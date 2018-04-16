package io.github.sisRide.tags;

import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.model.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class PerfilTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

        Usuario user = (Usuario) request.getAttribute("UsuarioP");
        System.out.println(user);

        this.getJspContext().setAttribute("UsuarioP", user);
    }

    @Override
    public void setParent(JspTag parent) {
        super.setParent(parent);
    }

    @Override
    public JspTag getParent() {
        return super.getParent();
    }

    @Override
    public void setJspContext(JspContext pc) {
        super.setJspContext(pc);
    }

    @Override
    protected JspContext getJspContext() {
        return super.getJspContext();
    }

    @Override
    public void setJspBody(JspFragment jspBody) {
        super.setJspBody(jspBody);
    }

    @Override
    protected JspFragment getJspBody() {
        return super.getJspBody();
    }

}
