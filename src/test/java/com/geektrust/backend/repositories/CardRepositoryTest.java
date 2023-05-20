package com.geektrust.backend.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.geektrust.backend.models.Card;
import com.geektrust.backend.repositories.CardRepository;
import com.geektrust.backend.repositories.CardRepositoryImpl;

@DisplayName("App Test")
class CardRepositoryTest {

    CardRepository cardRepository;
    Card card;
    @BeforeEach                                         
    void setUp() {
        cardRepository = new CardRepositoryImpl();
        card = new Card("AB1", 100);
        cardRepository.save(card);
    }

    @Test
    public void save() throws Exception{
        assertEquals(cardRepository.getByCardNumber("AB1"), card);
    }

    @Test
    public void delete() throws Exception{
        cardRepository.delete(card);
        assertNull(cardRepository.getByCardNumber("AB1"));
    }

    @Test
    void containsCardNumber() {
        assertTrue(cardRepository.containsCardNumber(card.getCardNumber()));
    }

    @Test
    void getByCardNumber() {
        assertEquals(cardRepository.getByCardNumber(card.getCardNumber()),card);
    }

}
