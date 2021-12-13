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
import back.Diet;
import back.Leao;
public class AlterarAnimal extends JFrame{
    private final static String url = "jdbc:mysql://localhost:3306/zdb?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    public AlterarAnimal(){
        JLabel title = new JLabel(" == Atualizar Leão == ", JLabel.CENTER);
        JLabel infoId = new JLabel("Insira o ID do leão: ", JLabel.CENTER);
        JTextField insertId = new JTextField(15);
        JLabel infoName = new JLabel("Insira o Nome novo do leão: ", JLabel.CENTER);
        JTextField insertName = new JTextField(15);
        JLabel infoTrain = new JLabel("Insira horario novo de alimentação do leão: ", JLabel.CENTER);
        JTextField insertTrain = new JTextField(15);
        JButton cad = new JButton("Atualizar Leão");
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
            "Leão Atualizado!", "", JOptionPane.INFORMATION_MESSAGE);
    }

    // Sei que Statements nao retorna resultados, mas fazendo statement.execute com variavel boolean me permite conferir se o statement deu certo ou não
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
    public static void updtLeao(Leao leao) throws Exception{
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmnt = con.createStatement();
            boolean leo = stmnt.execute("UPDATE leao SET nome = '"+leao.getNome()+"', alimentacao = '"+leao.getDiet()+"', visitantes = '"+leao.getGuest()+"' WHERE id = "+leao.getId());
            if (leo) {
                System.out.println("Deu ruim, olha o log");
            } else {
                System.out.println("Leao alterado");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
