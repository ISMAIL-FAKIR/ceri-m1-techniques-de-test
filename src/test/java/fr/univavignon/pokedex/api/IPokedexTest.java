package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon samplePokemon;

    @Before
    public void setUp() {
        pokedex = mock(IPokedex.class);
        samplePokemon = new Pokemon(1, "Bulbasaur", 50, 50, 50, 100, 80, 200, 10, 90.0);
    }

    @Test
    public void testSize() {
        when(pokedex.size()).thenReturn(5);

        assertEquals(5, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        when(pokedex.addPokemon(samplePokemon)).thenReturn(1);

        int index = pokedex.addPokemon(samplePokemon);

        assertEquals(1, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        when(pokedex.getPokemon(1)).thenReturn(samplePokemon);

        Pokemon retrievedPokemon = pokedex.getPokemon(1);

        assertNotNull(retrievedPokemon);
        assertEquals(1, retrievedPokemon.getIndex());
        assertEquals("Bulbasaur", retrievedPokemon.getName());
    }



}
