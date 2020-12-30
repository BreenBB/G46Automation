package tests.api;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class ApiHomeWork01Test extends BaseApiTest {

    private final static Logger LOG = LogManager.getLogger("API Тест получение списка банкоматов");

    @Owner("BreenBB")
    @Feature("")
    @Stories({@Story("List APM adresses"), @Story("Privat bank API")})
    @Link("G-46")
    @TmsLink("TC-1")
    @Description("Please ignore me!")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void checkATMList() {
        //List<String> result =
                given()
                .spec(this.reqspec)
                .queryParam("json")
                .queryParam("atm")
                .queryParam("address", "")
                .queryParam("city", "Киев")
                .when()
                .get("https://api.privatbank.ua/p24api/infrastructure")
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body("devices.type", hasItems(equalTo("ATM")))
                .body("devices.cityRU", hasItems(equalTo("Киев")))
                .body("devices.cityEN", hasItems(equalTo("Kyiv")));
                //.extract()
                //.jsonPath()
                //.getList("devices.fullAddressRu");

        /*//Вывод полученных адресов банкоматов
        LOG.info("Адреса Банкоматов: ");
        for(int i = 0; i < result.size(); i++) {
            LOG.info(result.get(i));
        }*/
    }
}
