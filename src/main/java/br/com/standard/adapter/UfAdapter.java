package br.com.standard.adapter;

import java.util.ArrayList;
import java.util.List;
import br.com.standard.dto.UfDTO;
import br.com.standard.entity.Uf;

public class UfAdapter {

	private RegiaoAdapter regiaoAdapter = new RegiaoAdapter();
	
	public Uf adapt(UfDTO dto) {
		
		if (dto != null) {
			
			Uf uf = new Uf();
			
			uf.setId(dto.getId());
			uf.setSigla(dto.getSigla());
			uf.setNome(dto.getNome());
			uf.setRegiao(regiaoAdapter.adapt(dto.getRegiao()));
			
			return uf;
		}
		
		return null;
	}
	
	public List<Uf> adaptAll(List<UfDTO> dtos) {
		
		List<Uf> ufs = new ArrayList<Uf>();
		
		if (dtos != null) 
			dtos.forEach(x -> ufs.add(adapt(x)));
		
		return ufs;
	}
}
