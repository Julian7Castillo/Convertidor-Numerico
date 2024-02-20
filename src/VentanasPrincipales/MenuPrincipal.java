package VentanasPrincipales;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame implements ActionListener {
    
    JPanel contenedorMenuPrincipal;
    JLabel jltitulo;
    JMenuBar mb;
    JMenuItem miElCreador;
    JMenu menuAcercaDe;
    JButton jbmenuconversion, jbmenutabla, jbsalir;
    
    public MenuPrincipal(){
        //Creamos el JFrame que es la ventana
        this.setSize(510,375);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Sistemas Numéricos / Tabla de Verdad");
        
        Color miColor = new Color(1, 89, 101);
        
        // Creamos el contenedores para implementar los Label, Botones, etc...
        contenedorMenuPrincipal = new JPanel();
        contenedorMenuPrincipal.setBounds(0,0,510,430);
        contenedorMenuPrincipal.setBackground(miColor);
        contenedorMenuPrincipal.setLayout(null);
        contenedorMenuPrincipal.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        this.add(contenedorMenuPrincipal);
        
        // Crear barra para las opciones con JMenuBar
        mb = new JMenuBar();
        mb.setBackground(miColor);
        setJMenuBar(mb);
        
        menuAcercaDe = new JMenu("Acerca de");
        menuAcercaDe.setBackground(new Color(255,0,0));
        menuAcercaDe.setFont(new Font("Andale Mono",1,14));
        menuAcercaDe.setForeground(new Color(255,255,255));
        mb.add(menuAcercaDe);
        
        miElCreador = new JMenuItem("Los Creadores");
        miElCreador.setFont(new Font("Andale Mono",1,14));
        miElCreador.setForeground(miColor);
        menuAcercaDe.add(miElCreador);
        miElCreador.addActionListener(this);
        
        //Titulo de la interfaz
        jltitulo = new JLabel("Menú Principal - Sistemas Númericos");
        jltitulo.setBounds(80,35,330,25);
        jltitulo.setForeground(new Color(255,255,255));
        jltitulo.setFont(new Font("Arial",Font.BOLD,18));
        jltitulo.setHorizontalAlignment(JLabel.CENTER);
        jltitulo.setVerticalAlignment(JLabel.CENTER);
        contenedorMenuPrincipal.add(jltitulo);
        
        //Botones de ingresar a menú de converciones o menú de la tabla de verdad
        jbmenuconversion = new JButton("Menú Conversiones");
        jbmenuconversion.setBounds(140, 90, 230, 35);
        jbmenuconversion.setFont(new Font("Arial",Font.BOLD,17));
        jbmenuconversion.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jbmenuconversion.addActionListener(this);
        contenedorMenuPrincipal.add(jbmenuconversion);
        
        jbmenutabla = new JButton("Menú Tabla de Verdad");
        jbmenutabla.setBounds(140, 150, 230, 35);
        jbmenutabla.setFont(new Font("Arial",Font.BOLD,17));
        jbmenutabla.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jbmenutabla.addActionListener(this);
        contenedorMenuPrincipal.add(jbmenutabla);
        
        //Boton para salir
        jbsalir = new JButton("Salir");
        jbsalir.setBounds(370, 250, 100, 35);
        jbsalir.setFont(new Font("Arial",Font.BOLD,17));
        jbsalir.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jbsalir.addActionListener(this);
        contenedorMenuPrincipal.add(jbsalir);
        
    }
    @Override
    public void actionPerformed (ActionEvent ae){
        
        Object fuente = ae.getSource();
        
        if(fuente == jbsalir){
            this.setVisible(false);
            this.dispose();
        }
        if(fuente == jbmenuconversion){
            MenuConversiones menuConver = new MenuConversiones();
            menuConver.setVisible(true);
            this.setVisible(false);
        }
        if(fuente == jbmenutabla){
            MenuTablaVerdad menuTabla = new MenuTablaVerdad();
            menuTabla.setVisible(true);
            this.setVisible(false);
        }
        if(fuente == miElCreador){
            JOptionPane.showMessageDialog(null,"Desarrollado por Diego Méndez | Oscar Castillo | Dany Ruiz | Tatiana Castellanos\n"+
                                       "Todos los derechos reservados ©");
        }
    }
}
