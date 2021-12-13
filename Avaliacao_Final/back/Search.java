package back;
import java.sql.Date;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// IMPORT DE METODOS DE SELECT, UPDATE, CREATE, DELETE
import front.CadastrarAnimal;
import front.CadastrarAlimentacao;
import front.CadastrarTreino;
import front.DeletarAnimal;
import front.ListarAnimal;
import front.AlterarAnimal;
import front.CadastrarAnimalGolfi;
import front.AlterarAnimalGolfi;
import front.ListarAnimalGolfi;
import front.DeletarAnimalGolfi;


public class Search extends JFrame{

    JButton cadAnimalGolfi = new JButton("Cadastar Golfinho");
    JButton cadAnimalLeo = new JButton("Cadastar Leão");
    JButton cadDiet = new JButton("Cadastrar Alimentação");
    JButton cadTrain = new JButton("Cadastrar Treinamento");
    JButton altGolfi = new JButton("Alterar Golfinho");
    JButton altLeo = new JButton("Alterar Leão");
    JButton delGolfi = new JButton("Deletar Golfinho");
    JButton delLeo = new JButton("Deletar Leão");
    JButton selGolfi = new JButton("Selecionar Golfinho");
    JButton selLeo = new JButton("Selecionar Leão");
    JButton sair = new JButton("Fechar programa");
    public Search(){
        Container menuFrame = this.getContentPane();
        menuFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        menuFrame.add(cadAnimalGolfi);
        menuFrame.add(cadAnimalLeo);
        menuFrame.add(cadDiet);
        menuFrame.add(cadTrain);
        menuFrame.add(altGolfi);
        menuFrame.add(altLeo);
        menuFrame.add(delGolfi);
        menuFrame.add(delLeo);
        menuFrame.add(selGolfi);
        menuFrame.add(selLeo);
        menuFrame.add(sair);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250,400);
        this.setResizable(false);
        this.setVisible(true);

        //BOTÕES
        // CADASTRAR GOLFINHO
        cadAnimalGolfi.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                dispose();
                new CadastrarAnimalGolfi();
            }
        });
        // CADASTRAR LEÃO
        cadAnimalLeo.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                dispose();
                new CadastrarAnimal();
            }
        });
        // CADASTRAR TREINAMENTO DO GOLFINHO
        cadTrain.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                dispose();
                new CadastrarTreino();
            }
        });
        // CADASTRAR ALIMENTAÇÃO DO LEÃO
        cadDiet.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                dispose();
                new CadastrarAlimentacao();
            }
        });
        // CADASTRAR ALIMENTAÇÃO DO LEÃO
        altGolfi.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                dispose();
                new AlterarAnimalGolfi();
            }
        });
         // CADASTRAR ALIMENTAÇÃO DO LEÃO
         altLeo.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                dispose();
                new AlterarAnimal();
            }
        });
         // CADASTRAR ALIMENTAÇÃO DO LEÃO
         delGolfi.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                dispose();
                new DeletarAnimalGolfi();
            }
        });
         // CADASTRAR ALIMENTAÇÃO DO LEÃO
         delLeo.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                dispose();
                new DeletarAnimal();
            }
        });
         // CADASTRAR ALIMENTAÇÃO DO LEÃO
         selGolfi.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                dispose();
                new ListarAnimalGolfi();
            }
        });
         // CADASTRAR ALIMENTAÇÃO DO LEÃO
         selLeo.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                dispose();
                new ListarAnimal();
            }
        });
        // FECHAR PROGRAMA
        sair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                buttonConfirmaActionPerformed(evt);
            }
        });



    }
    // CONFIRMAR PARA FECHAR PROGRAMA
    private void buttonConfirmaActionPerformed(ActionEvent e){
        int ret = JOptionPane.showConfirmDialog(
            this, 
            "Deseja Fechar?",
            "Fechar",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if(ret == JOptionPane.OK_OPTION){
            System.exit(0);
        }
    }
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        int chc = 0;
        int id = 0;
        int idDiet = 0;
        int idTrain = 0;
        int qtdDiet = 0;
        String nome = "";
        int qtdTraining = 0;
        String desc = "";
        String details = "";
        int guest = 0;
        String date = "";
        Search menu = new Search();
        do{
            System.out.print("\n [1] - Cadastrar Leão");                    // FEITO | TODO: CRIAR TELAS/INTERFACES
            System.out.print("\n [2] - Cadastrar Alimentação do leão");     // FEITO | TODO: CRIAR TELAS/INTERFACES
            System.out.print("\n [3] - Alterar leão");                      // FEITO | TODO: CRIAR TELAS/INTERFACES
            System.out.print("\n [4] - Selecionar leão");                   // FEITO | TODO: CRIAR TELAS/INTERFACES
            System.out.print("\n [5] - Deletar leão");                      // FEITO | TODO: CRIAR TELAS/INTERFACES
            System.out.print("\n [6] - Cadastrar golfinho");                // FEITO | TODO: CRIAR TELAS/INTERFACES
            System.out.print("\n [7] - Cadastrar treinamento do golfinho"); // FEITO | TODO: CRIAR TELAS/INTERFACES
            System.out.print("\n [8] - Alterar golfinho");                  // FEITO | TODO: CRIAR TELAS/INTERFACES
            System.out.print("\n [9] - Selecionar golfinho");               // FEITO | TODO: CRIAR TELAS/INTERFACES
            System.out.print("\n [10] - Deletar golfinho");                 // FEITO | TODO: CRIAR TELAS/INTERFACES
            System.out.print("\n [0] - Sair");
            System.out.print("\n Sua escolha: ");
            try {
                chc = sc.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            switch(chc){
                case 1:
                    System.out.println("CADASTRAR LEÃO");
                    try {
                        System.out.print("\n Nome: ");
                        nome = sc.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Visitantes: ");
                        guest = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Alimentação: ");
                        qtdDiet = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Descrição: ");
                        desc = sc.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    // Chamando metodo para o cadastro do leão
                    try {
                        Leao leao = new Leao(id, nome, qtdDiet, guest, desc);
                        Cage cage = new Cage(id, desc);
                        CadastrarAnimal.insrtLeao(leao, cage);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                break;
                case 2:
                    System.out.println("CADASTRAR ALIMENTAÇÃO DO LEÃO");
                    try {
                        System.out.print("\n Id do leão: ");
                        id = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Data da alimentação: ");
                        date = sc.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Descrição da alimentação: ");
                        details = sc.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Leao leao = new Leao(id, nome, qtdDiet, guest, desc);
                        Diet diet = new Diet(idDiet, Date.valueOf(date), details, leao);
                        CadastrarAlimentacao.insrtDiet(diet, leao);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                break;
                case 3:
                    System.out.println("ALTERAR LEÃO");
                    try {
                        System.out.print("\n Id do leão para alteração: ");
                        id = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Nome novo: ");
                        nome = sc.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Horario de alimentação: ");
                        qtdDiet = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Nova quantidade de visitantes: ");
                        guest = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Leao leao = new Leao(id, nome, qtdDiet, guest, desc);
                        AlterarAnimal.updtLeao(leao);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                break;
                case 4:
                    System.out.println("SELECIONAR LEÃO");
                    try {
                        Leao leao = new Leao(id, nome, qtdDiet, guest, desc);
                        ListarAnimal.slctLeao(leao);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                break;
                case 5:
                    System.out.println("DELETAR LEÃO");
                    try {
                        System.out.print("\n Id do leão para deletar: ");
                        id = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Leao leao = new Leao(id, nome, qtdDiet, guest, desc);
                        DeletarAnimal.dltLeao(leao);;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                break;
                case 6:
                    System.out.println("CADASTAR GOLFINHO");
                    try {
                        System.out.print("\n Nome: ");
                        nome = sc.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Treinamentos: ");
                        qtdTraining = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Descrição: ");
                        desc = sc.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    // Chamando metodo para o cadastro do golfinho
                    try {
                        Golfinho golfinho = new Golfinho(id, nome, qtdTraining, desc);
                        Cage cage = new Cage(id, desc);
                        CadastrarAnimalGolfi.insrtGolfi(golfinho, cage);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                break;
                case 7:
                    System.out.println("CADASTRAR TREINAMENTO DO GOLFINHO");
                    try {
                        System.out.print("\n Id do golfinho: ");
                        id = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Data do treino: ");
                        date = sc.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Detalhes do treinamento: ");
                        details = sc.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Golfinho golfinho = new Golfinho(id, nome, qtdTraining, desc);
                        Training train = new Training(idTrain, details, Date.valueOf(date), golfinho);
                        CadastrarTreino.insrtTrain(train, golfinho);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                break;
                case 8:
                    System.out.println("ALTERAR GOLFINHO");
                    try {
                        System.out.print("\n Id do golfinho para alteração: ");
                        id = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Nome novo: ");
                        nome = sc.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.print("\n Quantidade de treinamentos: ");
                        qtdTraining = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Golfinho golfinho = new Golfinho(id, nome, qtdTraining, desc);
                        AlterarAnimalGolfi.updtGolfi(golfinho);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                break;
                case 9:
                    System.out.println("SELECIONAR GOLFINHO");
                    try {
                        Golfinho golfinho = new Golfinho(id, nome, qtdTraining, desc);
                        ListarAnimalGolfi.slctGolfi(golfinho);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                break;
                case 10:
                    System.out.println("DELETAR GOLFINHO");
                    try {
                        System.out.print("\n Id do golfinho para deletar: ");
                        id = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Golfinho golfinho = new Golfinho(id, nome, qtdTraining, desc);
                        DeletarAnimalGolfi.dltGolfi(golfinho);;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                break;
                case 0:
                    System.out.println("\n\nAdeus");
                break;
                default:
                    System.out.println("Operação inválida, inexistente, ou não implementada");
                break;

            }
        } while (chc != 0);
        sc.close();
    }
}
