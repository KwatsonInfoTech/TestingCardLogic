package com.adam.testingcardlogic

import org.junit.Assert.*
import org.junit.Test

class CardValidationTest {

    val cardValidation = CardValidation()

    @Test
    fun `Check the card for its valid state`() { //only available unit test
        val sampleCard = "3796-1231-3426-0624"  // AMEX
        val sampleCard2 = "1111-1231-3426-0624" // ALFA
        val sampleExpiryDate = "06/24"

        val result = cardValidation.validate(sampleCard, sampleExpiryDate)
        val result2 = cardValidation.validate(sampleCard2, sampleExpiryDate)

        assertTrue(result)
        assertTrue(result2)
    }

    @Test
    fun `Check the card for its invalid state`() { //only available unit test
        val sampleCard = "1234-1231-3426-0321"
//        val sampleCard = "1234--3426-0321"
//        val sampleCard = "1234dd-3426-0321"
//        val sampleCard = "1234-0321"
        val sampleExpiryDate = "06/24"

        val result = cardValidation.validate(sampleCard, sampleExpiryDate)

        assertFalse(result)
    }

    @Test
    fun `verify the date is valid within a CARD`() {
        val sampleCard = "1234-1231-3426-0624"
        val sampleExpiryDate = "06/24"

        assertTrue(cardValidation.validateDate(sampleExpiryDate, sampleCard))
    }

    @Test
    fun `verify the date is invalid within a CARD`() {
        val sampleCard = "1234-1231-3426-0224"
        val sampleExpiryDate = "06/24"
//        val sampleExpiryDate = "024"
//        val sampleExpiryDate = "0/4"
//        val sampleExpiryDate = "13/19"
//        val sampleExpiryDate = "06/18"

        assertFalse(cardValidation.validateDate(sampleExpiryDate, sampleCard))
    }

    @Test
    fun `very that card is not null or empty`(){
        val sampleCard = "1234-1231-3426-0224"
        val falseCard = ""

        assertTrue(cardValidation.detailsValidator(sampleCard))
        assertFalse(cardValidation.detailsValidator(falseCard))


    }
    @Test
    fun`check for valid card length`(){
        val sampleCard = "1234-1231-3426-0224"
        val badCard = "1234-123331-342644-02b24"
        assertTrue(cardValidation.validateValidCardLength(sampleCard))
        assertFalse(cardValidation.validateValidCardLength(badCard))


    }

    @Test
    fun `check if card contains letters`(){
        val sampleCard = "1234-1231-3426-0224"
        val badCard = "1234-123331-342644-02b24"
        assertTrue(cardValidation.lettersCheck(sampleCard))
        assertFalse(cardValidation.lettersCheck(badCard))

    }


}