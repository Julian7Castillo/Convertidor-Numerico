package VentanasPrincipales;

import VentanasPrincipales.MenuPrincipal;
import VentanasSecundarias.TablasVerdadDibujo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuTablaVerdad extends JFrame implements ActionListener{
    
    public static int numeroTabla;
    JPanel contenedorMenuTabla;
    JLabel jltitulo, jbnumtabla, jbmaxtabla;
    JMenuBar mb;
    JComboBox jcomboOpcionTabla;
    JMenuItem miElCreador;
    JTextField jtnumtabla;
    JMenu menuAcercaDe;
    JButton jbagregarTabla, jbregresar, jbtabla;
    
    public MenuTablaVerdad(){
        
        //Creamos el JFrame que es la ventana
        this.setSize(510,410);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Agregar Tabla de Verdad");
        
        Color miColor = new Color(1, 89, 101);
        
        // Creamos el contenedores para implementar los Label, Botones, etc...
        contenedorMenuTabla = new JPanel();
        contenedorMenuTabla.setBounds(0,0,510,430);
        contenedorMenuTabla.setBackground(miColor);
        contenedorMenuTabla.setLayout(null);
        contenedorMenuTabla.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        this.add(contenedorMenuTabla);
        
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
        jltitulo = new JLabel("Tabla de Verdad / Ingreso");
        jltitulo.setBounds(80,35,330,35);
        jltitulo.setForeground(new Color(255,255,255));
        jltitulo.setFont(new Font("Arial",Font.BOLD,20));
        jltitulo.setHorizontalAlignment(JLabel.CENTER);
        jltitulo.setVerticalAlignment(JLabel.CENTER);
        contenedorMenuTabla.add(jltitulo);
        
        //Mensaje para el usuario
        jbnumtabla = new JLabel("Ingrese los digitos para la Tabla de Verdad");
        jbnumtabla.setBounds(80, 90, 330, 30);
        jbnumtabla.setForeground(new Color(255, 255, 255));
        jbnumtabla.setFont(new Font("Arial", Font.BOLD, 16));
        jbnumtabla.setHorizontalAlignment(JLabel.CENTER);
        jbnumtabla.setVerticalAlignment(JLabel.CENTER);
        contenedorMenuTabla.add(jbnumtabla);
        
        /*//Para que el usuario ingrese un valor a la tabla
        jtnumtabla = new JTextField();
        jtnumtabla.setFont(new Font("Arial", Font.BOLD, 16));
        jtnumtabla.setBounds(90,140,310,25);
        contenedorMenuTabla.add(jtnumtabla);*/
        
        //JComboBox
        jcomboOpcionTabla = new JComboBox();
        jcomboOpcionTabla.setBounds(90,140,310,25);
        jcomboOpcionTabla.setBackground(new java.awt.Color(224,224,224));
        jcomboOpcionTabla.setFont(new java.awt.Font("Andale Mono",1,14));
        jcomboOpcionTabla.setForeground(miColor);
        contenedorMenuTabla.add(jcomboOpcionTabla);
        jcomboOpcionTabla.addItem("");
        jcomboOpcionTabla.addItem("Tabla 1");
        jcomboOpcionTabla.addItem("Tabla 2");
        jcomboOpcionTabla.addItem("Tabla 3");
        jcomboOpcionTabla.addItem("Tabla 4");
        jcomboOpcionTabla.addItem("Tabla 5");
        jcomboOpcionTabla.addItem("Tabla 6");
        
        //Mensaje indicando el máximo de digitos en la tabla
        jbmaxtabla = new JLabel("* El mínimo es de 1 / Máximo es de 6");
        jbmaxtabla.setBounds(140, 170, 210, 20);
        jbmaxtabla.setForeground(new Color(255, 255, 255));
        jbmaxtabla.setFont(new Font("Arial", Font.BOLD, 12));
        jbmaxtabla.setHorizontalAlignment(JLabel.CENTER);
        jbmaxtabla.setVerticalAlignment(JLabel.CENTER);
        contenedorMenuTabla.add(jbmaxtabla);
        
        //Boton para ingresar el dato y botón de regresar
        jbagregarTabla = new JButton("Ingresar");
        jbagregarTabla.setBounds(200, 220, 100, 35);
        jbagregarTabla.setFont(new Font("Arial",Font.BOLD,17));
        jbagregarTabla.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jbagregarTabla.addActionListener(this);
        contenedorMenuTabla.add(jbagregarTabla);
        
        jbregresar = new JButton("Regresar");
        jbregresar.setBounds(370, 290, 100, 30);
        jbregresar.setFont(new Font("Arial",Font.BOLD,17));
        jbregresar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jbregresar.addActionListener(this);
        contenedorMenuTabla.add(jbregresar);
        
        jbtabla = new JButton("Ver Tabla");
        jbtabla.setBounds(20, 290, 100, 30);
        jbtabla.setFont(new Font("Arial",Font.BOLD,17));
        jbtabla.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jbtabla.addActionListener(this);
        contenedorMenuTabla.add(jbtabla);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        Object fuente = ae.getSource();
        
        String opcionSistema = jcomboOpcionTabla.getSelectedItem().toString();
        
        if(fuente == jbagregarTabla){
            if(opcionSistema.equals("")){ //Revisa si el usuario digito un valor en el JTextField
                JOptionPane.showMessageDialog(null,"No has elegido una tabla de verdad","ADVERTENCIA",2);
            }else{
                //Opciones según la tabla que eliga el usuario con el comboBox. Además, según la condición
                //la variable de tipo entera "numeroTabla" guarda un valor numérico para ser utilizado en el menú de conversiones
                if (opcionSistema.equals("Tabla 1")){
                    JOptionPane.showMessageDialog(null, "Has elegido la Tabla de verdad 1", "MENSAJE", 1);
                    numeroTabla = 1;
                }
                if(opcionSistema.equals("Tabla 2")){
                    JOptionPane.showMessageDialog(null, "Has elegido la Tabla de verdad 2", "MENSAJE", 1);
                    numeroTabla = 2;
                }
                if(opcionSistema.equals("Tabla 3")){
                    JOptionPane.showMessageDialog(null, "Has elegido la Tabla de verdad 3", "MENSAJE", 1);
                    numeroTabla = 3;
                }
                if(opcionSistema.equals("Tabla 4")){
                    JOptionPane.showMessageDialog(null, "Has elegido la Tabla de verdad 4", "MENSAJE", 1);
                    numeroTabla = 4;
                }
                if(opcionSistema.equals("Tabla 5")){
                    JOptionPane.showMessageDialog(null, "Has elegido la Tabla de verdad 5", "MENSAJE", 1);
                    numeroTabla = 5;
                }
                if(opcionSistema.equals("Tabla 6")){
                    JOptionPane.showMessageDialog(null, "Has elegido la Tabla de verdad 6", "MENSAJE", 1);
                    numeroTabla = 6;
                }
            }
        }
        if(fuente == jbregresar){
            MenuPrincipal menup = new MenuPrincipal();
            menup.setVisible(true);
            this.setVisible(false);
        }
        if(fuente == jbtabla){
            if (opcionSistema.equals("") || numeroTabla == 0){
                JOptionPane.showMessageDialog(null, "Debes seleccionar una tabla de verdad!", "ADVERTENCIA", 2);
            }else{
                TablasVerdadDibujo drawTable = new TablasVerdadDibujo();
                drawTable.setVisible(true);
                this.setVisible(false);
            }
        }
        if(fuente == miElCreador){
            JOptionPane.showMessageDialog(null,"Desarrollado por Diego Méndez | Oscar Castillo | Dany Ruiz | Tatiana Castellanos\n"+
                                       "Todos los derechos reservados ©");
        }
    }
}
