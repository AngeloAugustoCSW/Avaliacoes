package front;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import back.Golfinho;
import back.Search;

public class DeletarAnimalGolfi extends JFrame {

    public DeletarAnimalGolfi(){
        JLabel title = new JLabel(" == Deletar Golfinho == ", JLabel.CENTER);
        JLabel infoId = new JLabel("Insira o ID do golfinho: ", JLabel.CENTER);
        JTextField insertId = new JTextField(15);
        JButton cad = new JButton("Deletar Golfinho");
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
            "Golfinho Deletado!", "", JOptionPane.INFORMATION_MESSAGE);
    }

    private final static String url = "jdbc:mysql://localhost:3306/zdb?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";
    
    // METODO PARA DELETAR GOLFINHO
    public static void dltGolfi(Golfinho golfinho) throws Exception{
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmnt = con.createStatement();
            Statement stmntTrain = con.createStatement();
            stmntTrain.execute("DELETE FROM treinamento WHERE golfinho_id = "+golfinho.getId());
            boolean gf = stmnt.execute("DELETE FROM golfinho WHERE id = "+golfinho.getId());
            if (!gf){
                System.out.println("SUMIU, golfinho deletado com sucesso!");
            } else {
                System.out.println("Golfinho não foi deletado, talvez ele nao existe no banco de dados");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
