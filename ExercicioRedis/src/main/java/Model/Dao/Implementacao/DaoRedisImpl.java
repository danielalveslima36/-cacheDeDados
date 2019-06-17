package Model.Dao.Implementacao;

import Model.Dao.Interfaces.DaoBanco;
import Model.Publicacao;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

public class DaoRedisImpl implements DaoBanco {

    @Override
    public Publicacao buscar(String id) {
        Jedis jedis = new Jedis();

        String publicacaoJson = jedis.get(id);

        if (publicacaoJson != null){
            Gson gson = new Gson();

            Publicacao publicacao = gson.fromJson(publicacaoJson, Publicacao.class);
            return publicacao;
        }
        return null;
    }

    @Override
    public void salvar(Publicacao publicacao) {

        Jedis jedis = new Jedis();
        Gson gson = new Gson();

        String publicacaoJson = gson.toJson(publicacao);

        jedis.setex(publicacao.getId(), 3600, publicacaoJson);

    }
}
