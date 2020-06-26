package br.com.standard.adapter;

import java.util.ArrayList;
import java.util.List;
import br.com.standard.dto.MesorregiaoDTO;
import br.com.standard.entity.Mesorregiao;


public class MesorregiaoAdapter {

	private UfAdapter ufAdapter = new UfAdapter();
	
	public Mesorregiao adapt(MesorregiaoDTO dto) {
		
		if (dto != null) {
			
			Mesorregiao mesorregiao = new Mesorregiao();
			
			mesorregiao.setId(dto.getId());
			mesorregiao.setNome(dto.getNome());
			mesorregiao.setUf(ufAdapter.adapt(dto.getUf()));
			
			return mesorregiao;
		}
		
		return null;
	}
	
	public List<Mesorregiao> adaptAll(List<MesorregiaoDTO> dtos) {
		
		List<Mesorregiao> mesorregioes = new ArrayList<Mesorregiao>();
		
		if (dtos != null)
			dtos.forEach(x -> mesorregioes.add(adapt(x)));
		
		return mesorregioes;
	}
}
