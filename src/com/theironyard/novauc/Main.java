package com.theironyard.novauc;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.*;

public class Main {
    static Users user;

    public static HashMap<String, Users> blog = new HashMap<>();

    public static void main(String[] args) {
        Spark.init();

        Spark.get(
                "/",
                ((request, response) -> {
                    HashMap m = new HashMap();
                    HashMap bm=new HashMap();
                    if (user == null || user.userName.length()==0) {
                        return new ModelAndView(m, "index.html");
                    } else {
                        String currentPost = request.queryParams("post");
                        user.posts.add(currentPost);
                        Enumeration<String> e = Collections.enumeration(user.posts);
                        while(e.hasMoreElements()) {
                            bm.put("post", e.nextElement());
                        }
                        return new ModelAndView("post", "messages.html");
                    }
                }),
                new MustacheTemplateEngine()

        );

        Spark.post(
                "/login",
                ((request, response) -> {
                    String username = request.queryParams("loginName");
                    String password = request.queryParams("password");
                    user = new Users(username, password);
//                    if (!blog.containsKey(userName)){
//                        response.redirect("/create");
//                    }
//                    else if(!blog.get(userName).containsKey(password)){
//                        response.redirect("/create");
//                    }else  {
                    response.redirect("/");
                    return "";
                })
        );
    }
}
//        Spark.post(
//                "/create",
//                ((request, response) -> {
//                    userName = request.queryParams("loginName");
//                    String password = request.queryParams("password");
//                    if (blog.containsKey(userName)){
//                        response.redirect("/create");
//                    }
//                    else {
//                        myList = blog.get(userName).get(password);
//                        blog.put(userName,blog.get(userName));
//                        response.redirect("/");
//                        return "";
//                    }
//                    return "";
//                })
//        );
//    }

//    innerHash placeIt = (HashMap largeHash, String userName,String password) -> {
//        for (int i = 0; i < largeHash.size(); i++){
//
//        }
//        for(HashMap looper: largeHash){
//
//        }
//
//    };
//    }
//
//    @FunctionalInterface
//    public interface innerHash {
//        public HashMap innerPlacer(HashMap largeHash, String userName, String pasword);
//    }
//
//    @FunctionalInterface
//    public interface innerList {
//        public abstract void listPlacer(HashMap smallerHash);
//    }
//}

