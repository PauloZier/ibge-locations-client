package br.com.standard.adapter;

import java.util.ArrayList;
import java.util.List;
import br.com.standard.dto.RegiaoDTO;
import br.com.standard.entity.Regiao;

public class RegiaoAdapter {

	public Regiao adapt(RegiaoDTO dto) {
		
		if (dto != null) {
		
			Regiao regiao = new Regiao();
			
			regiao.setId(dto.getId());
			regiao.setNome(dto.getNome());
			regiao.setSigla(dto.getSigla());
			
			return regiao;
		}
		
		return null;
	}
	
	public List<Regiao> adaptAll(List<RegiaoDTO> dtos) {
		
		List<Regiao> regioes = new ArrayList<Regiao>();
		
		if (dtos != null)
			dtos.forEach(x -> regioes.add(adapt(x)));
			
		return regioes;
	}
}
