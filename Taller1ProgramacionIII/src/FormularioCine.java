import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FormularioCine {
    private JPanel principal;
    private JComboBox cboPelicula;
    private JComboBox cboCantidad;
    
    private JButton cboComprar;
    //private JTextArea txtEntradas;
    private JButton btnPelicula1;
    private JButton btnPelicula2;
    private JLabel txtAutor;
    private JTextArea txtEntradas;
    private Cine sala1=new Cine ();

    private Cine sala2=new Cine ();

    public FormularioCine() {
        try {
        String a="",b="";
        do {
            b= JOptionPane.showInputDialog("Ingrese su número de cédula real");
            a = JOptionPane.showInputDialog("Ingrese su nombre real");
        }while(b.length()<10);
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Taller1ProgramacionIII.dat"));
            o.writeObject(a+b);
        }catch (Exception ex) {

        }
        cboComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cboPelicula.getSelectedItem().equals("XMEN")){
                    try{
                        sala1.encolar((String) cboPelicula.getSelectedItem(), Integer.parseInt((String) cboCantidad.getSelectedItem()));
                        JOptionPane.showMessageDialog(null, "Boletos disponibles para XMEM \t" + sala1.entradasDisponibles());
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
                else
                    try{
                        sala2.encolar((String) cboPelicula.getSelectedItem(), Integer.parseInt((String) cboCantidad.getSelectedItem()));
                        JOptionPane.showMessageDialog(null, "Boletos disponibles para MARIO \t" +
                                "" + sala2.entradasDisponibles());
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    txtEntradas.setText(sala2.listarPeliculas()+sala1.listarPeliculas());
                    limpiarCampos();
            }
        });
        btnPelicula1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    JOptionPane.showMessageDialog(null,"Entradas disponibles: "+sala1.entradasDisponibles());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }
        });
        btnPelicula2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    JOptionPane.showMessageDialog(null,"Entradas disponibles: "+sala2.entradasDisponibles());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }
    public void limpiarCampos(){
        cboPelicula.setSelectedItem("");
        cboCantidad.setSelectedItem("");

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormularioCine");
        frame.setContentPane(new FormularioCine().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
