package core.rest;

import io.restassured.http.ContentType;

public interface Constantes {

    String APP_BASE_URL = "http://localhost:8080/api";
    Integer APP_PORT = 80; //para http seria a porta 80;
    String APP_BASE_PATH = "v1";

    ContentType APP_CONTENT_TYPE = ContentType.JSON;

    Long MAX_TIMEOUT = 5000L;

}
