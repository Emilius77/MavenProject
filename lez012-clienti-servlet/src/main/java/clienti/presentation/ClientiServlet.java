/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.presentation;

import clienti.entity.Cliente;
import clienti.service.ClienteService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tss
 */

@WebServlet(urlPatterns = "/cliente")
public class ClientiServlet extends HttpServlet {
    
    @Inject
    ClienteService clienteservice;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Inizializzooooo [init()] la SEeEeEeeeeRVLET ..... ");
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Distruggoooooo [destroy()] la SEeEeEeeeeRVLET ..... ");
    }    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        StringBuilder sb = new StringBuilder("<html><head><title>Elenco Clienti</title></head>");
        sb.append("<body><table>");
        for (Cliente cli : clienteservice.findAll()) {
            sb.append("<tr>");
            sb.append("<td>" + cli.getId() + "</td>");
            sb.append("<td>" + cli.getRagioneSociale() + "</td>");
            sb.append("<td>" + cli.getIndirizzo() + "</td>");
            sb.append("</tr>");
        }
        sb.append("</table><a href = index.html>home</a></body></html>");
            resp.getWriter().println(sb.toString());
            
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("inserimento dati");
        String cind = req.getParameter("ind");    //vado a leggere ciò che ho inserito nel campo "ind"
        String cragsoc = req.getParameter("ragsoc");   //vado a leggere ciò che ho inserito nel campo "ragsoc"
        System.out.println(cind);
        System.out.println(cragsoc);
        
        //creo un nuovo cliente per l'inserimento
        Cliente cli = new Cliente();
        cli.setIndirizzo(cind);             //imposta l'indirizzo del cliente con i dati contenuti in "ind" (inseriti via web)
        cli.setRagioneSociale(cragsoc);     //imposta il nome del cliente con i dati contenuti in "ragsoc" (inseriti via web)
        
        clienteservice.save(cli);           //salva i dati del cliente sul database
        
        resp.sendRedirect("index.html");    //redirect alla home del menu
//        resp.sendRedirect("cliente");       //redirect alla pagina che viene richiamata dal "doget"
         
        }
    }
    
    
    
    

