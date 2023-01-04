package org.skan.helpers;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
   // curl -u "serhii_DarJRT:vj2zyqmysYxh4Yktt9PM" -X GET "https://api.browserstack.com/app-automate/sessions/d86b9e4d05cb6d2a2040396a4037458b895070b7.json"

    public static String getVideoUrl(String sessionId){
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json" , sessionId);

        return given()
                .log().all()
                .auth().basic("serhii_DarJRT", "vj2zyqmysYxh4Yktt9PM")
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");


    }

}
