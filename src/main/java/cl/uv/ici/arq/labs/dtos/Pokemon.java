package cl.uv.ici.arq.labs.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Pokemon {

	private Integer pokedex;
	private String name;
	private List<Type> types= new ArrayList<Type>();
	
}