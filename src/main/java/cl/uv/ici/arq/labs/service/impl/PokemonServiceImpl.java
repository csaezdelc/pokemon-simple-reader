/**
 * 
 */
package cl.uv.ici.arq.labs.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import cl.uv.ici.arq.labs.dtos.Pokemon;
import cl.uv.ici.arq.labs.dtos.Type;
import cl.uv.ici.arq.labs.service.PokemonService;

/**
 * @author c.saez.del.canto
 *
 */
public class PokemonServiceImpl implements PokemonService {

	private Map<String, Type> getMapTypes(String fileName) {
		Map<String, Type> types = new HashMap<String, Type>();

		BufferedReader reader;
		String line = "";
		StringTokenizer stk = null;

		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream(fileName);

			reader = new BufferedReader(new InputStreamReader(is));
			reader.readLine();
			line = reader.readLine().replace("\t", " ");

			while (!line.contains("pokemons")) {
				
				if (line.length() > 0) {
					stk = new StringTokenizer(line, " ");
					Type pokemonType = new Type();
					pokemonType.setSpanish(stk.nextToken());
					pokemonType.setEnglish(stk.nextToken().replaceAll("\\(|\\)",""));
					pokemonType.setKey(stk.nextToken());
					types.put(pokemonType.getKey().toUpperCase(), pokemonType);
				}
				line = reader.readLine().replace("\t", " ");
			}
			reader.close();
			is.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return types;
	}

	public List<Pokemon> getListPokemon(String fileName) {

		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		Map<String, Type> types = this.getMapTypes(fileName);

		for (Map.Entry<String, Type> entry : types.entrySet()) {
			System.out.println(entry.getKey() + "/" + entry.getValue().toString());
		}
		
		BufferedReader reader;
		String line = "";
		StringTokenizer stk = null;
		
		
		
		
		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream(fileName);

			reader = new BufferedReader(new InputStreamReader(is));
			
			line=reader.readLine();

			while (!line.contains("pokemons")) {
				line=reader.readLine();			
			}
			reader.readLine();
			
			String key=null;
			
			while ((line = reader.readLine()) != null) {	
				if (line.length() > 0) {
					line=line.replace("\t", " ");
					stk = new StringTokenizer(line, " ");
					Pokemon pokemon= new Pokemon();
					pokemon.setPokedex(Integer.valueOf(stk.nextToken()));
					pokemon.setName(stk.nextToken());
					stk.nextToken();
					
					while (stk.hasMoreTokens()) {
						System.out.println(line);
						key=stk.nextToken().toUpperCase();
						if(key.length()==2)
						{pokemon.getTypes().add(types.get(key));}
					}
					
					pokemonList.add(pokemon);
					
				}
				
			}
			reader.close();
			is.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		return pokemonList;
	}

}
