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
import back.Diet;
import back.Leao;


public class ListarAnimal extends JFrame {

    public ListarAnimal(){
        JLabel title = new JLabel(" == Listar Leão == ", JLabel.CENTER);
        JLabel infoId = new JLabel("Insira o ID do leão: ", JLabel.CENTER);
        JTextField insertId = new JTextField(15);
        JButton cad = new JButton("Listar Leão");
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


    // METODO PARA SELECIONAR TODOS OS LEÕES
    public static void slctLeao(Leao leao) throws Exception{
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmnt = con.createStatement();
            ResultSet rslt = stmnt.executeQuery("SELECT * FROM leao l INNER JOIN jaula j ON l.jaula_id = j.id");
            while (rslt.next()){
                leao = new Leao(
                    rslt.getInt("id"), 
                    rslt.getString("nome"), 
                    rslt.getInt("alimentacao"), 
                    rslt.getInt("visitantes"), 
                    rslt.getString("descricao"));
                Statement stmntDiet = con.createStatement();
                ResultSet rsltDiet = stmntDiet.executeQuery("SELECT * FROM alimentacao WHERE leao_id = " + leao.getId());
                while (rsltDiet.next()){
                    new Diet(rsltDiet.getInt("id"), rsltDiet.getDate("data"), rsltDiet.getString("detalhes"), leao);
                }
                System.out.println(leao);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
