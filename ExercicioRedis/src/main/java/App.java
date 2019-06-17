import Model.Dao.Implementacao.DaoPostgreImpl;
import Model.Dao.Implementacao.DaoRedisImpl;
import Model.Publicacao;

import java.sql.Timestamp;
import java.time.Instant;

public class App {
    public static void main(String[] args) {
        DaoPostgreImpl daoPostgre = new DaoPostgreImpl();
        DaoRedisImpl daoRedis = new DaoRedisImpl();

        // Criação da publicação e escrita no banco de dados Postgre
        daoPostgre.salvar(new Publicacao(
                "",
                "I'm impressed with this crowd. Damn Brazil. You are such an amazing crowd.",
                Timestamp.from(Instant.now()),
                1
        ));

        // ID da publicação a ser buscada
        String publicacaoID = "156070851";

        //Publicação sendo buscada no banco Redis a partir do ID
       Publicacao publicacao = daoRedis.buscar(publicacaoID);

       //Verifica se a publicação retornada pelo busca no banco Redis existe
        if (publicacao != null){
            //Caso exista, a publicação é retornada
            System.out.println(publicacao.toString());
        }else{
            //Caso não exista, a publicação é buscada no banco Postgre
            publicacao = daoPostgre.buscar(publicacaoID);

            //Salva a publicação no Redis por 1 hora
            daoRedis.salvar(publicacao);

            //Apresenta ao usuario a publicação
            System.out.println(publicacao.toString());
        }
    }
}