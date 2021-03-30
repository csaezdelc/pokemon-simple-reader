package cl.uv.ici.arq.labs.service;

import java.util.List;

import cl.uv.ici.arq.labs.dtos.Pokemon;

public interface PokemonService {

	
	public List<Pokemon> getListPokemon(String fileName);
}