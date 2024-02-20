package VentanasSecundarias;

import VentanasPrincipales.MenuConversiones;
import static VentanasSecundarias.ConversionHexa.decimalABinario;
import static VentanasSecundarias.ConversionHexa.hexadecimalADecimal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConversionOctal extends JFrame implements ActionListener{
    
    private int binario = MenuConversiones.bin;
    private int decimal = MenuConversiones.decim;
    private String hexadecimal = MenuConversiones.hexa;
    private int octal = MenuConversiones.octa;
    JPanel contenedorMOcta;
    JTextField jfnumOcta, jtfsalida;
    JLabel jltituloOcta;
    JComboBox jcomboConverOcta;
    JButton jbconverOcta, jbregresar;
    
    public ConversionOctal(){
        
        //Creamos el JFrame que es la ventana
        this.setSize(510,375);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Conversiones Sistema OCTAL");
        
        Color FondoVentana = new Color(203,203,203);
        Color miColor = new Color(1, 89, 101);
        
        // Creamos el JPanel
        contenedorMOcta = new JPanel();
        contenedorMOcta.setBounds(0,0,510,430);
        contenedorMOcta.setBackground(miColor);
        contenedorMOcta.setLayout(null);
        contenedorMOcta.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        this.add(contenedorMOcta);
        
        //JTextField
        jfnumOcta = new JTextField("Octal actual: "+octal);
        jfnumOcta.setBounds(145,75,200,25);
        jfnumOcta.setForeground(new Color(0,0,0));
        jfnumOcta.setFont(new Font("Arial",Font.BOLD,16));
        jfnumOcta.setEditable(false);
        jfnumOcta.setHorizontalAlignment(JTextField.CENTER);
        contenedorMOcta.add(jfnumOcta);
        
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
        contenedorMOcta.add(jtfsalida);
        
        //JLabel
        jltituloOcta = new JLabel("Conversiones Octal");
        jltituloOcta.setBounds(80,35,330,25);
        jltituloOcta.setForeground(new Color(255,255,255));
        jltituloOcta.setFont(new Font("Arial",Font.BOLD,18));
        jltituloOcta.setHorizontalAlignment(JLabel.CENTER);
        jltituloOcta.setVerticalAlignment(JLabel.CENTER);
        contenedorMOcta.add(jltituloOcta);
        
        //JButton
        jbconverOcta = new JButton("Convertir");
        jbconverOcta.setBounds(20,265,85,25);
        jbconverOcta.addActionListener(this);
        jbconverOcta.setFont(new Font("Arial",Font.BOLD,13));
        jbconverOcta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contenedorMOcta.add(jbconverOcta);
        
        jbregresar = new JButton("Regresar");
        jbregresar.setBounds(390,265,85,25);
        jbregresar.addActionListener(this);
        jbregresar.setFont(new Font("Arial",Font.BOLD,13));
        jbregresar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contenedorMOcta.add(jbregresar);
        
        //JComboBox
        jcomboConverOcta = new JComboBox();
        jcomboConverOcta.setBounds(135,125,220,25);
        jcomboConverOcta.setBackground(new java.awt.Color(224,224,224));
        jcomboConverOcta.setFont(new java.awt.Font("Andale Mono",1,14));
        jcomboConverOcta.setForeground(miColor);
        contenedorMOcta.add(jcomboConverOcta);
        jcomboConverOcta.addItem("");
        jcomboConverOcta.addItem("Octal a Binario");
        jcomboConverOcta.addItem("Octal a Decimal");
        jcomboConverOcta.addItem("Octal a Hexadecimal");
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        Object fuente = ae.getSource();
        
        String itemSeleccionado = (String)jcomboConverOcta.getSelectedItem();
        //String datoactual = jtfsalida.getText();
        if(fuente == jbconverOcta){
            if(itemSeleccionado.equals("")){
                JOptionPane.showMessageDialog(null,"Ningúna opción elegida!","ADVERTENCIA",2);
            }else{
                if(itemSeleccionado.equals("Octal a Binario")){
                    decimal = octalADecimal(octal);
                    String binarioResultante = decimalABinario(decimal);
                    //String binarioResultante = String.valueOf(binarioResultante);
                    jtfsalida.setText(binarioResultante);
                }
                if(itemSeleccionado.equals("Octal a Decimal")){
                    decimal = octalADecimal(octal);
                    String decimalResult = String.valueOf(decimal);
                    jtfsalida.setText(decimalResult);
                }
                if(itemSeleccionado.equals("Octal a Hexadecimal")){
                    decimal = octalADecimal(octal);
                    String hexadecimalResultante = decimalAHexadecimal(decimal);
                    jtfsalida.setText(hexadecimalResultante);
                }
            }
        }
        if(fuente == jbregresar){
            MenuConversiones MnConversiones = new MenuConversiones();
            MnConversiones.setVisible(true);
            this.setVisible(false);
        }
    }
    public static int octalADecimal(int octal) {
        int decimal = 0;
        int potencia = 0;
        // Ciclo infinito que se rompe cuando octal es 0
        while (true) {
            if (octal == 0) {
                break;
            } else {
                int temp = octal % 10;
                decimal += temp * Math.pow(8, potencia);
                octal = octal / 10;
                potencia++;
            }
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
