package front;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import back.Search;
import back.Golfinho;
import back.Training;

public class ListarAnimalGolfi extends JFrame{

    public ListarAnimalGolfi(){
        JLabel title = new JLabel(" == Listar Golfinho == ", JLabel.CENTER);
        JLabel infoId = new JLabel("Insira o ID do golfinho: ", JLabel.CENTER);
        JTextField insertId = new JTextField(15);
        JButton cad = new JButton("Listar Golfinho");
        JButton back = new JButton("Voltar");
        Container cadFrame = this.getContentPane();
        cadFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        cadFrame.add(title);
        cadFrame.add(infoId);
        cadFrame.add(insertId);
        cadFrame.add(cad);
        cadFrame.add(back);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(325,400);
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
            "No momento, essa tela nao recebe to string", "", JOptionPane.INFORMATION_MESSAGE);
    }

    private final static String url = "jdbc:mysql://localhost:3306/zdb?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";


    // METODO PARA SELECIONAR TODOS OS GOLFINHOS
    public static void slctGolfi(Golfinho golfinho) throws Exception{
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmnt = con.createStatement();
            ResultSet rslt = stmnt.executeQuery("SELECT * FROM golfinho g INNER JOIN jaula j ON g.jaula_id = j.id");
            while (rslt.next()){
                golfinho = new Golfinho(
                    rslt.getInt("id"), 
                    rslt.getString("nome"), 
                    rslt.getInt("treinamento"), 
                    rslt.getString("descricao"));
                    Statement stmntTrain = con.createStatement();
                    ResultSet rsltTrain = stmntTrain.executeQuery("SELECT * FROM treinamento WHERE golfinho_id = " + golfinho.getId());
                    while (rsltTrain.next()){
                        new Training(rsltTrain.getInt("id"), rsltTrain.getString("detalhes"), rsltTrain.getDate("data"), golfinho);
                    }
                System.out.println(golfinho);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
