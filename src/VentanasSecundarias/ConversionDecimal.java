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

public class ConversionDecimal extends JFrame implements ActionListener {
    
    private int binario = MenuConversiones.bin;
    private int decimal = MenuConversiones.decim;
    private String hexadecimal = MenuConversiones.hexa;
    JPanel contenedorMDec;
    JTextField jfnumDec, jtfsalida;
    JLabel jltituloDec;
    JComboBox jcomboConverDec;
    JButton jbconverDec, jbregresar;
    
    public ConversionDecimal(){
     
        //Creamos el JFrame que es la ventana
        this.setSize(510,375);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Conversiones Sistema DECIMAL");
        
        Color FondoVentana = new Color(203,203,203);
        Color miColor = new Color(1, 89, 101);
        
        // Creamos el JPanel
        contenedorMDec = new JPanel();
        contenedorMDec.setBounds(0,0,510,430);
        contenedorMDec.setBackground(miColor);
        contenedorMDec.setLayout(null);
        contenedorMDec.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        this.add(contenedorMDec);
        
        //JTextField
        jfnumDec = new JTextField("Decimal actual: "+decimal);
        jfnumDec.setBounds(145,75,200,25);
        jfnumDec.setForeground(new Color(0,0,0));
        jfnumDec.setFont(new Font("Arial",Font.BOLD,16));
        jfnumDec.setEditable(false);
        jfnumDec.setHorizontalAlignment(JTextField.CENTER);
        contenedorMDec.add(jfnumDec);
        
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
        contenedorMDec.add(jtfsalida);
        
        //JLabel
        jltituloDec = new JLabel("Conversiones Decimal");
        jltituloDec.setBounds(80,35,330,25);
        jltituloDec.setForeground(new Color(255,255,255));
        jltituloDec.setFont(new Font("Arial",Font.BOLD,18));
        jltituloDec.setHorizontalAlignment(JLabel.CENTER);
        jltituloDec.setVerticalAlignment(JLabel.CENTER);
        contenedorMDec.add(jltituloDec);
        
        //JButton
        jbconverDec = new JButton("Convertir");
        jbconverDec.setBounds(20,265,85,25);
        jbconverDec.addActionListener(this);
        jbconverDec.setFont(new Font("Arial",Font.BOLD,13));
        jbconverDec.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contenedorMDec.add(jbconverDec);
        
        jbregresar = new JButton("Regresar");
        jbregresar.setBounds(390,265,85,25);
        jbregresar.addActionListener(this);
        jbregresar.setFont(new Font("Arial",Font.BOLD,13));
        jbregresar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contenedorMDec.add(jbregresar);
        
        //JComboBox
        jcomboConverDec = new JComboBox();
        jcomboConverDec.setBounds(135,125,220,25);
        jcomboConverDec.setBackground(new java.awt.Color(224,224,224));
        jcomboConverDec.setFont(new java.awt.Font("Andale Mono",1,14));
        jcomboConverDec.setForeground(miColor);
        contenedorMDec.add(jcomboConverDec);
        jcomboConverDec.addItem("");
        jcomboConverDec.addItem("Decimal a Binario");
        jcomboConverDec.addItem("Decimal a Octal");
        jcomboConverDec.addItem("Decimal a Hexadecimal");
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        Object fuente = ae.getSource();
        
        String itemSeleccionado = (String)jcomboConverDec.getSelectedItem();
        String datoactual = jtfsalida.getText();
        
        if(fuente == jbconverDec){
            if(itemSeleccionado.equals("")){
                JOptionPane.showMessageDialog(null,"Ningúna opción elegida!","ADVERTENCIA",2);
            }else{
                if(itemSeleccionado.equals("Decimal a Binario")){
                    String binarioResultante = decimalABinario(decimal);
                    jtfsalida.setText(binarioResultante);
                }
                if(itemSeleccionado.equals("Decimal a Octal")){
                    String octalResultante = decimalAOctal(decimal);
                    jtfsalida.setText(octalResultante);
                }
                if(itemSeleccionado.equals("Decimal a Hexadecimal")){
                    String hexadec = decimalAHexadecimal(decimal);
                    jtfsalida.setText(hexadec);
                }
                if(itemSeleccionado.equals("Binario a Complemento A2")){
                    String temp = Integer.toString(binario);
                    int[] numeroBin = new int[temp.length()];
                    for(int i = 0; i < numeroBin.length;i++){
                        System.out.println(numeroBin[i]+" ");
                    }
                }
            }
        }
        if(fuente == jbregresar){
            MenuConversiones MnConversiones = new MenuConversiones();
            MnConversiones.setVisible(true);
            this.setVisible(false);
        }
    }
    public static String decimalABinario(int decimal){
        String binario = "";
        while(decimal > 0){
            binario = decimal % 2 + binario;
            decimal = decimal / 2;
        }
        return binario;
    }
    public static String decimalAOctal(int decimal){
        int residuo;
        String octal = "";
        char[] caracteresOctales = {'0','1','2','3','4','5','6','7'};
        while(decimal > 0){
            residuo = decimal % 8;
            char caracterOctal = caracteresOctales[residuo];
            octal = caracterOctal + octal;
            decimal = decimal / 8;
        }
        return octal;
    }
    public static String decimalAHexadecimal(int decimal){
        int residuo;
        String hexadecimal = "";
        char[] caracteresHexadecimales = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(decimal > 0){
            residuo = decimal % 16;
            char caracterHexadecimal = caracteresHexadecimales[residuo];
            hexadecimal = caracterHexadecimal + hexadecimal;
            decimal = decimal / 16;
        }
        return hexadecimal;
    }
}
