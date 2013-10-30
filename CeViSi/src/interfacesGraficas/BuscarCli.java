/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesGraficas;

import datosPersona.Cliente;
import excepciones.DateAccessException;
import gestionar.GestorClientes;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Administrador
 */
public class BuscarCli extends JFrame implements ActionListener{
    
    JLabel id = new JLabel("Id Cliente: ");
    JTextField ides = new JTextField("");
    JButton bus = new JButton("Buscar");
    JLabel nom = new JLabel("Nombre: ");
    JTextField nomid = new JTextField("");
    JLabel ape = new JLabel("Apellido: ");
    JTextField apeid = new JTextField("");
    JLabel dir = new JLabel("Direccion: ");
    JTextField dirid = new JTextField("");
    JLabel tel = new JLabel("Telefono: ");
    JFormattedTextField telid = new JFormattedTextField("");
    JLabel cuil = new JLabel("CUIL: ");
    JTextField cuilid = new JTextField(""); 
    //JLabel fe_insc = new JLabel("Fecha Inscripcion: ");
    //JTextField fe_inscid = new JTextField("");
    
    public BuscarCli(){
        super("Buscar CLiente");
        this.setBounds(300, 100, 300, 400);
        
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(7,2));
        p.add(id);
        p.add(ides);
        p.add(bus);
        p.add(nom);
        p.add(nomid);
        p.add(ape);
        p.add(apeid);
        p.add(dir);
        p.add(dirid);
        p.add(tel);
        p.add(telid);
        p.add(cuil);
        p.add(cuilid);
        //p.add(fe_insc);
        //p.add(fe_inscid);
        
        
        bus.addActionListener(this);
        
        FlowLayout fl = new FlowLayout();
        this.setLayout(fl);
        add(p);
    }
    public void actionPerformed(ActionEvent e){
        
        try{
        Object buscar = e.getSource();
        
        if(buscar==bus){
            Cliente cliente = new Cliente();
            GestorClientes gc = new GestorClientes();
            String id = ides.getText();
            Integer idcli = Integer.parseInt(id);
            gc.buscarCliente(idcli);
            
            //if()
            nomid.setText(cliente.getNombre());
            apeid.setText(cliente.getApellido());
            dirid.setText(cliente.getDomicilio());
            telid.setValue(cliente.getTelefono());
            cuilid.setText(cliente.getCuil());
            //java.util.Date fec= cliente.getFechaInscripcion();
            //java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy/MM/dd");
            //fe_inscid.setText(sdf.format(fec));
            
        }
        }catch(DateAccessException exc) {
            System.out.println(exc);
                                    }
    }
    
}
