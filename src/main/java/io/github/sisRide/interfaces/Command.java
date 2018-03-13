package io.github.sisRide.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException;
    
}