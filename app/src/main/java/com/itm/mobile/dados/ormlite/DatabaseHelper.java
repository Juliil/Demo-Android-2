package com.itm.mobile.dados.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itm.mobile.dados.ormlite.model.Endereco;
import com.itm.mobile.dados.ormlite.model.Equipe;
import com.itm.mobile.dados.ormlite.model.EquipeMembros;
import com.itm.mobile.dados.ormlite.model.LocalVotacao;
import com.itm.mobile.dados.ormlite.model.Localizacao;
import com.itm.mobile.dados.ormlite.model.MensagemCab;
import com.itm.mobile.dados.ormlite.model.MensagemDet;
import com.itm.mobile.dados.ormlite.model.Municipio;
import com.itm.mobile.dados.ormlite.model.Ocorrencia;
import com.itm.mobile.dados.ormlite.model.OcorrenciaTipo;
import com.itm.mobile.dados.ormlite.model.SecaoEleitoral;
import com.itm.mobile.dados.ormlite.model.Tabelas;
import com.itm.mobile.dados.ormlite.model.Usuario;

import com.itm.mobile.dados.ormlite.model.UsuarioAtividade;
import com.itm.mobile.dados.ormlite.model.ZonaEleitoral;
import com.itm.mobile.dados.ormlite.model.ZonadeAtuacao;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.UUID;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	private static final String databaseName = "voto";
	private static final int databaseVersion = 270909001;
	
	public DatabaseHelper(Context context) {
		super(context, databaseName, null, databaseVersion);
	}
	
	@Override
	public void onCreate(SQLiteDatabase sd, ConnectionSource cs) {
		try {

			TableUtils.createTable(cs, Endereco.class);
			TableUtils.createTable(cs, Equipe.class);
			TableUtils.createTable(cs, EquipeMembros.class);
			TableUtils.createTable(cs, Localizacao.class);
			TableUtils.createTable(cs, LocalVotacao.class);
			TableUtils.createTable(cs, MensagemCab.class);
			TableUtils.createTable(cs, MensagemDet.class);
			TableUtils.createTable(cs, Municipio.class);
			TableUtils.createTable(cs, Ocorrencia.class);
			TableUtils.createTable(cs, OcorrenciaTipo.class);
			TableUtils.createTable(cs, SecaoEleitoral.class);
			TableUtils.createTable(cs, Tabelas.class);
			TableUtils.createTable(cs, Usuario.class);
			TableUtils.createTable(cs, UsuarioAtividade.class);
			TableUtils.createTable(cs, ZonadeAtuacao.class);
			TableUtils.createTable(cs, ZonaEleitoral.class);

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onUpgrade(SQLiteDatabase sd, ConnectionSource cs, int oldVersion, int newVersion) {
		try {

			/*List<String> allSql = new ArrayList<String>();
			switch(oldVersion)
			{
				case 1:
					//allSql.add("altere AdData add column `new_col` VARCHAR");
					//allSql.add("altere AdData add column `new_col2` VARCHAR");
			}
			for (String sql : allSql) {
				db.execSQL(sql);
			}*/


			TableUtils.dropTable(cs, Endereco.class, true);
			TableUtils.dropTable(cs, Equipe.class, true);
			TableUtils.dropTable(cs, EquipeMembros.class, true);
			TableUtils.dropTable(cs, Localizacao.class, true);
			TableUtils.dropTable(cs, LocalVotacao.class, true);
			TableUtils.dropTable(cs, MensagemCab.class, true);
			TableUtils.dropTable(cs, MensagemDet.class, true);
			TableUtils.dropTable(cs, Municipio.class, true);
			TableUtils.dropTable(cs, Ocorrencia.class, true);
			TableUtils.dropTable(cs, OcorrenciaTipo.class, true);
			TableUtils.dropTable(cs, SecaoEleitoral.class, true);
			TableUtils.dropTable(cs, Tabelas.class, true);
			TableUtils.dropTable(cs, Usuario.class, true);
			TableUtils.dropTable(cs, UsuarioAtividade.class, true);
			TableUtils.dropTable(cs, ZonadeAtuacao.class, true);
			TableUtils.dropTable(cs, ZonaEleitoral.class, true);

			onCreate(sd, cs);
		}
		catch(SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "exception during onUpgrade", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void close(){
		super.close();
	}


	private Dao<Endereco, UUID> enderecoDao = null;
	private Dao<Equipe, UUID> equipeDao = null;
	private Dao<EquipeMembros, UUID> equipeMembrosDao = null;
	private Dao<Localizacao, UUID> localizacaoDao = null;
	private Dao<LocalVotacao, UUID> localVotacaoDao = null;
	private Dao<MensagemCab, UUID> mensagemCabDao = null;
	private Dao<MensagemDet, UUID> mensagemDetDao = null;
	private Dao<Municipio, UUID> municipioDao = null;
	private Dao<Ocorrencia, UUID> ocorrenciaDao = null;
	private Dao<OcorrenciaTipo, UUID> ocorrenciaTipoDao = null;
	private Dao<SecaoEleitoral, UUID> secaoEleitoralDao = null;
	private Dao<Tabelas, UUID> tabelasDao = null;
	private Dao<Usuario, UUID> usuarioDao = null;
	private Dao<UsuarioAtividade, UUID> usuarioAtividadeDao = null;
	private Dao<ZonadeAtuacao, UUID> zonadeAtuacaoDao = null;
	private Dao<ZonaEleitoral, UUID> zonaEleitoralDao = null;
	

	/* * Returns the Database Access Object (DAO) for our Questionario class. It will create it or just give the cached
	 * value.
	 **/

	public Dao<Endereco, UUID> getEnderecoDao() throws SQLException {
		if (enderecoDao == null) {
			try {
				enderecoDao = getDao(Endereco.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return enderecoDao;
	}

	public Dao<Equipe, UUID> getEquipeDao() throws SQLException {
		if (equipeDao == null) {
			try {
				equipeDao = getDao(Equipe.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return equipeDao;
	}

	public Dao<EquipeMembros, UUID> getEquipeMembrosDao() throws SQLException {
		if (equipeMembrosDao == null) {
			try {
				equipeMembrosDao = getDao(EquipeMembros.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return equipeMembrosDao;
	}
	
	public Dao<Localizacao, UUID> getLocalizacaoDao() throws SQLException {
		if (localizacaoDao == null) {
			try {
				localizacaoDao = getDao(Localizacao.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return localizacaoDao;
	}

	public Dao<LocalVotacao, UUID> getLocalVotacaoDao() throws SQLException {
		if (localVotacaoDao == null) {
			try {
				localVotacaoDao = getDao(LocalVotacao.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return localVotacaoDao;
	}

	public Dao<MensagemCab, UUID> getMensagemCabDao() throws SQLException {
		if (mensagemCabDao == null) {
			try {
				mensagemCabDao = getDao(MensagemCab.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return mensagemCabDao;
	}

	public Dao<MensagemDet, UUID> getMensagemDetDao() throws SQLException {
		if (mensagemDetDao == null) {
			try {
				mensagemDetDao = getDao(MensagemDet.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return mensagemDetDao;
	}

	public Dao<Municipio, UUID> getMunicipioDao() throws SQLException {
		if (municipioDao == null) {
			try {
				municipioDao = getDao(Municipio.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return municipioDao;
	}

	public Dao<Ocorrencia, UUID> getOcorrenciaDao() throws SQLException {
		if (ocorrenciaDao == null) {
			try {
				ocorrenciaDao = getDao(Ocorrencia.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return ocorrenciaDao;
	}

	public Dao<OcorrenciaTipo, UUID> getOcorrenciaTipoDao() throws SQLException {
		if (ocorrenciaTipoDao == null) {
			try {
				ocorrenciaTipoDao = getDao(OcorrenciaTipo.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return ocorrenciaTipoDao;
	}

	public Dao<SecaoEleitoral, UUID> getSecaoEleitoralDao() throws SQLException {
		if (secaoEleitoralDao == null) {
			try {
				secaoEleitoralDao = getDao(SecaoEleitoral.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return secaoEleitoralDao;
	}

	public Dao<Tabelas, UUID> getTabelasDao() throws SQLException {
		if (tabelasDao == null) {
			try {
				tabelasDao = getDao(Tabelas.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return tabelasDao;
	}

	public Dao<Usuario, UUID> getUsuarioDao() throws SQLException {
		if (usuarioDao == null) {
			try {
				usuarioDao = getDao(Usuario.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return usuarioDao;
	}

	public Dao<UsuarioAtividade, UUID> getUsuarioAtividadeDao() throws SQLException {
		if (usuarioAtividadeDao == null) {
			try {
				usuarioAtividadeDao = getDao(UsuarioAtividade.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return usuarioAtividadeDao;
	}

	public Dao<ZonadeAtuacao, UUID> getZonadeAtuacaoDao() throws SQLException {
		if (zonadeAtuacaoDao == null) {
			try {
				zonadeAtuacaoDao = getDao(ZonadeAtuacao.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return zonadeAtuacaoDao;
	}

	public Dao<ZonaEleitoral, UUID> getZonaEleitoralDao() throws SQLException {
		if (zonaEleitoralDao == null) {
			try {
				zonaEleitoralDao = getDao(ZonaEleitoral.class);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return zonaEleitoralDao;
	}

}
