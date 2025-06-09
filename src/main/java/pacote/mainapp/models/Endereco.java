package pacote.mainapp.models;

/**
 * Representa um endereço com seus atributos básicos.
 * Inclui logradouro, número, complemento, cidade, estado e CEP.
 */
public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;

    /**
     * Construtor para criar um endereço completo.
     *
     * @param logradouro Logradouro do endereço
     * @param numero Número do imóvel
     * @param complemento Complemento do endereço (se houver)
     * @param cidade Cidade do endereço
     * @param estado Estado do endereço
     * @param cep Código postal (CEP) do endereço
     */
    public Endereco(String logradouro, String numero, String complemento,
                    String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    /** @return O logradouro do endereço */
    public String getLogradouro() { return logradouro; }

    /** Define o logradouro do endereço. */
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    /** @return O número do imóvel */
    public String getNumero() { return numero; }

    /** Define o número do imóvel */
    public void setNumero(String numero) { this.numero = numero; }

    /** @return O complemento do endereço */
    public String getComplemento() { return complemento; }

    /** Define o complemento do endereço */
    public void setComplemento(String complemento) { this.complemento = complemento; }

    /** @return A cidade do endereço */
    public String getCidade() { return cidade; }

    /** Define a cidade do endereço */
    public void setCidade(String cidade) { this.cidade = cidade; }

    /** @return O estado do endereço */
    public String getEstado() { return estado; }

    /** Define o estado do endereço */
    public void setEstado(String estado) { this.estado = estado; }

    /** @return O CEP do endereço */
    public String getCep() { return cep; }

    /** Define o CEP do endereço */
    public void setCep(String cep) { this.cep = cep; }
}
