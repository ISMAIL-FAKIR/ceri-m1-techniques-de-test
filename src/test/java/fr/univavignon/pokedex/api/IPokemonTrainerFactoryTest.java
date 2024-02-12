package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;
    private PokemonTrainer sampleTrainer;

    @Before
    public void setUp() {
        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
        
        // Initialisez un PokemonTrainer de test
        sampleTrainer = new PokemonTrainer("Ash", Team.MYSTIC, mock(IPokedex.class));
    }

    @Test
    public void testCreateTrainer() {
        // Création d'un PokemonTrainer
        when(trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory))
            .thenReturn(sampleTrainer);

        PokemonTrainer createdTrainer = trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory);

        assertNotNull(createdTrainer);
        assertEquals("Ash", createdTrainer.getName());
        assertEquals(Team.MYSTIC, createdTrainer.getTeam());
    }


}


