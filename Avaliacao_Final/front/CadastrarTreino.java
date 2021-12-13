package front;

import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import back.Search;
import back.Golfinho;
import back.Training;

public class CadastrarTreino extends JFrame{
    public CadastrarTreino(){
        JLabel title = new JLabel(" == Cadastrar Treinamneto! == ", JLabel.CENTER);
        JLabel selectId = new JLabel("Informe o Id do golfinho: ", JLabel.CENTER);
        JTextField infoId = new JTextField(15);
        JLabel insertDate = new JLabel("Informe a data de treino: ", JLabel.CENTER);
        JTextField infoDate = new JTextField(15);
        JLabel insertDesc = new JLabel("Informe a Descrição: ", JLabel.CENTER);
        JTextArea infoDesc = new JTextArea(10, 15);
        JButton cad = new JButton("Cadastrar");
        JButton back = new JButton("back");
        Container cadFrame = this.getContentPane();
        cadFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        cadFrame.add(title);
        cadFrame.add(selectId);
        cadFrame.add(infoId);
        cadFrame.add(insertDate);
        cadFrame.add(infoDate);
        cadFrame.add(insertDesc);
        cadFrame.add(infoDesc);
        cadFrame.add(cad);
        cadFrame.add(back);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250,400);
        this.setResizable(false);
        this.setVisible(true);
        cad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMensagemActionPerformed(evt);
                dispose();
                new Search();
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                new Search();
            }
        });
    }
    private void buttonMensagemActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(
            this, 
            "Treinamento do golfinho Cadastrado!", "", JOptionPane.INFORMATION_MESSAGE);
    }
    private final static String url = "jdbc:mysql://localhost:3306/zdb?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";


    // METODO PARA CADASTRAR TREINAMENTO (ArrayList) DO GOLFINHO
    public static void insrtTrain(Training training, Golfinho golfinho) throws Exception{
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmnt = con.createStatement();
            boolean trn = stmnt.execute("INSERT INTO treinamento (golfinho_id, data, detalhes) VALUES ('"+golfinho.getId()+"', '"+training.getDate()+"', '"+training.getDetails()+"')");
            if(!trn){
                System.out.println("Treinamento cadastrado");
            } else {
                System.out.println("E mais um erro, olhe log");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
