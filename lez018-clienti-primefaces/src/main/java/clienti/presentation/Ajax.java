/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.presentation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author tss
 */

@Named
@RequestScoped
public class Ajax {
    
    private String msg;
    private boolean error;

    public Ajax() {
    }

    public boolean isError() {
        return error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void onAjax() {
        this.error = msg.contains("error");
//        System.out.println("onAjax: " + msg);
    }
}
