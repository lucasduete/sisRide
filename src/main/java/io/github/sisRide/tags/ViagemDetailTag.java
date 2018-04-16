package io.github.sisRide.tags;

import io.github.sisRide.gerenciadores.GerenciadorLugar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ViagemDetailTag extends SimpleTagSupport {

    private int idLocalSaida;
    private int idLocalDestino;

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

        this.getJspContext().setAttribute("localSaida", new GerenciadorLugar().getNome(idLocalSaida));
        this.getJspContext().setAttribute("localDestino", new GerenciadorLugar().getNome(idLocalDestino));
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

    public int getIdLocalSaida() {
        return idLocalSaida;
    }

    public void setIdLocalSaida(int idLocalSaida) {
        this.idLocalSaida = idLocalSaida;
    }

    public int getIdLocalDestino() {
        return idLocalDestino;
    }

    public void setIdLocalDestino(int idLocalDestino) {
        this.idLocalDestino = idLocalDestino;
    }
}
