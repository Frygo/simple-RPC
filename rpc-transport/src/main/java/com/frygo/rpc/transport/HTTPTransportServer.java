package com.frygo.rpc.transport;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author frygo
 * @Create 2020--05-11 15:25
 */
@Slf4j
public class HTTPTransportServer implements TransportServer{
    private RequestHandler handler;
    private Server server;

    @Override
    public void init(int port, RequestHandler handler) {
        this.server = new Server(port);
        this.handler = handler;
        ServletContextHandler ctx = new ServletContextHandler();
        server.setHandler(ctx);//必须注册
        ServletHolder holder = new ServletHolder(new RequstServlet());
        ctx.addServlet(holder,"/*");
    }

    @Override
    public void start() {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    @Override
    public void stop() {

        try {
            server.stop();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }
    class RequstServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req,resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("client connect");
            InputStream in = req.getInputStream();
            OutputStream out = resp.getOutputStream();
            if (handler != null){
                handler.onRequst(in,out);
            }
            out.flush();
        }
    }
}
