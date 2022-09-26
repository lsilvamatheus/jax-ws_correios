package com.lsilva.matheus;

import com.lsilva.matheus.service.AtendeCliente;
import com.lsilva.matheus.service.EnderecoERP;
import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.URL;

public class App
{
    public static void main(String...args ) throws Exception {
        URL urlCorreios = new URL("https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl");

        QName qNameCorreios = new QName("http://cliente.bean.master.sigep.bsb.correios.com.br/", "AtendeClienteService");

        Service serviceCorreios = Service.create(urlCorreios, qNameCorreios);

        AtendeCliente correios = serviceCorreios.getPort(AtendeCliente.class);

        EnderecoERP endereco= correios.consultaCEP("87023150");
        System.out.println("Cidade: ".concat(endereco.getCidade()));


    }
}
