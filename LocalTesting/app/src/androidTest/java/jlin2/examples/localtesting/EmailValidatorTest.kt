package jlin2.examples.localtesting
import org.junit.Test
import org.junit.Assert.*

class EmailValidatorTest {
    @Test
    fun testValidEmail() {
        val validEmail = "123@abc.com" // A valid email address
        assertTrue(EmailValidator.isValidEmail(validEmail)) // Assert that it should be valid
    }

    @Test
    fun testValidEmailWithSubdomain() {
        val validEmailWithSubdomain = "123@abc.co.ca" // Another valid email address with a subdomain
        assertTrue(EmailValidator.isValidEmail(validEmailWithSubdomain)) // Assert that it should be valid
    }


    @Test
    fun testInvalidEmailIncorrectDomain() {
        val invalidEmail = "123@abc" // Missing top-level domain (.com, .net, etc.)
        assertFalse(EmailValidator.isValidEmail(invalidEmail)) // Assert that it should be invalid
    }


    @Test
    fun testInvalidEmailWithDoubleDots() {
        val invalidEmail = "123@abc..com" // Double dots between domain parts
        assertFalse(EmailValidator.isValidEmail(invalidEmail)) // Assert that it should be invalid
    }

    @Test
    fun testInvalidEmailWithoutUsername() {
        val invalidEmail = "@abc.com" // No username part before the '@'
        assertFalse(EmailValidator.isValidEmail(invalidEmail)) // Assert that it should be invalid
    }

    @Test
    fun testInvalidEmailWithoutDomain() {
        val invalidEmail = "testing123" // No domain part after the '@'
        assertFalse(EmailValidator.isValidEmail(invalidEmail)) // Assert that it should be invalid
    }

    @Test
    fun testInvalidEmailEmptyString() {
        val emptyEmail = "" // An empty email address
        assertFalse(EmailValidator.isValidEmail(emptyEmail)) // Assert that it should be invalid
    }

    @Test
    fun testInvalidEmailNull() {
        assertFalse(EmailValidator.isValidEmail(null)) // Assert that null should be considered invalid
    }
}