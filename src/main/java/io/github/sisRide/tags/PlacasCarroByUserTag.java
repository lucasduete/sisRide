package io.github.sisRide.tags;

import io.github.sisRide.gerenciadores.GerenciadorCarro;
import io.github.sisRide.model.Usuario;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PlacasCarroByUserTag extends SimpleTagSupport {

    Object user;

    @Override
    public void doTag() throws JspException, IOException {

        Usuario usuario = (Usuario) user;

        System.out.println(usuario);

        GerenciadorCarro gerenciadorCarro = new GerenciadorCarro();
        List<String> placas = new ArrayList<>();


        gerenciadorCarro.getCarrosByMotorista(usuario.getEmail())
                .forEach((carro) -> placas.add(carro.getPlaca()));

        this.getJspContext().setAttribute("placas", placas);
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

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }
}
