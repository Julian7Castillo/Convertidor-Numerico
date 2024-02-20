package VentanasPrincipales;

import VentanasPrincipales.MenuPrincipal;
import VentanasPrincipales.MenuTablaVerdad;
import VentanasSecundarias.ConversionBin;
import VentanasSecundarias.ConversionDecimal;
import VentanasSecundarias.ConversionHexa;
import VentanasSecundarias.ConversionOctal;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuConversiones extends JFrame implements ActionListener{
    
    //Debe ser de tipo publica y entera para usar el dato sin restricciones
    //public int menuTable = MenuTablaVerdad.numeroTabla; //Llamo el módulo de la tabla verdad para recibir el valor que digite en ese módulo
    public static int bin, decim, octa, ca2; //Al ser static, no cambia su valor en este código
    public static String hexa, numCondicion;
    JPanel contenedorMenuConversiones;
    JLabel jltitulo, jlsistemanum, jldigitenum;
    JTextField jtsistemnum, jtdigitenum;
    JMenuBar mb;
    JMenu menuAcercaDe;
    JMenuItem miElCreador;
    JComboBox jcomboOpcion;
    JButton jbsigmenu, jbregresar;

    public MenuConversiones(){
        
        //Creamos el JFrame que es la ventana
        this.setSize(510,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Sistemas Númericos | Conversiones");
        
        Color miColor = new Color(1, 89, 101);
        
        // Creamos el contenedores para implementar los Label, Botones, etc...
        contenedorMenuConversiones = new JPanel();
        contenedorMenuConversiones.setBounds(0,0,510,430);
        contenedorMenuConversiones.setBackground(miColor);
        contenedorMenuConversiones.setLayout(null);
        contenedorMenuConversiones.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        this.add(contenedorMenuConversiones);
        
        //JLabel
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
        
        jltitulo = new JLabel("Menú de Conversiones");
        jltitulo.setBounds(80,35,330,25);
        jltitulo.setForeground(new Color(255,255,255));
        jltitulo.setFont(new Font("Arial",Font.BOLD,18));
        jltitulo.setHorizontalAlignment(JLabel.CENTER);
        jltitulo.setVerticalAlignment(JLabel.CENTER);
        contenedorMenuConversiones.add(jltitulo);
        
        jlsistemanum = new JLabel("Seleccione sistema númerico: ");
        jlsistemanum.setBounds(60,80,240,25);
        jlsistemanum.setFont(new Font("Arial",Font.BOLD,16));
        jlsistemanum.setForeground(new Color(255,255,255));
        contenedorMenuConversiones.add(jlsistemanum);
        
        //JComboBox
        jcomboOpcion = new JComboBox();
        jcomboOpcion.setBounds(140,120,220,25);
        jcomboOpcion.setBackground(new java.awt.Color(224,224,224));
        jcomboOpcion.setFont(new java.awt.Font("Andale Mono",1,14));
        jcomboOpcion.setForeground(miColor);
        contenedorMenuConversiones.add(jcomboOpcion);
        jcomboOpcion.addItem("");
        jcomboOpcion.addItem("Binario");
        jcomboOpcion.addItem("Decimal");
        jcomboOpcion.addItem("Hexadecimal");
        jcomboOpcion.addItem("Octal");
        jcomboOpcion.addItem("Complemento a2");
        
        //JLabel
        jlsistemanum = new JLabel("Ingrese valor númerico: ");
        jlsistemanum.setBounds(60,170,190,25);
        jlsistemanum.setFont(new Font("Arial",Font.BOLD,16));
        jlsistemanum.setForeground(new Color(255,255,255));
        contenedorMenuConversiones.add(jlsistemanum);
        
        //JTextField
        jtsistemnum = new JTextField();
        jtsistemnum.setBounds(250,170,130,25);
        contenedorMenuConversiones.add(jtsistemnum);
        
        //JButton
        jbsigmenu = new JButton("Aceptar");
        jbsigmenu.setBounds(165,220,120,35);
        jbsigmenu.addActionListener(this);
        jbsigmenu.setFont(new Font("Arial",Font.BOLD,17));
        jbsigmenu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contenedorMenuConversiones.add(jbsigmenu);
        
        //Boton para regresar
        jbregresar = new JButton("Regresar");
        jbregresar.setBounds(370, 280, 100, 35);
        jbregresar.setFont(new Font("Arial",Font.BOLD,17));
        jbregresar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jbregresar.addActionListener(this);
        contenedorMenuConversiones.add(jbregresar);

    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object fuente = ae.getSource();
        
        //Inicializamos las variables, para que no guarden los datos para todo el funcionamiento del algoritmo
        //Permitiendo que el usuario digite nuevos números cuando quiera
        bin = 0;
        decim = 0;
        octa = 0;
        ca2 = 0;
        hexa = "";
        
        //Cuando se oprima el boton de aceptar, hará toda esta funcionalidad
        if(fuente == jbsigmenu){
            String valorSistemaNum = jtsistemnum.getText(); //Recibe el valor que digite el usuario en el JTextField
            String opcionSistema = jcomboOpcion.getSelectedItem().toString(); //Guarda el sistema númerico que eliga de la lista
            if(valorSistemaNum.equals("") || opcionSistema.equals("")){
                JOptionPane.showMessageDialog(null,"No has ingresado un valor en los campos","ADVERTENCIA",2);
            }else{
                //numCondicion = String.valueOf(menuTable);
                //System.out.println(numCondicion);
                /*System.out.println(menuTable);
                if( valorSistemaNum.length() < 0){
                    JOptionPane.showMessageDialog(null,"La razones pueden ser las siguientes: \n* Superaste el límite de los digitos de tu tabla de verdad\n* No has ingresado un límite de digitos en tu tabla","ADVERTENCIA",2);
                }else{*/
                if(opcionSistema.equals("Binario")){
                    bin = Integer.parseInt(valorSistemaNum); 
                    if(!validarBinario(bin)){ //Entra a la función de validar y sigue todo el proceso
                        JOptionPane.showMessageDialog(null,"Número no valido","ADVERTENCIA",2);
                    }else{
                        ConversionBin Cbin = new ConversionBin();
                        Cbin.setVisible(true); //Muestra la ventana de conversión de binario
                        this.setVisible(false); //Oculta la ventana actual
                    }
                }
                if(opcionSistema.equals("Decimal")){
                    decim = Integer.parseInt(valorSistemaNum); //Convierte el dato de tipo String a Entero 
                    if(!validarDecimal(decim)){ //Entra a la función de validar el decimal
                        JOptionPane.showMessageDialog(null,"Número no valido","ADVERTENCIA",2);
                        return;
                    }else{
                        ConversionDecimal Cdec = new ConversionDecimal();
                        Cdec.setVisible(true); //Muestra la ventana de conversión de decimal
                        this.setVisible(false); //Oculta la ventana actual
                    }
                }
                if(opcionSistema.equals("Hexadecimal")){
                    hexa = valorSistemaNum; //Hexadecimal no es necesario convertirlo a entero
                    if(!validarHexadecimal(hexa)){
                        JOptionPane.showMessageDialog(null,"Número no valido y debe ser en mayúscula","ADVERTENCIA",2);
                        return;
                    }else{
                        ConversionHexa Chex = new ConversionHexa();
                        Chex.setVisible(true);
                        this.setVisible(false);
                    }
                }
                if(opcionSistema.equals("Octal")){
                    octa = Integer.parseInt(valorSistemaNum); 
                    if (!validarOctal(octa)) {
                        JOptionPane.showMessageDialog(null,"Número no valido","ADVERTENCIA",2);
                        return;
                    }else{
                        ConversionOctal Coctal = new ConversionOctal();
                        Coctal.setVisible(true);
                        this.setVisible(false);
                    }
                }
                if(opcionSistema.equals("Complemento a2")){
                    ca2 = Integer.parseInt(valorSistemaNum); 
                    if(!validarcomplementoa2(ca2)){
                        JOptionPane.showMessageDialog(null,"Número no valido","ADVERTENCIA",2);
                    }else{
                        JOptionPane.showMessageDialog(null, "Este apartado sigue en construcción...", "MENSAJE", 1);
                        //System.out.println("True "+ca2);
                    }
                }
            }
        }
        if(fuente == miElCreador){
            JOptionPane.showMessageDialog(null,"Desarrollado por Diego Méndez | Oscar Castillo | Dany Ruiz | Tatiana Castellanos\n"+
                                       "Todos los derechos reservados ©");
        }
        if(fuente == jbregresar){
            MenuPrincipal menPrincipal = new MenuPrincipal();
            menPrincipal.setVisible(true);
            this.setVisible(false);
        }
        
    }
    
    public static boolean validarBinario(int bin) {
        String binarioComoCadena = String.valueOf(bin);
        for(int i = 0; i < binarioComoCadena.length();i++){
            char caracter = binarioComoCadena.charAt(i);
            if(caracter != '0' && caracter != '1'){
                return false;
            }   
        }
        return true;
    }
    public static boolean validarDecimal(int decim) {
        return true;
    }
    public static boolean validarHexadecimal(String hexa) {
        String caracteresHexadecimal = "0123456789ABCDEF";
        for(int i = 0;i < hexa.length(); i++){
            char caracter = hexa.charAt(i);
            if(caracteresHexadecimal.indexOf(caracter) == -1){
                return false;
            }
        }
        return true;  
    }
     public static boolean validarOctal(int octa) {
        String octalComoCadena = String.valueOf(octa);
        String caracteresOctales = "01234567";
        for (int i = 0; i < octalComoCadena.length(); i++) {
            char caracter = octalComoCadena.charAt(i);
            if (caracteresOctales.indexOf(caracter) == -1) {
                return false;
            }
        }
        return true;
    }
    public static boolean validarcomplementoa2(int ca2) {
        String binarioComoCadena = String.valueOf(ca2);
        for(int i = 0; i < binarioComoCadena.length();i++){
            char caracter = binarioComoCadena.charAt(i);
            if(caracter != '0' && caracter != '1'){
                return false;
            }   
        }
        return true;
    }
    public String sincero(int resultado){
        String retorno = "";
        retorno = Double.toString(resultado);
        
        if(resultado%1 == 0){ // Es para saber si residuo es == 0, para poder eliminar el .0 de un entero
            retorno = retorno.substring(0, retorno.length()-2);
        }
        return retorno;
    }
}
