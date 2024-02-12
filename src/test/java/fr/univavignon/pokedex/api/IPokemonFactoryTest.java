package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {
        when(pokemonFactory.createPokemon(1, 100, 80, 200, 10))
            .thenReturn(new Pokemon(1, "Bulbasaur", 50, 50, 50, 100, 80, 200, 10, 90.0));

        Pokemon createdPokemon = pokemonFactory.createPokemon(1, 100, 80, 200, 10);

        assertNotNull(createdPokemon);
        assertEquals(1, createdPokemon.getIndex());
        assertEquals("Bulbasaur", createdPokemon.getName());
        assertEquals(100, createdPokemon.getCp());
        assertEquals(80, createdPokemon.getHp());
        assertEquals(200, createdPokemon.getDust());
        assertEquals(10, createdPokemon.getCandy());
        assertEquals(90.0, createdPokemon.getIv(), 0.01);
    }

}
