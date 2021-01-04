package tests.api;

import io.qameta.allure.*;
import io.restassured.mapper.ObjectMapperType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

@RunWith(Parameterized.class)
public class CheckCargoTypesTest extends BaseApiTest {

    private final static String API_KEY = System.getProperty("apiKey");

    private Map<String, Object> reqJSON;
    private String reqXML;

    private String type;
    private String contentType;
    private String checkPath;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        List<Object[]> result = new ArrayList<>();
        Object[] xml = new Object[3];
        xml[0] = "xml";
        xml[1] = "application/xml";
        xml[2] = "root.data.item.Ref";
        Object[] json = new Object[3];
        json[0] = "json";
        json[1] = "application/json";
        json[2] = "data.Ref";
        result.add(xml);
        result.add(json);
        return result;
    }

    public CheckCargoTypesTest(String type, String contentType, String checkPath) {
        this.type = type;
        this.contentType = contentType;
        this.checkPath = checkPath;
    }

    @Before
    public void setReqBody(){
        reqJSON = new HashMap<>();
        Map<String, Object> methodProperties = new HashMap<>();
        reqJSON.put("modelName", "Common");
        reqJSON.put("calledMethod", "getCargoTypes");
        reqJSON.put("methodProperties", methodProperties);
        reqJSON.put("apiKey", API_KEY);
        this.reqXML = format("<file>\n" +
                "<apiKey>%s</apiKey>\n" +
                "<calledMethod>getCargoTypes</calledMethod>\n" +
                "<methodProperties />\n" +
                "<modelName>Common</modelName>\n" +
                "</file>", API_KEY);
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
                .baseUri("http://testapi.novaposhta.ua/v2.0")
                .contentType(this.contentType)
                .body(this.type.equals("json") ? this.reqJSON : this.reqXML)
                .when()
                .post("/common/getCargoTypes/" + this.type)
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body(this.checkPath, hasItems(equalTo("Parcel"),
                        equalTo("Cargo"),
                        equalTo("Documents"),
                        equalTo("TiresWheels"),
                        equalTo("Pallet")));
    }

}
