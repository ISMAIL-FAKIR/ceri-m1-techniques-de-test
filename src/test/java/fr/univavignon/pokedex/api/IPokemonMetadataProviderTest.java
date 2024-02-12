package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        when(metadataProvider.getPokemonMetadata(1)).thenReturn(new PokemonMetadata(1, "Bulbasaur", 50, 50, 50));

        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(1);

        assertNotNull(metadata);
        assertEquals(1, metadata.getIndex());
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(50, metadata.getAttack());
        assertEquals(50, metadata.getDefense());
        assertEquals(50, metadata.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        // Test de l'exception pour un index invalide
        when(metadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalid index"));

        metadataProvider.getPokemonMetadata(-1);
    }

}

