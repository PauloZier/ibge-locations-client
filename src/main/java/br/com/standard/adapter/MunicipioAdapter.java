package br.com.standard.adapter;

import java.util.ArrayList;
import java.util.List;
import br.com.standard.dto.MunicipioDTO;
import br.com.standard.entity.Municipio;

public class MunicipioAdapter {

	private MicrorregiaoAdapter microrregiaoAdapter = new MicrorregiaoAdapter();
	
	public Municipio adapt(MunicipioDTO dto) {
		
		if (dto != null) {
			
			Municipio municipio = new Municipio();
			
			municipio.setId(dto.getId());
			municipio.setNome(dto.getNome());
			municipio.setMicrorregiao(microrregiaoAdapter.adapt(dto.getMicrorregiao()));
			
			return municipio;
		}
		
		return null;
	}
	
	public List<Municipio> adaptAll(List<MunicipioDTO> dtos) {
		
		List<Municipio> municipios = new ArrayList<Municipio>();
		
		if (dtos != null)
			dtos.forEach(x -> municipios.add(adapt(x)));
			
		return municipios;
	}
}
