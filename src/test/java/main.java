import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class main {
    @BeforeMethod
    void beforemethod(){
        RestAssured.baseURI="https://swapi.co/";
    }

    @Test
    public void Getswapi(){
      //  RestAssured.baseURI="https://swapi.co/";
        given().
                param("name","Obi-Wan Kenobi").
                param("height","202").
                when().
                get("api/people/10").
                then().assertThat().statusCode(200);

    }
    @Test
     void Getsapi2(){
        given().
                param("name","Wicket Systri Warrick").
                param("mass","20").
                param("gender","male").
                when().
                get("api/people/30").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON);

    }



            @Ignore
        public void getPlaceAPI() {
                // TODO Auto-generated method stub

                //BaseURL or Host
                RestAssured.baseURI = "https://maps.googleapis.com";

                given().
                        param("location", "-33.8670522,151.1957362").
                        param("radius", "500").
                        param("key", "AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
                        when().
                        get("/maps/api/place/nearbysearch/json").
                        then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                        body("results[0].name", equalTo("Sydney")).and().
                        body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
                        header("Server", "pablo");
            }
            @Test
            void Postpet(){
                RestAssured.baseURI="https://petstore.swagger.io";
                given();
                JSONObject jsonfile = new JSONObject();
                jsonfile.put("petId",3);
                jsonfile.put("name","psinapomoina9");
                jsonfile.put("status","alive");
                RequestSpecification request = RestAssured.given();
                request.header("Content-Type", "application/json");
                request.body(jsonfile.toString());
                ValidatableResponse response=request.post("https://petstore.swagger.io").then().statusCode(200);

        }
        @Test
    void createhuman(){
        RestAssured.baseURI="https://petstore.swagger.io";
        given();
                JSONObject jsonfile1 = new JSONObject();
                jsonfile1.put("id",1);
                jsonfile1.put("username","Vartan");
                jsonfile1.put("firstName","Ashot");
                jsonfile1.put("lastName","zalupidze");
                jsonfile1.put("email","allah@yandex.ru");
                jsonfile1.put("password","parol");
                jsonfile1.put("phone","Iphone");
                jsonfile1.put("userStatus",2);
            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            request.body(jsonfile1.toString());
            ValidatableResponse response=request.post("https://petstore.swagger.io/").then().statusCode(200);

        }
        @Test
    void Postreq1(){
        RestAssured.baseURI="http://httpbin.org/";
        given();
        JSONObject jsonfile2= new JSONObject();
        jsonfile2.put("name",200);
        RequestSpecification requrst = RestAssured.given();
        requrst.body(jsonfile2.toString());
        ValidatableResponse asssertresp = requrst.post().then().statusCode(405);



        }


		       /*header("dfd","fsdfds").
		       cookie("dsfs","csder").
		       body()*/
            //Status code of the response
            //Content type
            //Body
            //Header responses
         //   given().
                  //  param("","").
                   // param("","").
                   // param("","")




    }


