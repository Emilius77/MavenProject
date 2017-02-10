/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clienti.swing;

import com.mycompany.clienti.swing.entity.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tss
 */
public class ClienteTableModel extends AbstractTableModel {

    private List<Cliente> clienti;

    private final String[] columnNames = {"ID", "Ragione Sociale", "Indirizzo"};

    public ClienteTableModel() {
        this.clienti=MainFrame.getEm().createQuery("select c from Cliente c order by c.ragioneSociale DESC").getResultList();
    }

    @Override
    public int getRowCount() {
        return clienti.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cli = clienti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cli.getId();
            case 1:
                return cli.getRagioneSociale();
            case 2:
                return cli.getIndirizzo();
            default:
                return null;
        }

    }

}