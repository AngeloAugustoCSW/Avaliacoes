package front;


import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;

import back.Search;
import back.Diet;
import back.Leao;

public class CadastrarAlimentacao extends JFrame{
    public CadastrarAlimentacao(){
        JLabel title = new JLabel(" == Cadastrar Alimentação! == ", JLabel.CENTER);
        JLabel selectId = new JLabel("Informe o Id do leão: ", JLabel.CENTER);
        JTextField infoId = new JTextField(15);
        JLabel insertDate = new JLabel("Informe a data de alimentação: ", JLabel.CENTER);
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
            "Alimentação do leão Cadastrado!", "", JOptionPane.INFORMATION_MESSAGE);
    }

    private final static String url = "jdbc:mysql://localhost:3306/zdb?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    // METODO PARA CADASTRAR ALIMENTAÇÃO (ArrayList) DO LEAO
    public static void insrtDiet(Diet diet, Leao leao) throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmnt = con.createStatement();
            boolean dt = stmnt.execute("INSERT INTO alimentacao (leao_id, data, detalhes) VALUES ('"+leao.getId()+"', '"+diet.getDate()+"', '"+diet.getDetails()+"')");
            if (!dt){
                System.out.println("Alimentação cadastrada");
            } else {
                System.out.println("Eita, olha o log, deu erro");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
