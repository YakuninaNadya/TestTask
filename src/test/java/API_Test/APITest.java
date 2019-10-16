package API_Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class APITest {
    public JsonPath getFirstThreeTenders(String companyId) {
        String url = "http://www.tender.pro/api/_info.tenderlist_by_set.json?_key=1732ede4de680a0c93d81f01d7bac7d1&set_type_id=1&set_id=" + companyId + "&max_rows=3&open_only=true";
        Response res = get(url);
        Assert.assertEquals(200, res.getStatusCode());
        String json = res.asString();
        JsonPath jp = new JsonPath(json);
        return jp;
    }

    @BeforeTest
    public JsonPath getResult() {
        JsonPath result = getFirstThreeTenders("150152");
        return result;
    }

    @Test
    public void checkThreeTenders() {
        Assert.assertEquals(getResult().get("result.args.max_rows"), "3");
    }

    @Test
    public void checkCompanyName() {
        Assert.assertEquals(getResult().get("result.data[0].company_name"), "О КЕЙ");
    }

    @Test
    public void checkOpenness() {
        Assert.assertEquals(getResult().get("result.args.open_only"), "true");
    }


}
