package VentanasSecundarias;

import VentanasPrincipales.MenuTablaVerdad;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class TablasVerdadDibujo extends JFrame implements ActionListener{
    
    public int numTable = MenuTablaVerdad.numeroTabla;
    public String tablas[];
    public Object tablaSeis[][];
    JPanel contenedorDrawTable;
    JScrollPane scrollPane;
    JButton jbregresar;
    JMenuBar mb;
    JLabel jltitulo;
    JMenu menuAcercaDe;
    JMenuItem miElCreador;
    JTable tabla1, tabla2, tabla3, tabla4, tabla5, tabla6;
    DefaultTableModel tableModel;
    DefaultTableCellRenderer alinearTable;
    
    public TablasVerdadDibujo(){
        
        //Creamos el JFrame de la ventana
        this.setSize(700, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Ver tablas de verdad");
        
        Color miColor = new Color(1, 89, 101);
        
        //Creamos el JPanel para colocar todo accesorio a la interfaz
        contenedorDrawTable = new JPanel();
        contenedorDrawTable.setBounds(0,0,700,1000);
        contenedorDrawTable.setBackground(miColor);
        contenedorDrawTable.setLayout(null);
        contenedorDrawTable.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        this.add(contenedorDrawTable);
        
        //Creamos el título según la tabla
        jltitulo = new JLabel("Tabla de Verdad "+numTable);
        jltitulo.setBounds(240,15,190,35);
        jltitulo.setForeground(new Color(255,255,255));
        jltitulo.setFont(new Font("Arial",Font.BOLD,20));
        jltitulo.setHorizontalAlignment(JLabel.CENTER);
        jltitulo.setVerticalAlignment(JLabel.CENTER);
        contenedorDrawTable.add(jltitulo);
        
        //Creamos el botón de regresar
        jbregresar = new JButton("Regresar");
        jbregresar.setFont(new Font("Arial", Font.BOLD, 18));
        jbregresar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jbregresar.addActionListener(this);
        contenedorDrawTable.add(jbregresar);
        
        String[] columnaUno = {"A"};
        Object[][] tablaUno = {
            {"0"},
            {"1"}};
        
        String[] columnaDos = {"A", "B"};
        Object[][] tablaDos = {
            {"0", "0"},
            {"0", "1"},
            {"1", "0"},
            {"1", "1"}};
        
        String[] columnaTres = {"A", "B", "C"};
        Object[][] tablaTres = {
            {"0", "0", "0"},
            {"0", "0", "1"},
            {"0", "1", "0"},
            {"0", "1", "1"},
            {"1", "0", "0"},
            {"1", "0", "1"},
            {"1", "1", "0"},
            {"1", "1", "1"}};
        
        String[] columnaCuatro = {"A", "B", "C", "D"};
        Object[][] tablaCuatro = {
            {"0", "0", "0", "0"},
            {"0", "0", "0", "1"},
            {"0", "0", "1", "0"},
            {"0", "0", "1", "1"},
            {"0", "1", "0", "0"},
            {"0", "1", "0", "1"},
            {"0", "1", "1", "0"},
            {"0", "1", "1", "1"},
            {"1", "0", "0", "0"},
            {"1", "0", "0", "1"},
            {"1", "0", "1", "0"},
            {"1", "0", "1", "1"},
            {"1", "1", "0", "0"},
            {"1", "1", "0", "1"},
            {"1", "1", "1", "0"},
            {"1", "1", "1", "1"}};
        
        String[] columnaCinco = {"A", "B", "C", "D", "E"};
        Object[][] tablaCinco = {
            {"0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "1"},
            {"0", "0", "0", "1", "0"},
            {"0", "0", "0", "1", "1"},
            {"0", "0", "1", "0", "0"},
            {"0", "0", "1", "0", "1"},
            {"0", "0", "1", "1", "0"},
            {"0", "0", "1", "1", "1"},
            {"0", "1", "0", "0", "0"},
            {"0", "1", "0", "0", "1"},
            {"0", "1", "0", "1", "0"},
            {"0", "1", "0", "1", "1"},
            {"0", "1", "1", "0", "0"},
            {"0", "1", "1", "0", "1"},
            {"0", "1", "1", "1", "0"},
            {"0", "1", "1", "1", "1"},
            {"1", "0", "0", "0", "0"},
            {"1", "0", "0", "0", "1"},
            {"1", "0", "0", "1", "0"},
            {"1", "0", "0", "1", "1"},
            {"1", "0", "1", "0", "0"},
            {"1", "0", "1", "0", "1"},
            {"1", "0", "1", "1", "0"},
            {"1", "0", "1", "1", "1"},
            {"1", "1", "0", "0", "0"},
            {"1", "1", "0", "0", "1"},
            {"1", "1", "0", "1", "0"},
            {"1", "1", "0", "1", "1"},
            {"1", "1", "1", "0", "0"},
            {"1", "1", "1", "0", "1"},
            {"1", "1", "1", "1", "0"},
            {"1", "1", "1", "1", "1"}};
        
        String[] columnaSeis = {"A", "B", "C", "D", "E", "F"};
        Object[][] tablaSeis = {
            {"0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "1"},
            {"0", "0", "0", "0", "1", "0"},
            {"0", "0", "0", "0", "1", "1"},
            {"0", "0", "0", "1", "0", "0"},
            {"0", "0", "0", "1", "0", "1"},
            {"0", "0", "0", "1", "1", "0"},
            {"0", "0", "0", "1", "1", "1"},
            {"0", "0", "1", "0", "0", "0"},
            {"0", "0", "1", "0", "0", "1"},
            {"0", "0", "1", "0", "1", "0"},
            {"0", "0", "1", "0", "1", "1"},
            {"0", "0", "1", "1", "0", "0"},
            {"0", "0", "1", "1", "0", "1"},
            {"0", "0", "1", "1", "1", "0"},
            {"0", "0", "1", "1", "1", "1"},
            {"0", "1", "0", "0", "0", "0"},
            {"0", "1", "0", "0", "0", "1"},
            {"0", "1", "0", "0", "1", "0"},
            {"0", "1", "0", "0", "1", "1"},
            {"0", "1", "0", "1", "0", "0"},
            {"0", "1", "0", "1", "0", "1"},
            {"0", "1", "0", "1", "1", "0"},
            {"0", "1", "0", "1", "1", "1"},
            {"0", "1", "1", "0", "0", "0"},
            {"0", "1", "1", "0", "0", "1"},
            {"0", "1", "1", "0", "1", "0"},
            {"0", "1", "1", "0", "1", "1"},
            {"0", "1", "1", "1", "0", "0"},
            {"0", "1", "1", "1", "0", "1"},
            {"0", "1", "1", "1", "1", "0"},
            {"0", "1", "1", "1", "1", "1"},
            {"1", "0", "0", "0", "0", "0"},
            {"1", "0", "0", "0", "0", "1"},
            {"1", "0", "0", "0", "1", "0"},
            {"1", "0", "0", "0", "1", "1"},
            {"1", "0", "0", "1", "0", "0"},
            {"1", "0", "0", "1", "0", "1"},
            {"1", "0", "0", "1", "1", "0"},
            {"1", "0", "0", "1", "1", "1"},
            {"1", "0", "1", "0", "0", "0"},
            {"1", "0", "1", "0", "0", "1"},
            {"1", "0", "1", "0", "1", "0"},
            {"1", "0", "1", "0", "1", "1"},
            {"1", "0", "1", "1", "0", "0"},
            {"1", "0", "1", "1", "0", "1"},
            {"1", "0", "1", "1", "1", "0"},
            {"1", "0", "1", "1", "1", "1"},
            {"1", "1", "0", "0", "0", "0"},
            {"1", "1", "0", "0", "0", "1"},
            {"1", "1", "0", "0", "1", "0"},
            {"1", "1", "0", "0", "1", "1"},
            {"1", "1", "0", "1", "0", "0"},
            {"1", "1", "0", "1", "0", "1"},
            {"1", "1", "0", "1", "1", "0"},
            {"1", "1", "0", "1", "1", "1"},
            {"1", "1", "1", "0", "0", "0"},
            {"1", "1", "1", "0", "0", "1"},
            {"1", "1", "1", "0", "1", "0"},
            {"1", "1", "1", "0", "1", "1"},
            {"1", "1", "1", "1", "0", "0"},
            {"1", "1", "1", "1", "0", "1"},
            {"1", "1", "1", "1", "1", "0"},
            {"1", "1", "1", "1", "1", "1"}};
        
        if (numTable == 1){
            this.setSize(680, 280);
            contenedorDrawTable.setBounds(0,0,680,280);
            jbregresar.setBounds(270, 170, 160, 25);
            //Creamos la tabla de verdad 1
            tableModel = new DefaultTableModel(tablaUno, columnaUno);
            tableModel.addRow(tablas);
            tabla1 = new JTable(tableModel);
            tabla1.setBounds(230, 80, 230, 75);
            //Creamos el scrollPane
            scrollPane = new JScrollPane(tabla1);
            scrollPane.setBounds(230, 80, 230, 75);
            contenedorDrawTable.add(scrollPane);
            //Alinear la información dentro de las celdas
            alinearTable = new DefaultTableCellRenderer();
            alinearTable.setHorizontalAlignment(SwingConstants.CENTER);
            tabla1.getColumnModel().getColumn(0).setCellRenderer(alinearTable);
        }
        if (numTable == 2){
            this.setSize(680, 350);
            contenedorDrawTable.setBounds(0,0,680,350);
            jbregresar.setBounds(270, 260, 160, 25);
            //Creamos la tabla de verdad 2
            tableModel = new DefaultTableModel(tablaDos, columnaDos);
            tableModel.addRow(tablas);
            tabla2 = new JTable(tableModel);
            tabla2.setBounds(230, 80, 230, 110);
            //Creamos el scrollPane
            scrollPane = new JScrollPane(tabla2);
            scrollPane.setBounds(230, 80, 230,110);
            contenedorDrawTable.add(scrollPane);
            //Alinear datos al centro
            alinearTable = new DefaultTableCellRenderer();
            alinearTable.setHorizontalAlignment(SwingConstants.CENTER);
            tabla2.getColumnModel().getColumn(0).setCellRenderer(alinearTable);
            tabla2.getColumnModel().getColumn(1).setCellRenderer(alinearTable);
        }
        if (numTable == 3){
            this.setSize(690, 400);
            contenedorDrawTable.setBounds(0,0,690,400);
            jbregresar.setBounds(250, 260, 185, 25);
            //Creamos la tabla de verdad 3
            tableModel = new DefaultTableModel(tablaTres, columnaTres);
            tableModel.addRow(tablas);
            tabla3 = new JTable(tableModel);
            tabla3.setBounds(40, 60, 600, 168);
            //Creamos el scrollPane
            scrollPane = new JScrollPane(tabla3);
            scrollPane.setBounds(40, 60, 600, 168);
            contenedorDrawTable.add(scrollPane);
            //Alinear datos al centro
            alinearTable = new DefaultTableCellRenderer();
            alinearTable.setHorizontalAlignment(SwingConstants.CENTER);
            tabla3.getColumnModel().getColumn(0).setCellRenderer(alinearTable);
            tabla3.getColumnModel().getColumn(1).setCellRenderer(alinearTable);
            tabla3.getColumnModel().getColumn(2).setCellRenderer(alinearTable);
        }
        if (numTable == 4){
            this.setSize(690, 500);
            contenedorDrawTable.setBounds(0,0,690,500);
            jbregresar.setBounds(250, 400, 185, 25);
            //Creamos la tabla de verdad 4
            tableModel = new DefaultTableModel(tablaCuatro, columnaCuatro);
            tableModel.addRow(tablas);
            tabla4 = new JTable(tableModel);
            tabla4.setBounds(40, 60, 600, 298);
            //Creamos el scrollPane
            scrollPane = new JScrollPane(tabla4);
            scrollPane.setBounds(40, 60, 600, 298);
            contenedorDrawTable.add(scrollPane);
            //Alinear contenido de las columnas
            alinearTable = new DefaultTableCellRenderer();
            alinearTable.setHorizontalAlignment(SwingConstants.CENTER);
            tabla4.getColumnModel().getColumn(0).setCellRenderer(alinearTable);
            tabla4.getColumnModel().getColumn(1).setCellRenderer(alinearTable);
            tabla4.getColumnModel().getColumn(2).setCellRenderer(alinearTable);
            tabla4.getColumnModel().getColumn(3).setCellRenderer(alinearTable);
        }
        if (numTable == 5){
            this.setSize(690, 760);
            contenedorDrawTable.setBounds(0,0,690,760);
            jbregresar.setBounds(250, 650, 185, 25);
            //Creamos la tabla de verdad 6
            tableModel = new DefaultTableModel(tablaCinco, columnaCinco);
            tableModel.addRow(tablas);
            tabla5 = new JTable(tableModel);
            tabla5.setBounds(40, 60, 600, 552);
            //Creamos el scrollPane
            scrollPane = new JScrollPane(tabla5);
            scrollPane.setBounds(40, 60, 600, 552);
            contenedorDrawTable.add(scrollPane);
            alinearTable = new DefaultTableCellRenderer();
            alinearTable.setHorizontalAlignment(SwingConstants.CENTER);
            tabla5.getColumnModel().getColumn(0).setCellRenderer(alinearTable);
            tabla5.getColumnModel().getColumn(1).setCellRenderer(alinearTable);
            tabla5.getColumnModel().getColumn(2).setCellRenderer(alinearTable);
            tabla5.getColumnModel().getColumn(3).setCellRenderer(alinearTable);
            tabla5.getColumnModel().getColumn(4).setCellRenderer(alinearTable);
        }
        if (numTable == 6){
            jbregresar.setBounds(250, 890, 185, 25);
            //Creamos la tabla de verdad 6
            tableModel = new DefaultTableModel(tablaSeis, columnaSeis);
            tableModel.addRow(tablas);
            tabla6 = new JTable(tableModel);
            tabla6.setBounds(40, 60, 600, 800);
            //Creamos el scrollPane
            scrollPane = new JScrollPane(tabla6);
            scrollPane.setBounds(40, 60, 600, 800);
            contenedorDrawTable.add(scrollPane);
            //Alinear contenido de las columnas
            alinearTable = new DefaultTableCellRenderer();
            alinearTable.setHorizontalAlignment(SwingConstants.CENTER);
            tabla6.getColumnModel().getColumn(0).setCellRenderer(alinearTable);
            tabla6.getColumnModel().getColumn(1).setCellRenderer(alinearTable);
            tabla6.getColumnModel().getColumn(2).setCellRenderer(alinearTable);
            tabla6.getColumnModel().getColumn(3).setCellRenderer(alinearTable);
            tabla6.getColumnModel().getColumn(4).setCellRenderer(alinearTable);
            tabla6.getColumnModel().getColumn(5).setCellRenderer(alinearTable);
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        Object fuente = ae.getSource();

        if (fuente == jbregresar){
            MenuTablaVerdad menuTablaV = new MenuTablaVerdad();
            menuTablaV.setVisible(true);
            this.setVisible(false);
        }
    }
}
