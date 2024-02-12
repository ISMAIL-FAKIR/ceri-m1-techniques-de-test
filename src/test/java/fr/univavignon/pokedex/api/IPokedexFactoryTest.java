package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedex samplePokedex;

    @Before
    public void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        
        // Initialisez un IPokedex de test
        samplePokedex = mock(IPokedex.class);
    }

    @Test
    public void testCreatePokedex() {
        // Création d'un IPokedex
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory))
            .thenReturn(samplePokedex);

        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(createdPokedex);
        assertEquals(samplePokedex, createdPokedex);
    }


}
