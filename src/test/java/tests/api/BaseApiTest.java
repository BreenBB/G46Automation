package tests.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import listeners.RestAssuredAllureFilter;
import org.junit.Before;

public abstract class BaseApiTest {

    protected RequestSpecification reqspec;
    protected ResponseSpecification resSpec;

    @Before
    public void setSpecs(){
        reqspec = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .addFilter(new RestAssuredAllureFilter())
                .build();
        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }

}