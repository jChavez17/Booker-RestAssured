package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.BookingContext;
import pages.CreateBookingPage;
import pages.ReadBookingPage;
import utils.DataGenerator;

import static org.junit.Assert.assertEquals;

public class CRUDsteps {
    private CreateBookingPage createBookingPage;
    private ReadBookingPage readBookingPage;
    private Response response;
    private int statusCode;
    private String requestBody;
    int bookingId;

   @Given("I have valid booking data")
    public void setValidBookingData() {
        // Generar datos aleatorios para la reserva
        requestBody = "{" +
                "\"firstname\": \"" + DataGenerator.generateRandomName() + "\"," +
                "\"lastname\": \"" + DataGenerator.generateRandomLastName() + "\"," +
                "\"totalprice\": " + DataGenerator.generateRandomTotalPrice() + "," +
                "\"depositpaid\": " + DataGenerator.generateRandomDepositPaid() + "," +
                "\"bookingdates\": {" +
                "\"checkin\": \"" + DataGenerator.generateRandomCheckinDate() + "\"," +
                "\"checkout\": \"" + DataGenerator.generateRandomCheckoutDate() + "\"" +
                "}," +
                "\"additionalneeds\": \"" + DataGenerator.generateRandomAdditionalNeeds() + "\"" +
                "}";
        // Inicializar la página de creación de reserva
        createBookingPage = new CreateBookingPage();
    }

    @Dado("I make a POST request to create a booking")
    public void makePostRequest() {

        // Realizar una solicitud POST para crear una reserva y obtener la respuesta
        response = createBookingPage.createBooking(requestBody);
        statusCode = response.getStatusCode();

        // Extraer el bookingId de la respuesta y guardarlo en la variable miembro bookingId
        bookingId = response.then().extract().path("bookingid");
        bookingContext.setBookingId(bookingId);

        System.out.println("Booking ID Create: " + bookingId);
        System.out.println(response.prettyPrint());
    }

    @Then("the booking should be created successfully")
    public void verifyBookingCreation() {
        // Verificar que la reserva se haya creado exitosamente (código de estado 200)
        assertEquals("Se ha creado correctamente",200, statusCode);
    }

    @Given("I have a booking ID")
    public void i_have_a_booking_id() {
        // No necesitas acceder al bookingId aquí, ya que se debería obtener en el constructor
        // System.out.println(bookingContext.getBookingId());
    }
    @When("I make a GET request to read a booking")
    public void makeGetRequest() {
        readBookingPage = new ReadBookingPage();
        System.out.println("imprimir 1: " + bookingId); // Imprimir el valor de bookingId
        // Realizar una solicitud GET para leer la reserva y obtener la respuesta
        response = readBookingPage.readBooking(bookingId);
        statusCode = response.getStatusCode();
    }

    @Then("the booking details should be retrieved successfully")
    public void verifyBookingDetails() {
        // Verificar que los detalles de la reserva se hayan recuperado exitosamente (código de estado 200)
        assertEquals(200, statusCode);
        // Agregar más verificaciones según sea necesario, como verificar el contenido de la respuesta
    }
}