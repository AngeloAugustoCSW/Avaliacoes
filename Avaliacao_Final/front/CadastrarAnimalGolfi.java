package front;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import back.Search;

import back.Cage;
import back.Golfinho;

public class CadastrarAnimalGolfi extends JFrame{

    public CadastrarAnimalGolfi(){
        JLabel title = new JLabel(" == Cadastrar Golfinho == ", JLabel.CENTER);
        JLabel infoName = new JLabel("Insira o nome do golfinho: ", JLabel.CENTER);
        JTextField insertName = new JTextField(15);
        JLabel infoTrain = new JLabel("Insira a quantidade de treinos do golfinho: ", JLabel.CENTER);
        JTextField insertTrain = new JTextField(15);
        JLabel infoDesc = new JLabel("Insira a descrição da jaula: ", JLabel.CENTER);
        JTextField insertDesc = new JTextField(15);
        JButton cad = new JButton("Cadastrar Golfinho");
        JButton back = new JButton("Voltar");
        Container cadFrame = this.getContentPane();
        cadFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        cadFrame.add(title);
        cadFrame.add(infoName);
        cadFrame.add(insertName);
        cadFrame.add(infoTrain);
        cadFrame.add(insertTrain);
        cadFrame.add(infoDesc);
        cadFrame.add(insertDesc);
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
            "Golfinho Cadastrado!", "", JOptionPane.INFORMATION_MESSAGE);
    }
    private final static String url = "jdbc:mysql://localhost:3306/zdb?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    // METODO PARA CADASTRAR JAULA E GOLFINHO
    public static void insrtGolfi(Golfinho golfinho, Cage cage) throws Exception{
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmnt = con.createStatement();
            PreparedStatement pStm = con.prepareStatement("INSERT INTO jaula (descricao) VALUES (?) ", PreparedStatement.RETURN_GENERATED_KEYS);
            pStm.setString(1, cage.getDesc());
            pStm.executeUpdate();
            ResultSet rsJaula = pStm.getGeneratedKeys();
            rsJaula.next();
            stmnt.execute("INSERT INTO golfinho (nome, treinamento, jaula_id) VALUES ('"+golfinho.getNome()+"', '"+golfinho.getQtdTraining()+"', "+ rsJaula.getInt(1) + ")");
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
