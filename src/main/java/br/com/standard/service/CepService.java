package br.com.standard.service;

import java.io.IOException;
import com.google.gson.Gson;
import br.com.standard.dto.CepDTO;
import br.com.standard.util.HttpUtil;


public class CepService {
	
	private final String VIA_CEP_URL = "https://viacep.com.br/ws/%s/json/";
	
	private Gson gson = new Gson();
	
	public CepDTO buscarCep(String cep) throws IOException {
	
		String url = HttpUtil.get(String.format(VIA_CEP_URL, cep));
		
		return gson.fromJson(url, CepDTO.class);
		
	}
	
}
