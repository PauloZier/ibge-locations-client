package br.com.standard.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import br.com.standard.adapter.MesorregiaoAdapter;
import br.com.standard.adapter.MicrorregiaoAdapter;
import br.com.standard.adapter.MunicipioAdapter;
import br.com.standard.adapter.RegiaoAdapter;
import br.com.standard.adapter.UfAdapter;
import br.com.standard.dto.DistritoDTO;
import br.com.standard.dto.MesorregiaoDTO;
import br.com.standard.dto.MicrorregiaoDTO;
import br.com.standard.dto.MunicipioDTO;
import br.com.standard.dto.RegiaoDTO;
import br.com.standard.dto.UfDTO;
import br.com.standard.entity.Mesorregiao;
import br.com.standard.entity.Microrregiao;
import br.com.standard.entity.Municipio;
import br.com.standard.entity.Regiao;
import br.com.standard.entity.Uf;
import br.com.standard.util.HibernateUtil;
import br.com.standard.util.HttpUtil;

	
public class MunicipioService {

	private final String IBGE_URL_DISTRITOS = "https://servicodados.ibge.gov.br/api/v1/localidades/distritos";

	private final String IBGE_URL_MUNICIPIOS = "https://servicodados.ibge.gov.br/api/v1/localidades/municipios";

	private final String IBGE_URL_REGIOES = "https://servicodados.ibge.gov.br/api/v1/localidades/regioes";

	private final String IBGE_URL_ESTADOS = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";

	private final String IBGE_URL_MESORREGIOES = "https://servicodados.ibge.gov.br/api/v1/localidades/Mesorregioes";

	private final String IBGE_URL_MICRORREGIOES = "http://servicodados.ibge.gov.br/api/v1/localidades/Microrregioes";

	private Gson gson = new Gson();

	public List<DistritoDTO> buscarDistritos() throws IOException {

		DistritoDTO[] distritos = gson.fromJson(HttpUtil.get(IBGE_URL_DISTRITOS), DistritoDTO[].class);

		return Arrays.asList(distritos);
	}

	public List<MunicipioDTO> buscarMunicipiosDTO() throws IOException {

		MunicipioDTO[] municipios = gson.fromJson(HttpUtil.get(IBGE_URL_MUNICIPIOS), MunicipioDTO[].class);

		return Arrays.asList(municipios);
	}

	public List<Municipio> buscarMunicipios() throws IOException {

		return new MunicipioAdapter().adaptAll(this.buscarMunicipiosDTO());

	}

	public List<RegiaoDTO> buscarRegioesDTO() throws JsonSyntaxException, IOException {

		RegiaoDTO[] regioes = gson.fromJson(HttpUtil.get(IBGE_URL_REGIOES), RegiaoDTO[].class);

		return Arrays.asList(regioes);
	}

	public List<Regiao> buscarRegioes() throws IOException {

		return new RegiaoAdapter().adaptAll(buscarRegioesDTO());
	}

	public List<UfDTO> buscarUfsDTO() throws IOException {

		UfDTO[] ufs = gson.fromJson(HttpUtil.get(IBGE_URL_ESTADOS), UfDTO[].class);

		return Arrays.asList(ufs);
	}

	public List<Uf> buscarUfs() throws IOException {

		return new UfAdapter().adaptAll(buscarUfsDTO());
	}

	public List<MesorregiaoDTO> buscarMesorregioesDTOs() throws IOException {

		MesorregiaoDTO[] mesorregioes = gson.fromJson(HttpUtil.get(IBGE_URL_MESORREGIOES), MesorregiaoDTO[].class);

		return Arrays.asList(mesorregioes);
	}

	public List<Mesorregiao> buscarMesorregioes() throws IOException {

		return new MesorregiaoAdapter().adaptAll(buscarMesorregioesDTOs());
	}

	public List<MicrorregiaoDTO> buscarMicrorregioesDTOs() throws IOException {

		MicrorregiaoDTO[] microrregioes = gson.fromJson(HttpUtil.get(IBGE_URL_MICRORREGIOES), MicrorregiaoDTO[].class);

		return Arrays.asList(microrregioes);
	}

	public List<Microrregiao> buscarMicrorregioes() throws IOException {

		return new MicrorregiaoAdapter().adaptAll(buscarMicrorregioesDTOs());
	}

	public Boolean importToDatabase() throws Exception {

		return importToDatabase(HibernateUtil.getEntityManager());

	}

	public Boolean importToDatabase(EntityManager entityManager) throws Exception {

		try {

			this.salvarMunicipios(entityManager);

			return true;

		} catch (Exception ex) {

			ex.printStackTrace();

			throw ex;

		}

	}

	private Boolean salvarMunicipios(EntityManager entityManager) throws Exception {

		List<Municipio> municipios = this.buscarMunicipios();

		try {

			municipios.forEach(x -> {

				save(entityManager, x);

			});

			return true;

		} catch (Exception ex) {

			throw ex;

		}

	}

	public <T> void save(EntityManager entityManager, T t) {

		try {

			entityManager.getTransaction().begin();

			entityManager.merge(t);

			entityManager.getTransaction().commit();

		} catch (Exception ex) {

			entityManager.getTransaction().rollback();

			throw ex;
		}

	}
}
