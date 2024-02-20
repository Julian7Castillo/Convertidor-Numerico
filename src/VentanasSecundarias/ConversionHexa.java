package VentanasSecundarias;

import VentanasPrincipales.MenuConversiones;
import static VentanasSecundarias.ConversionBin.binarioADecimal;
import static VentanasSecundarias.ConversionBin.decimalAHexadecimal;
import static VentanasSecundarias.ConversionBin.decimalAOctal;
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
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ConversionHexa extends JFrame implements ActionListener {
    
    private int binario = MenuConversiones.bin;
    private int decimal = MenuConversiones.decim;
    private String hexadecimal = MenuConversiones.hexa;
    JPanel contenedorMHex;
    JTextField jfnumHex, jtfsalida;
    JLabel jltituloHex;
    JComboBox jcomboConverHex;
    JButton jbconverHex, jbregresar;
    
    public ConversionHexa(){
     
        //Creamos el JFrame que es la ventana
        this.setSize(510,375);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Conversiones Sistema HEXADECIMAL");
        
        Color FondoVentana = new Color(203,203,203);
        Color miColor = new Color(1, 89, 101);
        
        // Creamos el JPanel
        contenedorMHex = new JPanel();
        contenedorMHex.setBounds(0,0,510,430);
        contenedorMHex.setBackground(miColor);
        contenedorMHex.setLayout(null);
        contenedorMHex.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        this.add(contenedorMHex);
        
        //JTextField
        jfnumHex = new JTextField("Hexadecimal actual: "+hexadecimal);
        jfnumHex.setBounds(145,75,200,25);
        jfnumHex.setForeground(new Color(0,0,0));
        jfnumHex.setFont(new Font("Arial",Font.BOLD,16));
        jfnumHex.setEditable(false);
        jfnumHex.setHorizontalAlignment(JTextField.CENTER);
        contenedorMHex.add(jfnumHex);
        
        jtfsalida = new JTextField("");
        jtfsalida.setBounds(130,265,250,25);
        jtfsalida.setHorizontalAlignment(JTextField.CENTER);
        jtfsalida.setFont(new Font("Arial",Font.BOLD,24)); // Cambiar estilo, fuente y tamaño de la letra)
        jtfsalida.setForeground(Color.BLACK); // Color de la fuente
        jtfsalida.setBackground(FondoVentana); // Definir color del fondo del JLabel de Salida
        jtfsalida.setOpaque(true); // Crear el opaque del color del JLabel
        jtfsalida.setHorizontalAlignment(JTextField.RIGHT);
        jtfsalida.setEditable(false); // Para que no sea editable el TextField
        jtfsalida.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Crear borde
        contenedorMHex.add(jtfsalida);
        
        //JLabel
        jltituloHex = new JLabel("Conversiones Hexadecimal");
        jltituloHex.setBounds(80,35,330,25);
        jltituloHex.setForeground(new Color(255,255,255));
        jltituloHex.setFont(new Font("Arial",Font.BOLD,18));
        jltituloHex.setHorizontalAlignment(JLabel.CENTER);
        jltituloHex.setVerticalAlignment(JLabel.CENTER);
        contenedorMHex.add(jltituloHex);
        
        //JButton
        jbconverHex = new JButton("Convertir");
        jbconverHex.setBounds(20,265,85,25);
        jbconverHex.addActionListener(this);
        jbconverHex.setFont(new Font("Arial",Font.BOLD,13));
        jbconverHex.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contenedorMHex.add(jbconverHex);
        
        jbregresar = new JButton("Regresar");
        jbregresar.setBounds(390,265,85,25);
        jbregresar.addActionListener(this);
        jbregresar.setFont(new Font("Arial",Font.BOLD,13));
        jbregresar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contenedorMHex.add(jbregresar);
        
        //JComboBox
        jcomboConverHex = new JComboBox();
        jcomboConverHex.setBounds(135,125,220,25);
        jcomboConverHex.setBackground(new java.awt.Color(224,224,224));
        jcomboConverHex.setFont(new java.awt.Font("Andale Mono",1,14));
        jcomboConverHex.setForeground(miColor);
        contenedorMHex.add(jcomboConverHex);
        jcomboConverHex.addItem("");
        jcomboConverHex.addItem("Hexadecimal a Binario");
        jcomboConverHex.addItem("Hexadecimal a Decimal");
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        Object fuente = ae.getSource();
        
        String itemSeleccionado = (String)jcomboConverHex.getSelectedItem();
        //String datoactual = jtfsalida.getText();
        
        if(fuente == jbconverHex){
            if(itemSeleccionado.equals("")){
                JOptionPane.showMessageDialog(null,"Ningúna opción elegida!","ADVERTENCIA",2);
            }else{
                if(itemSeleccionado.equals("Hexadecimal a Binario")){
                    int decimalResultante = hexadecimalADecimal(hexadecimal);
                    decimal = decimalResultante;
                    String binarioResultante = decimalABinario(decimal);
                    //String binarioResultante = String.valueOf(binarioResultante);
                    jtfsalida.setText(binarioResultante);
                }
                if(itemSeleccionado.equals("Hexadecimal a Decimal")){
                    int decimalResultante = hexadecimalADecimal(hexadecimal);
                    String decimalResult = String.valueOf(decimalResultante);
                    jtfsalida.setText(decimalResult);
                }
            }
        }
        if(fuente == jbregresar){
            MenuConversiones MnConversiones = new MenuConversiones();
            MnConversiones.setVisible(true);
            this.setVisible(false);
        }
    }
    public static int hexadecimalADecimal(String hexadecimal){
        String caracteresHexadecimales = "0123456789ABCDEF";
        hexadecimal = hexadecimal.toUpperCase();
        int decimal = 0;
        for(int i = 0; i < hexadecimal.length();i++){
            char caracter = hexadecimal.charAt(i);
            int posicionCaracteres = caracteresHexadecimales.indexOf(caracter);
            decimal = 16 * decimal + posicionCaracteres;
        }
        return decimal;
    }
    public static String decimalABinario(int decimal) {
        String binario = "";
        while (decimal > 0) {
            binario = decimal % 2 + binario;
            decimal = decimal / 2;
        }
        return binario;
    }
}