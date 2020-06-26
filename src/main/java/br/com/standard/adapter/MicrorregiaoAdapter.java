package br.com.standard.adapter;

import java.util.ArrayList;
import java.util.List;
import br.com.standard.dto.MicrorregiaoDTO;
import br.com.standard.entity.Microrregiao;

public class MicrorregiaoAdapter {

	private MesorregiaoAdapter mesorregiaoAdapter = new MesorregiaoAdapter();
	
	public Microrregiao adapt(MicrorregiaoDTO dto) {
		
		if (dto != null) {
			
			Microrregiao microrregiao = new Microrregiao();
			
			microrregiao.setId(dto.getId());
			microrregiao.setNome(dto.getNome());
			microrregiao.setMesorregiao(mesorregiaoAdapter.adapt(dto.getMesorregiao()));
			
			return microrregiao;
		}
		
		return null;
	}
	
	public List<Microrregiao> adaptAll(List<MicrorregiaoDTO> dtos) {
		
		List<Microrregiao> microrregioes = new ArrayList<Microrregiao>();
		
		if (dtos != null)
			dtos.forEach(x -> microrregioes.add(adapt(x)));
		
		return microrregioes;
	}
}
