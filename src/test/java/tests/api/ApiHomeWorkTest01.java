package tests.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class ApiHomeWorkTest01 {

    private final static Logger LOG = LogManager.getLogger("API Тест получение списка банкоматов");

    @Test
    public void checkATMList() {
        List<String> result = given()
                .queryParam("json")
                .queryParam("atm")
                .queryParam("address", "")
                .queryParam("city", "Киев")
                .when()
                .get("https://api.privatbank.ua/p24api/infrastructure")
                .then()
                .assertThat()
                .body("devices.type", hasItems(equalTo("ATM")))
                .body("devices.cityRU", hasItems(equalTo("Киев")))
                .body("devices.cityEN", hasItems(equalTo("Kyiv")))
                .extract()
                .jsonPath()
                .getList("devices.fullAddressRu");

        //Вывод полученных адресов банкоматов
        LOG.info("Адреса Банкоматов: ");
        for(int i = 0; i < result.size(); i++) {
            LOG.info(result.get(i));
        }
    }
}
