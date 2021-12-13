package front;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import back.Leao;
import back.Search;

public class DeletarAnimal extends JFrame {
    private final static String url = "jdbc:mysql://localhost:3306/zdb?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";
    
    public DeletarAnimal(){
        JLabel title = new JLabel(" == Deletar Leão == ", JLabel.CENTER);
        JLabel infoId = new JLabel("Insira o ID do leão: ", JLabel.CENTER);
        JTextField insertId = new JTextField(15);
        JButton cad = new JButton("Deletar Leão");
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
            "Leão Deletado!", "", JOptionPane.INFORMATION_MESSAGE);
    }

    // METODO PARA DELETAR LEAO
    public static void dltLeao(Leao leao) throws Exception{
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmnt = con.createStatement();
            Statement stmntDiet = con.createStatement();
            stmntDiet.execute("DELETE FROM alimentacao WHERE leao_id = "+leao.getId());
            boolean leo = stmnt.execute("DELETE FROM leao WHERE id = "+leao.getId());
            if (!leo){
                System.out.println("SUMIU, leao deletado com sucesso!");
            } else {
                System.out.println("Leao não foi deletado, talvez ele nao existe no banco de dados");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
