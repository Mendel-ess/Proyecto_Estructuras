package gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
public class VentanaPlanificador extends JFrame {

	private JPanel panel;
	Scanner ent = null;
	JButton closeS;
	JFileChooser fileChooser = new JFileChooser();

	public VentanaPlanificador() {
		setType(Type.UTILITY);
		setTitle("PLANIFICADOR");
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 521);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		
		JButton aggArchivo = new JButton("Agregar Archivo");
		aggArchivo.setBounds(5, 5, 800, 25);
		aggArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser();
			}
		});
		panel.setLayout(null);
		aggArchivo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(aggArchivo);
		
		closeS = new JButton("Cerrar Sesion");
		closeS.setBounds(5, 446, 800, 25);
		closeS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(closeS == e.getSource()) {
					setVisible(false);
				}
			}
		});
		closeS.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(closeS);
		
		JButton save = new JButton("Guardar Archivo");
		save.setBounds(5, 405, 800, 25);
		save.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(save);
		
		JButton añaEvento = new JButton("A\u00F1adir Evento");
		añaEvento.setBounds(5, 146, 131, 154);
		añaEvento.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(añaEvento);
		
		JButton eleEvento = new JButton("Eliminar Evento");
		eleEvento.setBounds(666, 146, 139, 154);
		eleEvento.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(eleEvento);
	}
	
	public void chooser() {
		fileChooser.showOpenDialog(fileChooser);
		
		 try {
	            String ruta = fileChooser.getSelectedFile().getAbsolutePath();                                        
	            File f = new File(ruta);
	            ent = new Scanner(f);
	            while (ent.hasNext()) {
	                System.out.println(ent.nextLine());
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println(e.getMessage());
	        } catch (NullPointerException e) {
	            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún fichero","WARNING MESSAGE", JOptionPane.WARNING_MESSAGE);
	        	
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        } finally {
	            if (ent != null) {
	                ent.close();
	            }
	        }
	    }
}
