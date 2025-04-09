package jlin2.examples.localtesting

import org.junit.Assert.*
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun validEmail_isCorrect() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

    @Test
    fun validSubdomainEmail_isCorrect() {
        assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }

    @Test
    fun invalidEmail_missingDomain() {
        assertFalse(EmailValidator.isValidEmail("123@abc"))
    }

    @Test
    fun invalidEmail_doubleDots() {
        assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }

    @Test
    fun invalidEmail_noUsername() {
        assertFalse(EmailValidator.isValidEmail("@abc.com"))
    }

    @Test
    fun invalidEmail_noDomain() {
        assertFalse(EmailValidator.isValidEmail("testing123"))
    }

    @Test
    fun invalidEmail_emptyString() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun invalidEmail_null() {
        assertFalse(EmailValidator.isValidEmail(null))
    }
}
