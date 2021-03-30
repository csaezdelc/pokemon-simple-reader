package cl.uv.ici.arq.labs.main;

import java.util.List;

import cl.uv.ici.arq.labs.dtos.Pokemon;
import cl.uv.ici.arq.labs.service.PokemonService;
import cl.uv.ici.arq.labs.service.impl.PokemonServiceImpl;

public class Main {

	public static void main(String[] args) {

		PokemonService pokemonService = new PokemonServiceImpl();
		List<Pokemon> pokeList=pokemonService.getListPokemon("Pokemon-dataset.txt");
		
		pokeList.stream().forEach((poke) -> {
			System.out.println(poke.toString());
		});
		

	}
	

}
