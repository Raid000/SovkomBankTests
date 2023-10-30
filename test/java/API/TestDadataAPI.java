package API;

import API.POJO.DadataResponse;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.stream.IntStream;

public class TestDadataAPI {
//Ready TestDadataAPI
    private static final String baseURL = "https://cleaner.dadata.ru";
    private static final Logger LOGGER = Logger.getLogger(TestDadataAPI.class.getName());

    @Test
    public void checkPhone() {
        String mynum = "89874088264";
        List<String> sendingNumbers = new ArrayList<>(Arrays.asList(mynum));
        List<DadataResponse> dtresp = given()
                .when()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Token " + DataClass.getApiKey())
                .header("X-Secret", DataClass.getSecretkey())
                .body(sendingNumbers)
                .post(baseURL + "/api/v1/clean/phone").then().log().all()
                .statusCode(200)
                .extract().body().jsonPath().getList("$", DadataResponse.class);
        IntStream.range(0, dtresp.size())
                .forEach(i -> assertThat(dtresp.get(i).getSource()).isEqualTo(sendingNumbers.get(i)));

        LOGGER.log(Level.INFO,"Запрос выполнен успешно\n" +
                "В поле source ответа содержится номер телефона, введенный в запросе");
    }
}
