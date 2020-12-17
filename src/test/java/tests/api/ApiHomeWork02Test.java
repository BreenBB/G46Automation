package tests.api;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

@RunWith(Parameterized.class)
public class ApiHomeWork02Test extends BaseApiTest {

    private final static String API_KEY = "[ВАШ КЛЮЧ]";

    private Map<String, Object> reqBody = new HashMap<>();

    private String type;
    private String contentType;
    private String checkPath;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        List<Object[]> result = new ArrayList<>();
        Object[] xml = new Object[3];
        xml[0] = "xml";
        xml[1] = "text/xml";
        xml[2] = "data.item.@Ref";
        Object[] json = new Object[3];
        json[0] = "json";
        json[1] = "application/json";
        json[2] = "data.Ref";
        result.add(xml);
        result.add(json);
        return result;
    }

    public ApiHomeWork02Test(String type, String contentType, String checkPath) {
        this.type = type;
        this.contentType = contentType;
        this.checkPath = checkPath;
    }

    @Before
    public void setReqBody(){
        //Map<String, Object> methodProperties = new HashMap<>();
        //methodProperties.put("", "");
        //methodProperties.put("Limit", 5);

        reqBody.put("modelName", "Common");
        reqBody.put("calledMethod", "getCargoTypes");
        //reqBody.put("methodProperties", methodProperties);
        reqBody.put("apiKey", API_KEY);

    }

    @Owner("BreenBB")
    @Feature("")
    @Stories({@Story("Get cargo types list"), @Story("Nova Poshta API")})
    @Link("G-46")
    @TmsLink("TC-2")
    @Description("Please ignore me!")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void checkCargoTypes(){
        given()
                .spec(this.reqspec)
                .body(this.reqBody)
                .baseUri("https://api.novaposhta.ua/v2.0/")
                .contentType(this.contentType)
                .when()
                .post(this.type + "/common/getCargoTypes/")
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body(this.checkPath, hasItems(equalTo("Parcel"),
                        equalTo("Documents"),
                        equalTo("Pallet")));
    }

}
