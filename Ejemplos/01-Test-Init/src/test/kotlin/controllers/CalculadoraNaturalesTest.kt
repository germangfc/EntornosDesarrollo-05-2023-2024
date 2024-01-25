package controllers

import dev.joseluisgs.controllers.CalculadoraNaturales
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Para que se cree una instancia por clase y no por método
class CalculadoraNaturalesTest {

    val calculadora = CalculadoraNaturales()


    @BeforeAll
    fun setUpAll() {
        println("Antes de todos los test")
    }

    @AfterAll
    fun tearDownAll() {
        println("Después de todos los test")
    }


    @BeforeEach
    fun setUp() {
        println("Antes de cada test")
    }

    @AfterEach
    fun tearDown() {
        println("Después de cada test")
    }

    @Test
    fun sumaOk() {

        // arrange
        val a = 2
        val b = 3

        // act
        val resultado = calculadora.suma(a, b)

        // assert
        Assertions.assertEquals(5, resultado)
    }

    @Test
    fun sumaSiAesMenorACero() {

        // arrange
        val a = -2
        val b = 3

        // act
        val res = assertThrows<IllegalArgumentException> {
            calculadora.suma(a, b)
        }

        // assert
        Assertions.assertEquals("Los números deben ser naturales", res.message)
    }

    @Test
    fun sumaSiBesMenorACero() {

        // arrange
        val a = 2
        val b = -3

        // act
        val res = assertThrows<IllegalArgumentException> {
            calculadora.suma(a, b)
        }

        // assert
        Assertions.assertEquals("Los números deben ser naturales", res.message)
    }

    @Test
    fun restaOk() {

        // arrange
        val a = 3
        val b = 2

        // act
        val resultado = calculadora.resta(a, b)

        // assert
        Assertions.assertEquals(1, resultado)
    }

    @Test
    fun restaSiBesMayorQueA() {
        // arrange
        val a = 3
        val b = 4

        // act
        val res = calculadora.resta(a, b)

        // assert
        Assertions.assertEquals(0, res)
    }

    @Test
    fun restaSiAesMenorACero() {
        // arrange
        val a = -3
        val b = 4

        // act
        val res = assertThrows<IllegalArgumentException> {
            calculadora.resta(a, b)
        }

        // assert
        Assertions.assertEquals("Los números deben ser naturales", res.message)
    }

    @Test
    fun restaSiBesMenorACero() {
        // arrange
        val a = 3
        val b = -4

        // act
        val res = assertThrows<IllegalArgumentException> {
            calculadora.resta(a, b)
        }

        // assert
        Assertions.assertEquals("Los números deben ser naturales", res.message)
    }

    @Test
    fun multiplicacionOk() {

        // arrange
        val a = 3
        val b = 2

        // act
        val resultado = calculadora.multiplicacion(a, b)

        // assert
        Assertions.assertEquals(6, resultado)
    }


    @Test
    fun multiplicacionSiAesMenorACero() {
        // arrange
        val a = -3
        val b = 4

        // act
        val res = assertThrows<IllegalArgumentException> {
            calculadora.multiplicacion(a, b)
        }

        // assert
        Assertions.assertEquals("Los números deben ser naturales", res.message)
    }

    @Test
    fun multiplicacionSiBesMenorACero() {
        // arrange
        val a = 3
        val b = -4

        // act
        val res = assertThrows<IllegalArgumentException> {
            calculadora.multiplicacion(a, b)
        }

        // assert
        Assertions.assertEquals("Los números deben ser naturales", res.message)
    }

    @Test
    fun divisionOk() {

        // arrange
        val a = 6
        val b = 2

        // act
        val resultado = calculadora.division(a, b)

        // assert
        Assertions.assertEquals(3, resultado)
    }

    @Test
    fun divisionSiAesMenorACero() {
        // arrange
        val a = -3
        val b = 4

        // act
        val res = assertThrows<IllegalArgumentException> {
            calculadora.division(a, b)
        }

        // assert
        Assertions.assertEquals("Los números deben ser naturales", res.message)
    }

    @Test
    fun divisionSiBesMenorACero() {
        // arrange
        val a = 3
        val b = -4

        // act
        val res = assertThrows<IllegalArgumentException> {
            calculadora.division(a, b)
        }

        // assert
        Assertions.assertEquals("Los números deben ser naturales", res.message)
    }

    @Test
    fun divisionSiBesCero() {
        // arrange
        val a = 3
        val b = 0

        // act
        val res = assertThrows<IllegalArgumentException> {
            calculadora.division(a, b)
        }

        // assert
        Assertions.assertEquals("El divisor debe ser mayor a cero", res.message)
    }
}