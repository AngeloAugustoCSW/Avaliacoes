package front;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

import back.Search;

import back.Cage;
import back.Leao;

public class CadastrarAnimal extends JFrame{

    public CadastrarAnimal(){
        JLabel title = new JLabel(" == Cadastrar Leão == ", JLabel.CENTER);
        JLabel infoName = new JLabel("Insira o nome do leão: ", JLabel.CENTER);
        JTextField insertName = new JTextField(15);
        JLabel infoDiet = new JLabel("Insira o horario de alimentação do leão: ", JLabel.CENTER);
        JTextField insertDiet = new JTextField(15);
        JLabel infoGuest = new JLabel("Insira a qauntidade de visitantes do leão: ", JLabel.CENTER);
        JTextField insertGuest = new JTextField(15);
        JLabel infoDesc = new JLabel("Insira a descrição da jaula: ", JLabel.CENTER);
        JTextField insertDesc = new JTextField(15);
        JButton cad = new JButton("Cadastrar Leão");
        JButton back = new JButton("Voltar");
        Container cadFrame = this.getContentPane();
        cadFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        cadFrame.add(title);
        cadFrame.add(infoName);
        cadFrame.add(insertName);
        cadFrame.add(infoDiet);
        cadFrame.add(insertDiet);
        cadFrame.add(infoGuest);
        cadFrame.add(insertGuest);
        cadFrame.add(infoDesc);
        cadFrame.add(insertDesc);
        cadFrame.add(cad);
        cadFrame.add(back);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250,400);
        this.setResizable(false);
        this.setVisible(true);

        cad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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
            "Leão Cadastrado!", "", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private final static String url = "jdbc:mysql://localhost:3306/zdb?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    // METODO PARA CADASTRAR JAULA E LEAO
    public static void insrtLeao(Leao leao, Cage cage) throws Exception{
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmnt = con.createStatement();
            PreparedStatement pStm = con.prepareStatement("INSERT INTO jaula (descricao) VALUES (?) ", PreparedStatement.RETURN_GENERATED_KEYS);
            pStm.setString(1, cage.getDesc());
            pStm.executeUpdate();
            ResultSet rsJaula = pStm.getGeneratedKeys();
            rsJaula.next();
            stmnt.execute("INSERT INTO leao (nome, alimentacao, visitantes,jaula_id) VALUES ('"+leao.getNome()+"', '"+leao.getDiet()+"', '"+leao.getGuest()+"', "+ rsJaula.getInt(1) + ")");
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
