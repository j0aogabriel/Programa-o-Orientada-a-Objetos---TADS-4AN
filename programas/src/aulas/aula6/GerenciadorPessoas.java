import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GerenciadorPessoas {

    private final Map<Integer, Pessoa> pessoas;

    public GerenciadorPessoas() {
        this.pessoas = new HashMap<>();
    }

    public boolean cadastrar(int id, Pessoa pessoa) {
        if (pessoas.containsKey(id)) {
            return false;
        }
        pessoas.put(id, pessoa);
        return true;
    }

    public boolean remover(int id) {
        if (pessoas.containsKey(id)) {
            pessoas.remove(id);
            return true;
        }
        return false;
    }

    public Map<Integer, Pessoa> getPessoas() {
        return Collections.unmodifiableMap(pessoas);
    }

    public boolean estaVazio() {
        return pessoas.isEmpty();
    }
}