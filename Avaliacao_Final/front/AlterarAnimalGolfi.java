package front;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import back.Search;
import back.Training;
import back.Golfinho;
public class AlterarAnimalGolfi extends JFrame{

    public AlterarAnimalGolfi(){
        JLabel title = new JLabel(" == Atualizar Golfinho == ", JLabel.CENTER);
        JLabel infoId = new JLabel("Insira o ID do golfinho: ", JLabel.CENTER);
        JTextField insertId = new JTextField(15);
        JLabel infoName = new JLabel("Insira o Nome novo do golfinho: ", JLabel.CENTER);
        JTextField insertName = new JTextField(15);
        JLabel infoTrain = new JLabel("Insira a quantidade nova de treinos do golfinho: ", JLabel.CENTER);
        JTextField insertTrain = new JTextField(15);
        JButton cad = new JButton("Atualizar Golfinho");
        JButton back = new JButton("Voltar");
        Container cadFrame = this.getContentPane();
        cadFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        cadFrame.add(title);
        cadFrame.add(infoId);
        cadFrame.add(insertId);
        cadFrame.add(infoName);
        cadFrame.add(insertName);
        cadFrame.add(infoTrain);
        cadFrame.add(insertTrain);
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
            "Golfinho Atualizado!", "", JOptionPane.INFORMATION_MESSAGE);
    }
    private final static String url = "jdbc:mysql://localhost:3306/zdb?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";


    // Sei que Statements nao retorna resultados, mas fazendo statement.execute com variavel boolean me permite conferir se o statement deu certo ou não
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
    public static void updtGolfi(Golfinho golfinho) throws Exception{
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmnt = con.createStatement();
            boolean gf = stmnt.execute("UPDATE golfinho SET nome = '"+golfinho.getNome()+"', treinamento = '"+golfinho.getQtdTraining()+"' WHERE id = "+golfinho.getId()+"");
            if (gf) {
                System.out.println("Deu ruim, olha o log");
            } else {
                System.out.println("Golfinho alterado");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
