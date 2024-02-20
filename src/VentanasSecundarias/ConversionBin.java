package VentanasSecundarias;

import VentanasPrincipales.MenuConversiones;
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

public class ConversionBin extends JFrame implements ActionListener{
    
    private int binario = MenuConversiones.bin;
    private int decimal = MenuConversiones.decim;
    private String hexadecimal = MenuConversiones.hexa;
    JPanel contenedorMBin;
    JTextField jfnumBin, jtfsalida;
    JLabel jltituloBin;
    JComboBox jcomboConverBin;
    JButton jbconverbin, jbregresar;
    
    public ConversionBin(){
       
        //Creamos el JFrame que es la ventana
        this.setSize(510,375);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Conversiones Sistema BIN");
        
        Color FondoVentana = new Color(203,203,203);
        Color miColor = new Color(1, 89, 101);
        
        // Creamos el JPanel
        contenedorMBin = new JPanel();
        contenedorMBin.setBounds(0,0,510,430);
        contenedorMBin.setBackground(miColor);
        contenedorMBin.setLayout(null);
        contenedorMBin.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        this.add(contenedorMBin);
        
        //JTextField
        jfnumBin = new JTextField("Binario actual: "+binario);
        jfnumBin.setBounds(145,75,200,25);
        jfnumBin.setForeground(new Color(0,0,0));
        jfnumBin.setFont(new Font("Arial",Font.BOLD,16));
        jfnumBin.setEditable(false);
        jfnumBin.setHorizontalAlignment(JTextField.CENTER);
        contenedorMBin.add(jfnumBin);
        
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
        contenedorMBin.add(jtfsalida);
        
        //JLabel
        jltituloBin = new JLabel("Conversiones Binario");
        jltituloBin.setBounds(80,35,330,25);
        jltituloBin.setForeground(new Color(255,255,255));
        jltituloBin.setFont(new Font("Arial",Font.BOLD,18));
        jltituloBin.setHorizontalAlignment(JLabel.CENTER);
        jltituloBin.setVerticalAlignment(JLabel.CENTER);
        contenedorMBin.add(jltituloBin);
        
        //JButton
        jbconverbin = new JButton("Convertir");
        jbconverbin.setBounds(20,265,85,25);
        jbconverbin.addActionListener(this);
        jbconverbin.setFont(new Font("Arial",Font.BOLD,13));
        jbconverbin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contenedorMBin.add(jbconverbin);
        
        jbregresar = new JButton("Regresar");
        jbregresar.setBounds(390,265,85,25);
        jbregresar.addActionListener(this);
        jbregresar.setFont(new Font("Arial",Font.BOLD,13));
        jbregresar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contenedorMBin.add(jbregresar);
        
        //JComboBox
        jcomboConverBin = new JComboBox();
        jcomboConverBin.setBounds(135,125,220,25);
        jcomboConverBin.setBackground(new java.awt.Color(224,224,224));
        jcomboConverBin.setFont(new java.awt.Font("Andale Mono",1,14));
        jcomboConverBin.setForeground(miColor);
        contenedorMBin.add(jcomboConverBin);
        jcomboConverBin.addItem("");
        jcomboConverBin.addItem("Binario a Decimal");
        jcomboConverBin.addItem("Binario a Hexadecimal");
        jcomboConverBin.addItem("Binario a Octal");
        jcomboConverBin.addItem("Binario a Complemento A2");
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        Object fuente = ae.getSource();
        
        String itemSeleccionado = (String)jcomboConverBin.getSelectedItem();
        String datoactual = jtfsalida.getText();
        
        if(fuente == jbconverbin){
            if(itemSeleccionado.equals("")){
                JOptionPane.showMessageDialog(null,"Ningúna opción elegida!","ADVERTENCIA",2);
            }else{
                if(itemSeleccionado.equals("Binario a Decimal")){
                    decimal = binarioADecimal(binario);
                    String binar = String.valueOf(decimal);
                    jtfsalida.setText(binar);
                }
                if(itemSeleccionado.equals("Binario a Hexadecimal")){
                    decimal = binarioADecimal(binario);
                    String hexadec = decimalAHexadecimal(decimal);
                    jtfsalida.setText(hexadec);
                }
                if(itemSeleccionado.equals("Binario a Octal")){
                    decimal = binarioADecimal(binario);
                    String octalResultante = decimalAOctal(decimal);
                    jtfsalida.setText(octalResultante);
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
    public static int binarioADecimal(int binario){ 
        int decimal = 0;
        int potencia = 0;
        while(true){
            if(binario == 0){
                break;
            }else{
                int temp = binario % 10;
                decimal += temp * Math.pow(2,potencia);
                binario = binario / 10;
                potencia++;
            }
        }
        return decimal;
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
    public static int decimalAComplemento(int complemento){
        int res;
        while((complemento%=10)!=1){
        complemento/=10;
        }
        res=~(complemento%=10);
        return res;
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
