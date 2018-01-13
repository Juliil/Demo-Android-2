package com.itm.mobile.dados.ormlite.model;

import com.google.gson.annotations.SerializedName;
import com.itm.mobile.voto.R;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@DatabaseTable(tableName="TB_USUARIO")
public class Usuario implements Serializable {

    public final static String ID = "id";
    public final static String NOME = "nome";
    public final static String ENDERECO = "endereco";
    public final static String BAIRRO = "bairro";
    public final static String CPF = "cpf";
    public final static String DOC_NO = "doc_no";
    public final static String DOC_TIPO = "doc_tipo";
    public final static String DOC_ORG_EXP = "doc_org_exp";
    public final static String EST_CIVIL = "est_civil";
    public final static String EMAIL = "email";
    public final static String TELEFONE = "telefone";
    public final static String CELULAR = "celular";
    public final static String LOGIN = "login";
    public final static String SENHA = "senha";
    public final static String USER_CATEG = "user_categ";
    public final static String SEXO = "sexo";
    public final static String TITULO_NO = "titulo_no";
    public final static String STATUS = "status";
    public final static String CIDADE = "cidade";
    public final static String UF = "uf";
    public final static String CEP = "cep";

    public final static int CATEG_AGENTE = 0;
    public final static int CATEG_LIDER = 1;
    public final static int CATEG_CORDENADOR = 2;
    public final static int CATEG_ADMIN = 3;

    @SerializedName("id")
    @DatabaseField(generatedId = true)
    private UUID id;
    @SerializedName("webid")
    @DatabaseField(canBeNull = true)
    String webid;
    @SerializedName("nome")
    @DatabaseField(canBeNull = false)
    String nome;
    @SerializedName("endereco")
    @DatabaseField(canBeNull = true)
    String endereco;
    @SerializedName("bairro")
    @DatabaseField(canBeNull = true)
    String bairro;
    @SerializedName("cpf")
    @DatabaseField(canBeNull = true)
    String cpf;
    @SerializedName("doc_no")
    @DatabaseField(canBeNull = true)
    String doc_no;
    @SerializedName("doc_tipo")
    @DatabaseField(canBeNull = true)
    String doc_tipo;
    @SerializedName("doc_org_exp")
    @DatabaseField(canBeNull = true)
    String doc_org_exp;
    @SerializedName("est_civil")
    @DatabaseField(canBeNull = true)
    int est_civil;
    @SerializedName("email")
    @DatabaseField(canBeNull = true)
    String email;
    @SerializedName("telefone")
    @DatabaseField(canBeNull = true)
    String telefone;
    @SerializedName("celular")
    @DatabaseField(canBeNull = true)
    String celular;
    @SerializedName("login")
    @DatabaseField(canBeNull = false, unique = true)
    String login;
    @SerializedName("senha")
    @DatabaseField(canBeNull = false)
    String senha;
    @SerializedName("user_categ")
    @DatabaseField(canBeNull = false)
    int user_categ;
    @SerializedName("sexo")
    @DatabaseField(canBeNull = true)
    int sexo;
    @SerializedName("titulo_no")
    @DatabaseField(canBeNull = true)
    int titulo_no;
    @SerializedName("status")
    @DatabaseField(canBeNull = true)
    int status;
    @SerializedName("avatar")
    @DatabaseField(canBeNull = true)
    String avatar;
    @SerializedName("cidade")
    @DatabaseField(canBeNull = true)
    int cidade;
    @SerializedName("uf")
    @DatabaseField(canBeNull = true)
    int uf;
    @SerializedName("cep")
    @DatabaseField(canBeNull = true)
    String cep;

    public Usuario(){
    }

    public Usuario(String webid, String nome, String endereco, String bairro, String cpf, String doc_no,
                   String doc_tipo, String doc_org_exp, int est_civil, String email, String telefone,
                   String celular, String login, String senha, int user_categ, int sexo, int titulo_no,
                   int status, String avatar, int cidade, int uf, String cep) {
        this.webid = webid;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cpf = cpf;
        this.doc_no = doc_no;
        this.doc_tipo = doc_tipo;
        this.doc_org_exp = doc_org_exp;
        this.est_civil = est_civil;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.login = login;
        this.senha = senha;
        this.user_categ = user_categ;
        this.sexo = sexo;
        this.titulo_no = titulo_no;
        this.status = status;
        this.avatar = avatar;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public Usuario(String nome, String endereco, String bairro, String cpf, String email, String login,
                   String senha, int user_categ, int sexo, int status) {
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.user_categ = user_categ;
        this.sexo = sexo;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWebid() {
        return webid;
    }

    public void setWebid(String webid) {
        this.webid = webid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDoc_no() {
        return doc_no;
    }

    public void setDoc_no(String doc_no) {
        this.doc_no = doc_no;
    }

    public String getDoc_tipo() {
        return doc_tipo;
    }

    public void setDoc_tipo(String doc_tipo) {
        this.doc_tipo = doc_tipo;
    }

    public String getDoc_org_exp() {
        return doc_org_exp;
    }

    public void setDoc_org_exp(String doc_org_exp) {
        this.doc_org_exp = doc_org_exp;
    }

    public int getEst_civil() {
        return est_civil;
    }

    public void setEst_civil(int est_civil) {
        this.est_civil = est_civil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getUser_categ() {
        return user_categ;
    }

    public void setUser_categ(int user_categ) {
        this.user_categ = user_categ;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getTitulo_no() {
        return titulo_no;
    }

    public void setTitulo_no(int titulo_no) {
        this.titulo_no = titulo_no;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    public int getUf() {
        return uf;
    }

    public void setUf(int uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<?> populateCateg(){
        List<Usuario> list  = new ArrayList<>();
        //Usuario(String login, String senha, Integer categ, Date dt_reg, String name, String email, int avatar, String sexo)
        //list.add(new Usuario("administracao@condominio.com", "", Usuario.CATEG_ADMIN, new Date(), "Administração do Condomínio", "Administração@condominio.com.br", R.drawable.img_empty_man_avatar_64dp, "M"));

        return list;
    }
}
