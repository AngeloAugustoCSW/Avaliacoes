public class RedeAlfa {
    public static void main(String[] args) {
        // ADD CHEFS
        Chef chefUm = new Chef("1","Gordon Ramsay","705.683.010-21","8/11/1966", "Carnes");
        Chef chefDois = new Chef("2","Guy Fieri","519.064.650-53","22/01/1968", "Fast food");
        Chef chefTres = new Chef("3","Jamie Oliver","705.683.010-21","27/04/1975", "Confeiteiro");
        // ADD RECEITAS
        Receita receitaUm = new Receita("1", "Almôndegas", "Estilo Asiatico", "5", 5.0, chefUm);
        Receita receitaDois = new Receita("2", "Rocambole", "de carne moida", "5", 5.0, chefUm);
        Receita receitaTres = new Receita("3", "Costelinha", "Ao molho outback", "7", 5.0, chefUm);
        Receita receitaQuatro = new Receita("4", "Hamburger", "Caseiro", "4", 5.0, chefDois);
        Receita receitaCinco = new Receita("5", "Hamburger", "Recheado", "3", 5.0, chefDois);
        Receita receitaSeis = new Receita("6", "Hamburger", "a parmegiana", "6", 5.0, chefDois);
        Receita receitaSete = new Receita("7", "Brownie", "de chocolate", "5", 5.0, chefTres);
        Receita receitaOito = new Receita("8", "Mousse", "de limão", "3", 5.0 ,chefTres);
        Receita receitaNove = new Receita("9", "Cupcake", "de nutella", "3", 5.0, chefTres);
        // ADD PADARIAS
        Padaria paoComCarne = new Padaria("1", "Pão com Carne", "02/05/2005", "13:00 as 20:00", "89211-445", "Rua Panamá", "115", "Floresta", "Joinville");
        Padaria flavorTown = new Padaria("2", "Flavor Town", "06/09/2001", "07:00 as 18:00", "89233-305", "Rua Cidade de Ivaí", "169", "Profipo", "Joinville");
        Padaria paoDoce = new Padaria("3", "Pão Doce", "09/12/2003", "15:00 as 23:00", "89230-725", "Rua Egon Freitag", "175", "Adhemar Garcia", "Joinville");
        // ADD CLIENTES
        Cliente clienteUm = new Cliente("1", "Pedro Pietro Felipe Moraes", "147.265.969-42", "20/08/1950", "(91) 3779-6172");
        Cliente clienteDois = new Cliente("2", "Márcio Calebe Bernardo Pires", "620.471.749-96", "25/08/1994", "(28) 2548-0962");
        Cliente clienteTres = new Cliente("3", "Tomás Jesus", "711.630.459-26", "01/08/1941", "(28) 98546-6095");

        //ADD MERCADOS
        Mercado mercadoUm = new Mercado("1", "Lojinha do Tadeu", "02/05/2005", "Quem nao comrpou...", "89227-646", "Rua das Cegonhas", "69420", "Centro", "Joinville");
        Mercado mercadoDois = new Mercado("2", "Mercadão do anão", "06/09/2001", "Preço baixo", "89239-780", "Estrada Caminho Curto", "1987", "Rio Bonito (Pirabeiraba)", "Joinville");
        Mercado mercadoTres = new Mercado("3", "Empório do tório", "09/12/2003", "Preço lindo", "89217-190", "Rua Jaú", "1337", "Glória", "Joinville");
        
        // ADD RECEITAS EM PADARIAS
        paoComCarne.addReceita(receitaUm);
        paoComCarne.addReceita(receitaDois);
        paoComCarne.addReceita(receitaTres);
        paoComCarne.addReceita(receitaQuatro);
        paoComCarne.addReceita(receitaCinco);
        flavorTown.addReceita(receitaQuatro);
        flavorTown.addReceita(receitaCinco);
        flavorTown.addReceita(receitaSeis);
        flavorTown.addReceita(receitaUm);
        flavorTown.addReceita(receitaDois);
        paoDoce.addReceita(receitaSete);
        paoDoce.addReceita(receitaOito);
        paoDoce.addReceita(receitaNove);
        paoDoce.addReceita(receitaQuatro);
        paoDoce.addReceita(receitaDois);

        //ADD RECEITAS EM CLIENTE
        clienteUm.addReceita(receitaUm);
        clienteUm.addReceita(receitaDois);
        clienteUm.addReceita(receitaTres);
        clienteUm.addReceita(receitaQuatro);
        clienteUm.addReceita(receitaCinco);
        clienteDois.addReceita(receitaQuatro);
        clienteDois.addReceita(receitaCinco);
        clienteDois.addReceita(receitaSeis);
        clienteDois.addReceita(receitaUm);
        clienteDois.addReceita(receitaDois);
        clienteTres.addReceita(receitaSete);
        clienteTres.addReceita(receitaOito);
        clienteTres.addReceita(receitaNove);
        clienteTres.addReceita(receitaQuatro);
        clienteTres.addReceita(receitaDois);


        System.out.println("\n\n ~~~~~~~~~~ Padarias ~~~~~~~~~~");
        System.out.println(paoComCarne);
        System.out.println(flavorTown);
        System.out.println(paoDoce);
        System.out.println("\n\n ~~~~~~~~~~ Mercados ~~~~~~~~~~");
        System.out.println(mercadoUm);
        System.out.println(mercadoDois);
        System.out.println(mercadoTres);
        System.out.println("\n\n ~~~~~~~~~~ Chefs ~~~~~~~~~~");
        System.out.println(chefUm);
        System.out.println(chefDois);
        System.out.println(chefTres);
        System.out.println("\n\n ~~~~~~~~~~ Clientes ~~~~~~~~~~");
        System.out.println(clienteUm);
        System.out.println(clienteDois);
        System.out.println(clienteTres);
    }
}
