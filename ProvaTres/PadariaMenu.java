import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;

public class PadariaMenu{
    public static void main (String[] args){
        Scanner scn = new Scanner(System.in);
        int chc = 0;
        int slctchc = 0;
        float setWage = 0;
        float setPrice = 0;
        String setID = "";
        String setSecID = "";
        String setName = "";
        String setCPF = "";
        String setCEP = "";
        String setBrthDt = "";
        String setPhone = "";
        String setSpec = "";
        String setEtapas = "";
        String setNumEt = "";
        String setOpnDt = "";
        String setRua = "";
        String setNum = "";
        String setBairro = "";
        String setCity = "";
        String setHours = "";
        String setPromo = "";
        do{
            System.out.println("================ DB_ALPH4 MENU ================");
            System.out.println("[01] - [INSERT] table [Cliente]");
            System.out.println("[02] - [UPDATE] table [Cliente]");
            System.out.println("[03] - [DELETE] table [Cliente]");
            System.out.println("[04] - [SELECT] table [Cliente]");
            System.out.println("[05] - [INSERT] table [Chef]");
            System.out.println("[06] - [UPDATE] table [Chef]");
            System.out.println("[07] - [DELETE] table [Chef]");
            System.out.println("[08] - [SELECT] table [Chef]");
            System.out.println("[09] - [INSERT] table [Receita]");
            System.out.println("[10] - [UPDATE] table [Receita]");
            System.out.println("[11] - [DELETE] table [Receita]");
            System.out.println("[12] - [SELECT] table [Receita]");
            System.out.println("[13] - [INSERT] table [Padaria]");
            System.out.println("[14] - [UPDATE] table [Padaria]");
            System.out.println("[15] - [DELETE] table [Padaria]");
            System.out.println("[16] - [SELECT] table [Padaria]");
            System.out.println("[17] - [INSERT] table [Mercado]");
            System.out.println("[18] - [UPDATE] table [Mercado]");
            System.out.println("[19] - [DELETE] table [Mercado]");
            System.out.println("[20] - [SELECT] table [Mercado]");
            System.out.println("[00] - Sair");
            System.out.print("Insira a opção desejada: ");
            chc = scn.nextInt();
            switch (chc){
                //AREA DO CLIENTE
                //ORDEM: INSERT, UPDATE, DELETE, SELECT
                case 1:
                    System.out.println("Insira os seguintes dados para cadastrar o cliente: ");
                    System.out.println("Identificação: ");
                    try {
                        setID = scn.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Nome: ");
                    try {
                        setName = scn.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("CPF: ");
                    try {
                        setCPF = scn.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Data de nascimento: ");
                    try {
                        setBrthDt = scn.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("telefone: ");
                    try {
                        setPhone = scn.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stmnt = con.prepareStatement("INSERT INTO cliente(id, nome, cpf, dtNasc, telefone) VALUES (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                        stmnt.setString(1, setID);
                        stmnt.setString(2, setName);
                        stmnt.setString(3, setCPF);
                        stmnt.setString(4, setBrthDt);
                        stmnt.setString(5, setPhone);
                        if (stmnt.executeUpdate()>0){
                            ResultSet result = stmnt.getGeneratedKeys();
                            if(result.next()){
                                result.getString(1);
                                result.getString(2);
                                result.getString(3);
                                result.getString(4);
                                result.getString(5);
                            }
                        }
                    con.close();
                    System.out.println("Cliente cadastrado com sucesso!");
                    } catch (SQLException e) {
                        System.out.println("Não foi possivel se conectar");
                        System.out.println(e.getMessage());
                    }
                break;

                case 2:
                System.out.println("Insira os seguintes dados para atualizar o cadastro do cliente: ");
                System.out.println("Identificação: ");
                try {
                    setID = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Nome: ");
                try {
                    setName = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("CPF: ");
                try {
                    setCPF = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Data de nascimento");
                try {
                    setBrthDt = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("telefone: ");
                try {
                    setPhone = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                try {
                    final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                    final String user = "root";
                    final String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmnt = con.prepareStatement("UPDATE cliente SET nome = ?, cpf = ?, dtNasc = ?, telefone = ? WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                    stmnt.setString(1, setName);
                    stmnt.setString(2, setCPF);
                    stmnt.setString(3, setBrthDt);
                    stmnt.setString(4, setPhone);
                    stmnt.setString(5, setID);
                    if (stmnt.executeUpdate()>0){
                        ResultSet result = stmnt.getGeneratedKeys();
                        if(result.next()){
                            result.getString(1);
                            result.getString(2);
                            result.getString(3);
                            result.getString(4);
                            result.getString(5);
                        }
                    }
                con.close();
                System.out.println("Cliente atualizado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Não foi possivel se conectar");
                    System.out.println(e.getMessage());
                }
                break;

                case 3:
                System.out.println("Insira o ID do cliente para deletar o cadastro do cliente: ");
                System.out.println("Identificação: ");
                try {
                    setID = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                try {
                    final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                    final String user = "root";
                    final String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmnt = con.prepareStatement("DELETE FROM cliente WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                    stmnt.setString(1, setID);
                    if (stmnt.executeUpdate()>0){
                        ResultSet result = stmnt.getGeneratedKeys();
                        if(result.next()){
                            result.getString(1);
                        }
                    }
                con.close();
                System.out.println("Cliente deletado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Não foi possivel se conectar");
                    System.out.println(e.getMessage());
                }
                break;

                case 4:
                System.out.println("Mostrar todos os clientes cadastrados ou somente um?");
                System.out.println("[1] - Mostrar todos");
                System.out.println("[2] - Mostrar apenas um");
                slctchc = scn.nextInt();
                if(slctchc == 1){
                    try {
                        final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stmnt = con.createStatement();
                        ResultSet result = stmnt.executeQuery("SELECT * FROM cliente");
                            while (result.next()){
                                Cliente cliente = new Cliente(
                                    result.getString("id"), 
                                    result.getString("nome"), 
                                    result.getString("cpf"), 
                                    result.getString("dtNasc"), 
                                    result.getString("telefone"));
                                System.out.println(cliente);
                            }
                    con.close();
                    } catch (SQLException e) {
                        System.out.println("Não foi possivel se conectar");
                        System.out.println(e.getMessage());
                    }
                }else if(slctchc == 2){
                    System.out.println("Insira o ID do cliente para mostrar o cadastro do cliente: ");
                    System.out.println("Identificação: ");
                    try {
                        setID = scn.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stmnt = con.prepareStatement("SELECT * FROM cliente WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                        stmnt.setString(1, setID);
                        ResultSet result = stmnt.executeQuery();
                            while (result.next()){
                                Cliente cliente = new Cliente(
                                    result.getString("id"), 
                                    result.getString("nome"), 
                                    result.getString("cpf"), 
                                    result.getString("dtNasc"), 
                                    result.getString("telefone"));
                                System.out.println(cliente);
                            }
                    con.close();
                    } catch (SQLException e) {
                        System.out.println("Não foi possivel se conectar");
                        System.out.println(e.getMessage());
                    }
                }
                break;




                // AREA DO CHEF
                //ORDEM: INSERT, UPDATE, DELETE, SELECT
                case 5:
                System.out.println("Insira os seguintes dados para cadastrar o chef: ");
                System.out.println("Identificação: ");
                try {
                    setID = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Nome: ");
                try {
                    setName = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("CPF: ");
                try {
                    setCPF = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Data de nascimento");
                try {
                    setBrthDt = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Especialidade: ");
                try {
                    setSpec = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Salário: ");
                try {
                    setWage = scn.nextFloat();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                try {
                    final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                    final String user = "root";
                    final String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmnt = con.prepareStatement("INSERT INTO chef(id, nome, cpf, dtNasc, specialty, salario) VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                    stmnt.setString(1, setID);
                    stmnt.setString(2, setName);
                    stmnt.setString(3, setCPF);
                    stmnt.setString(4, setBrthDt);
                    stmnt.setString(5, setSpec);
                    stmnt.setFloat(6, setWage);
                    if (stmnt.executeUpdate()>0){
                        ResultSet result = stmnt.getGeneratedKeys();
                        if(result.next()){
                            result.getString(1);
                            result.getString(2);
                            result.getString(3);
                            result.getString(4);
                            result.getString(5);
                            result.getFloat(6);
                        }
                    }
                con.close();
                System.out.println("Chef cadastrado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Não foi possivel se conectar");
                    System.out.println(e.getMessage());
                }
                break;

                case 6:
                System.out.println("Insira os seguintes dados para atualizar o cadasto do chef: ");
                System.out.println("Identificação: ");
                try {
                    setID = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                try {
                    final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                    final String user = "root";
                    final String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmnt = con.prepareStatement("UPDATE chef SET nome = ?, cpf = ? , dtNasc = ?, specialty = ?, salario = ? WHERE id =?)", PreparedStatement.RETURN_GENERATED_KEYS);
                    stmnt.setString(1, setName);
                    stmnt.setString(2, setCPF);
                    stmnt.setString(3, setBrthDt);
                    stmnt.setString(4, setSpec);
                    stmnt.setFloat(5, setWage);
                    stmnt.setString(6, setID);
                    if (stmnt.executeUpdate()>0){
                        ResultSet result = stmnt.getGeneratedKeys();
                        if(result.next()){
                            result.getString(1);
                            result.getString(2);
                            result.getString(3);
                            result.getString(4);
                            result.getFloat(5);
                            result.getString(6);
                        }
                    }
                con.close();
                System.out.println("Chef atualizado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Não foi possivel se conectar");
                    System.out.println(e.getMessage());
                }
                break;

                case 7:
                System.out.println("Insira o ID do chef para deletar o cadastro do chef: ");
                System.out.println("Identificação: ");
                try {
                    setID = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                try {
                    final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                    final String user = "root";
                    final String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmnt = con.prepareStatement("DELETE FROM chef WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                    stmnt.setString(1, setID);
                    if (stmnt.executeUpdate()>0){
                        ResultSet result = stmnt.getGeneratedKeys();
                        if(result.next()){
                            result.getString(1);
                        }
                    }
                con.close();
                System.out.println("Chef deletado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Não foi possivel se conectar");
                    System.out.println(e.getMessage());
                }
                break;

                case 8:
                System.out.println("Mostrar todos os chefs cadastrados ou somente um?");
                System.out.println("[1] - Mostrar todos");
                System.out.println("[2] - Mostrar apenas um");
                slctchc = scn.nextInt();
                if(slctchc == 1){
                    try {
                        final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stmnt = con.createStatement();
                        ResultSet result = stmnt.executeQuery("SELECT * FROM chef");
                            while (result.next()){
                                Chef chef = new Chef(
                                result.getString("id"), 
                                result.getString("nome"), 
                                result.getString("cpf"), 
                                result.getString("dtNasc"), 
                                result.getString("specialty"), 
                                result.getDouble("salario"));
                            System.out.println(chef);
                            }
                    con.close();
                    } catch (SQLException e) {
                        System.out.println("Não foi possivel se conectar");
                        System.out.println(e.getMessage());
                    }
                }else if(slctchc == 2){
                    System.out.println("Insira o ID do chef para mostrar o cadastro do chef: ");
                    System.out.println("Identificação: ");
                    try {
                        setID = scn.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stmnt = con.prepareStatement("SELECT * FROM chef WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                        stmnt.setString(1, setID);
                        ResultSet result = stmnt.executeQuery();
                            while (result.next()){
                                Chef chef = new Chef(
                                result.getString("id"), 
                                result.getString("nome"), 
                                result.getString("cpf"), 
                                result.getString("dtNasc"), 
                                result.getString("specialty"), 
                                result.getDouble("salario"));
                            System.out.println(chef);
                            }
                    con.close();
                    } catch (SQLException e) {
                        System.out.println("Não foi possivel se conectar");
                        System.out.println(e.getMessage());
                    }
                }
                break;



                // AREA DA RCEITA
                //ORDEM: INSERT, UPDATE, DELETE, SELECT
                case 9:
                    System.out.println("Insira os seguintes dados para cadastrar a receita: ");
                    System.out.println("Identificação: ");
                    try {
                        setID = scn.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Nome: ");
                    try {
                        setName = scn.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Etapas: ");
                    try {
                        setEtapas = scn.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Numero de etapas: ");
                    try {
                        setNumEt = scn.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("valor: ");
                    try {
                        setPrice = scn.nextFloat();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Chef da receita: ");
                    try {
                        setSecID = scn.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stmnt = con.prepareStatement("INSERT INTO receita(id, nome, etapas, numEtapas, valor, idChef) VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                        stmnt.setString(1, setID);
                        stmnt.setString(2, setName);
                        stmnt.setString(3, setEtapas);
                        stmnt.setString(4, setNumEt);
                        stmnt.setFloat(5, setPrice);
                        stmnt.setString(6, setSecID);
                        if (stmnt.executeUpdate()>0){
                            ResultSet result = stmnt.getGeneratedKeys();
                            if(result.next()){
                                result.getString(1);
                                result.getString(2);
                                result.getString(3);
                                result.getString(4);
                                result.getFloat(5);
                                result.getString(6);
                            }
                        }
                    con.close();
                    System.out.println("Receita cadastrada com sucesso!");
                    } catch (SQLException e) {
                        System.out.println("Não foi possivel se conectar");
                        System.out.println(e.getMessage());
                    }
                break;

                case 10:
                System.out.println("Insira os seguintes dados para atualizar o cadastro da receitae: ");
                System.out.println("Identificação: ");
                try {
                    setID = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Nome: ");
                try {
                    setName = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Etapas: ");
                try {
                    setEtapas = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Numero de etapas: ");
                try {
                    setNumEt = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Preço: ");
                try {
                    setPrice = scn.nextFloat();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Chef da receita: ");
                try {
                    setSecID = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                try {
                    final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                    final String user = "root";
                    final String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmnt = con.prepareStatement("UPDATE receita SET nome = ?, etapas = ?, numEtapas = ?, valor = ?, idChef = ? WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                    stmnt.setString(1, setName);
                    stmnt.setString(2, setEtapas);
                    stmnt.setString(3, setNumEt);
                    stmnt.setFloat(4, setPrice);
                    stmnt.setString(5, setSecID);
                    stmnt.setString(6, setID);
                    if (stmnt.executeUpdate()>0){
                        ResultSet result = stmnt.getGeneratedKeys();
                        if(result.next()){
                            result.getString(1);
                            result.getString(2);
                            result.getString(3);
                            result.getFloat(4);
                            result.getString(5);
                            result.getString(6);
                        }
                    }
                con.close();
                System.out.println("Receita atualizada com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Não foi possivel se conectar");
                    System.out.println(e.getMessage());
                }
                break;

                case 11:
                System.out.println("Insira o ID da receita para deletar o cadastro da receita: ");
                System.out.println("Identificação: ");
                try {
                    setID = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                try {
                    final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                    final String user = "root";
                    final String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmnt = con.prepareStatement("DELETE FROM receita WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                    stmnt.setString(1, setID);
                    if (stmnt.executeUpdate()>0){
                        ResultSet result = stmnt.getGeneratedKeys();
                        if(result.next()){
                            result.getString(1);
                        }
                    }
                con.close();
                System.out.println("Receita deletada com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Não foi possivel se conectar");
                    System.out.println(e.getMessage());
                }
                break;

                case 12:
                System.out.println("Mostrar todos as receitas cadastrados ou somente um?");
                System.out.println("[1] - Mostrar todas");
                System.out.println("[2] - Mostrar apenas um");
                slctchc = scn.nextInt();
                if(slctchc == 1){
                    try {
                        final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stmnt = con.createStatement();
                        ResultSet result = stmnt.executeQuery("SELECT * FROM receita");
                            while (result.next()){
                                PreparedStatement pStmnt = con.prepareStatement("SELECT * FROM chef WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                        pStmnt.setString(1, result.getString("idChef"));
                        ResultSet resultChef = pStmnt.executeQuery();
                                Chef chef = new Chef(
                                    resultChef.getString("id"), 
                                    resultChef.getString("nome"), 
                                    resultChef.getString("cpf"), 
                                    resultChef.getString("dtNasc"), 
                                    resultChef.getString("specialty"), 
                                    resultChef.getDouble("salario"));
                                Receita receita = new Receita(
                                    result.getString("id"), 
                                    result.getString("nome"), 
                                    result.getString("etapas"), 
                                    result.getString("numEtapas"), 
                                    result.getDouble("Valor"),
                                    chef
                                    );
                                System.out.println(receita);
                            }
                    con.close();
                    } catch (SQLException e) {
                        System.out.println("Não foi possivel se conectar");
                        System.out.println(e.getMessage());
                    }
                }else if(slctchc == 2){
                    System.out.println("Insira o ID da receita para mostrar o cadastro da receita: ");
                    System.out.println("Identificação: ");
                    try {
                        setID = scn.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                        final String user = "root";
                        final String password = "";
                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stmnt = con.prepareStatement("SELECT * FROM receita WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                        stmnt.setString(1, setID);
                        ResultSet result = stmnt.executeQuery();
                        while (result.next()){
                            PreparedStatement pStmnt = con.prepareStatement("SELECT * FROM chef WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                    pStmnt.setString(1, result.getString("idChef"));
                    ResultSet resultChef = pStmnt.executeQuery();
                            Chef chef = new Chef(
                                resultChef.getString("id"), 
                                resultChef.getString("nome"), 
                                resultChef.getString("cpf"), 
                                resultChef.getString("dtNasc"), 
                                resultChef.getString("specialty"), 
                                resultChef.getDouble("salario"));
                            Receita receita = new Receita(
                                result.getString("id"), 
                                result.getString("nome"), 
                                result.getString("etapas"), 
                                result.getString("numEtapas"), 
                                result.getDouble("Valor"),
                                chef
                                );
                            System.out.println(receita);
                        }
                    con.close();
                    } catch (SQLException e) {
                        System.out.println("Não foi possivel se conectar");
                        System.out.println(e.getMessage());
                    }
                }
                break;



                // AREA DA PADARIA
                //ORDEM: INSERT, UPDATE, DELETE, SELECT
                case 13:
                System.out.println("Insira os seguintes dados para cadastrar a padaria: ");
                System.out.println("Identificação: ");
                try {
                    setID = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Nome: ");
                try {
                    setName = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Data de abertura:: ");
                try {
                    setOpnDt = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("CEP: ");
                try {
                    setCEP = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Rua: ");
                try {
                    setRua = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Numero: ");
                try {
                    setNum = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Bairro: ");
                try {
                    setBairro = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Cidade: ");
                try {
                    setCity = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Horario: ");
                try {
                    setHours = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                try {
                    final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                    final String user = "root";
                    final String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmnt = con.prepareStatement("INSERT INTO padaria(id, nome, dtAbertura, cep, rua, numero, bairro, cidade, horario) VALUES (?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                    stmnt.setString(1, setID);
                    stmnt.setString(2, setName);
                    stmnt.setString(3, setOpnDt);
                    stmnt.setString(4, setCEP);
                    stmnt.setString(5, setRua);
                    stmnt.setString(6, setNum);
                    stmnt.setString(7, setBairro);
                    stmnt.setString(8, setCity);
                    stmnt.setString(9, setHours);
                    if (stmnt.executeUpdate()>0){
                        ResultSet result = stmnt.getGeneratedKeys();
                        if(result.next()){
                            result.getString(1);
                            result.getString(2);
                            result.getString(3);
                            result.getString(4);
                            result.getString(5);
                            result.getString(6);
                            result.getString(7);
                            result.getString(8);
                            result.getString(9);
                        }
                    }
                con.close();
                System.out.println("Padaria cadastrada com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Não foi possivel se conectar");
                    System.out.println(e.getMessage());
                }
            break;

                case 14:
            System.out.println("Insira os seguintes dados para atualizar o cadastro da padaria: ");
            System.out.println("Identificação: ");
            try {
                setID = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Nome: ");
            try {
                setName = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Data de abertura:: ");
            try {
                setOpnDt = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("CEP: ");
            try {
                setCEP = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Rua: ");
            try {
                setRua = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Numero: ");
            try {
                setNum = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Bairro: ");
            try {
                setBairro = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Cidade: ");
            try {
                setCity = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Horario: ");
            try {
                setHours = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                final String user = "root";
                final String password = "";
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement stmnt = con.prepareStatement("UPDATE padaria SET nome = ?, dtAbertura = ?, cep = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, horario = ? WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                stmnt.setString(1, setName);
                stmnt.setString(2, setOpnDt);
                stmnt.setString(3, setCEP);
                stmnt.setString(4, setRua);
                stmnt.setString(5, setNum);
                stmnt.setString(6, setBairro);
                stmnt.setString(7, setCity);
                stmnt.setString(8, setHours);
                stmnt.setString(9, setID);
                if (stmnt.executeUpdate()>0){
                    ResultSet result = stmnt.getGeneratedKeys();
                    if(result.next()){
                        result.getString(1);
                        result.getString(2);
                        result.getString(3);
                        result.getString(4);
                        result.getString(5);
                        result.getString(6);
                        result.getString(7);
                        result.getString(8);
                        result.getString(9);
                    }
                }
            con.close();
            System.out.println("padaria atualizada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Não foi possivel se conectar");
                System.out.println(e.getMessage());
            }
            break;

            case 15:
            System.out.println("Insira o ID da padaria para deletar o cadastro da padaria: ");
            System.out.println("Identificação: ");
            try {
                setID = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                final String user = "root";
                final String password = "";
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement stmnt = con.prepareStatement("DELETE FROM padaria WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                stmnt.setString(1, setID);
                if (stmnt.executeUpdate()>0){
                    ResultSet result = stmnt.getGeneratedKeys();
                    if(result.next()){
                        result.getString(1);
                    }
                }
            con.close();
            System.out.println("Padaria deletada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Não foi possivel se conectar");
                System.out.println(e.getMessage());
            }
            break;

                case 16:
            System.out.println("Mostrar todas as padarias cadastradas ou somente um?");
            System.out.println("[1] - Mostrar todas");
            System.out.println("[2] - Mostrar apenas um");
            slctchc = scn.nextInt();
            if(slctchc == 1){
                try {
                    final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                    final String user = "root";
                    final String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    Statement stmnt = con.createStatement();
                    ResultSet result = stmnt.executeQuery("SELECT * FROM padaria");
                        while (result.next()){
                            Padaria padaria = new Padaria(
                                result.getString("id"), 
                                result.getString("nome"), 
                                result.getString("dtAbertura"), 
                                result.getString("cep"),
                                result.getString("rua"),
                                result.getString("numero"),
                                result.getString("bairro"),
                                result.getString("cidade"),
                                result.getString("horario"));
                            System.out.println(padaria);
                        }
                con.close();
                } catch (SQLException e) {
                    System.out.println("Não foi possivel se conectar");
                    System.out.println(e.getMessage());
                }
            }else if(slctchc == 2){
                System.out.println("Insira o ID da padaria para mostrar o cadastro do padaria: ");
                System.out.println("Identificação: ");
                try {
                    setID = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                try {
                    final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                    final String user = "root";
                    final String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmnt = con.prepareStatement("SELECT * FROM padaria WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                    stmnt.setString(1, setID);
                    ResultSet result = stmnt.executeQuery();
                        while (result.next()){
                            Padaria padaria = new Padaria(
                                result.getString("id"), 
                                result.getString("nome"), 
                                result.getString("dtAbertura"), 
                                result.getString("cep"),
                                result.getString("rua"),
                                result.getString("numero"),
                                result.getString("bairro"),
                                result.getString("cidade"),
                                result.getString("horario"));
                            System.out.println(padaria);
                        }
                con.close();
                } catch (SQLException e) {
                    System.out.println("Não foi possivel se conectar");
                    System.out.println(e.getMessage());
                }
            }
            break;


                // AREA DO MERCADO
                //ORDEM: INSERT, UPDATE, DELETE, SELECT
                case 17:
                System.out.println("Insira os seguintes dados para cadastrar o mercado: ");
                System.out.println("Identificação: ");
                try {
                    setID = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Nome: ");
                try {
                    setName = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Data de abertura:: ");
                try {
                    setOpnDt = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("CEP: ");
                try {
                    setCEP = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Rua: ");
                try {
                    setRua = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Numero: ");
                try {
                    setNum = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Bairro: ");
                try {
                    setBairro = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Cidade: ");
                try {
                    setCity = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Promoção: ");
                try {
                    setPromo = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                try {
                    final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                    final String user = "root";
                    final String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmnt = con.prepareStatement("INSERT INTO mercado(id, nome, dtAbertura, cep, rua, numero, bairro, cidade, promo) VALUES (?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                    stmnt.setString(1, setID);
                    stmnt.setString(2, setName);
                    stmnt.setString(3, setOpnDt);
                    stmnt.setString(4, setCEP);
                    stmnt.setString(5, setRua);
                    stmnt.setString(6, setNum);
                    stmnt.setString(7, setBairro);
                    stmnt.setString(8, setCity);
                    stmnt.setString(9, setPromo);
                    if (stmnt.executeUpdate()>0){
                        ResultSet result = stmnt.getGeneratedKeys();
                        if(result.next()){
                            result.getString(1);
                            result.getString(2);
                            result.getString(3);
                            result.getString(4);
                            result.getString(5);
                            result.getString(6);
                            result.getString(7);
                            result.getString(8);
                            result.getString(9);
                        }
                    }
                con.close();
                System.out.println("Mercado cadastrado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Não foi possivel se conectar");
                    System.out.println(e.getMessage());
                }
            break;

            case 18:
            System.out.println("Insira os seguintes dados para atualizar o cadastro do mercado: ");
            System.out.println("Identificação: ");
            try {
                setID = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Nome: ");
            try {
                setName = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Data de abertura:: ");
            try {
                setOpnDt = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("CEP: ");
            try {
                setCEP = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Rua: ");
            try {
                setRua = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Numero: ");
            try {
                setNum = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Bairro: ");
            try {
                setBairro = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Cidade: ");
            try {
                setCity = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Promoção: ");
            try {
                setPromo = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                final String user = "root";
                final String password = "";
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement stmnt = con.prepareStatement("UPDATE padaria SET nome = ?, dtAbertura = ?, cep = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, promo = ? WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                stmnt.setString(1, setName);
                stmnt.setString(2, setOpnDt);
                stmnt.setString(3, setCEP);
                stmnt.setString(4, setRua);
                stmnt.setString(5, setNum);
                stmnt.setString(6, setBairro);
                stmnt.setString(7, setCity);
                stmnt.setString(8, setPromo);
                stmnt.setString(9, setID);
                if (stmnt.executeUpdate()>0){
                    ResultSet result = stmnt.getGeneratedKeys();
                    if(result.next()){
                        result.getString(1);
                        result.getString(2);
                        result.getString(3);
                        result.getString(4);
                        result.getString(5);
                        result.getString(6);
                        result.getString(7);
                        result.getString(8);
                        result.getString(9);
                    }
                }
            con.close();
            System.out.println("Receita atualizado com sucesso!");
            } catch (SQLException e) {
                System.out.println("Não foi possivel se conectar");
                System.out.println(e.getMessage());
            }
            break;

                case 19:
            System.out.println("Insira o ID do mercado para deletar o cadastro do mercado: ");
            System.out.println("Identificação: ");
            try {
                setID = scn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                final String user = "root";
                final String password = "";
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement stmnt = con.prepareStatement("DELETE FROM mercado WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                stmnt.setString(1, setID);
                if (stmnt.executeUpdate()>0){
                    ResultSet result = stmnt.getGeneratedKeys();
                    if(result.next()){
                        result.getString(1);
                    }
                }
            con.close();
            System.out.println("Mercado deletadao com sucesso!");
            } catch (SQLException e) {
                System.out.println("Não foi possivel se conectar");
                System.out.println(e.getMessage());
            }
            break;

            case 20:
            System.out.println("Mostrar todos os mercados cadastrados ou somente um?");
            System.out.println("[1] - Mostrar todos");
            System.out.println("[2] - Mostrar apenas um");
            slctchc = scn.nextInt();
            if(slctchc == 1){
                try {
                    final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                    final String user = "root";
                    final String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    Statement stmnt = con.createStatement();
                    ResultSet result = stmnt.executeQuery("SELECT * FROM mercado");
                        while (result.next()){
                            Mercado mercado = new Mercado(
                                result.getString("id"), 
                                result.getString("nome"), 
                                result.getString("dtAbertura"), 
                                result.getString("cep"),
                                result.getString("rua"),
                                result.getString("numero"),
                                result.getString("bairro"),
                                result.getString("cidade"),
                                result.getString("promo"));
                            System.out.println(mercado);
                        }
                con.close();
                } catch (SQLException e) {
                    System.out.println("Não foi possivel se conectar");
                    System.out.println(e.getMessage());
                }
            }else if(slctchc == 2){
                System.out.println("Insira o ID do mercado para mostrar o cadastro do mercado: ");
                System.out.println("Identificação: ");
                try {
                    setID = scn.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                try {
                    final String url = "jdbc:mysql://localhost:3306/padariateste?useTimezone=true&serverTimezone=UTC";
                    final String user = "root";
                    final String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmnt = con.prepareStatement("SELECT * FROM mercado WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                    stmnt.setString(1, setID);
                    ResultSet result = stmnt.executeQuery();
                        while (result.next()){
                            Mercado mercado = new Mercado(
                                result.getString("id"), 
                                result.getString("nome"), 
                                result.getString("dtAbertura"), 
                                result.getString("cep"),
                                result.getString("rua"),
                                result.getString("numero"),
                                result.getString("bairro"),
                                result.getString("cidade"),
                                result.getString("promo"));
                            System.out.println(mercado);
                        }
                con.close();
                } catch (SQLException e) {
                    System.out.println("Não foi possivel se conectar");
                    System.out.println(e.getMessage());
                }
            }
            break;
            }
        }while(chc<1&&chc>20);
        scn.close();
        
        
        
        
        
        
        
    }
}