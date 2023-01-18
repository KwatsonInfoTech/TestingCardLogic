package com.adam.testingcardlogic

import android.util.Log
import androidx.core.text.isDigitsOnly

class CardValidation {
    /*
    * ACME 1121
    * ALFA 1111
    * AMEX 3796
    *
    * -> 1121-0000-0000-0312  -- Expiry Date (03/12)
    * -> First 4 digit represent company
    * -> Last 4 digit represent expiry date
    *
    *
    * */

    /*
    * - Chiril -> handle null or empty / Card Length / Expiry date is already gone
    * - Felix -> Check if the card number is in right pairs of 4
    * - Priyanka -> same as Aren
    * - Aren -> Improve test cases to verify all cases
    * - Kevon -> same Chiril
    * */

    val ACME = "1121"
    val ALFA = "1111"
    val AMEX = "3796"

    fun validate(
        card: String,
        expiryDate: String
    ) = if (
        card.take(4) == ACME
        || card.take(4) == ALFA
        || card.take(4) == AMEX
    ) {
        detailsValidator(card)
        lettersCheck(card)
        validateValidCardLength(card)
        validateDate(expiryDate, card)
    } else {
        false
    }


    // TDD
    fun validateDate(expiryDate: String, card: String) =
        expiryDate.replace("/", "") == card.takeLast(4)

    fun detailsValidator(card: String) = card != null && card.isNotEmpty()
    fun validateValidCardLength(card: String) = card.replace("-", "").length == 16
    fun lettersCheck(card: String) = card.replace("-", "").all{ chars -> chars.isDigit()}






    fun detailsValidator2(card: String):Boolean{
        var result = false
        if(card.isNotEmpty()){
            // card length  valid
            card.replace("-","")
            card.take(card.length)
            if (card.length == 16){

                if (card.isDigitsOnly()){
                    card.replace("....".toRegex(),"-")
                    card.dropLast(1)
                    println(card)
                    return true
                }

            }

        }
        return false

    }

}



/*
parse the long card number into fuction that will check if its all digits
1. replace the "-" with ""
2. do the check
3. returns true of false -> if false is returned the the validate method will return error,
    before having the chance to check the card type ( doesnt matter what the type is if card not valid)
4. parser method can also check the length of the string also to make sure its valid

-> use isNotEmpty() & isNotBlack()
-> check if string contains only digits ( remove the"-" and replace with ""
-> check string length
 */