package com.puppet.sample;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.before;

public class App
{

  public String enMsg()
  {
    return "Hello World!";
  }

  private static String requestInfoToString(Request request) {
    StringBuilder sb = new StringBuilder();
    sb.append(request.requestMethod());
    sb.append(" " + request.url());
    sb.append(" " + request.body());
    return sb.toString();
  }

  public static void main(String[] args) {

    try {
      Spark.port(Integer.parseInt(System.getProperty("appPort")));
    } catch (Exception e) {
      Spark.port(9999);
    }

    Spark.threadPool(10, 5, 600);

    before((request, response) -> {
        System.out.println(requestInfoToString(request));
    });

    get("/", App::helloWorld, new ThymeleafTemplateEngine());

  }

  public static ModelAndView helloWorld(Request req, Response res) {
    Map<String, Object> params = new HashMap<>();

    App t = new App();
    params.put("version", t.getClass().getPackage().getImplementationVersion() );

    App test = new App();
    params.put("lang", test.enMsg());

    return new ModelAndView(params, "index");
  }

}
