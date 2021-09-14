package tests;

import core.rest.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SicrediTests  extends BaseTest {

    private String TOKEN;

//    @Before
//    public void login() {
//        Map<String, String> login = new HashMap<>();
//        login.put("email", "rdg4368@gmail.com");
//        login.put("senha", "123456");
//
//        TOKEN = given()
//                .body(login)
//                .when()
//                .get("/restricoes/97093236014")
//                .then()
//                .statusCode(200)
//                .extract().path("token");
//    }

    @Test
    public void ConsultarUmaRestricaoPeloCPF() {
        given()
                .when()
                .get("/restricoes/97093236014")
                .then()
                .statusCode(200)
                .body("mensagem", is("O CPF 97093236014 tem problema"));
        ;
    }

    @Test
    public void CriarUmaSimulacao() {
        given()
                .when()
                .body("{ \"nome\": \"Peixe baiacu\", \"cpf\": 02345678909, \"email\": \"teste@email.com\", \"valor\":  40.000,  \"parcelas\": 3, \"seguro\": true  }")
                .post("/simulacoes")
                .then()
                .statusCode(201)
                .body("nome", is("Peixe baiacu"))
                .body("cpf", is("02345678909"))
                .body("email", is("teste@email.com"))
                .body("valor", is("40.000"))
                .body("parcelas", is("3"))
                .body("seguro", is("true"))
        ;
    }

    @Test
    public void AlterarUmaSimulacao(){
        given()
                .when()
                .body("{ \"nome\": \"Peixe baiacu\", \"cpf\": 77777777777, \"email\": \"baiacu@email.com\", \"valor\":  20.000,  \"parcelas\": 2, \"seguro\": true  }")
                .put("/simulacoes/97093236014")
                .then()
                .statusCode(200)
                .body("nome", is("Peixe baiacu"))
                .body("cpf", is("77777777777"))
                .body("email", is("baiacu@email.com"))
                .body("valor", is("20.000"))
                .body("parcelas", is("2"))
                .body("seguro", is("true"))
        ;
    }

}
