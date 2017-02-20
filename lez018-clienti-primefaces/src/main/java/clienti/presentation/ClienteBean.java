/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.presentation;

import clienti.entity.Cliente;
import clienti.service.ClienteService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tss
 */

@Named
@RequestScoped
public class ClienteBean {

    @Inject
    ClienteService clienteService;

    private List<Cliente> clienti;
    
    private Cliente cliente;
    
    @PostConstruct
    public void init() {
        cliente = new Cliente();
        this.clienti = clienteService.findAll();
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<Cliente> getClienti() {
        return clienti;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void onElimina(Long id) {
        clienteService.delete(id);
        clienti = clienteService.findAll();
    }
    
    public String onSave() {
        clienteService.save(cliente);
        clienti = clienteService.findAll();
        return "elencoClienti";
    }

}
